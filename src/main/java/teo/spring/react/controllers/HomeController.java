package teo.spring.react.controllers;

import org.springframework.web.bind.annotation.*;
import teo.spring.react.entities.Home;
import teo.spring.react.services.HomeService;
import teo.spring.react.services.HomeServiceImpl;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

@RestController

@CrossOrigin(origins ="https://sleepy-inlet-37715.herokuapp.com")
public class HomeController {
    private HomeServiceImpl homeService;

    public HomeController(HomeServiceImpl homeService) {
        this.homeService = homeService;
    }


    @GetMapping("/homes")
    public List<Home> getHomes() {

        return this.homeService.findAll();
    }

    @GetMapping("/home/{id}")
    public Home getHome(@PathVariable String id) {
        System.out.println(id);
        Long idd = Long.valueOf(id);
        return this.homeService.getOne(idd);
    }

    @DeleteMapping("/home/delete/{id}")
    public String deleteHome(@PathVariable String id) {
        System.out.println(id);
        Long idd = Long.valueOf(id);
        this.homeService.deleteByID(idd);
        return "Object with id " + id + " deleted";
    }

    @PostMapping("/home/ins")
    public String insertHome(@RequestBody Home newHome) {

     //Home h ;//= new Home();
       Home h = this.homeService.saveAndFlush(newHome);
        return "Created home with id :" + h.getHomeId().toString();

    }

    @PutMapping("/home/ins/{id}")
    public String insertHome(@RequestBody Home newHome, @PathVariable String id) {

     //   Home h = new Home();
        Home h = this.homeService.getOne(Long.valueOf(id));
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
        if (newHome.getDateToVisit() != null) {
            h.setDateToVisit(newHome.getDateToVisit());
        }
       // if (newHome.getDateToVisit() != null) {
            h.setLiked(newHome.isLiked());
      //  }
        this.homeService.saveAndFlush(h);
        return "Updated home with id :" + h.getHomeId().toString();

    }
}
