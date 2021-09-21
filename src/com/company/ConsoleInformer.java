package com.company;

public class ConsoleInformer  {


    ConsoleInformer(){
    }




    public void InputCard() {
        System.out.println("Please, input your card:");
    }

    public void CheckMoneyInCard(Card a) { System.out.println("Your money:"+a.getSum());
 }
    public void receiveMoney() { System.out.println( "How much money do you want to withdraw? : "); }

    public void cardFindError(){ System.out.println("ATM does not find your card. Input other card!"); }

    public void pinError() {
        System.out.println("Invalid PIN!");
    }

    public void yourChoice(){
        System.out.println("Enter your choice");
    }

    public void yourPin(){
        System.out.println("Enter your pin");
    }

    public void cardMatchesError(){
        System.out.println("Invalid input; Your card does not match the template");
    }

    public void invalidInputInMenu(){
        System.out.println("Invalid input; enter your choice:");
    }



    public void printMenu() { System.out.println( "0) Check your money\n" +
                                                  "1) Receive cash\n" +
                                                  "2) Replenish your card\n"); }

}
