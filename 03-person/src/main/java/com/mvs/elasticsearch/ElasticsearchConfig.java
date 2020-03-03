package com.mvs.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by suman.das on 6/19/19.
 */
@Configuration
public class ElasticsearchConfig implements IElasticsearchConfig {
	@Value("${elasticsearch.host:192.168.15.96}")
	public String host;
	@Value("${elasticsearch.port:9200}")
	public int port;

	public String getHost() {
		if (host == null) {
			host = "192.168.15.96";
		}
		return host;
	}

	public int getPort() {
		if (port == 0) {
			port = 9200;
		}
		return port;
	}

	//private int timeout = 60;

	public RestHighLevelClient client() {

		System.out.println("host:" + getHost() + "port:" + getPort());

		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "http")));

		return client;

	}
}