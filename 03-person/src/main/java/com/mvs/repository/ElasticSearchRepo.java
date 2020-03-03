package com.mvs.repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;
import com.mvs.data.model.Person;
import com.mvs.elasticsearch.ElasticsearchConfig;

public class ElasticSearchRepo implements IElasticSearchRepo {

	// @Autowired
	private ElasticsearchConfig elasticConfig = new ElasticsearchConfig();

	public void createIndex(Person person) throws IOException {
		CreateIndexRequest request = new CreateIndexRequest("person");
		request.settings(Settings.builder());
		Map<String, Object> message = new HashMap<>();
		message.put("type", "text");

		Map<String, Object> keyWordMap = new HashMap<>();
		Map<String, Object> keyWordValueMap = new HashMap<>();
		keyWordValueMap.put("type", "keyword");
		keyWordValueMap.put("ignore_above", 256);
		keyWordMap.put("keyword", keyWordValueMap);
		message.put("fields", keyWordMap);

		Map<String, Object> properties = new HashMap<>();
		properties.put("id", message);
		properties.put("nome", message);
		properties.put("sobreNome", message);
		properties.put("endereco", message);
		properties.put("genero", message);

		Map<String, Object> mapping = new HashMap<>();
		mapping.put("properties", properties);
		request.mapping(mapping);

		GetIndexRequest getIndexRequest = new GetIndexRequest("person");
		boolean exists = elasticConfig.client().indices().exists(getIndexRequest, RequestOptions.DEFAULT);
		if (!exists) {
			CreateIndexResponse indexResponse = elasticConfig.client().indices().create(request,
					RequestOptions.DEFAULT);
			System.out.println("response id: " + indexResponse.index());
		}
		salvar(person);
	}


	@Bean
	public void salvar(Person person) throws IOException {
		IndexRequest request = new IndexRequest("person");

		request.opType(DocWriteRequest.OpType.CREATE);
		request.opType("create");
		System.out.println(new Gson().toJson(person));
		request.id(person.getId().toString());
		String source = new Gson().toJson(person).toString();
		request.source(source, XContentType.JSON);
		
		try {
			IndexResponse indexResponse = elasticConfig.client().index(request, RequestOptions.DEFAULT);
			System.out.println("response id: " + indexResponse.getId());
		} catch (ElasticsearchStatusException e) {
			if (e.status() == RestStatus.CONFLICT) {
				e.getCause();
				update(person);
			} else if (e.status() == RestStatus.NOT_FOUND)
				createIndex(person);
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Bean
	public void update(Person person) throws IOException {

		try {
			UpdateRequest request = new UpdateRequest();
			request.index("person").id(person.getId().toString());
			// request.opType(DocWriteRequest.OpType.CREATE);
			// request.opType("create");
			System.out.println(new Gson().toJson(person));

			request.doc(new Gson().toJson(person).toString(), XContentType.JSON).type("_doc");

			UpdateResponse updateResponse = elasticConfig.client().update(request, RequestOptions.DEFAULT);
			// IndexResponse indexResponse = elasticConfig.client().index(request,
			// RequestOptions.DEFAULT);
			System.out.println("response id: " + updateResponse.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
