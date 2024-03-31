package com.bhh.moneyback.domain.activity.type;

public enum Type {
        REVENUE("revenue"),
        EXPENSE("expense");

        private String value;
        Type(String aValue){
            this.value = aValue;}

        public String getValue(){
            return this.getValue();}
}

