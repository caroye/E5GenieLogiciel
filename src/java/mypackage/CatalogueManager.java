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
import java.sql.ResultSet;

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
    public static void add(Livre livre) throws UnavailableException, SQLException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String insertStatementStr = "INSERT INTO LIVRE (ID, TITRE, RESUME, DATE, GENRE, AUTEUR) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PLAISIRDELIRE","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement insertStatement = connexion.prepareStatement(insertStatementStr);
        insertStatement.setInt(1, livre.getId());
        insertStatement.setString(2, livre.getTitre());
        insertStatement.setString(3, livre.getResume());
        insertStatement.setString(4, livre.getDate()); //changer type !!!
        insertStatement.setString(5, livre.getGenre());
        insertStatement.setString(6, livre.getAuteur());
        insertStatement.executeUpdate();
        //PreparedStatement selectStatement = connexion.prepareStatement(selectCustomerStr);
    }
    //ajoute la liste de livre d'un fichier csv dans la base de donnée
    public static void addMultiple(){
        
    }
    
        
    //retourne la liste des livre du genre en paramètre
    public static String getBookByGenre(String genre) throws UnavailableException, SQLException{
        //System.out.println("plop");
       
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String selectCustomerStr = "SELECT ID, TITRE, RESUME, DATE, GENRE, AUTEUR, PRIX FROM LIVRE WHERE GENRE = ?";
       
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PLAISIRDELIRE","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement selectStatement = connexion.prepareStatement(selectCustomerStr);
        selectStatement.setString(1, genre);
        ResultSet rs = selectStatement.executeQuery();
        String res = "[";
        while(rs.next()){
            res = res + "{"+rs.getString("TITRE")+","+rs.getString("RESUME")+","+rs.getString("GENRE")+","+rs.getString("AUTEUR")+","+rs.getInt("PRIX")+"}\n";
        }
        res = res +"]";
        return res;
    }
    //retourne la liste des livre de l'auteur en paramètre
    public static String getBookByAuteur(String auteur) throws UnavailableException, SQLException{
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String selectCustomerStr = "SELECT ID, TITRE, RESUME, DATE, GENRE, AUTEUR, PRIX FROM LIVRE WHERE AUTEUR = ?";
       
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PLAISIRDELIRE","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement selectStatement = connexion.prepareStatement(selectCustomerStr);
        selectStatement.setString(1, auteur);
        ResultSet rs = selectStatement.executeQuery();
        String res = "[";
        while(rs.next()){
            res = res + "{"+rs.getString("TITRE")+","+rs.getString("RESUME")+","+rs.getString("GENRE")+","+rs.getString("AUTEUR")+","+rs.getInt("PRIX")+"}\n";
        }
        res = res +"]";
        return res;
    }
    //retourne la liste des livre du titre en paramètre
    public static String getBookByTitre(String titre) throws UnavailableException, SQLException{
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String selectCustomerStr = "SELECT ID, TITRE, RESUME, DATE, GENRE, AUTEUR, PRIX FROM LIVRE WHERE TITRE = ?";
       
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PLAISIRDELIRE","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement selectStatement = connexion.prepareStatement(selectCustomerStr);
        selectStatement.setString(1, titre);
        ResultSet rs = selectStatement.executeQuery();
        String res = "[";
        while(rs.next()){
            res = res + "{"+rs.getString("TITRE")+","+rs.getString("RESUME")+","+rs.getString("GENRE")+","+rs.getString("AUTEUR")+","+rs.getInt("PRIX")+"}\n";
        }
        res = res +"]";
        return res;
    }
    //update
    public static void setBook(Livre livre) throws UnavailableException, SQLException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
       
        String modifyStatementStr = "UPDATE LIVRE SET TITRE = ?, RESUME = ?, DATE = ?, GENRE = ?, AUTEUR = ?, PRIX = ? WHERE TITRE = ?";
       
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PlaisirDeLire","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        PreparedStatement modifyStatement = connexion.prepareStatement(modifyStatementStr);
        modifyStatement.setString(1, livre.getTitre());
        modifyStatement.setString(2, livre.getResume());
        modifyStatement.setString(3, livre.getDate());
        modifyStatement.setString(4, livre.getGenre());
        modifyStatement.setString(5, livre.getAuteur());
        modifyStatement.setInt(6, livre.getPrix());
        modifyStatement.setString(7, livre.getTitre());
        modifyStatement.executeUpdate();
    }
    
    //retourne true si la suppression du livre du titre en paramètre est effectué
    public static boolean removeBook(String titre) throws UnavailableException, SQLException{
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String supprCustomerStr = "DELETE FROM LIVRE WHERE TITRE = ?";
        String selectCustomerStr = "SELECT * FROM LIVRE WHERE TITRE = ?";
        
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PLAISIRDELIRE","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement deleteStatement = connexion.prepareStatement(supprCustomerStr);
        deleteStatement.setString(1, titre);
        PreparedStatement selectStatement = connexion.prepareStatement(selectCustomerStr);
        ResultSet rs = selectStatement.executeQuery();
        if(rs.next()) return true;
        else return false;
    }
    
}
