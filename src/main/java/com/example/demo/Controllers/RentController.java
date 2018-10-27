package com.example.demo.Controllers;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/rent")
    public String Rent(@RequestParam String productId)
    {
        int id = Integer.parseInt(productId);
        Product product = productRepository.findById(id);
        product.decrementQuantity();
        productRepository.save(product);

        System.out.println("Rent productid: " + id + " " + product.toString());
        return "redirect:/Products";
    }
}
