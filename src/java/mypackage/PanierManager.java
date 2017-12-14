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
public class PanierManager {

    /**
     * A remplir
     */
    public static String getAdresse(Client client) throws SQLException, UnavailableException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
       
        String findStatementStr = "SELECT ADRESSE, CP, VILLE FROM CLIENT WHERE MAIL = ?";
       
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PlaisirDeLire","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        PreparedStatement findStatement = connexion.prepareStatement(findStatementStr);
        findStatement.setString(1, client.getMail());
        ResultSet rs = findStatement.executeQuery();  
        String res = "";
        if(rs.next()){
             res = res + rs.getString("ADRESSE") +","+rs.getString("CP")+","+rs.getString("VILLE");
        }
        return res;
    // public Client(int id, String nom, String prenom, String mdp, String mail, int telephone, String adresse, int codePostal, String ville, String societe) {
        
    }
    
    public static void setAdresse(Client client) throws UnavailableException, SQLException{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            throw new UnavailableException("Driver non trouve dans le classpath");
        }
        Connection connexion = null;
       
        String modifyStatementStr = "UPDATE CLIENT SET ADRESSE = ?, CP = ?, VILLE = ? WHERE MAIL = ?";
       
        try {
            connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PlaisirDeLire","plaisirdelire", "plaisirdelire");
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        PreparedStatement modifyStatement = connexion.prepareStatement(modifyStatementStr);
        modifyStatement.setString(1, client.getAdresse());
        modifyStatement.setInt(2, client.getCodePostal());
        modifyStatement.setString(3, client.getVille());
        modifyStatement.setString(4, client.getMail());
        modifyStatement.executeUpdate();          
    }
    
}
