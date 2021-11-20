package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment env;

    @Autowired
    private BookRepository repository;


    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency) {

        var book = repository.getById(id);
        if (book == null) throw new RuntimeException("Book not found");

        var port = env.getProperty("local.server.port");
        book.setEnvironment(port);

        return book;
    }


}
