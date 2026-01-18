package spring_crud.demo_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_crud.demo_app.model.UserEntity;
import spring_crud.demo_app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    // Read All
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Read One
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update
    public UserEntity updateUser(Long id, UserEntity userDetails) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());

        return userRepository.save(user);
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
