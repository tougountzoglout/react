package teo.spring.react.services;

import teo.spring.react.entities.Home;
import teo.spring.react.entities.User;

import java.util.List;

public interface UserService {
     public List<User> findAll();

  //  public List<Home> findAll(Sort var1);

   // List<T> findAllById(Iterable<ID> var1);

//    <S extends T> List<S> saveAll(Iterable<S> var1);

    void flush();

     public <S extends User> S saveAndFlush(S home);

   // void deleteInBatch(Iterable<T> var1);

  //  void deleteAllInBatch();

    public void deleteByID(Long id);

   public User getOne(Long id);




}
