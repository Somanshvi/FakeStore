package com.NewProduct.ProductVal.Services;

import com.NewProduct.ProductVal.Dtos.fakeStoreProductDto;
import com.NewProduct.ProductVal.Models.Product;
import org.springframework.stereotype.Service;

@Service

public interface ProductService {
    public Product GetProductById(long id);
}
