package com.example.ocp_be.service;

import com.example.ocp_be.dto.UserDto;
import com.example.ocp_be.entity.Role;
import com.example.ocp_be.entity.User;
import com.example.ocp_be.repository.RoleRepository;
import com.example.ocp_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User saveUser(User user) {
        return userRepository.save(user);

    }

    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }



    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


//    @Override
//    public Optional<User> findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    public List<UserDto> findAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map((user) -> mapToUserDto(user))
//                .collect(Collectors.toList());
//    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        String[] str = user.getFirstName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}