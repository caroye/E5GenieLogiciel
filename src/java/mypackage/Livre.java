/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*INSERT INTO PLAISIRDELIRE.LIVRE (ID, TITRE, RESUME, DATE, GENRE, AUTEUR) VALUES (1, 'p', 'l', DATE('2015-12-17'), 'o', 'poesie' );

SELECT * FROM PLAISIRDELIRE.LIVRE FETCH FIRST 100 ROWS ONLY;
*/
package mypackage;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.UnavailableException;

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
    private Date date;    
    private String genre;
    private String auteur;
    private int prix;
    public static String requete;
    
  
    public Livre(){
        
    }
    
    public Livre(int id, String titre, String resume, Date date, String genre, String auteur, int prix) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.date = date;
        this.genre = genre;
        this.auteur = auteur;
        this.prix = prix;
    }

    public String getRequete() {
        return requete;
    }

    public void setRequete(String requete) {
        this.requete = requete;
    }
    public String getBookByAuteur() throws UnavailableException, SQLException{
        Livre livre = CatalogueManager.getBookByAuteur();
        if(livre !=null){
            this.id = livre.getId();
            this.titre = livre.getTitre();
            this.resume = livre.getResume();
            this.date = livre.getDate();
            this.genre = livre.getGenre();
            this.auteur = livre.getAuteur();
            this.prix = livre.getPrix();
        }
        else{
            this.titre = "";
            this.resume = "";
            this.date = null;
            this.genre = "";
            this.auteur = "";
            this.prix = 0;
        }
        
        
        return "rechercher";
    }
    public String getBookByTitre() throws UnavailableException, SQLException{
        Livre livre = CatalogueManager.getBookByTitre();
        if(livre != null){
            //this.id = livre.getId();
            this.titre = livre.getTitre();
            this.resume = livre.getResume();
            this.date = livre.getDate();
            this.genre = livre.getGenre();
            this.auteur = livre.getAuteur();
            this.prix = livre.getPrix();
        }
        else{
            this.titre = "";
            this.resume = "";
            this.date = null;
            this.genre = "";
            this.auteur = "";
            this.prix = 0;
        }
        
        
        return "rechercher";
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

    public Date getDate() {
        return date;
    }
    public String getGenre(){
        return genre;
    }
    public String getAuteur(){
        return auteur;
    }
    public int getPrix(){
        return prix;
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

    public void setDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        this.date = (Date) formatter.parse(date);
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    
    public void setPrix(int prix){
        this.prix = prix;
    }
    
}
