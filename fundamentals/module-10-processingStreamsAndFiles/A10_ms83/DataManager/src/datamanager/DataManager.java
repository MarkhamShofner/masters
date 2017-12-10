/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanager;

import java.io.*;

/**
 * Read the text data file and write a reformatted file to be read
 * by the second program which will create the report to standard out.
 * @author mark8604
 */
public class DataManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.init();
    }

    public void init() {
        Row dataSet[] = new Row[13486]; // current number of rows in the dataset

        // read the data
        try ( FileReader fr = new FileReader("../SmallAreaIncomePovertyEstData.txt"))
        {
            int c;
            int i = 0;
            int j = 0;
            char rowInputs[] = new char[130]; // number of characters per row

            while((c = fr.read()) != -1) {
                rowInputs[i] = (char) c;
                i++;
                if ( c == 10) { // `32` is blank space, '10' is new line
                    dataSet[j] = new Row(rowInputs);
                    j++;
                    i = 0;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        // manipulate the data
        this.manipulateData(dataSet);

        // write the data
    }

    public Row[] manipulateData(Row[] dataset) {
        Row[] manipulatedData = new Row[57];

        try ( BufferedWriter bw = new BufferedWriter (new FileWriter("../SmallAreaIncomePovertyEstDataManipulated.txt")) )
        {
            int stateId = 1; // starting point id
            int statePopulation = 0;
            int stateChildPopulation = 0;
            int stateChildPovertyPopulation = 0;
            for (int i = 0; i < dataset.length; i++) {
                if (dataset[i].id == stateId) {
                    statePopulation += dataset[i].population;
                    stateChildPopulation += dataset[i].childPopulation;
                    stateChildPovertyPopulation += dataset[i].childPovertyPopulation;
                } else {
                    double stateChildPovertyPopulationPercentage = 0;
                    if (stateChildPopulation != 0) {
                        stateChildPovertyPopulationPercentage = (double) stateChildPovertyPopulation/stateChildPopulation*100;
                        int z = 12;
                    } else {
                        stateChildPovertyPopulationPercentage = 0;
                    }
                    bw.append(stateId + " \t " + statePopulation + " \t " + stateChildPopulation + " \t " + stateChildPovertyPopulation + " \t " +  stateChildPovertyPopulationPercentage + "\n");
                    statePopulation = 0;
                    stateChildPopulation = 0;
                    stateChildPovertyPopulation = 0;
                    i--;
                    stateId++;
                }
            }

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        int x = 12;
        return manipulatedData;
    };

    public class Row {
        private char[] contents;
        private int id;
        private int population;
        private int childPopulation; // Population of Relevant Children 5 to 17 years of Age
        private int childPovertyPopulation; // Estimated Number of Relevant Children 5 to 17 years old
//                     in Poverty Related to the Householder
        private double percentageChildPovertyPopulation;
        Row (char[] input) {
            contents = input;
            char [] stateIdPlaceholder = java.util.Arrays.copyOfRange(contents, 0, 2); // state id [char range]
            id = Integer.parseInt(new String(stateIdPlaceholder).trim());
            char[] tPopPlaceholder = java.util.Arrays.copyOfRange(contents, 83, 90); // total poulation [char range]
            population = Integer.parseInt(new String(tPopPlaceholder).trim());
            char[] cPopPlaceholder = java.util.Arrays.copyOfRange(contents, 92, 99); // child population [char range]
            childPopulation = Integer.parseInt(new String(cPopPlaceholder).trim());
            char[] cPPopPlaceholder = java.util.Arrays.copyOfRange(contents, 101, 108); // child poverty population [char range]
            try{
                childPovertyPopulation = Integer.parseInt(new String(cPPopPlaceholder).trim());
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }

}
