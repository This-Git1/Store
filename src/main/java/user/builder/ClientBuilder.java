package user.builder;

import user.Client;
import user.UserRole;
import user.User;
import user.value.Phone;

public class ClientBuilder extends UserBuilder<ClientBuilder> {
    protected String category;
    protected String address;
    protected Phone phone;

    protected ClientBuilder() {
        this.role = UserRole.CLIENT;
    }

    public String getCategory() { return category; }
    public String getAddress() { return address; }
    public Phone getPhone() { return phone; }

    public ClientBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public ClientBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public ClientBuilder setPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    @Override
    protected ClientBuilder self() {
        return this;
    }

    @Override
    public User build() {
        return new Client(this);
    }
}
