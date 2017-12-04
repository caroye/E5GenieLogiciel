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
public class Commande {

    /**
     * Creates a new instance of Commande
     */
    private String date;
    private int prix;

    public Commande(String date, int prix) {
        this.date = date;
        this.prix = prix;
    }

    public String getDate() {
        return date;
    }

    public int getPrix() {
        return prix;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
    
}
