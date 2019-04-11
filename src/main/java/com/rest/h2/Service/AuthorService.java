package com.rest.h2.Service;

import com.rest.h2.dao.AuthorDao;
import com.rest.h2.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorDao authorDao;

    public List<Author> getAuthors() {
        return authorDao.findAll();
    }

    public Author createAuthor(Author author) {
        return authorDao.save(author);
    }

}
