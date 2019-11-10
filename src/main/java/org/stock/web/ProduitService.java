package org.stock.web;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;
import org.stock.entities.Produit;
import org.stock.repository.ProduitRepository;

@RestController
@RequestMapping("/produit")
public class ProduitService extends GenericServices<Produit,Long>{
	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public JpaRepository<Produit,Long> getRepository() {
		
		return produitRepository;
	}
	@PutMapping(value = "/update/{id}")
	public void update(@RequestBody Produit p,@PathVariable Long id){
		p.setRef(id);
		  produitRepository.save(p);
	}
	
	@PutMapping(value="/addQuantity/{id}/{quantity}")
	public void addQuantity (@RequestBody Produit p,@PathVariable Long id,@PathVariable int quantity) {
		p.setRef(id);
		p.setQuantite(p.getQuantite()+quantity);
		 produitRepository.save(p);
	}
	@PutMapping(value="/removeQuantity/{id}/{quantity}")
	public void removeQuantity (@RequestBody Produit p,@PathVariable Long id,@PathVariable int quantity) {
		
		if(p.getQuantite()>=quantity) {
			p.setRef(id);
			p.setQuantite(p.getQuantite()-quantity);
			produitRepository.save(p);
		}
		else 
			System.out.println("impo");
	}
	

	@RequestMapping(value="/search",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Produit> chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return produitRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		
		
	}

	
	
}
