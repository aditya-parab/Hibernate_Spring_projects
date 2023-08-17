package com.example.collegemgmt.exceptions;

public class BookAlreadyIssuedException extends RuntimeException{
    public BookAlreadyIssuedException (String msg){
        super(msg);
    }
}
