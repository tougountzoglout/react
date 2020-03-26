package teo.spring.react.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import teo.spring.react.entities.Users;
import teo.spring.react.services.UserServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = {"https://sleepy-inlet-37715.herokuapp.com","http://localhost:3000"}, allowedHeaders = "*")
public class UserController {
    private UserServiceImpl userService;
    private PasswordEncoder passwordEncoder;

//    public UserController(UserServiceImpl userService) {
//        this.userService = userService;
//    }

    public UserController(UserServiceImpl userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return this.userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable String id) {
        System.out.println(id);
        Long idd = Long.valueOf(id);
        return this.userService.getOne(idd);
    }

    @PostMapping("/user")
    public String getUserByNameAndPassword(@RequestBody Users newUser) {
//        System.out.println(id);
//        Long idd = Long.valueOf(id);
        Users user=this.userService.findByUsernameAndPassword(newUser.getUsername(),newUser.getPassword());
        return  user.getId().toString();

    }

    @GetMapping("/users/{username}")
    public Users getUserByNameAndPassword(@PathVariable String username) {
//        System.out.println(id);
//        Long idd = Long.valueOf(id);
        return this.userService.findByUsername(username);
    }


    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        System.out.println(id);
        Long idd = Long.valueOf(id);
        this.userService.deleteByID(idd);
        return "Object with id " + id + " deleted";
    }

    @PostMapping("/user/ins")
    public String insertUser(@RequestBody Users newUser) {

        String pass = newUser.getPassword();
        newUser.setPassword(passwordEncoder.encode(pass));
        Users h = this.userService.saveAndFlush(newUser);
        return h.getId().toString();

    }

    @PutMapping("/user/ins/{id}")
    public String updateUser(@RequestBody Users newUser, @PathVariable String id) {

        //   Home h = new Home();
        Users h = this.userService.getOne(Long.valueOf(id));
//        if (newUser.getDateToVisit() != null) {
//            h.setDateToVisit(newHome.getDateToVisit());
//        }
//        if (newHome.getName() != null) {
//            h.setName(newHome.getName());
//        }
//        if (newHome.getPhone() > 0) {
//            h.setPhone(newHome.getPhone());
//        }
//        if (newHome.getUrl() != null) {
//            h.setUrl(newHome.getUrl());
//        }
//        if (newHome.getDateToVisit() != null) {
//            h.setDateToVisit(newHome.getDateToVisit());
//        }
//       // if (newHome.getDateToVisit() != null) {
//            h.setLiked(newHome.isLiked());
//      //  }
        this.userService.saveAndFlush(h);
        return "Updated user with id :" + h.getId().toString();

    }
}
