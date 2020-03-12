package teo.spring.react.services;

import org.springframework.stereotype.Service;
import teo.spring.react.entities.Users;
import teo.spring.react.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> findAll() {
       return this.userRepository.findAll();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Users> S saveAndFlush(S user) {
       return this.userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteByID(Long id) {

    }

    @Override
    public Users getOne(Long id) {
      return this.userRepository.findById(id).get();
    }
}