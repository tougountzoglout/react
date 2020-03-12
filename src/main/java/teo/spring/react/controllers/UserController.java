package teo.spring.react.controllers;

import org.springframework.web.bind.annotation.*;
import teo.spring.react.entities.User;
import teo.spring.react.services.UserServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://sleepy-inlet-37715.herokuapp.com/")
public class UserController {
    private UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        User teo=new User();
       // teo.setId(Long.valueOf()1);
    //    teo.setUsername("teo");
     //   teo.setPassword("123");
        this.userService.saveAndFlush(teo);
        return this.userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        System.out.println(id);
        Long idd = Long.valueOf(id);
        return this.userService.getOne(idd);
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser (@PathVariable String id) {
        System.out.println(id);
        Long idd = Long.valueOf(id);
        this.userService.deleteByID(idd);
        return "Object with id " + id + " deleted";
    }

    @PostMapping("/user/ins")
    public String insertUser(@RequestBody User newUser) {

     //Home h ;//= new Home();
       User h = this.userService.saveAndFlush(newUser);
        return "Created home with id :" + h.getId().toString();

    }

    @PutMapping("/user/ins/{id}")
    public String updateUser(@RequestBody User newUser, @PathVariable String id) {

     //   Home h = new Home();
        User h = this.userService.getOne(Long.valueOf(id));
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
