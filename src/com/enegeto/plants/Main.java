/*  Domácí úkol lekce 5: Pokojové rostliny
  * Zadání
  *     Vytvoř datové třídy pro sledování zalévání domácích pokojových rostlin.
 *     Případné chybové stavy ošetři pomocí výjimek.
 *     Připrav metody pro načtení dat ze souboru a pro uložení dat zpět do souboru.
 *
 */

package com.enegeto.plants;

import java.time.LocalDate;
import java.util.*;

import static com.enegeto.plants.PlantList.printParticularPlant;
import static com.enegeto.plants.Support.keyboardRead;

public class Main {
    public static void main(String[] args) throws PlantException {

        Plant plant1 = new Plant("Monstera", "is sensitive to straight sunshine", LocalDate.of(2022, 3,15), LocalDate.of(2023,3,1), 10);
        Plant plant2 = new Plant("MeatEatingMonster", LocalDate.of(2020,4,15), 10);
        Plant plant3 = new Plant("Ficus");

        // System.out.println(getWateringInfo(plant3));

        PlantList plantList = new PlantList();
        try {
            plantList.addPlant(plant1);
            plantList.addPlant(plant2);
            plantList.addPlant(plant3);

        } catch (PlantException e){
            System.err.println(e.getLocalizedMessage());
        }

        System.out.println("Size of your garden is now " + plantList.getSize() + " plants" + "\n---------------");
        plantList.printPlantList();



        printParticularPlant(plantList.getPosition(keyboardRead(plantList)));
        System.out.println("---------------");




        try {
            plantList.addDataFromFile(Settings.FILENAME);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());

        }



        plantList.printPlantListWatering();
        System.out.println("-------------------");

        plantList.addPlant(new Plant("Horsetail", "From prehistoric times", LocalDate.of(100, 1, 6), LocalDate.of(1950, 6, 17), (26645)));
        plantList.addPlant(new Plant("Eucalypt", "Not for eating!", LocalDate.now().minusDays(20), LocalDate.now().minusDays(10), (21)));

        plantList.removePlant(plantList.getPosition(3));


        try {
            plantList.addDataIntoFile(Settings.OUTPUT_FILENAME);
        } catch (PlantException e){
            System.err.println(e.getLocalizedMessage());
        }


        try {
            plantList.addDataFromFile(Settings.FILENAME);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        System.out.println("Print before sorting:");
        plantList.printPlantList();
        System.out.println("-------------------");


        System.out.println("Print after sorting by name:");
        plantList.sortList();
        plantList.printPlantList();
        System.out.println("-------------------");

        System.out.println("Print after sorting by date of watering:");
        plantList.sortByWatering();
        plantList.printPlantList();
        System.out.println("-------------------");

        System.out.println("Dates of flowers planting: ");
        Set<LocalDate> setPlanted = new HashSet<>();
        setPlanted = plantList.getDatePlanted();
        System.out.println(setPlanted);

        System.out.println("Dates of flowers planting last month: ");
        Set<LocalDate> setPlantedLastMonth = new HashSet<>();
        setPlantedLastMonth = plantList.getDatePlantedLastMonth();
        System.out.println(setPlantedLastMonth);

        System.out.println("Print after sorting by frequency of watering (comparator class):");
        plantList.sortByFrequencyOfWatering();
        plantList.printPlantList();
        System.out.println("-------------------");




    }




}