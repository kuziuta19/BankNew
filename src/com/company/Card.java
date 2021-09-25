package com.company;

public class Card{

    Card(String cardNumber,int pin,long sum) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.sum = sum;

    }
    private String cardNumber;
    public String getNumber(){
        return this.cardNumber;
    }
    private int pin;
    public int getPin(){
        return this.pin;
    }
    public boolean checkPin(int pin){
        if(this.pin ==pin)
        return true;
        else return false;
    }
    private long sum;
    public long getSum(){
        return this.sum;
    }
    private boolean isBlocked = false;
    public boolean getBlockedState(){
        return this.isBlocked;
    }

    public void replenishCard(long cash){
        this.sum = this.sum+cash;
    }
    public void receiveMoney(long cash){
        this.sum = this.sum-cash;
    }
}
