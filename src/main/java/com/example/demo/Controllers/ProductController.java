package com.example.demo.Controllers;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/Products")
    public String GetProducts(Model model)
    {
        for (Product product: productRepository.findAll()) {
            System.out.println(product.getId() + " " + product.getCatalogueNumber() + " " + product.getDescription() + " " + product.getQuantity());
        }
        model.addAttribute("products", productRepository.findAll());
        return "Products";
    }

}
