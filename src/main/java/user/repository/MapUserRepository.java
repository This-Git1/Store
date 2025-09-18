package user.repository;

import user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MapUserRepository implements UserRepository {
    Map<String, User> storage = new HashMap<>();


    @Override
    public void save(User user) {
        storage.put(user.getId().toString(), user);
    }

    @Override
    public Optional<User> findById(String id) {
        if (storage.containsKey(id)) {
            return Optional.of(storage.get(id));
        }
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
