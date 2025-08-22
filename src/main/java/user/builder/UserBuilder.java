package user.builder;

import user.UserRole;
import user.value.*;
import user.User;

public abstract class UserBuilder<T extends UserBuilder<T>> {
    protected UserRole role;
    private Name name;
    private Email email;
    private Password passwordHash;

    public UserRole getRole() { return role; }
    public Name getName() { return name; }
    public Email getEmail() { return email; }
    public Password getPasswordHash() { return passwordHash; }


    public T setName(String name) {
        this.name = new Name(name);
        return self();
    }

    public T setEmail(String email) {
        this.email = new Email(email);
        return self();
    }

    public T setPassword(Password passwordHash) {
        this.passwordHash = passwordHash;
        return self();
    }

    protected abstract T self();
    public abstract User build();



}
