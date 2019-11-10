package org.stock.web;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stock.entities.Produit;
import org.stock.entities.users.Utilisateurs;


public abstract class GenericServices<T,U extends Serializable> {

	
	public abstract JpaRepository getRepository();
	
	@Transactional(readOnly = true)
	@CrossOrigin
	@RequestMapping(value="/findById/{id}",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> findAllByStream(@PathVariable("id")U id) {
		
		return new ResponseEntity<Object>(this. getRepository().findOne(id), HttpStatus.OK);
	}
	

	

	
	
	@Transactional(readOnly = true)
	@CrossOrigin
	@RequestMapping(value="/findAll",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<T>> findAll() {
		
		List<T> listResponses =  this. getRepository().findAll();
		return new ResponseEntity<List<T>>(listResponses, HttpStatus.OK);
	}
	
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> deleteObject(@PathVariable("id")U id) {
		this. getRepository().delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK); 
	}
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value="/save",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object>saveObject(@RequestBody T entity) {
		
		return new ResponseEntity<Object>(this. getRepository().save(entity),HttpStatus.OK); 
	}
	
	

}
