package fr.anais;

public class ClientReservation {

    public static void main(String[] args) throws ExceptionPlanning {

        try{
            Reservation reservation1 = new Reservation(new PlageHoraire(new Horaire(15,15),
                    new Horaire(15,30)),"Véto",
                    new DateCalendrier(18,5,2021));

            Reservation reservation2 = new Reservation(new PlageHoraire(new Horaire(10,0),
                new  Horaire(19,15)),"Gym",
                new DateCalendrier(15,10,2021));

            System.out.println(reservation1);
            System.out.println(reservation2);

            System.out.println(reservation1.compareTo(reservation2));
        }
        catch(ExceptionPlanning e){
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
