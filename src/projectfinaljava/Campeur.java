/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinaljava;


/**
 *
 * @author atdig
 */
public class Campeur {
    private String nom;
    private String phone;
    private String courriel;

    Campeur(){}
    Campeur(String nom, String phone, String courriel){
        this.nom = nom;
        this.phone = phone;
        this.courriel = courriel;
    }
    
    public String getNom() { return nom; } 
    public String getPhone() { return phone; }
    public String getCourriel (){ return courriel; };
    
    public void setNom(String nom) { this.nom = nom; } 
    public void setPhone(String phone) { this.phone = phone; }
    public void setCourriel(String courriel){ this.courriel = courriel; }
    

}
