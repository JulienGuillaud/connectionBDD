package com.guillaud.ConnectionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.sasl.SaslException;

public class bddConnect {

	private Connection con = null;
	private PreparedStatement prepareStat = null;
	/**
	 * Constructeur vide par défaut
	 */
	public bddConnect() {
		
	}
	
	/**
	 * Méthode qui permet de réaliser une connexion à une BDD
	 */
	public void connect() {
    	try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite?serverTimezone=UTC", "root", "Guillaud24");
	    	if (con != null) {
	    		System.out.println("Connexion réussi");
	    	} else {
	    		System.out.println("Connexion échouée");
	    	}
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    		return;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
	}
		
	/**
	 * Insertion des données de base
	 */
	public void insertData(boolean insert) {
		if(insert) {
			try {
				String insertQueryStatement = "INSERT INTO etudiant VALUES (?,?,?,?,?,?,?)";
				prepareStat = con.prepareStatement(insertQueryStatement);
				prepareStat.setString(1, "129");
				prepareStat.setString(2, "GUILLAUD");
				prepareStat.setString(3, "Julien");
				prepareStat.setString(4, "2000-10-24");
				prepareStat.setString(5, "2 rue bermond gonnet");
				prepareStat.setString(6, "05100");
				prepareStat.setString(7, "Briançon");
				
				prepareStat.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Methode permettant d'afficher les données
	 */
	public void selectData() {	
		String getQueryStatement = "SELECT * FROM etudiant";
		try {
			prepareStat = con.prepareStatement(getQueryStatement);
			ResultSet rs = prepareStat.executeQuery();
			while (rs.next()) {
				String numetu = rs.getString("numetu");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
;
				System.out.println("numetu : " +numetu + ", nom : " + nom + ", prénom : " + prenom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

