package fr.anais;

import java.util.Scanner;

public class Date {
    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    public Date(int parJour, int parMois, int parAnnee) {
        chJour = parJour;
        chMois = parMois;
        chAnnee = parAnnee;
    }

    public Date(int parAnnee) {
        chAnnee = parAnnee;
        chMois = 1;
        chJour = 1;
    }

    public static Date lireDate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("entre le jour:");
        int scJour = sc.nextInt();
        System.out.println("entre le mois:");
        int scMois = sc.nextInt();
        System.out.println("entre le annee:");
        int chAnnee = sc.nextInt();
        return new Date(scJour,scMois,chAnnee);
    }

    public boolean estValide() {
        if (chAnnee < 1583) {
            return false;
        }
        if (chMois > 12) {
            return false;
        }
        if (chJour > dernierJourMois(chMois,chAnnee)) {
            System.out.println("jour invalide"+chJour+";"+dernierJourMois(chMois,chAnnee));
            return false;
        }
        return true;
    }

    private static int dernierJourMois(int parMois,int parAnnee) {
        switch (parMois) {
            case 2:
                return estBissextile(parAnnee) ?29:28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static boolean estBissextile(int parAnnee) {
        return parAnnee%4==0;
    }

    public int compareTo(Date parDate) {
        if (chAnnee == parDate.chAnnee && chMois == parDate.chMois && chJour == parDate.chJour) {
            return 0;
        }
        if (chAnnee > parDate.chAnnee) {
            return 1;
        }
        if (chMois > parDate.chMois) {
            return 1;
        }
        if (chJour > parDate.chJour) {
            return 1;
        }
        return -1;
    }



    @Override
    public String toString() {
        return chJour+"-"+chMois+"-"+chAnnee;
    }

}