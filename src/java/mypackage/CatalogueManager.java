/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.UnavailableException;
import java.sql.PreparedStatement;

/**
 *
 * @author Kévin
 */
@ManagedBean
@RequestScoped
public class CatalogueManager {

    /**
     * A remplir
     */
    
   
    //ajoute un livre dans la base de donnée
    public void add() throws UnavailableException, SQLException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
         String insertStatementStr = "INSERT INTO requete VALUES(?, ?, ?, ?, ?, ?)";
        String selectCustomerStr = "SELECT PRENOM, NOM FROM client WHERE EMAIL = ?";
       
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/hotline","kevin", "esiee");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        Livre livre = new Livre(1, "plop", "plop", "plop", "plop", "plop");
        PreparedStatement insertStatement = connexion.prepareStatement(insertStatementStr);
        insertStatement.setInt(1, livre.getId());
        insertStatement.setString(2, livre.getAuteur());
        insertStatement.setString(3, livre.getDate());
        insertStatement.setString(4, livre.getResume());
        insertStatement.setString(5, livre.getGenre());
        insertStatement.setString(6, livre.getTitre());
        insertStatement.executeUpdate();
        PreparedStatement selectStatement = connexion.prepareStatement(selectCustomerStr);
    }
    //ajoute la liste de livre d'un fichier csv dans la base de donnée
    public void addMultiple(){
        
    }
    
    public void find(){
        
    }
    
    public void getBookByGenre(){
        
    }
    public void getBookByAuteur(){
        
    }
    public void getBookByTitre(){
        
    }
    
    public void setBook(){
        
    }
    
    public void removeBook(){
        
    }
    
}
