package teo.spring.react.jwt.resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import teo.spring.react.entities.Users;
import teo.spring.react.jwt.JwtUserDetails;
import teo.spring.react.services.UserService;
import teo.spring.react.services.UserServiceImpl;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UserServiceImpl userService;

    public UserDetailsServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users users=this.userService.findByUsername(s);
       return new JwtUserDetails(users.getId(), users.getUsername(),
                users.getPassword(), "ROLE_USER_2");

    }


}
