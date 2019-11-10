package org.stock.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stock.entities.users.Utilisateurs;
import org.stock.repository.UtilisateurRepository;

@RestController
@RequestMapping("/users")
public class UtilisateurServices {
		@Autowired
		private UtilisateurRepository userRepository;
		
		
		@GetMapping(value="getAll")
		public  ResponseEntity<Object>  getUsers(){
			return new ResponseEntity<Object>(userRepository.findAll(),HttpStatus.OK);
		}

		@GetMapping(value="/getByRef/{ref}")
		public ResponseEntity<Object> getByRef(@PathVariable Long ref){
			return new ResponseEntity<Object>(userRepository.findOne(ref),HttpStatus.OK);
		}
		
		
		@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> save(@RequestBody Utilisateurs p){
			return new ResponseEntity<Object>(userRepository.save(p),HttpStatus.OK);
		}


		@DeleteMapping(value = "/delete/{id}")
		public ResponseEntity<Object> supprimer(@PathVariable Long id){
				return new ResponseEntity<Object>(HttpStatus.OK);
		}
		
		
		@PutMapping(value = "/update/{id}")
		public ResponseEntity<Object> save(@PathVariable Long ref,@RequestBody Utilisateurs p){
			
			return new ResponseEntity<Object>(userRepository.save(p),HttpStatus.OK);
		}
		
	
		
		
		
	}

