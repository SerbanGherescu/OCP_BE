package com.example.ocp_be.security;

import com.example.ocp_be.entity.User;
import com.example.ocp_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User searchUserById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public User searchByEmail(String email) {
        User user = userRepository.findByEmail(email).get();
        return user;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
