package com.example.bookstore.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RestBookController {

    private BookRepository repository;
    private CategoryRepository crepository;

    public RestBookController(BookRepository repository,
            CategoryRepository crepository) {
        this.repository = repository;
        this.crepository = crepository;
    }

    @GetMapping(value = "/books")
    public List<Book> booksRest() {
        return (List<Book>) repository.findAll();
    }

    @GetMapping(value = "/books/{id}")
    public Optional<Book> bookById(@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }

    @PostMapping(value = "/books")
    public Book addBookRest(@RequestBody Book book) {
        return repository.save(book);
    }

    @PutMapping(value = "/books/{id}")
    public Book editBookRest(@RequestBody Book book, @PathVariable("id") Long bookId) {
        Optional<Book> exists = repository.findById(bookId);
        if (exists.isPresent()) {
            if (book.getId() == bookId) {
                return repository.save(book);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "/books/{id}")
    public Optional<Book> deleteBookRest(@PathVariable("id") Long bookId) {
        Optional<Book> book = repository.findById(bookId);
        repository.deleteById(bookId);
        return book;
    }

}
