package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.LoginDto;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public String Register(UserDto userDto) {
        User user = new User(
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPhone(),
                userDto.getType(),
                userDto.getStatus()
        );
        userRepository.save(user);
        return "Register Successfully!";
    }
    public String loginUser(LoginDto loginDto) {
        User user = findUserByEmail(loginDto.getEmail());
        if (user == null) {
            return "Email doesn't exist!";
        }

        if (!passwordMatches(loginDto.getPassword(), user.getPassword())) {
            return "Password doesn't match!";
        }

        Optional<User> authenticatedUser = authenticateUser(loginDto.getEmail(), user.getPassword());
        if (authenticatedUser.isPresent()) {
            return "Logged in!";
        } else {
            return "Login failed!";
        }
    }
    private User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private boolean passwordMatches(String loginDtoPassword, String userPassword) {
        return loginDtoPassword.equals(userPassword);
    }

    private Optional<User> authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User newUser) {
         userRepository.save(newUser);

    }
    public void updateUser(User updateUser) {
        userRepository.save(updateUser);

    }
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
