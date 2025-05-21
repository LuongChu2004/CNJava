package com.example.quanlysach.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean available = true; // Thuộc tính trạng thái mượn

    // Nếu bạn không dùng Lombok, thì thêm thủ công:
    // public boolean isAvailable() { return available; }
    // public void setAvailable(boolean available) { this.available = available; }
}