package com.company;

public class ConsoleInformer  {
    //public Results gameResults;

    ConsoleInformer(){
    }




    public void InputCard() {
        System.out.println("Please, input your card:");
    }

    public void turn(String turn) { System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:"); }

    public void win(String winner) { System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing."); }

    public void draw() {
        System.out.println("It's a draw! Thanks for playing.");
    }

    public void yourChoice(){
        System.out.println("Enter your choice");
    }

    public void invalidInputSlot(){
        System.out.println("Invalid input; re-enter slot number:");
    }

    public void invalidInputInMenu(){
        System.out.println("Invalid input; enter your choice:");
    }



    public void printMenu() { System.out.println( "0) Check your money\n" +
                                                  "1) Receive cash\n" +
                                                  "2) Replenish your card\n"); }


    public void enterName(String symbol){ System.out.println("You will play by "+symbol+". Enter your name please.");}
}
