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

        /*KeyValue<Integer, FrenchIdentity> result = bInt.rechercheArbre(5400);
        System.out.println(result.getValue());

        result = bInt.rechercheSequentielle(5400);
//        KeyValue<Integer, FrenchIdentity> result = bInt.rechercheSequentielle(5400);
        System.out.println(result.getValue());*/
        //j'ai commenté parce que ça fait planter l'application quand j'essaye avec avec un nombre de clef differents de 10000
        
        
        //test de temps
        //1: rechercheArbre()
        long startTime = System.nanoTime();
        long minTime = 147483647;
        long maxTime = 0;
        for(int i=0; i<100; i++) {
            Integer val = (int)(Math.random() * (10000-1));
            long startTimeTmmp = System.nanoTime();
            bInt.rechercheArbre(val);
            long endTimeTmp = System.nanoTime();
            long timeElapsedTmp = endTimeTmp - startTimeTmmp;
            if(maxTime<timeElapsedTmp) {
                maxTime = timeElapsedTmp;
            }
            if(minTime>timeElapsedTmp){
                minTime = timeElapsedTmp;
            }
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        long moyenneParRecherche = timeElapsed/100;
        System.out.println();
        System.out.println("rechercheArbre() : " + moyenneParRecherche/1000 + " microsecondes d'execution en moyenne !");
        System.out.println("temps minimum : " + minTime/1000 + " microsecondes d'execution");
        System.out.println("temps maximum : " + maxTime/1000 + " microsecondes d'execution");

        //test de temps()
        //2: rechercheSequencielle
        startTime = System.nanoTime();
        minTime = 147483647;
        maxTime = 0;
        for(int i=0; i<100; i++) {
            Integer val = (int)(Math.random() * (10000-1));
            long startTimeTmmp = System.nanoTime();
            bInt.rechercheSequentielle(val);
            long endTimeTmp = System.nanoTime();
            long timeElapsedTmp = endTimeTmp - startTimeTmmp;
            if(maxTime<timeElapsedTmp) {
                maxTime = timeElapsedTmp;
            }
            if(minTime>timeElapsedTmp){
                minTime = timeElapsedTmp;
            }
        }
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        moyenneParRecherche = timeElapsed/100;
        System.out.println();
        System.out.println("rechercheSequentielle() : " + moyenneParRecherche/1000 + " microsecondes d'execution en moyenne !");
        System.out.println("temps minimum : " + minTime/1000 + " microsecondes d'execution");
        System.out.println("temps maximum : " + maxTime/1000 + " microsecondes d'execution");

    }

}
