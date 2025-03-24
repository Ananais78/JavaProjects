package fr.anais;

public class ExceptionPlanning extends Exception implements ConstantesErreurs {
    private int chCodeErreur;
    //constructeur
    public ExceptionPlanning(int parCodeErreur){
        super(ERREURS_PLANNING[parCodeErreur]); //appel au constructeur de la classe mère (Exception)
        this.chCodeErreur = parCodeErreur;
    }

    public int getChCodeErreur() {
        return chCodeErreur;
    }

    private String getMessageErreur(){
        return ERREURS_PLANNING[chCodeErreur];
    }
}
