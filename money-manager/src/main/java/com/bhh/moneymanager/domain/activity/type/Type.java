package com.bhh.moneymanager.domain.activity.type;

public class Type {

    public enum ActivityType {
        REVENUE("revenue"),
        EXPANSE("expanse");

        private String value;

        ActivityType(final String aValue){
            this.value = aValue;
        }

        public String getValue(){
            return this.value;
        }
    }
}
