package com.mike.mike.Person;

public enum UserTypeEnum {
    EMPLOYEE,
    CUSTOMER;

    public static UserTypeEnum fromString(String value) {
        try {
            return UserTypeEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid user type: " + value);
        }
    }
};
