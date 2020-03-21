package teo.spring.react.jwt.resource;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import teo.spring.react.entities.Users;
import teo.spring.react.repositories.UserRepository;
import teo.spring.react.services.UserService;
import teo.spring.react.services.UserServiceImpl;

@Service
public class AuthenticationManagerImpl implements AuthenticationManager {
    private UserServiceImpl userService;
    private PasswordEncoder encoder;

    public AuthenticationManagerImpl(UserServiceImpl userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        Users user = userService.findByUsername(username);
        String pass="";
        boolean auth=false;
        if (user == null) {
            throw new BadCredentialsException("1000");
        }
        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("1000");
        }
        else{
            pass=user.getPassword();
            auth=true;
        }

        Authentication auth1 =new UsernamePasswordAuthenticationToken(username, pass);
     //   auth1.setAuthenticated(auth);
        return  auth1;
    }


}
