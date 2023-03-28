package com.enegeto.plants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;


    ///region Getters and setters
    public String getName(){
        return name;
    }
    public void setName (String name){
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }
    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }
    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }
    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }
    ///endregion

    ///region Constructors
    public Plant (String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering){
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant (String name, LocalDate planted, int frequencyOfWatering){
        this(name, "", planted, LocalDate.now(), frequencyOfWatering);
    }

    public Plant (String name){
        this(name, "", LocalDate.now(), LocalDate.now(), 7);
    }



    ///endregion


    ///region Methods
    public static String getWateringInfo(Plant plant){
        LocalDate nextWatering = plant.getWatering().plusDays(plant.frequencyOfWatering);
        String info = "Plant: " + plant.getName() + ", last watering was " + plant.getWatering().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
                    " and the next watering will be at " + nextWatering;
        return info;
    }
    /** Method for keyboard reading
     */
    public static int keyboardRead(PlantList plantList) {
        int input = 0;
        do {
            System.out.print("Please enter the position you want to read out (-1 ends the program): ");
            input = Support.safeReadInt();
            if (input == -1) {
               System.out.println("You ended the program (result is automatically set for the first plant in the list)");
               return 0;
            }
            if (input < 0 && input != -1) System.err.println("You entered a negative number, try again!");
            if (input > (plantList.getSize()-1)) {
                System.err.println("The number is higher than number of plants in your list, try again!");
            }
        } while ((input != -1 && input < 0) || input >= plantList.getSize());                   // ????? proč zde nelze využít metodu plantList.size() ?
            return input;
    }






    ///endregion




}
