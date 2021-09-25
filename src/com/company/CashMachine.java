package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CashMachine {

    FileService reader = new FileService(this);
    public static ConsoleInformer consoleInformer =new ConsoleInformer();

    public Map<String, Card> cards = new HashMap<String, Card>();
    CashMachine(){
        reader.getFileState();
    }

    private long limit = 1000000000;
    public long getLimit(){
        return this.limit;
    }
    public void setLimit(long limit){
        this.limit = limit;
    }

    public void receiveMoney(String cardNumber, long cash){
        this.cards.get(cardNumber).receiveMoney(cash);
        this.limit = this.limit-cash;

    }
    public void replenishCard(String cardNumber, long cash){
        this.cards.get(cardNumber).replenishCard(cash);
        this.limit = this.limit+cash;

    }

    public boolean checkMoney(long money){
        if (money<this.limit)
            return true;
        else return false;
    }


    public void startCashMachine() throws IOException, InterruptedException {



        String inputCard ;
        do
        {
            consoleInformer.startCashMachine();
            Scanner in = new Scanner(System.in);
            inputCard = in.nextLine();

            if (!inputCard.matches("\\d{4}\\-\\d{4}\\-\\d{4}\\-\\d{4}")&&inputCard=="exit")
            {
                consoleInformer.cardMatchesError();
            }
            else  if (cards.containsKey(inputCard))
                    {
                    boolean flag=false;
                    do {

                        consoleInformer.yourPin();
                        int inputPIN = in.nextInt();

                        if (this.cards.get(inputCard).checkPin(inputPIN)) {
                            Menu menu = new Menu(this.cards.get(inputCard));
                            menu.startProgram();
                            flag=true;
                        }
                        else consoleInformer.pinError();

                    }
                    while (!flag);
                    }
                    else{ if(inputCard=="exit")
                    consoleInformer.cardFindError();
                    }

        }
        while (inputCard=="exit");
    }
    public void closeCashMachine() {
        reader.putStateToFile();
    }

}
