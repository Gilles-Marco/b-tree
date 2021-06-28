package fr.miage.fsgbd;

import java.io.*;

public class MainNoGUI {

    public static void main(String args[]) {
        BufferedReader reader = null;
        TestInteger testInt = new TestInteger();
        BTreePlus<Integer, FrenchIdentity> bInt = new BTreePlus<Integer, FrenchIdentity>(4, testInt);
        try {
            reader = new BufferedReader(new FileReader(new File("C:\\Users\\lordi\\Documents\\MEGA\\Cours\\M1\\S8\\SGBD\\b-tree\\data.csv")));
            String line = reader.readLine();
            int indexRow = 0;
            while (line != "" && line != null) {
                String[] tokens = line.split(";");
                if (indexRow > 0) { // Ignore header
                    if (tokens.length == 5) {
                        FrenchIdentity identity = new FrenchIdentity(tokens[4], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                        bInt.addValeur(new KeyValue<Integer, FrenchIdentity>(Integer.parseInt(tokens[0]), identity));
                    }
                }
                try {
                    line = reader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                indexRow++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data successfully loaded !");

        KeyValue<Integer, FrenchIdentity> result = bInt.rechercheArbre(5400);
        System.out.println(result.getValue());

        result = bInt.rechercheSequentielle(5400);
//        KeyValue<Integer, FrenchIdentity> result = bInt.rechercheSequentielle(5400);
        System.out.println(result.getValue());

    }

}
