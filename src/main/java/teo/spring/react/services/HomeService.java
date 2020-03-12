package teo.spring.react.services;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import teo.spring.react.entities.Home;

import java.util.List;
import java.util.Optional;

public interface HomeService {
    // public List<Home> findAll();

    public Home  findByHomeIdAndUserId (Long id , Long userId);
  //  public List<Home> findAll(Sort var1);

   // List<T> findAllById(Iterable<ID> var1);

//    <S extends T> List<S> saveAll(Iterable<S> var1);

    void flush();

     public <S extends Home> S saveAndFlush(S home);

   // void deleteInBatch(Iterable<T> var1);

  //  void deleteAllInBatch();

    public void deleteByID(Long id);

  // public Home getOne(Long id);

   public List<Home> findByUserId(Long userId);

    public Page<Home> findByUserId(Long userId, Pageable pageable);
}
