package com.mvs.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;

public interface IElasticsearchConfig {
	RestHighLevelClient client();
}
