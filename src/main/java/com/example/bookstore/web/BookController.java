package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bookstore.domain.Book;


@Controller
public class BookController {

    public static Book testBook = new Book("Testi", "Testaaja", "2000", "0123456789123", "12,21");

    @GetMapping(value = {"/index", "/"})
    public String index(Model model) {
        model.addAttribute("book", testBook);
        return "index";
    }
    
}
