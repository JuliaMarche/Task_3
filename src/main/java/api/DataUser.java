package api;

import net.datafaker.Faker;

public class DataUser {
    private static final Faker dataUser = new Faker();

    public static User generateDataUser() {
        String email = dataUser.internet().emailAddress();
        String password = dataUser.internet().password();
        String name = dataUser.name().firstName();

        return new User(email, password, name);
    }
}
