package fr.anais;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Planning {
    private static final int TAILLE = 15;
    private Reservation[] chTabReservations;

    public Planning(int parTaille) {
        chTabReservations = new Reservation[TAILLE];
    }

    /**ajout de Reservation au tableau des réservations
     * (champ chTabReservation)
     * @param parReservation
     *
     * ExceptionPlanning levée quand :
     * - parReservation est invalide (code 0)
     * - chTabReservation est déjà plein (code 1)
     * - une réservation de chTabReservation est incompatible avec parReservation (code 2)
     */

    public void ajout(Reservation parReservation) throws ExceptionPlanning {
        if (chTabReservations[TAILLE - 1] != null)
            throw new ExceptionPlanning(1);
        for (int i = 0; i < chTabReservations.length; i++) {
            if (chTabReservations[i] == null) {
                chTabReservations[i] = parReservation;
                break;
            }
            if (chTabReservations[i].compareTo(parReservation) == 0)
                throw new ExceptionPlanning(2);
        }
    }

    public String toString() {
        String listeReservations = "Liste des reservations : ";
        for (int i = 0; i < TAILLE; i++) {
            if (chTabReservations[i] != null) {
                listeReservations += "\n" + chTabReservations[i];
            } else break;
        }
        return listeReservations;
    } //on peut faire une version équivalente avec while


    public Reservation getReservation(Date date) {
        for (int i = 0; i < TAILLE; i++) {
            if (chTabReservations[i] != null && chTabReservations[i].getChdate().equals(date)) {
                return chTabReservations[i];
            }
        }
        return null;
    }

    public Reservation [] getReservations(Date parDate) {
        List<Reservation> foundResas = new ArrayList<>();
        for (int i = 0; i < TAILLE; i++) {
            if (chTabReservations[i] != null && chTabReservations[i].getChdate().equals(parDate)) {
                foundResas.add(chTabReservations[i]);
            }
        }
        return foundResas.toArray(new Reservation[0]);
    }

}
