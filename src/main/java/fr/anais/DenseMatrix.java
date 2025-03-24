package fr.anais;

public class DenseMatrix {
    private int nRow;
    private int nCol;
    private double[][] vals;

    // Constructeur par défaut
    public DenseMatrix() {
        this.nRow = 0;
        this.nCol = 0;
        this.vals = new double[0][0];
    }

    // Constructeur à partir d'un tableau de double
    public DenseMatrix(double[][] mat) {
        this.nRow = mat.length;
        this.nCol = mat[0].length;
        this.vals = new double[nRow][nCol];

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                this.vals[i][j] = mat[i][j];
            }
        }
    }

    // Constructeur qui initialise une matrice vide de taille n x m
    public DenseMatrix(int n, int m) {
        this.nRow = n;
        this.nCol = m;
        this.vals = new double[n][m];
    }

    // Accesseurs pour les dimensions de la matrice
    public int getRowDimension() {
        return nRow;
    }

    public int getColDimension() {
        return nCol;
    }

    // Méthode pour obtenir un élément (i, j)
    public double get(int i, int j) {
        return vals[i][j];
    }

    // Méthode pour modifier un élément (i, j)
    public void set(int i, int j, double aij) {
        vals[i][j] = aij;
    }

    // Méthode pour afficher la matrice
    public void write() {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                System.out.print(vals[i][j] + " ");
            }
            System.out.println();
        }
    }

}
