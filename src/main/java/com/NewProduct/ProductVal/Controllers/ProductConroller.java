package com.NewProduct.ProductVal.Controllers;

import com.NewProduct.ProductVal.Dtos.fakeStoreProductDto;
import com.NewProduct.ProductVal.Models.Product;
import com.NewProduct.ProductVal.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductConroller {

    @Autowired
    private ProductService productService;

    @GetMapping("{Id}")

    public ResponseEntity<Product> getProduct(@PathVariable long Id) {
        if(Id<1 || Id> 20){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }

        Product product= productService.GetProductById(Id);
        return  new ResponseEntity<>(product,HttpStatusCode.valueOf(200));
    }
}
