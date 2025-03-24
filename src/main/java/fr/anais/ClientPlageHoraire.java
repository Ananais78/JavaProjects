package fr.anais;

import org.w3c.dom.ls.LSOutput;

public class ClientPlageHoraire {
    public static void main(String[] args) throws ExceptionPlanning {
        try {
            PlageHoraire plageHoraire1 = new PlageHoraire(new Horaire(12,15),new Horaire(15,15));
            System.out.println(plageHoraire1);

            PlageHoraire plageHoraire2 = new PlageHoraire(new Horaire(14,45),new Horaire(15,15));
            System.out.println(plageHoraire2);

            System.out.println(plageHoraire1.duree());
            System.out.println(plageHoraire2.duree());
        } catch (ExceptionPlanning e){
            System.out.println("Erreur réservation invalide: " + e.getMessage());
        }
    }
}
