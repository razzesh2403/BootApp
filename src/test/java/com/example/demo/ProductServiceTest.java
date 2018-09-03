package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {
	
	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductService productService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllProducts(){
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1,"pen",10,15.0));
		productList.add(new Product(2,"pencil",10,15.0));
		productList.add(new Product(3,"book",10,15.0));
		when(productRepository.findAll()).thenReturn(productList);
		
		List<Product> result = productService.getAllProducts();
		Assert.assertEquals(3, result.size());
	}

}
