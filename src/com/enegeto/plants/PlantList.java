package com.enegeto.plants;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlantList {
    /**Vytvoření seznamu květin
     *Vytvoř třídu pro ukládání seznamu pokojových květin. Jako atribut bude mít kolekci, uchovávající objekty s informacemi o květinách.
     * Přidej metody pro přidání nové květiny, získání květiny na zadaném indexu a odebrání květiny ze seznamu.
     */
    List<Plant> plantList = new ArrayList<>();


    ///region Methods

    /**Ošetření nesprávného vstupu
     *Ošetři zadávání frekvence zálivky — pokud je parametrem 0 nebo záporné číslo, systém vyhodí výjimku třídy PlantException s vhodným popisem.
     *Obdobně ošetřete zadávání data poslední zálivky — nesmí být starší než datum zasazení rostliny.
     * @param plant
     * @throws PlantException
     */
    public void addPlant(Plant plant) throws PlantException {
        if (plant.getFrequencyOfWatering() <= 0){
            throw new PlantException("The frequency of watering is smaller or equal to zero!!!");
        }
        if (plant.getPlanted().isAfter(plant.getWatering())){
            throw new PlantException("The date of last watering is before date of planting!!!");
        }
        plantList.add(plant);

    }

    public void removePlant(Plant plant){
        plantList.remove(plant);

    }

    public void printPlantList(){
        System.out.println("The plants of plant list: ");
        for (Plant plant : plantList){
            System.out.println("Plant: " + plant.getName() + " (" + plant.getNotes() +
                    "), planted " + plant.getPlanted() + ", last watering was " + plant.getWatering() +
                    ", watering period is " + plant.getFrequencyOfWatering() + " days");
        }
    }
    public void printPlantListWatering(){
        System.out.println("The plants of plant list - watering: ");
        for (Plant plant : plantList){
            System.out.println("Plant: " + plant.getName() + ", last watering was " + plant.getWatering() +
                    ", watering period is " + plant.getFrequencyOfWatering() + " days");
        }
    }


    public static void printParticularPlant(Plant plant){
            System.out.println("Particular plant is: " + plant.getName() + " (" + plant.getNotes() +
                    "), planted " + plant.getPlanted() + ", last watering was " + plant.getWatering() +
                    ", watering period is " + plant.getFrequencyOfWatering() + " days");

    }

    public Plant getPosition(int position) {
        return plantList.get(position);
    }

    public int getSize(){
        return plantList.size();
    }


    /** Method for loading data from a file
     */

    public void addDataFromFile (String filename) throws PlantException {
        int lineNumber = 0;
        String[] items = new String[0];
        String line = "";

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                line = scanner.nextLine();
                items = line.split("\t");
                Plant plant = new Plant(items[0], items[1], LocalDate.parse(items[4]),
                        LocalDate.parse(items[3]), Integer.parseInt(items[2]));

                plantList.add(plant);
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("File not found! File \"" +
                    filename + "\" is not available. " + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            throw new PlantException("Wrong number format on line no." +
                    lineNumber + "\n Line: " + line + "\n\"" + e.getLocalizedMessage() + "\"");
        } catch (DateTimeException e) {
            throw new PlantException("Wrong date format on line no." +
                    lineNumber + "\n Line: " + line + "\n\"" + e.getLocalizedMessage() + "\"");
        }
    }

        /** Method for saving data form list into a file
         */

        public void addDataIntoFile (String filename) throws PlantException {
            // int lineNumber = (int) FILENAME.lines().count();
            String line = "";

            try (PrintWriter outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
                for (Plant plant : plantList){
                    line = plant.getName() + "\t" + plant.getNotes() + "\t" + plant.getFrequencyOfWatering() + "\t" +
                            plant.getWatering() + "\t" + plant.getPlanted();

                    outputWriter.println(line);
                    }
                } catch (IOException e) {
                System.err.println("IOException problem");
                }
        }




        /** Method for encapsulation of the list
         */
            public List<Plant> getList(){
                return new ArrayList<>(plantList);
            }


    ///endregion




}
