package fr.anais;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Horaire heure1 = new Horaire(23,45);

        System.out.println(heure1.toString());
        System.out.println(heure1.getChHeure());
        System.out.println(heure1.getChQuartHeure());
        System.out.println(heure1.toMinutes());
        heure1.setChHeure(12);
        heure1.setChQuartHeure(15);
        System.out.println(heure1);
        System.out.println(heure1.toMinutes());
    }


}