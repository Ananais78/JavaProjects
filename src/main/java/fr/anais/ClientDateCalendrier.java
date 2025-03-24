package fr.anais;

public class ClientDateCalendrier {
    public static void main(String... args){
        DateCalendrier dateCalendrier1 = new DateCalendrier(15,3,2024);

        dateCalendrier1.setChJour(19);
        dateCalendrier1.setChMois(11);
        dateCalendrier1.setChAnnee(2024);

        System.out.println(dateCalendrier1.toString());
    }
}