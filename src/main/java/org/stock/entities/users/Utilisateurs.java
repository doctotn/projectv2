package org.stock.entities.users;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "utilisateurs")
@JsonSerialize
public class Utilisateurs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idutilisateurs")
	private long idutilisateurs ;
	@Column(name="nom")
	private String nom   ;
	@Column(name="prenom")
	private String prenom;
	
	@Embedded
	private Credentials credentials;
	
	@Column(name="roles")
	private String role;
	@Column(name="img")
	private String avatar;
	
	public Utilisateurs() {
	
	}


	public long getIdutilisateurs() {
		return idutilisateurs;
	}


	public void setIdutilisateurs(long idutilisateurs) {
		this.idutilisateurs = idutilisateurs;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}






	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public Credentials getCredentials() {
		return credentials;
	}


	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}


	
}