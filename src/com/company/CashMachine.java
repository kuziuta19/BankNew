package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CashMachine {
    private Card activeCard;
    private ConsoleInformer consoleInformer =new ConsoleInformer();

    private Map<String, Card> cards = new HashMap<String, Card>();
    CashMachine(){

                Card a = new Card("1234-1234-1234-1234",1111,123);
                Card b = new Card("1234-1234-1234-1111",3333,124);
                Card c = new Card("1234-1234-1234-2222",2222,100);

                this.cards.put(a.getNumber(),a);
                this.cards.put(b.getNumber(),b);
                this.cards.put(c.getNumber(),c);
    }
    private long limit = 1000000000;
    public void receiveMoney(long cash){
        this.limit = this.limit-cash;
    }
    public boolean checkMoney(long money){
                if (money<this.limit)
                    return false;
                else return true;
    }

    public void startCashMachine(){
             Scanner in = new Scanner(System.in);

             do
             {
                 consoleInformer.InputCard();
                 String inputCard = in.nextLine();
                 if (inputCard.matches("\\d{4}\\-\\d{4}\\-\\d{4}\\-\\d{4}"))
                 {
                     if (cards.containsKey(inputCard))
                     {
                         do {
                             activeCard = cards.get(inputCard);
                             consoleInformer.yourPin();
                             int inputPIN = in.nextInt();

                             if (activeCard.checkPin(inputPIN)) {
                                 Menu menu = new Menu(activeCard);
                                 menu.startProgram();
                             }
                             else consoleInformer.pinError();
                         }
                         while (true);
                     }
                     else consoleInformer.cardFindError();

                 }
                 else consoleInformer.cardMatchesError();


             }
             while (true);
    }
}
