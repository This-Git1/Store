package user.repository;

import user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(String id);
    List<User> getAllUsers();

}
