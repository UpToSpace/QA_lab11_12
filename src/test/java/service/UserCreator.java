package service;

import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "Valerie143@mail.ru";
    public static final String TESTDATA_USER_PASSWORD = "v1542139";

    public static User withCredentialsFromProperty(){
        return new User(TESTDATA_USER_NAME, TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyUsername(){
        return new User("", TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyPassword(){
        return new User(TESTDATA_USER_NAME, "");
    }
}
