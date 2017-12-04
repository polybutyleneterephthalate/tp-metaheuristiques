package sfo;

import java.util.Random;

public class UBQP {
    private int[][] constantes; // matrice n×n de constantes
    private int[] n; // n-uplet de variables binaires

    public UBQP(int n, int[][] constantes) {
        this.constantes = new int[n][n];
        this.constantes = constantes;
        this.n = new int[n];
    }

    public int[] createInitialSolution() {
        int[] solution = new int[n.length];
        for (int i = 0; i < n.length; i++) {
            solution[i] = new Random().nextInt(2);
        }
        return solution;
    }

    public void setN(int[] n) {
        for (int i = 0; i < this.n.length; i++) {
            this.n[i] = n[i];
        }
    }

    public void printUBQP() {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                System.out.print(constantes[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void printN() {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
        System.out.println("");
    }

    public int[][] transposeN() {
        int[][] temp = new int[1][n.length];
        for (int i = 0; i < n.length; i++)
            temp[0][i] = n[i];
        return temp;
    }

    public int[][] getMatrixN() {
        int[][] temp = new int[n.length][1];
        for (int i = 0; i < n.length; i++)
            temp[i][0] = n[i];
        return temp;
    }

    static int[][] multiplier(int[][] MA, int[][] MB) {

        int[][] MC;
        int l, c;

        if (MA.length * MA[0].length < MB.length * MB[0].length) {
            l = MB.length;
            c = MB[0].length;
        } else {
            l = MA.length;
            c = MA[0].length;
        }
        MC = new int[l][c];
        l = 0;
        for (int i = 0; i < MA.length; i++) { /// Ligne de MA
            c = 0;
            for (int n = 0; n < MB[0].length; n++) { /// colonne de  MB

                int calcul = 0;
                for (int m = 0; m < MB.length; m++) {  /// colone de MA et ligne de MB
                    calcul += MA[i][m] * MB[m][n];
                }
                MC[l][c] = calcul;
                c++;
            }
            l++;
        }


        return MC;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int calculateInitialSolution(){
        int[][] solution = multiplier(multiplier(transposeN(), constantes), getMatrixN());
        return solution[0][0];
    }
}
