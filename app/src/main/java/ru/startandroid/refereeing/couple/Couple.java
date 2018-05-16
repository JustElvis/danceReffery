package ru.startandroid.refereeing.couple;

/**
 * Created by Slav on 26.12.2016.
 */

public class Couple {
    private String number;
    private int place;
    public Couple (String number, int place){
        this.number = number;
        this.place = place;
    }
    public String getNumber(){
        return number;
    }
    public int getPlace(){
        return place;
    }


}
