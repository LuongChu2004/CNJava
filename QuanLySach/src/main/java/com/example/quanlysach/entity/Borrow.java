package com.example.quanlysach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    private Long userId;

    private LocalDate borrowDate;

    // Nếu không dùng Lombok, thêm getter/setter thủ công
}