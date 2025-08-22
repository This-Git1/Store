package user.builder;

import user.AccessLevel;
import user.Admin;
import user.UserRole;

public class AdminBuilder extends UserBuilder<AdminBuilder> {
    private AccessLevel accessLevel;

    protected AdminBuilder() {
        this.role = UserRole.ADMIN;
    }

    public AccessLevel getAccessLevel() { return accessLevel; }

    public AdminBuilder setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    @Override
    protected AdminBuilder self() {
        return this;
    }

    @Override
    public Admin build() {
        return new Admin(this);
    }

}
