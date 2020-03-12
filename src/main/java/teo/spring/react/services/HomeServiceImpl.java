package teo.spring.react.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import teo.spring.react.entities.Home;
import teo.spring.react.repositories.HomeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {

    private HomeRepository homeRepository;

    public HomeServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }


//    @Override
//    public List<Home> findAll() {
//        return this.homeRepository.findAll();
//    }

    @Override
    public Home  findByHomeIdAndUserId(Long id, Long userId) {

        return this.homeRepository.findByHomeIdAndUserId(id, userId);
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

//    @Override
//    public Home getOne(Long id) {
//        return this.homeRepository.findById(id).get();
//    }

    @Override
    public List<Home> findByUserId(Long userId) {
        return this.homeRepository.findByUserId( userId);
    }

    @Override
    public Page<Home> findByUserId(Long userId, Pageable pageable) {
        return this.homeRepository.findByUserId(userId, pageable);
    }
}
