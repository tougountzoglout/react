package teo.spring.react.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import teo.spring.react.entities.Home;
import teo.spring.react.entities.User;
import teo.spring.react.services.HomeService;
import teo.spring.react.services.HomeServiceImpl;
import teo.spring.react.services.UserService;
import teo.spring.react.services.UserServiceImpl;


import java.util.List;

@RestController
@CrossOrigin(origins = "https://sleepy-inlet-37715.herokuapp.com/")
public class HomeController {
    private HomeServiceImpl homeService;
    private UserServiceImpl userService;

    public HomeController(HomeServiceImpl homeService,UserServiceImpl userService) {
        this.userService=userService;
        this.homeService = homeService;
    }


    @GetMapping("/homes/{userId}")
    public List<Home> getHomes(@PathVariable String userId) {

        return this.homeService.findByUserId(Long.valueOf(userId));
    }


    @GetMapping("/homes/{userId}/{page}")
    public Page<Home> getHomes(@PathVariable String userId,@PathVariable String page) {
        Pageable pageable= PageRequest.of(Integer.parseInt(page),5, Sort.by("homeId").descending());
        return this.homeService.findByUserId(Long.valueOf(userId),pageable);
    }

//    @GetMapping("/home/{id}")
//    public Home getHome(@PathVariable String id) {
//        System.out.println(id);
//        Long idd = Long.valueOf(id);
//        return this.homeService.getOne(idd);
//    }

    @GetMapping("/home/{userid}/{id}")
    public Home getHome(@PathVariable String id,@PathVariable String userid) {
        System.out.println(id);
        Long idd = Long.valueOf(id);
        Long uid = Long.valueOf(userid);
        return this.homeService.findByHomeIdAndUserId(idd,uid);
    }

    @DeleteMapping("/home/{userid}/delete/{id}")
    public String deleteHome(@PathVariable String id, @PathVariable String userid) {
       // System.out.println(id);
        this.homeService.findByHomeIdAndUserId(Long.valueOf(id),Long.valueOf(userid)).setUser(null);
        Long idd = Long.valueOf(id);
        this.homeService.deleteByID(idd);
        return "Object with id " + id + " deleted";
    }

    @PostMapping("/home/{userid}/ins")
    public String insertHome(@RequestBody Home newHome,@PathVariable String userid) {

     //Home h ;//= new Home();
       User u=this.userService.getOne(Long.valueOf(userid));
       newHome.setUser(u);
       Home h = this.homeService.saveAndFlush(newHome);
        return "Created home with id :" + h.getHomeId().toString();

    }

    @PutMapping("/home/{userid}/ins/{id}")
    public String updateHome(@RequestBody Home newHome, @PathVariable String id,@PathVariable String userid) {

     //   Home h = new Home();
        Home h = this.homeService.findByHomeIdAndUserId(Long.valueOf(id),Long.valueOf(userid));
        if (newHome.getDateToVisit() != null) {
            h.setDateToVisit(newHome.getDateToVisit());
        }
        if (newHome.getName() != null) {
            h.setName(newHome.getName());
        }
        if (newHome.getPhone() > 0) {
            h.setPhone(newHome.getPhone());
        }
        if (newHome.getUrl() != null) {
            h.setUrl(newHome.getUrl());
        }
        if (newHome.getArea() != null) {
            h.setArea(newHome.getArea());
        }
        if (newHome.getComments() != null) {
            h.setComments(newHome.getComments());
        }
        if (newHome.getEidos() != null) {
            h.setEidos(newHome.getEidos());
        }
        if (newHome.getTm() != null) {
            h.setEidos(newHome.getEidos());
        }
        if (newHome.getYear() != null) {
            h.setYear(newHome.getYear());
        }
       // if (newHome.getDateToVisit() != null) {
            h.setLiked(newHome.isLiked());
      //  }
        this.homeService.saveAndFlush(h);
        return "Updated home with id :" + h.getHomeId().toString();

    }
}
