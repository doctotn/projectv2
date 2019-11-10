package org.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stock.entities.Produit;
import org.stock.entities.users.Utilisateurs;


public interface UtilisateurRepository extends JpaRepository <Utilisateurs,Long>  {
	 
}
