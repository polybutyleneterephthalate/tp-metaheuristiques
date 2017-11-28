package sfo;

public class UBQP {
    private int[][] constantes; // matrice n×n de constantes
    private int[] n; // n-uplet de variables binaires

    public UBQP(int n, int[][] constantes, int[] nUplet) {
        constantes = new int[n][n];
        this.constantes = constantes;
        this.n = nUplet;
    }
}
