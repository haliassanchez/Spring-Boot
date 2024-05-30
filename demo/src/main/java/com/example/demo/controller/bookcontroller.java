package com.example.demo.controller;


import com.example.demo.model.Book;
import repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {


    private final BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/")
    public String showBookList(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }


    @PostMapping("/add")
    public String addBook(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }
}
