package com.example.demo.controller;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.User;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.LoginDto;
import java.util.List;

@RestController
public class UserController {
      @Autowired
      private UserService userService;

      @PostMapping("/Register")
      public String Register(@RequestBody UserDto newUser) {
             userService.Register(newUser);
             return "Register Successfully!!";

      }
      @PostMapping("/Login")
      public String Login(@RequestBody LoginDto loginDTO) {
            userService.loginUser(loginDTO);
            return "Login Successfully";
      }

      @GetMapping("/getAllUsers")
      public List <User> getAllUsers(){return userService.getAllUsers();}

      @PostMapping ("/AddUser")
      public String addUser (@RequestBody User newUser) {
             userService.addUser(newUser);
            return "Add User Successfully";
      }
      @PutMapping ("/UpdateUser")
      public String updateUser (@RequestBody User updateUser) {
            userService.updateUser(updateUser);
            return "Update User Successfully";
      }
      @DeleteMapping ("/DeleteUser")
      public String deleteUser (@RequestParam Integer id) {
            userService.deleteUser(id);
            return "delete User Successfully";
      }
}

