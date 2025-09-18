package user.service;

import user.User;
import user.repository.UserRepository;

import java.util.Optional;

public class UserService {
    // DIP: зависимость на абстракции UserRepository, конкретная реализация внедряется через конструктор
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }
}
