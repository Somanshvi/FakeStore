package com.NewProduct.ProductVal.Services;

import com.NewProduct.ProductVal.Dtos.fakeStoreProductDto;
import com.NewProduct.ProductVal.Exceptions.ProductNotFoundException;
import com.NewProduct.ProductVal.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service

public class fakeStoreProductService implements  ProductService {
    @Override
    public Product GetProductById(long Id) throws ProductNotFoundException {
        /* Take the Id from the in
        put*/

        String url="https://fakestoreapi.com/products/"+Id;
        RestTemplate restTemplate = new RestTemplate();
       fakeStoreProductDto fspd = restTemplate.getForObject(url, fakeStoreProductDto.class);
       if(fspd==null){
           throw new ProductNotFoundException("Product With ID"+Id+"Not Found");
       }
        return convertFakeStoreProductToProduct(fspd);
    }
    private Product convertFakeStoreProductToProduct(fakeStoreProductDto dto){
        Product product = new Product();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getTitle());


        return product;
    }


}
