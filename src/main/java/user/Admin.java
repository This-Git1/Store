package user;

import user.builder.AdminBuilder;

final public class Admin extends User {
    private final AccessLevel accessLevel;

    public Admin(AdminBuilder builder) {
        super(builder);
        this.accessLevel = builder.getAccessLevel();
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

}
