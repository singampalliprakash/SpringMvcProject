package com.sathya.mvc.service;

import java.time.LocalDateTime;    
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.mvc.entity.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	ProductRepository productRepository;

	public void saveProductData(ProductModel productmodel) 
	{
		double price=productmodel.getPrice();
		double taxamount= price*0.28;

		ProductEntity productEntity=new ProductEntity();

		productEntity.setName(productmodel.getName());
		productEntity.setPrice(productmodel.getPrice());
		productEntity.setQuantity(productmodel.getQuantity());
		productEntity.setBrand(productmodel.getBrand());
		productEntity.setMadein(productmodel.getMadein());
		productEntity.setTaxamount(taxamount);
		productEntity.setCreatedby(System.getProperty("username"));
		productEntity.setCreatedAt(LocalDateTime.now());

		productRepository.save(productEntity);
	}

	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> products=productRepository.findAll();
		return products;
	}

	public ProductEntity getProduct(Long id) {
		ProductEntity product=productRepository.findById(id).get();
		return product;
	}

	public void deleteProductById(Long id) {
		productRepository.deleteById(id);

	}

	public ProductEntity getEditProduct(Long id) 
	{ 
		ProductEntity productEntity=productRepository.findById(id).get(); 

		return productEntity;

	}

	public void updateProduct(long id, ProductModel productModel) {
		ProductEntity productEntity = productRepository.findById(id).get();

		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setMadein(productModel.getMadein());
		productRepository.save(productEntity);
	}
}
