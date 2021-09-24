package com.company;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;


public class Menu extends CashMachine{

    Menu(Card activeCard){
      this.activeCard = activeCard;
    }
    public Card activeCard;
    private Scanner in;



    private int choiceInput() {
        CashMachine.consoleInformer.yourChoice();
        int yourChoice = in.nextInt();
        while (!(yourChoice >= 0 && yourChoice <= 3)) {
            CashMachine.consoleInformer.invalidInputInMenu();
            yourChoice = in.nextInt();
        }
        return yourChoice;
    }

    public void startProgram() throws IOException, InterruptedException {

        int yourChoice;
        in = new Scanner(System.in);
        do {
            CashMachine.consoleInformer.printMenu();
            yourChoice = choiceInput();
            switch (yourChoice) {
                case 0: {
                    checkMoney(activeCard);
                    break;
                }
                case 1:{
                    receiveCash();
                    break;}
                case 2:{
                    cardReplenish();
                    break;}
                case 3:{
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    super.startCashMachine();
                }
            }
        }
        while (yourChoice != 3) ;
    }

    public void checkMoney(Card a){
        CashMachine.consoleInformer.CheckMoneyInCard(a);
    }
    public void receiveCash(){
        long cash;
        do {
            CashMachine.consoleInformer.receiveMoney();
            cash = in.nextLong();
        }
        while (activeCard.getSum()<cash&&super.checkMoney(cash))
            ;
        activeCard.receiveMoney(cash);
        super.receiveMoney(activeCard.getNumber(),cash);

    }
    public void cardReplenish(){

    }

}
