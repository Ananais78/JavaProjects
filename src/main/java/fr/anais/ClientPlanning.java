package fr.anais;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ClientPlanning {
    public static void main(String[] args) throws ExceptionPlanning {

        //on suppose que TAILLE = 3
        PlanningCollections planning = new PlanningCollections();
        Reservation res1 = new Reservation(
                new PlageHoraire(new Horaire(11,0),
                        new Horaire(13,45)),
                "Java",
                new DateCalendrier(4,3,2025));

        Reservation res2 = new Reservation(
                new PlageHoraire(new Horaire(12,0),
                        new Horaire(15,30)),
                "Java",
                new DateCalendrier(4,3,2025));
        Reservation res3 = new Reservation(
                new PlageHoraire(new Horaire(5,0),
                        new Horaire(7,30)),
                "Java",
                new DateCalendrier(4,3,2025));
        Reservation res4 = new Reservation(
                new PlageHoraire(new Horaire(19,0),
                        new Horaire(21,30)),
                "Java",
                new DateCalendrier(10,3,2025));

        //try{
        planning.ajout(res1);
        planning.ajout(res2);
        planning.ajout(res3);
        planning.ajout(res4);
        //}
        //catch(ExceptionPlanning e){
        //    System.out.println("Erreur : " + e.getMessage());
        //}

        try {
            Scanner scanner = new Scanner(new File("data"+File.separator+"planning.txt")).useDelimiter(",");
            List<Reservation> reservations = new ArrayList<>();

            while (scanner.hasNext()) {
                if (!scanner.hasNextInt())
                    scanner.next();

                int Heure = scanner.nextInt();
                int QuartHeure = scanner.nextInt();
                int chHeure = scanner.nextInt();
                int chQuartHeure = scanner.nextInt();
                String intitule = scanner.next();
                int jour = scanner.nextInt();
                int mois = scanner.nextInt();
                int annee = scanner.nextInt();
                Reservation res = new Reservation(new PlageHoraire(new Horaire(Heure,QuartHeure),new Horaire(chHeure,chQuartHeure)),
                        intitule, new DateCalendrier(jour,mois,annee));
                reservations.add(res);
                System.out.println("Ajout de "+res);
            }

            System.out.println("Oh, il y a " + reservations.size() + " reservations");

        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Fichier non trouvé");
        } catch (InputMismatchException e) { //format demandé n'est pas celui obtenu avec le scanner.next
            System.out.println("Format invalide. Se référrer à la documentation");
        } catch (NoSuchElementException e) {
            System.out.println("pas d'élément trouvé");
        } catch (IllegalStateException e) {
            System.out.println("pas le bon état");
        }

    }
}