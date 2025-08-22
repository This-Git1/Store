package user.repository;

import user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUserRepository implements UserRepository {
    Map<String, User> storage = new HashMap<>();


    @Override
    public void save(User user) {
        storage.put(user.getId().toString(), user);
    }

    @Override
    public User findById(String id) {
        return storage.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
