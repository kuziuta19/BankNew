package com.company;

public class Card {
    Card(String cardNumber,int pin,int sum) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.sum = sum;

    }
    private String cardNumber;
    public String getNumber(){
        return this.cardNumber;
    }
    private int pin;
    public boolean checkPin(int pin){
        if(this.pin ==pin)
        return true;
        else return false;
    }
    private int sum;
    public int getSum(){
        return this.sum;
    }
    private boolean isBlocked = false;



}
