package com.rest.h2.Service;

import com.rest.h2.dao.AuthorDao;
import com.rest.h2.dao.BookDao;
import com.rest.h2.entity.Author;
import com.rest.h2.entity.Book;
import com.rest.h2.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }


    public Optional<Book> getBookById(Long bookId) {
        if (!bookDao.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }
        return bookDao.findById(bookId);
    }


    public Book createBook(Long authorId, Book book) {
        Set<Book> books = new HashSet<>();
        Author author1 = new Author();

        Optional<Author> byId = authorDao.findById(authorId);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
        }
        Author author = byId.get();

        //tie Author to Book
        book.setAuthor(author);

        Book book1 = bookDao.save(book);
        //tie Book to Author
        books.add(book1);
        author.setBooks(books);

        return book1;

    }

    //other methods omitted for brevity
}
