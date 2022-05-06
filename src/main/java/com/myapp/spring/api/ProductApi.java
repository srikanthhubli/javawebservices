package com.myapp.spring.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductApi {

	@Autowired
	private ProductRepository repository;

	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(repository.findById(id).get(),HttpStatus.OK);
	} 
	
	@GetMapping("/findByPrice/{price}")
	public ResponseEntity<List<Product>> findProductsByPrice(@PathVariable("price") Double price){
		return new ResponseEntity<>(repository.findByPriceGreaterThanEqual(price).get(),HttpStatus.OK);
	}
	
	@GetMapping("/findByPriceorName")
	public ResponseEntity<List<Product>> findByPriceOrName(@RequestParam("price") Optional<Double> price, @RequestParam("name") Optional<String> name){
		return new ResponseEntity<>(repository.findByProductNameOrPrice(name.get(),price.get()).get(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> saveNewProduct(@RequestBody Product product){
		return new ResponseEntity<>(repository.save(product),HttpStatus.CREATED);
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<List<Product>> saveMultipleProducts(@RequestBody List<Product> product){
		return new ResponseEntity<>(repository.saveAll(product),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProducts(@PathVariable("id") Integer id,@RequestBody Product product){
		Product existingproduct = repository.findById(id).orElseThrow(()-> new RuntimeException ("Product Not FOund" + id));
		BeanUtils.copyProperties(product, existingproduct);
		return new ResponseEntity<>(repository.save(existingproduct),HttpStatus.CREATED);
	}
}

//JSON Object {"":}

//JSON ARRAY [{},{}]

//JSON Number 

//JSON String

//JSON Boolean
