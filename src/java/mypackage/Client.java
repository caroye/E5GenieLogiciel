/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
    private String prenom;
    private String mdp;
    private String mail;
    private int telephone;
    private String adresse;
    private int codePostal;
    private String ville;
    private String societe;

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
