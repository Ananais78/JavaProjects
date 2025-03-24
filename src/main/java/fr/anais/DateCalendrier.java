package fr.anais;

import java.time.DayOfWeek;
import java.util.Calendar;

public class DateCalendrier extends Date implements ConstantesCalendrier {
    private int chSemaine;
    public DateCalendrier(int parJour, int parMois, int parAnnee) {
        super(parJour,parMois,parAnnee);
        Calendar today = Calendar.getInstance();

        chAnnee = today.get(Calendar.YEAR);
        chMois = today.get(Calendar.MONTH);
        chJour = today.get(Calendar.DAY_OF_MONTH);
        chSemaine = today.get(Calendar.WEEK_OF_YEAR);
//
//        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
//
//        if (dayOfWeek == 1){
//            dayOfWeek = 7;
//        }
//        else {
//            dayOfWeek = dayOfWeek - 1;
//        }
    }

    public void setChJour(int chJour) {this.chJour = chJour;}
    public void setChMois(int chMois) {this.chMois = chMois;}
    public void setChAnnee(int chAnnee) {this.chAnnee = chAnnee;}

    public int getSemaine() {
        return chSemaine;
    }

    @Override
    public String toString(){
        return chJour + " " + MOIS[chMois - 1] + " " + chAnnee;
    }

}
