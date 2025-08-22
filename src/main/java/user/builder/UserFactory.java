package user.builder;

public class UserFactory {

    public static AdminBuilder createAdmin() {
        return new AdminBuilder();
    }

    public static ClientBuilder createClient() {
        return new ClientBuilder();
    }
}
