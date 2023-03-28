/**Ošetření nesprávného vstupu
 *Vytvoř novou třídu výjimek s názvem PlantException. Bude potomkem (extends) třídy Exception
 */

package com.enegeto.plants;

public class PlantException extends Exception {

    public PlantException(String message){
        super(message);
    }


}
