package com.neebal.collegemgmt.exceptions;

public class BookNotIssuedYetException extends RuntimeException{
    public BookNotIssuedYetException(String msg){
        super(msg);
    }
}
