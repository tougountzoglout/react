package teo.spring.react.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teo.spring.react.entities.Home;
import teo.spring.react.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

      public Users findByUsernameAndPassword(String username,String password);
      public Users findByUsername(String username);
}
