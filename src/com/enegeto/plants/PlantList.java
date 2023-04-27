package com.enegeto.plants;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;


public class PlantList {

    List<Plant> plantList = new ArrayList<>();


    ///region Methods


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




    public void addDataFromFile (String filename) throws PlantException {
        int lineNumber = 0;
        String[] items;
        String line = "";

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                line = scanner.nextLine();
                items = line.split(Settings.DELIMITER);
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



        public void addDataIntoFile (String filename) throws PlantException {
            // int lineNumber = (int) FILENAME.lines().count();
            String line = "";

            try (PrintWriter outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
                for (Plant plant : plantList){
                    line = plant.getName() + Settings.DELIMITER + plant.getNotes() + Settings.DELIMITER + plant.getFrequencyOfWatering() +
                            Settings.DELIMITER + plant.getWatering() + Settings.DELIMITER + plant.getPlanted();

                    outputWriter.println(line);
                    }
                } catch (IOException e) {
                System.err.println("IOException problem");
                }
        }


        public List<Plant> sortList (){
            Collections.sort(plantList);
            return plantList;
        }

        public List<Plant> sortByWatering (){
            Collections.sort(plantList, (o1, o2) -> o1.getWatering().compareTo(o2.getWatering()));
            return plantList;
    }



            public List<Plant> getList(){
                return new ArrayList<>(plantList);
            }




    ///endregion




}
