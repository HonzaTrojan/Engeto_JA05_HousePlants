package com.enegeto.plants;

import java.util.Comparator;

public class FrequencyOfWateringComparator implements Comparator<Plant> {
    @Override
    public int compare(Plant o1, Plant o2) {
//        return Integer.compare(o1.getFrequencyOfWatering(), o2.getFrequencyOfWatering());     // řešení podle chatGPT
        int result;
       if (o1.getFrequencyOfWatering() > o2.getFrequencyOfWatering()) {
           result = 1;
       } if (o1.getFrequencyOfWatering() < o2.getFrequencyOfWatering()){
           result = -1;
        } else {
           result = 0;
        }

        return result;
    }
}
