package teo.spring.react.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import teo.spring.react.entities.Home;
import teo.spring.react.entities.Users;
import teo.spring.react.services.HomeServiceImpl;
import teo.spring.react.services.UserServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://sleepy-inlet-37715.herokuapp.com"}, allowedHeaders = "*")
//allowedHeaders = "*"
public class HomeController {
    private HomeServiceImpl homeService;
    private UserServiceImpl userService;

    public HomeController(HomeServiceImpl homeService, UserServiceImpl userService) {
        this.userService = userService;
        this.homeService = homeService;
    }


    @GetMapping("/homes/{userId}")
    public List<Home> getHomes(@PathVariable String userId) {

        return this.homeService.findByUsersId(Long.valueOf(userId));
    }


    @GetMapping("/homes/{userId}/{page}")
    public Page<Home> getHomes(@PathVariable String userId, @PathVariable String page) {
        Pageable pageable = PageRequest.of(Integer.parseInt(page), 5, Sort.by("homeId").descending());
        return this.homeService.findByUsersId(Long.valueOf(userId), pageable);
    }


    @GetMapping("/home/{userid}/{id}")
    public Home getHome(@PathVariable String id, @PathVariable String userid) {
        System.out.println(id);
        Long idd = Long.valueOf(id);
        Long uid = Long.valueOf(userid);
        return this.homeService.findByHomeIdAndUsersId(idd, uid);
    }

    @DeleteMapping("/home/{userid}/delete/{id}")
    public String deleteHome(@PathVariable String id, @PathVariable String userid) {
        // System.out.println(id);
        this.homeService.findByHomeIdAndUsersId(Long.valueOf(id), Long.valueOf(userid)).setUsers(null);
        Long idd = Long.valueOf(id);
        this.homeService.deleteByID(idd);
        return "Object with id " + id + " deleted";
    }

    @PostMapping("/home/{userid}/ins")
    public String insertHome(@RequestBody Home newHome, @PathVariable String userid) {

        //Home h ;//= new Home();
        try {
            newHome.setDateToVisit(new SimpleDateFormat("yyyy/mm/dd").parse(newHome.getDateToVisit().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            Users u = this.userService.getOne(Long.valueOf(userid));
            newHome.setUsers(u);

            Home h = this.homeService.saveAndFlush(newHome);
            return "Created home with id :" + h.getHomeId().toString();
        }
    }

    @PutMapping("/home/{userid}/ins/{id}")
    public String updateHome(@RequestBody Home newHome, @PathVariable String id, @PathVariable String userid) {

        //   Home h = new Home();
        Home h = this.homeService.findByHomeIdAndUsersId(Long.valueOf(id), Long.valueOf(userid));
        if (newHome.getDateToVisit() != null) {
            try {
                h.setDateToVisit(new SimpleDateFormat("yyyy/mm/dd").parse(newHome.getDateToVisit().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
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
