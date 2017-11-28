package sfo;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        UBQPReader r = new UBQPReader(new File("").getAbsolutePath() + "/data/partition6.txt");
        int n = r.getN(); System.out.println("n = " + n);
        int[][] data = new int[n][n];
        data = r.getConstantes(n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
