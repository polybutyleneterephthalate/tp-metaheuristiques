package sfo;

import java.io.*;

public class UBQPReader {

    private String fileName;

    public UBQPReader(String fileName) {
        this.fileName = fileName;
    }

    public int getValueAt(int i) {
        File file = new File(fileName);
        FileInputStream fileReader;
        String line;
        String[] lineData;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            line = bufferedReader.readLine();
            lineData = line.split(" ");
            return Integer.parseInt(lineData[i]);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getN(){
        return getValueAt(0);

    }

    public int getP(){
        return getValueAt(1);
    }

    public int[][] getConstantes(int lineSize) {
        int[][] values = new int[lineSize][lineSize];
        File file = new File(fileName);
        FileInputStream fileReader;
        String line;
        String[] lineData;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            line = bufferedReader.readLine();
            lineData = line.split(" ");
            int k = 2;
            for (int i = 0; i < lineSize; i++) {
                for (int j = 0; j < lineSize; j++) {
                    values[i][j] = Integer.parseInt(lineData[k++]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return values;
        }
        return values;
    }

}
