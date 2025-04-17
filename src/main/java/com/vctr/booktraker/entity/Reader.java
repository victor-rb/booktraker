package com.vctr.booktraker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Reader {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<Book> books;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}

