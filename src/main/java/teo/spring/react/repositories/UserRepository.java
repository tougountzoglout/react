package teo.spring.react.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teo.spring.react.entities.Home;
import teo.spring.react.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
