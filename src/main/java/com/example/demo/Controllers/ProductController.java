package com.example.demo.Controllers;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.models.Product;
import com.example.demo.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersRepository userRepository;

    @GetMapping("/Products")
    public String GetProducts(Model model)
    {
        List<Product> productList = productRepository.findAllByOrderByIdAsc();

        for (Product product: productList) {
            System.out.println(product.getId() + " " + product.getCatalogueNumber() + " " + product.getDescription() + " " + product.getQuantity());
        }

        for (Users user: userRepository.findAll()) {
            System.out.println(user.toString());
        }
        model.addAttribute("products", productList);
        return "Products";
    }

}
