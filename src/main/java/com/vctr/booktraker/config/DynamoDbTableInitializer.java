package com.vctr.booktraker.config;

import com.vctr.booktraker.exception.TableCreationException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

@Component
@RequiredArgsConstructor
public class DynamoDbTableInitializer {

    private final DynamoDbClient dynamoDbClient;

    private static final Logger logger = LoggerFactory.getLogger(DynamoDbTableInitializer.class);
    private static final String TABLE_BOOK = "Books";
    private static final String TABLE_READER = "Readers";

    @PostConstruct
    public void createTableIfNotExists(){
        ListTablesResponse listTablesResponse = dynamoDbClient.listTables();

        if(!listTablesResponse.tableNames().contains(TABLE_BOOK)){
            logger.info("'Books' table not found. Creating...");

            CreateTableRequest createTableRequest = CreateTableRequest.builder()
                    .tableName(TABLE_BOOK)
                    .keySchema(KeySchemaElement.builder()
                            .attributeName("id")
                            .keyType(KeyType.HASH)
                            .build())
                    .attributeDefinitions(AttributeDefinition.builder()
                            .attributeName("id")
                            .attributeType(ScalarAttributeType.S)
                            .build())
                    .provisionedThroughput(ProvisionedThroughput.builder()
                            .readCapacityUnits(5L)
                            .writeCapacityUnits(5L)
                            .build())
                    .build();

            try{
                dynamoDbClient.createTable(createTableRequest);
            }catch (TableCreationException e) {
                logger.error("Failed to create table: {}", e.getMessage());
                throw new TableCreationException(TABLE_BOOK);
            }
            logger.info("'Books' table created successfully.");
        }else {
            logger.info("Books table already exists.");
        }

        if(!listTablesResponse.tableNames().contains(TABLE_READER)){
            logger.info("'Readers' table not found. Creating...");

            CreateTableRequest createTableRequest = CreateTableRequest.builder()
                    .tableName(TABLE_READER)
                    .keySchema(KeySchemaElement.builder()
                            .attributeName("id")
                            .keyType(KeyType.HASH)
                            .build())
                    .attributeDefinitions(AttributeDefinition.builder()
                            .attributeName("id")
                            .attributeType(ScalarAttributeType.S)
                            .build())
                    .provisionedThroughput(ProvisionedThroughput.builder()
                            .readCapacityUnits(5L)
                            .writeCapacityUnits(5L)
                            .build())
                    .build();

            try{
                dynamoDbClient.createTable(createTableRequest);
            }catch (TableCreationException e) {
                logger.error("Failed to create table: {}", e.getMessage());
                throw new TableCreationException(TABLE_READER);
            }
            logger.info("'Readers' table created successfully.");
        }else {
            logger.info("Readers table already exists.");
        }


    }
}
