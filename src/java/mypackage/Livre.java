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
public class Livre {

    /**
     * Creates a new instance of Livre
     */
    
    private int id;
    private String titre;
    private String resume;
    private String date;    
    private String genre;
    private String auteur;
    private boolean checkAuteur = false;
    private boolean checkTitre = false;
    
    public Livre(){
        
    }
    
    public Livre(int id, String titre, String resume, String date, String genre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.date = date;
        this.genre = genre;
        this.auteur = auteur;
    }

    public boolean isCheckAuteur() {
        return checkAuteur;
    }

    public boolean isCheckTitre() {
        return checkTitre;
    }

    public void setCheckAuteur(boolean checkAuteur) {
        this.checkAuteur = checkAuteur;
        this.checkTitre = !checkAuteur;
    }

    public void setCheckTitre(boolean checkTitre) {
        this.checkTitre = checkTitre;
        this.checkAuteur = !checkTitre;
    }
    
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getResume() {
        return resume;
    }

    public String getDate() {
        return date;
    }
    public String getGenre(){
        return genre;
    }
    public String getAuteur(){
        return auteur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    
    
    
}
