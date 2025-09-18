import user.AccessLevel;
import user.User;
import user.builder.AdminBuilder;
import user.builder.UserFactory;
import user.value.Name;
import user.value.Password;

public class Main {

    public static void main(String[] args) {

        AdminBuilder builder = UserFactory.createAdmin();
        User user = builder
                .setName("admin")
                .setEmail("admin@gmail.com")
                .setAccessLevel(AccessLevel.READ_ONLY)
                .setPassword(new Password("admin124D"))
                .build();

        System.out.println(user);



    }


}
