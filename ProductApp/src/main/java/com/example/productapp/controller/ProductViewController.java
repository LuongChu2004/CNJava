package com.example.productapp.controller;

import com.example.productapp.entity.Product;
import com.example.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductViewController {

    @Autowired
    private ProductRepository productRepository;

    // Hiển thị danh sách sản phẩm và form thêm mới
    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("product", new Product());  // Dùng để binding form
        return "products";
    }

    // Xử lý POST thêm sản phẩm
    @PostMapping("/products")
    public String addProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/products";  // Redirect về danh sách để load lại dữ liệu mới
    }
}