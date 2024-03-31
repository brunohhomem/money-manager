package com.bhh.moneyback.domain.exceptions;

public class DomainException extends RuntimeException{

    public DomainException(final String aMessage){
        super(aMessage);
    }
}
