package com.sathya.mvc.controller;
import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.mvc.entity.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.service.ProductService;




@Controller
public class ProductController{
	  @Autowired
	  ProductService productService;
		
		  @GetMapping("/wish") public String greet() { return "hello"; }
		  
		  @GetMapping("/type") public String greed() { return "nice"; }
		  
		  @GetMapping("/help") public String greek() { return "welcome"; }
		  
		  @GetMapping("/emptyform")
		  public String getform1(Model model)
		  {
			  model.addAttribute("productModel", new ProductModel());
			  return "add-product";
		  }
		 
		
		  @GetMapping("/productform") 
		  public String getform(Model model) 
		  { 
			  ProductModel product=new ProductModel(); 
			  product.setPrice(18000);
			  model.addAttribute("product", product);
			  return "add-product"; 
			  }
		  
		  @PostMapping("/product/saveproduct")
		  public String saveProductData(@ModelAttribute ProductModel productmodel) 
		  {
			productService.saveProductData(productmodel);
		  	return "hello";
		  }
		  
		  @GetMapping("/getAllProducts")
		   public String getAllProducts(Model model)
		   {
			  List<ProductEntity> products=productService.getAllProducts();
			  model.addAttribute("products", products);
			  
			return "product-list";
			  
		   }
		  
		  
		  @GetMapping("/getProduct/{id}")
		  public String getMethodName(@PathVariable Long id,Model model) {
			  ProductEntity product=productService.getProduct(id);
			  model.addAttribute("product", product);
			  return "productById";
		  }
		  @GetMapping("/deleteProduct/{id}")
		  public String deleteProductById(@PathVariable("id") Long id) {
		      productService.deleteProductById(id);
		      return "redirect:/getAllProducts";
		  }

			
			  @GetMapping("/editProduct/{id}")
			  public String editProductById(@PathVariable Long id,Model model)
			  { 
				  ProductModel productModel=productService.getEditProduct(id);
			  
			    model.addAttribute("productModel",productModel); 
			    return "editProduct";
			    }
			  @GetMapping("/hi")
			  public String byeBye() {
				return "bye";
				  
			  }
			 
		  
		  
		  
		  
		  
		 
	

}
