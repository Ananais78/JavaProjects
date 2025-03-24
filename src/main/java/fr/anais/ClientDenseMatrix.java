package fr.anais;

public class ClientDenseMatrix {
    public static void main(String[] args) {
        // Définition des matrices A, B et C
        double[][] A_vals = {
                {4, 1, -2},
                {0, 1, 1},
                {1, -2, 0}
        };

        double[][] B_vals = {
                {2, -1, 1},
                {0, 1, 0}
        };

        double[][] C_vals = {
                {3, -1},
                {1, 0},
                {0, 2}
        };

        // Création des objets DenseMatrix
        DenseMatrix A = new DenseMatrix(A_vals);
        DenseMatrix B = new DenseMatrix(B_vals);
        DenseMatrix C = new DenseMatrix(C_vals);

        // Affichage des matrices
        System.out.println("Matrice A :");
        A.write();
        System.out.println("\nMatrice B :");
        B.write();
        System.out.println("\nMatrice C :");
        C.write();

    }
}
