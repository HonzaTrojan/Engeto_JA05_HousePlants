package com.enegeto.plants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Plant implements Comparable<Plant>{
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;


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




    ///region Methods
    public static String getWateringInfo(Plant plant){
        LocalDate nextWatering = plant.getWatering().plusDays(plant.frequencyOfWatering);
        String info = "Plant: " + plant.getName() + ", last watering was " +
                plant.getWatering().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
                    " and the next watering will be at " + nextWatering;
        return info;
    }

    @Override
    public int compareTo(Plant o) {
        return getName().compareTo(o.getName());
    }


    ///endregion




}
