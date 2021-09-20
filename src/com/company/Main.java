package com.company;
import java.util.*;
import java.util.Scanner;


public class Main{

    public static void main(String[] args) {

        Map<String, Card> cards = new HashMap<String, Card>();

        Card a = new Card("1234-1234-1234-1234",1111,123);
        Card b = new Card("1234-1234-1234-1111",3333,124);
        Card c = new Card("1234-1234-1234-2222",2222,100);

        cards.put(a.getNumber(),a);
        cards.put(b.getNumber(),b);
        cards.put(c.getNumber(),c);

        Card activeCard;

        Scanner in = new Scanner(System.in);
        ConsoleInformer consoleInformer =new ConsoleInformer();
        consoleInformer.InputCard();
        String inputCard = in.nextLine();
        if(inputCard.matches("\\d{4}\\-\\d{4}\\-\\d{4}\\-\\d{4}")&&cards.containsKey(inputCard))
        {
            activeCard = cards.get(inputCard);
            consoleInformer.yourPin();
            int inputPIN = in.nextInt();
            if(activeCard.checkPin(inputPIN)){
                Menu menu =new Menu(activeCard);
                menu.startProgram();

            }

        }








    }
}
