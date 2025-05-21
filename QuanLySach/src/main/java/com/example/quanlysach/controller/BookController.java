package com.example.quanlysach.controller;

import com.example.quanlysach.entity.Book;
import com.example.quanlysach.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*; // @GetMapping, @PostMapping, @RequestParam

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/add")
    public String showAddForm() {
        return "add-book"; // Trả về trang JSP tên add-book.jsp
    }

    @PostMapping("/add")
    public String addBook(
            @RequestParam("title") String title,
            @RequestParam(value = "available", required = false) String availableParam,
            Model model
    ) {
        boolean available = (availableParam != null);
        Book book = new Book();
        book.setTitle(title);
        book.setAvailable(available);

        bookRepository.save(book);
        model.addAttribute("message", "Thêm sách thành công!");
        return "add-book";
    }
    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books"; // ✅ đúng tên với books.jsp
    }
}

