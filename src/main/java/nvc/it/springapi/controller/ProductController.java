package nvc.it.springapi.controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nvc.it.springapi.model.Product;
import nvc.it.springapi.service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<Object>getAllProduct(){
        List<Product> product = productService.getProducts();

        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Success!");
        map.put("data", product);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getProductById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search By Id Success!");
        map.put("data", productService.findById(id));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<Object>getProductByanme(@PathVariable String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search By Id Success!");
        map.put("data", productService.findProductByName(name));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
