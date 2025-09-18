package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
/*
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;
     */
    private BookRepository repository;
    private CategoryRepository crepository;

    public BookController(BookRepository repository,
        CategoryRepository crepository) {
        this.repository = repository;
        this.crepository = crepository;
    }


    public static Category testCategory = new Category("fantasy");
    public static Book testBook = new Book("Testi", "Testaaja", 2000, "0123456789123", "12,21", testCategory);

    @GetMapping(value = { "/index", "/" })
    public String getIndex(Model model) {
        model.addAttribute("book", testBook);
        model.addAttribute("category", testCategory);
        model.addAttribute("books", repository.findAll());
        model.addAttribute("categories", crepository.findAll());
        return "index";
    }

    @GetMapping(value = { "/booklist" })
    public String getBooklist(Model model) {
        model.addAttribute("book", testBook);
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    @PostMapping(value = "/save")
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

}
