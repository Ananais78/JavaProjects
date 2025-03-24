package fr.anais;

import java.util.concurrent.Semaphore;

public class Reservation implements Comparable<Reservation> {
    private PlageHoraire chPlageHoraire;
    private String chintitule;
    private DateCalendrier chdate;

    public Reservation (PlageHoraire parPlageHoraire, String parintitule, DateCalendrier pardate) throws ExceptionPlanning {
        chPlageHoraire = parPlageHoraire;
        chintitule = parintitule;
        chdate = pardate;

        if (!chdate.estValide())
            throw new ExceptionPlanning(0);
    }

    public String toString() {
        return chintitule + ", " + chPlageHoraire.toString() + ", " + chdate.toString();
    }

    @Override
    public int compareTo(Reservation o) {
        if (chdate.estValide() && o.chdate.estValide()) {
            if (chdate.compareTo(o.chdate) == 0) {
                if (chPlageHoraire.compareTo(o.chPlageHoraire) == 0) {
                    return 0;
                } else if (chPlageHoraire.compareTo(o.chPlageHoraire) < 0) {
                    return -1;
                } else if (chPlageHoraire.compareTo(o.chPlageHoraire) > 0) {
                    return 1;
                }
            } else if (chdate.compareTo(o.chdate) > 0) {
                return 1;
            }
            return -1;
        }
        else return -5;
    }

    public boolean estValide() {
        return (chdate.estValide());
    }

    public DateCalendrier getChdate() {
        return chdate;
    }

    public PlageHoraire getChPlageHoraire() {
        return chPlageHoraire;
    }

    public String getChintitule() {
        return chintitule;
    }
}
