package com.sathya.mvc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.sathya.mvc.entity.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.service.ProductService;
import jakarta.validation.Valid;
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
		product.setPrice(13455.335);
		model.addAttribute("product", product);
		return "add-product"; 
	}

	@PostMapping("/product/saveproduct")
	public String saveProductData(@Valid @ModelAttribute("product") ProductModel productmodel,BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors())
		{
			return "add-product";
		}
		productService.saveProductData(productmodel);
		return "hello";
	}

	@GetMapping("/getAllProducts")
	public String getAllPr(Model model)
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
	public String editProductById(@PathVariable long id,Model model)
	{ 
		ProductEntity productEntity=productService.getEditProduct1(id);
		model.addAttribute("productModel",productEntity); 
		return "editProduct";
	}

	@PostMapping("/products/update/{id}")
	public String updateProduct(@PathVariable long id, @ModelAttribute ProductModel product) {
		productService.updateProduct(id, product);
		return "redirect:/getAllProducts";
	}
	@GetMapping("/well") 
	public String great() {
		return "hi"; }
}
