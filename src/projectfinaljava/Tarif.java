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
public class Tarif {
    private float tarifTante, tarifEquitation, tarifCanot, tarifEscalade;
    Campeur campeur;
    //Price for stay
    public float prix1pers = 23.25f;
    public float prix2pers = 20.90f;
    public float prix3pers = 18.25f;
    public float prix4pluspers = 16.25f;
    //Price for riding horse
    public float prixparcours1Week = 15.25f;
    public float prixparcours2Week = 22.75f;
    public float prixparcours3Week = 25.25f;
    
    public float prixparcours1WeekEnd = 18.25f;
    public float prixparcours2WeekEnd = 25.00f;
    public float prixparcours3WeekEnd = 27.75f;
    //Price for canot
    public float prixcanotWeek = 22.35f;
    public float prixcanotWeekEnd = 29.55f;
    //Price for Escalade
    public float prixEscalade = 10.00f;
    
    public Tarif(Campeur campeur){this.campeur = campeur;}
    
    public float GetTarifTante() {return tarifTante;}
    public float GetTarifEquitation() {return tarifEquitation;}
    public float GetTarifCanot() {return tarifCanot;}
    public float GetTarifEscalade() {return tarifEscalade;}
    public Campeur GetCampeur() {return campeur;}
    
    //Method caculate tent fee
    public float calculTarifTante(int jours, int nombrePer){
        if (nombrePer == 1)
            tarifTante = prix1pers * jours;
        if (nombrePer == 2)
            tarifTante = prix2pers * jours;
        if (nombrePer == 3)
            tarifTante = prix3pers * jours; 
        if (nombrePer >= 4)
            tarifTante = prix4pluspers * jours;           

        return tarifTante;
    }
    
    //Method calculate riding horse fee
    public float CalculTarifEquitation(int nombrePer, int nbrParcours, int weekend){
         switch (weekend) {
            case 1:
                switch (nbrParcours){
                    case 1:
                         tarifEquitation = nombrePer * prixparcours1WeekEnd;
                         break;
                    case 2:
                         tarifEquitation = nombrePer * prixparcours2WeekEnd;
                         break;
                    case 3:
                         tarifEquitation = nombrePer * prixparcours3WeekEnd;
                         break;   
                    default:
                        System.out.println("Invalid number!!");
                }
                break;
            case 0:
                switch (nbrParcours){
                    case 1:
                         tarifEquitation = nombrePer * prixparcours1Week;
                         break;
                    case 2:
                         tarifEquitation = nombrePer * prixparcours2Week;
                         break;
                    case 3:
                         tarifEquitation = nombrePer * prixparcours3Week;
                         break;
                    default:
                        System.out.println("Invalid number!!");
                }
                break;
            default:
                System.out.println("Invalid number!!");
         }
         return tarifEquitation;
    }
    
    //Method calculate Canot fee
    
    public float CalculTarifCanot(int weekend, int foisDeuxHeures) {
        switch (weekend){
            case 1: 
                tarifCanot = prixcanotWeekEnd * foisDeuxHeures;
                break;
            case 0:
                tarifCanot = prixcanotWeek * foisDeuxHeures;
           default:
                System.out.println("Invalid number!!");     
        }
        return tarifCanot;
    } 
    
    //Method calculate Escalade fee
    public float CalculTarifEscalade(int nombrePer, int heurs){
        
        tarifEscalade = prixEscalade * nombrePer * heurs;
        return tarifEscalade;
    }
    
    //Method for calculate total fee
    public float TotalTarifs(){
        return tarifTante + tarifEquitation + tarifCanot + tarifEscalade;
    }
}
