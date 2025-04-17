package com.vctr.booktraker.repository;

import com.vctr.booktraker.entity.Book;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.Optional;

@Repository
public class BookRepository {

    private final DynamoDbTable<Book> table;

    public BookRepository(DynamoDbClient dbClient){
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dbClient)
                .build();
        this.table = enhancedClient.table(
                "Books",
                TableSchema.fromBean(Book.class)
        );
    }

    public void save(Book book) {
        table.putItem(book);
    }

    public Optional<Book> findById(String id) {
        return Optional.ofNullable(table.getItem(
                r -> r.key(
                        k -> k.partitionValue(id))
        ));
    }
}
