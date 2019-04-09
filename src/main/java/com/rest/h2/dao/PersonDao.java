package com.rest.h2.dao;
 
import com.rest.h2.entity.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {
      @Query(value = "select * from PERSON Where id = ?",nativeQuery = true)
        List<Person> findAllQuerry(Integer id);
}