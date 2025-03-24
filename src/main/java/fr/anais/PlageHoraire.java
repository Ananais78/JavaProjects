package fr.anais;

public class PlageHoraire implements Comparable<PlageHoraire> {
    public static final int dureeMinimal = 60;

    private Horaire horaireDebut;
    private Horaire horaireFin;

    public PlageHoraire(Horaire horaireDebut, Horaire horaireFin) throws ExceptionPlanning{
        if (Math.abs(horaireDebut.toMinutes() - horaireFin.toMinutes()) < dureeMinimal)
            throw new ExceptionPlanning(0);
        this.horaireDebut = horaireDebut;
        this.horaireFin = horaireFin;
    }

    @Override
    public String toString() {
        return horaireDebut + "-" + horaireFin + " durée : " + duree();
    }

    public Horaire duree(){
        int duree = Math.abs(horaireDebut.toMinutes() - horaireFin.toMinutes());
        return new Horaire(duree / 60, duree % 60);
    }

    @Override
    public int compareTo(PlageHoraire plageHoraire) {

        if (this.horaireFin.toMinutes() <= plageHoraire.horaireDebut.toMinutes()) {
            return -1;
        }
        else if (plageHoraire.horaireFin.toMinutes() <= this.horaireDebut.toMinutes()) {
            return 1;
        }
        return 0;

    }

}