package com.bhh.moneyback.service.exceptions;

public class ServiceException extends RuntimeException{
    public ServiceException(final String aMessage){
        super(aMessage);
    }
}
