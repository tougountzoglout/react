package teo.spring.react.services;

import org.springframework.stereotype.Service;
import teo.spring.react.entities.Home;
import teo.spring.react.repositories.HomeRepository;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private HomeRepository homeRepository;

    public HomeServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }


    @Override
    public List<Home> findAll() {
        return this.homeRepository.findAll();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Home> S saveAndFlush(S home) {
        return this.homeRepository.save(home);
    }

    @Override
    public void deleteByID(Long id) {
        this.homeRepository.deleteById(id);
    }

    @Override
    public Home getOne(Long id) {
        return this.homeRepository.findById(id).get();
    }
}
