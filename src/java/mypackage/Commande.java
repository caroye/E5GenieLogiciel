/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kévin
 */
@ManagedBean
@RequestScoped
public class Commande {

    /**
     * Creates a new instance of Commande
     */
    private int Id;
    private String date;
    private int prix;
    private Map<String, Integer> liste; 

    public Commande(String date, int prix, Map<String, Integer> liste, int id) {
        this.date = date;
        this.prix = prix;
        this.liste = liste;
        this.Id = id;
    }

    public String getDate() {
        return date;
    }

    public int getPrix() {
        return prix;
    }
    public Map<String, Integer> getListe(){
        return liste;
    }
    public int getId(){
        return Id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    public void setListe(Map<String, Integer> liste){
        this.liste = liste;
    }
    public void setId(int id){
        this.Id = id;
    }
    
    public void modifyListe(String titre, int quantite){
        if(quantite == 0){
            supprElementListe(titre);
        }
        else{
            liste.put(titre, quantite);
        }
    }
    
    public void supprElementListe(String titre){
        liste.remove(titre);
    }
    
}
