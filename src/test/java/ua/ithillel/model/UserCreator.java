package ua.ithillel.model;

public class UserCreator {

    public static final String STANDARD_USER_NAME = "standard_user";
    public static final String STANDARD_USER_PASSWORD = "secret_sauce";

    public static User createStandartUser() {
        return new User(STANDARD_USER_NAME, STANDARD_USER_PASSWORD);
    }

}
