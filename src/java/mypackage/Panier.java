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
public class Panier {

    /**
     * Creates a new instance of Panier
     */
    private String adresseDest;

    public Panier(String adresseDest) {
        this.adresseDest = adresseDest;
    }

    public String getAdresseDest() {
        return adresseDest;
    }

    public void setAdresseDest(String adresseDest) {
        this.adresseDest = adresseDest;
    }
    
    
    
}
