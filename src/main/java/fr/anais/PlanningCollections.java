package fr.anais;

import java.util.*;

public class PlanningCollections {
    private List<Reservation> chListReservations;
    private Set<Reservation> chSetReservations;
    private Map<Integer, List<Reservation>> chResParSemaines;

    public PlanningCollections() {
        chListReservations = new ArrayList<>();
        chSetReservations = new TreeSet<>(); //pas obligé de mettre Reservation entre <>
        chResParSemaines = new TreeMap<>();
    }

    @Override
    public String toString() {
        return "TreeSet "+ chSetReservations.size() + " - " + chSetReservations //= chSetReservations.toString(); (la méthode toString() n'a pas besoin d'être appelée
                + "\n" + "ArrayList " + chListReservations.size() + " - " + chListReservations;
    }

    /** ajout de parReservation (classe Reservation)
     * à la liste des réservations et au set des réservations
     *
     * @param parReservation
     *
     * lève ExceptionPlanning quand parReservation
     * n'est pas compatible avec une réservation du planning
     */

    public void ajout (Reservation parReservation) throws ExceptionPlanning {
        // ajout à la liste
        // on fait un parcours avec itérateur
        Iterator<Reservation> iterateur = chListReservations.iterator();
        while (iterateur.hasNext()) {
            Reservation res = iterateur.next();
            if (parReservation.compareTo(res) == 0) {
                throw new ExceptionPlanning(2); // 2 pour incompatible
            }
        }
        chListReservations.add(parReservation);

        // ajout au Set
        int sizeInitiale = chSetReservations.size();
        chSetReservations.add(parReservation);

        if (sizeInitiale == chSetReservations.size()) {
            throw new ExceptionPlanning(2);
        }

        int semaine = parReservation.getChdate().getSemaine();

        if (!chResParSemaines.containsKey(semaine))
            chResParSemaines.put(semaine, new ArrayList<>());

        chResParSemaines.get(semaine).add(parReservation);
    }

    /** retourne l'ensemble des réservations du planning (classe Reservation)
     * ayant pour date parDate ou null si aucune réservation n'a lieu à cette date
     *
     * @param parDate
     */

    public TreeSet<Reservation> getReservations(DateCalendrier parDate) {
        Iterator<Reservation> iterateur = chSetReservations.iterator();
        TreeSet<Reservation> reservations = new TreeSet<Reservation>();
        while (iterateur.hasNext()) {
            Reservation res = iterateur.next();
            if (parDate.compareTo(res.getChdate()) == 0) {
                reservations.add(res);
            }
        }
        return reservations;
    }

    /** retourne l'ensemble des reservations du planning contenant la chaîne
     * parString dans leur intitulé
     *
     * @param parString
     */

    public TreeSet<Reservation> getReservation(String parString) {
        Iterator<Reservation> iterateur = chSetReservations.iterator();
        TreeSet<Reservation> reservations = new TreeSet<Reservation>();
        while (iterateur.hasNext()) {
            Reservation res = iterateur.next();
            if (parString.toLowerCase().contains(res.getChintitule().toLowerCase())) { //toLowerCase met tout en minuscules
                // contains compare 2 chaines de caractères (si une contient l'autre)
                reservations.add(res);
            }
        }
        return reservations;
    }


}
