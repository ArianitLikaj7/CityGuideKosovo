package com.arianit.CityGuideKosovo.service;

import com.arianit.CityGuideKosovo.dto.UserDto;
import com.arianit.CityGuideKosovo.entity.User;
import com.arianit.CityGuideKosovo.mapper.UserMapper;
import com.arianit.CityGuideKosovo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public UserDto createUser(UserDto userDto) {
        User user = userMapper.mapUserDtoToUser(userDto);
        User savedUser = userRepository.save(user);

        return userMapper.mapUserToUserDto(savedUser);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::mapUserToUserDto)
                .toList();
    }

    public UserDto getUserById(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        return userMapper.mapUserToUserDto(user);
    }

    public void deleteUser(long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User not found with id: " + userId);
        }
        userRepository.deleteById(userId);
    }

    public void updatePassword(long userId, String password) {
        userRepository.findById(userId)
                .ifPresent(user -> {
                    user.setPassword(password);
                    userRepository.save(user);
                });
    }

    public void updateEmail(long userId, String email) {
        if (userRepository.existsByEmailIgnoreCase(email)) {
            throw new IllegalArgumentException("Email already in use: " + email);
        }

        userRepository.findById(userId)
                .ifPresent(user -> {
                    user.setEmail(email);
                    userRepository.save(user);
                });
    }
}
