package user;

import user.builder.ClientBuilder;
import user.value.Phone;

final public class Client extends User {
    private final String category;
    private final String address;
    private final Phone phone;

    public Client(ClientBuilder builder) {
        super(builder);
        this.category = builder.getCategory();
        this.address = builder.getAddress();
        this.phone = builder.getPhone();
    }

    public String getCategory() {
        return category;
    }

    public String getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }

}
