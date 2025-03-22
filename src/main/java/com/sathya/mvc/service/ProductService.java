package com.sathya.mvc.service;

<<<<<<< HEAD
import java.time.LocalDateTime;    
=======
import java.time.LocalDateTime;  
>>>>>>> a6786815b5313ca26a241520e49137625c14d96f
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
<<<<<<< HEAD

=======
	
>>>>>>> a6786815b5313ca26a241520e49137625c14d96f
	public void saveProductData(ProductModel productmodel) 
	{
		double price=productmodel.getPrice();
		double taxamount= price*0.28;
<<<<<<< HEAD

		ProductEntity productEntity=new ProductEntity();

=======
		
		ProductEntity productEntity=new ProductEntity();
		
>>>>>>> a6786815b5313ca26a241520e49137625c14d96f
		productEntity.setName(productmodel.getName());
		productEntity.setPrice(productmodel.getPrice());
		productEntity.setQuantity(productmodel.getQuantity());
		productEntity.setBrand(productmodel.getBrand());
		productEntity.setMadein(productmodel.getMadein());
		productEntity.setTaxamount(taxamount);
		productEntity.setCreatedby(System.getProperty("username"));
		productEntity.setCreatedAt(LocalDateTime.now());
<<<<<<< HEAD

=======
		 	
>>>>>>> a6786815b5313ca26a241520e49137625c14d96f
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
<<<<<<< HEAD

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
=======
		
	}
	
	  public ProductModel getEditProduct(Long id) 
	  { ProductEntity
	  productEntity=productRepository.findById(id).get(); ProductModel
	  productModel=new ProductModel();
	  productModel.setName(productEntity.getName());
	  productModel.setPrice(productEntity.getPrice());
	  productModel.setQuantity(productEntity.getQuantity());
	  productModel.setMadein(productEntity.getMadein());
	  productModel.setBrand(productEntity.getBrand());
	  return productModel;
	  
	  }
	 }
>>>>>>> a6786815b5313ca26a241520e49137625c14d96f
