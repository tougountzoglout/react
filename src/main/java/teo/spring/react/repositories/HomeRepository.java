package teo.spring.react.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teo.spring.react.entities.Home;

import java.util.List;


@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

    Home  findByHomeIdAndUsersId (Long id , Long userId);
    List<Home> findByUsersId(Long userId);
    public Page<Home> findByUsersId(Long userId, Pageable pageable);
}
