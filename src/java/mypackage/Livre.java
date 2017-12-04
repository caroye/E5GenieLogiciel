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

    public Livre(int id, String titre, String resume, String date) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.date = date;
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
    
    
    
}
