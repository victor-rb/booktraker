package com.vctr.booktraker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDBConfig {

    @Profile("local")
    @Bean
    public DynamoDbClient localDynamoDbClient(
            @Value("${dynamodb.endpoint}") String endpoint,
            @Value("${dynamodb.region}") String region
    ) {
        return DynamoDbClient.builder()
                .endpointOverride(URI.create(endpoint))
                .region(Region.of(region))
                .build();
    }

    @Profile("prod")
    @Bean
    public DynamoDbClient awsDynamoDbClient(
            @Value("${dynamodb.region}") String region
    ) {
        return DynamoDbClient.builder()
                .region(Region.of(region))
                .build();
    }

}
