package com.mlproject.quickLease.Services;

import com.mlproject.quickLease.DTOs.UserDto;
import com.mlproject.quickLease.Exceptions.UserAlreadyExistException;
import com.mlproject.quickLease.Exceptions.UserNotFoundException;
import com.mlproject.quickLease.Entities.UserEntity;
import com.mlproject.quickLease.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // TODO: Add pagination
    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> users =  userRepository.findAll();
        // convert entity to dto so that we can return what we want to return
        // map return a new list
        return users.stream().map(user -> mapEntityToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        return mapEntityToDto(user);
    }

    // since we are modifying the db, need to add transaction notation on SERVICE layer not DAO
    @Transactional
    @Override
    public UserDto saveUser(UserDto userDto) {
        UserEntity newUser = mapDtoToEntity(userDto);
        UserDto newUserDto = mapEntityToDto(userRepository.save(newUser));
        return newUserDto;
    }

    @Transactional
    @Override
    public void deleteUserById(int id) {
        UserEntity deleteUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        userRepository.delete(deleteUser);
    }

    public String registerUser(UserDto userDto){
        UserEntity user = mapDtoToEntity(userDto);
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if(userExists){
            throw new UserAlreadyExistException("User with email " + user.getEmail() + " already existed");
        }
        else{
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(user);
            return "User with email " + user.getEmail() + " is created";
        }
    }

    /// BEST practice to create our own mapping functions
    private UserDto mapEntityToDto(UserEntity user) {
        if(user == null){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFullName(user.getFullName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setGender(user.isGender());
        return userDto;
    }

    private UserEntity mapDtoToEntity(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setGender(userDto.isGender());
        return user;
    }
}
