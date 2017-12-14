/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.UnavailableException;

/**
 *
 * @author Kévin
 */
@ManagedBean
@RequestScoped
public class ClientManager {   
   
    /**
     * Inscription
     */
    public static void create(Client client) throws UnavailableException, SQLException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String insertStatementStr = "INSERT INTO client VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String countStatementStr = "SELECT COUNT(*) FROM client";
       
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PlaisirDeLire","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement countStatement = connexion.prepareStatement(countStatementStr);
        ResultSet id = countStatement.executeQuery();
        int next = 0;
        while(id.next()){
            next = Integer.parseInt(id.getString("1"));
        }
        
        System.out.println(" valeur de next: " + next);
        PreparedStatement insertStatement = connexion.prepareStatement(insertStatementStr);
        insertStatement.setInt(1, next);
        insertStatement.setString(2, client.getNom());
        insertStatement.setString(3, client.getPrenom());
        insertStatement.setString(4, client.getAdresse());
        insertStatement.setInt(5, client.getCodePostal());
        insertStatement.setString(6, client.getVille());
        insertStatement.setInt(7, client.getTelephone());
        insertStatement.setString(8, client.getMail());
        insertStatement.setString(9, client.getSociete());
        insertStatement.setString(10, client.getMdp());
        insertStatement.executeUpdate();        
    }
    
    public Client find(String mail) throws UnavailableException, SQLException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String findStatementStr = "SELECT ID, NOM, PRENOM, ADRESSE, CP, VILLE, TELEPHONE, MAIL, SOCIETE, MDP FROM CLIENT WHERE MAIL = ?";
        
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PlaisirDeLire","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement findStatement = connexion.prepareStatement(findStatementStr);
        findStatement.setString(1, mail);
        ResultSet rs = findStatement.executeQuery();           
    // public Client(int id, String nom, String prenom, String mdp, String mail, int telephone, String adresse, int codePostal, String ville, String societe) {
        if(rs.next()){
            Client client = new Client(rs.getInt("ID"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("MDP"), rs.getString("MAIL"), rs.getInt("TELEPHONE"), rs.getString("ADRESSE"), rs.getInt("CP"), rs.getString("VILLE"), rs.getString("SOCIETE"));
            return client;
        }
        return null;
    }
    
    public static Client getClient(String mail, String mdp) throws UnavailableException, SQLException{    
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
       
        String connectionStatementStr = "SELECT ID, NOM, PRENOM, ADRESSE, CP, VILLE, TELEPHONE, MAIL, SOCIETE, MDP FROM CLIENT WHERE MAIL = ? AND MDP = ?";

        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PlaisirDeLire","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement connectionStatement = connexion.prepareStatement(connectionStatementStr);
        connectionStatement.setString(1, mail);
        connectionStatement.setString(2, mdp); 
        ResultSet rs = connectionStatement.executeQuery();           
    // public Client(int id, String nom, String prenom, String mdp, String mail, int telephone, String adresse, int codePostal, String ville, String societe) {
    
        if(rs.next()){
          Client client = new Client(rs.getInt("ID"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("MDP"), rs.getString("MAIL"), rs.getInt("TELEPHONE"), rs.getString("ADRESSE"), rs.getInt("CP"), rs.getString("VILLE"), rs.getString("SOCIETE"));  
          System.out.println(""+rs.getString("NOM"));
          return client;
        }
        return null;
    }
    
    public static void setClient(Client client) throws UnavailableException, SQLException{

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
       
        String modifyStatementStr = "UPDATE client SET NOM = ?, PRENOM = ?, ADRESSE = ?, CP = ?, VILLE = ?, TELEPHONE = ?, SOCIETE = ?, MDP = ? WHERE MAIL = ?";
        
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PlaisirDeLire","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement modifyStatement = connexion.prepareStatement(modifyStatementStr);
        modifyStatement.setString(1, client.getNom());
        modifyStatement.setString(2, client.getPrenom());
        modifyStatement.setString(3, client.getAdresse());
        modifyStatement.setInt(4, client.getCodePostal());
        modifyStatement.setString(5, client.getVille());
        modifyStatement.setInt(6, client.getTelephone());
        modifyStatement.setString(7, client.getSociete());
        modifyStatement.setString(8, client.getMdp());
        modifyStatement.setString(9, client.getMail());
        modifyStatement.executeUpdate();           
    }
    
    public void removeClient(String mail) throws SQLException, UnavailableException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;

        String removeStatementStr = "DELETE MDP, TELEPHONE, MAIL, ADRESSE, CP, VILLE, SOCIETE FROM CLIENT WHERE MAIL = ?";
        
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PlaisirDeLire","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement removeStatement = connexion.prepareStatement(removeStatementStr);
        removeStatement.setString(1, mail);
        removeStatement.executeUpdate();           

    }
}