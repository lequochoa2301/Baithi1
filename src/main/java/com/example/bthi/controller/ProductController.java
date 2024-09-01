package com.example.bthi.controller;


import com.example.bthi.entitty.Product;
import com.example.bthi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String showListProduct(Model model) {
        List<Product> productList = (List<Product>) productRepository.findAll();
        model.addAttribute("productList", productList);

        return "home";
    }

    @GetMapping("/search")
    public String showListProduct(@RequestParam(value = "searchInput", required = false) String searchInput, Model model) {
        List<Product> resultList;

        if (searchInput.isEmpty()) {
            resultList = (List<Product>) productRepository.findAll();
        } else {
            resultList = productRepository.findByNameContainingOrAddressContaining(searchInput, searchInput);
        }

        model.addAttribute("productList", resultList);
        return "home";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        productRepository.save(product);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateProductForm(@PathVariable("id") int id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            // Handle the case where the product is not found
            return "redirect:/";
        }
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "update";
        }
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
        return "redirect:/";
    }

}
