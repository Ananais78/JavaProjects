package fr.anais;

public class Horaire {
    private int chHeure;
    private int chQuartHeure;

    public Horaire(int parHeure, int parQuartHeure) {
        chHeure = parHeure;
        chQuartHeure = parQuartHeure;
    }

    public int toMinutes() {
        return chHeure * 60 + chQuartHeure;
    }

    public int getChQuartHeure() {
        return chQuartHeure;
    }

    public int getChHeure() {
        return chHeure;
    }

    public void setChHeure(int chHeure) {
        this.chHeure = chHeure;
    }

    public void setChQuartHeure(int chQuartHeure) {
        this.chQuartHeure = chQuartHeure;
    }

    public String toString() {
        return chHeure + "h" + chQuartHeure;
    }
}
