package com.NewProduct.ProductVal.Advise;

import com.NewProduct.ProductVal.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> getProductNotFoundException(ProductNotFoundException ef){
        return new ResponseEntity<>(ef.getMessage(), HttpStatusCode.valueOf(400));

    }

}
