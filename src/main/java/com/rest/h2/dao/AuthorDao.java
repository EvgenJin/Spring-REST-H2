package com.rest.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rest.h2.entity.Author;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {

}
