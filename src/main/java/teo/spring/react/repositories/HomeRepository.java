package teo.spring.react.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teo.spring.react.entities.Home;

import java.util.List;
import java.util.Optional;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

    Home  findByHomeIdAndUserId (Long id , Long userId);
    List<Home> findByUserId(Long userId);
    public Page<Home> findByUserId(Long userId, Pageable pageable);
}
