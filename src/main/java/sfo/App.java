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
        int n = r.getN();
        UBQP ubqp = new UBQP(r.getN(), r.getConstantes(r.getN()));
        ubqp.printUBQP();
        ubqp.setN(ubqp.createInitialSolution());
        ubqp.printN();
        System.out.println(ubqp.calculateInitialSolution());
    }

}
