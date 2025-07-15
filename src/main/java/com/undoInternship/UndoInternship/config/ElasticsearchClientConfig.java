package com.undoInternship.UndoInternship.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchClientConfig {

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        // Step 1: Create and configure ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // ✅ Enables Instant support

        // Step 2: Create JacksonJsonpMapper using the configured ObjectMapper
        JacksonJsonpMapper mapper = new JacksonJsonpMapper(objectMapper);

        // Step 3: Build RestClientTransport
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build();
        RestClientTransport transport = new RestClientTransport(restClient, mapper);

        // Step 4: Return the configured ElasticsearchClient
        return new ElasticsearchClient(transport);
    }
}