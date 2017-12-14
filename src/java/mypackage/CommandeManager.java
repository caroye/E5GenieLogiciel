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
import java.util.Map;
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
public class CommandeManager {

    /**
     * A remplir
     */
    public static void create(Commande commande) throws UnavailableException, SQLException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String insertStatementStr = "INSERT INTO COMMANDE (ID, DATE, PRIX) VALUES(?, ?, ?)";
        String insertContenuStr = "INSERT INTO CONTENU (TITRE, QUANTITE, COMMANDE_NUM) VALUES (?, ?, ?)";
        
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PLAISIRDELIRE","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement insertStatement = connexion.prepareStatement(insertStatementStr);
        insertStatement.setInt(1, commande.getId());
        insertStatement.setString(2, commande.getDate());
        insertStatement.setInt(3, commande.getPrix());
        insertStatement.executeUpdate();
        Map<String, Integer> liste = commande.getListe();
        for(Map.Entry<String, Integer> entry : liste.entrySet()){
            PreparedStatement insertContenu = connexion.prepareStatement(insertContenuStr);
            insertContenu.setString(1, entry.getKey());
            insertContenu.setInt(2, entry.getValue());
            insertContenu.setInt(3, commande.getId());
            insertContenu.executeUpdate();
        }
        
    }
    
    public void add(Commande commande, String titre, int quantite) throws UnavailableException, SQLException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String insertContenuStr = "INSERT INTO CONTENU (TITRE, QUANTITE, COMMANDE_NUM) VALUES (?, ?, ?)";
        
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PLAISIRDELIRE","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement insertContenu = connexion.prepareStatement(insertContenuStr);
        insertContenu.setString(1, titre);
        insertContenu.setInt(2, quantite);
        insertContenu.setInt(3, commande.getId());
        insertContenu.executeUpdate();        
    }
    
    public void setCommand(Commande commande, String statut) throws UnavailableException, SQLException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
        
        String insertStatementStr = "UPDATE COMMANDE SET STATUS = ? WHERE ID = ?";
        
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PLAISIRDELIRE","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement insertStatement = connexion.prepareStatement(insertStatementStr);
        insertStatement.setString(1, statut);
        insertStatement.setInt(2, commande.getId());
        insertStatement.executeUpdate();        
    }
    
    //send confirmation email
    public void saveCommand(){
        
    }
    
    public void deleteCommand(){
        
    }
    
    public void update(){
        
    }
}
