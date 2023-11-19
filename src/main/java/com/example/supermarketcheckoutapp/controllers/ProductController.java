package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Product;
import com.example.supermarketcheckoutapp.response.ProductPackageResponse;
import com.example.supermarketcheckoutapp.response.ProductResponse;
import com.example.supermarketcheckoutapp.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    ProductServices productServices;


    @PostMapping("")
    public ResponseEntity<ProductResponse> postProduct(@RequestBody Product product){
        ProductResponse productResponse=new ProductResponse();
        try{
            productServices.postProduct(product);
            productResponse.setResponse("Product Created Successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
        }
        catch (Exception e){
            productResponse.setResponse("Error while creating the message");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productResponse);
        }
    }
    @GetMapping("/{prodId}")
    public ResponseEntity<ProductPackageResponse<Product>> getProductsByID(@PathVariable String prodId){
        ProductPackageResponse<Product> productPackageResponse=new ProductPackageResponse<Product>();
        try{
            Product product= productServices.getProductsByID(prodId);
            productPackageResponse.setData(product);
            productPackageResponse.setResponse("Product Found");
            return ResponseEntity.status(HttpStatus.OK).body(productPackageResponse);
        }
        catch(Exception e){
            productPackageResponse.setResponse("Id not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productPackageResponse);
        }
    }

    @GetMapping(value = "",params = {"pageIndex","pageSize","sortDirection","criteriaName","searchQuery","categoryName"})
    public ResponseEntity<ProductPackageResponse<List<Product>>> getAllProducts(@RequestParam(defaultValue = "0") int pageIndex, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "none") String sortDirection, @RequestParam(defaultValue = "title") String criteriaName, @RequestParam(required = false) String searchQuery, @RequestParam(required = false) String categoryName){

        System.out.println("working in");

            List<Product> products=productServices.getAllProducts(pageIndex,pageSize,sortDirection,criteriaName,categoryName,searchQuery);
            ProductPackageResponse<List<Product>> productPackageResponse=new ProductPackageResponse<List<Product>>();
            if(products.isEmpty())
            {
               productPackageResponse.setMessage("No such items found");
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productPackageResponse);
            }
            else {
                productPackageResponse.setData(products);
                productPackageResponse.setMessage("All items found");
                return ResponseEntity.status(HttpStatus.OK).body(productPackageResponse);
            }

    }

    @DeleteMapping("/{prodId}")
    public ResponseEntity<ProductResponse> deleteProductsByID(@PathVariable String prodId){
        ProductResponse productResponse=new ProductResponse();
        try{
            productServices.deleteProductsByID(prodId);
            productResponse.setResponse("Successfully Deleted");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productResponse);
        }
        catch(Exception e){
            productResponse.setResponse("Id Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productResponse);
        }
    }

    @PutMapping("/{prodId}")
    public ResponseEntity<ProductPackageResponse<Product>> updateProductsByID(@PathVariable String prodId,@RequestBody Product product){
        ProductPackageResponse<Product> productPackageResponse=new ProductPackageResponse<Product>() ;
        try{
            productServices.updateProductsByID(prodId,product);
            productPackageResponse.setMessage("Successfully Updated");
            productPackageResponse.setData(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(productPackageResponse);
        }
        catch(Exception e){
            productPackageResponse.setMessage("Id Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productPackageResponse);
        }
    }
}
