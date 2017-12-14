/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

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
public class Client {

    /**
     * Creates a new instance of Client
     */
    private int id;
    private String nom;
    private String prenom = "user";
    private String mdp;
    private String mdp2;
    private String mail;
    private int telephone;
    private String adresse;
    private int codePostal;
    private String ville;
    private String societe;

    public Client() {
    }
    
    

    public Client(int id, String nom, String prenom, String mdp, String mail, int telephone, String adresse, int codePostal, String ville) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.societe = "";
    }

    public Client(int id, String nom, String prenom, String mdp, String mail, int telephone, String adresse, int codePostal, String ville, String societe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.societe = societe;
    }
    
    public String connect() throws SQLException{
        Client client = null;
        try {
            client = ClientManager.getClient(this.mail, this.mdp);
        } catch (UnavailableException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (client !=null){
            this.id = client.getId();           
            this.nom = client.getNom();
            this.prenom = client.getPrenom();
            this.mdp = client.getMdp();
            this.mail = client.getMail();
            this.telephone = client.getTelephone();
            this.adresse = client.getAdresse();
            this.codePostal = client.getCodePostal();
            this.ville = client.getVille();
            this.societe = client.getSociete();
             System.out.println(id +" "+ prenom +" "+ nom +" "+ mdp + " "+ mail+" "+telephone+" "+adresse+" "+codePostal+" "+ville+" "+societe);
            return "profil";
        }
        else{
            return "connexion";
        }
    }
    
    public String deconnexion(){
        this.id = 0;
        this.nom = "";
        this.prenom = "user";
        this.mdp = "";
        this.mail = "";
        this.telephone = 0;
        this.adresse = "";
        this.codePostal = 0;
        this.ville = "";
        this.societe = "";
        return "catalogue";
    }
    
    public String checkPassWord() throws SQLException{
        if(this.getMdp().equals(this.getMdp2())){
            Client client = new Client(0, this.nom, this.prenom, this.mdp, this.mail, this.telephone, this.adresse, this.codePostal, this.ville, this.societe);
            try {
                ClientManager.create(client);
            } catch (UnavailableException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "profil";
        }
        else{
            return "inscription";
        }
    }
    
    public String checkPassWordForModification()throws SQLException{
        if(this.getMdp().equals(this.getMdp2())){
            Client client = new Client(0, this.nom, this.prenom, this.mdp, this.mail, this.telephone, this.adresse, this.codePostal, this.ville, this.societe);
            try {
                ClientManager.setClient(client);
            } catch (UnavailableException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "profil";
        }
        else{
            return "inscription";
        }
    }

    public void setMdp2(String mdp2) {
        this.mdp2 = mdp2;
    }
            
    public String getMdp2() {
        return mdp2;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public String getMail() {
        return mail;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getSociete() {
        return societe;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public void setMdp(String Mdp){
        this.mdp = Mdp;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public void setTelephone(int tel){
        this.telephone = tel;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public void setCodePostal(int code){
        this.codePostal = code;
    }
    public void setVille(String ville){
        this.ville = ville;
    }
    public void setSociete(String societe){
        this.societe = societe;
    }
    
     
    
}
