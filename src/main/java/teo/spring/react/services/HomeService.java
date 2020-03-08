package teo.spring.react.services;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import teo.spring.react.entities.Home;

import java.util.List;

public interface HomeService {
     public List<Home> findAll();

  //  public List<Home> findAll(Sort var1);

   // List<T> findAllById(Iterable<ID> var1);

//    <S extends T> List<S> saveAll(Iterable<S> var1);

    void flush();

     public <S extends Home> S saveAndFlush(S home);

   // void deleteInBatch(Iterable<T> var1);

  //  void deleteAllInBatch();

    public void deleteByID(Long id);

   public Home getOne(Long id);


}
