package com.vctr.booktraker.repository;

import com.vctr.booktraker.entity.Book;
import com.vctr.booktraker.entity.Reader;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.Optional;

@Repository
public class ReaderRepository {

    private final DynamoDbTable<Reader> table;

    public ReaderRepository(DynamoDbClient dbClient) {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dbClient)
                .build();
        this.table = enhancedClient.table(
                "Readers",
                TableSchema.fromBean(Reader.class)
        );
    }

    public void save(Reader reader) {
        table.putItem(reader);
    }

    public Optional<Reader> findById(String id) {
        return Optional.ofNullable(table.getItem(
                r -> r.key(
                        k -> k.partitionValue(id))
        ));
    }

    public Optional<Reader> findByEmail(String email) {
        return Optional.ofNullable(table.getItem(
                r -> r.key(
                        k -> k.partitionValue(email))
        ));
    }

}
