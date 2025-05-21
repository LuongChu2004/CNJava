package com.example.quanlysach.controller;

import com.example.quanlysach.entity.Book;
import com.example.quanlysach.entity.Borrow;
import com.example.quanlysach.repository.BookRepository;
import com.example.quanlysach.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class LibraryController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BorrowRepository borrowRepo;

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "books";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long bookId, @RequestParam Long userId) {
        Optional<Book> bookOpt = bookRepo.findById(bookId);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.isAvailable()) {
                book.setAvailable(false);
                bookRepo.save(book);

                Borrow borrow = new Borrow();
                borrow.setBook(book);
                borrow.setUserId(userId);
                borrow.setBorrowDate(LocalDate.now());
                borrowRepo.save(borrow);
            }
        }
        return "redirect:/books/list";
    }
}