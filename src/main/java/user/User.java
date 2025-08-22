package user;

import user.builder.UserBuilder;
import user.value.*;

import java.util.UUID;

public abstract class User {
    private final UUID id;
    private final UserRole role;
    private final Name name;
    private final Email email;
    private final Password passwordHash;

    protected User(UserBuilder<?> builder) {
        this.id = UUID.randomUUID();
        this.name = builder.getName();
        this.email = builder.getEmail();
        this.passwordHash = builder.getPasswordHash();
        this.role = builder.getRole();
    }

    public UUID getId() { return id; }
    public UserRole getRole() { return role; }
    public Name getName() { return name; }
    public Email getEmail() { return email; }

    //TODO
    public boolean isPasswordCorrect(String candidateHash) {
        return false;
    }

    @Override
    public String toString() {
        return "[ " + role + ";" + name + ";" + email + " ]";
    }

}
