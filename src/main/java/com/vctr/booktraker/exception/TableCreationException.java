package com.vctr.booktraker.exception;

public class TableCreationException extends RuntimeException{

    public TableCreationException(String tableName){
        super("Failed to create table: " + tableName);
    }
}
