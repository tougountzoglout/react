package teo.spring.react.services;


import teo.spring.react.entities.Users;

import java.util.List;

public interface UserService {
     public List<Users> findAll();

  //  public List<Home> findAll(Sort var1);

   // List<T> findAllById(Iterable<ID> var1);

//    <S extends T> List<S> saveAll(Iterable<S> var1);

    void flush();

     public <S extends Users> S saveAndFlush(S home);

   // void deleteInBatch(Iterable<T> var1);

  //  void deleteAllInBatch();
  public boolean existsByUsername(String username);

    public void deleteByID(Long id);

   public Users getOne(Long id);

    public Users findByUsernameAndPassword(String username,String password);

    public Users findByUsername(String username);

}
