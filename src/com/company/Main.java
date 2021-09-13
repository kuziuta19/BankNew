package com.company;

import java.util.Scanner;


public class Main{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);;
        ConsoleInformer consoleInformer =new ConsoleInformer();
        consoleInformer.InputCard();
        String inputCard = in.nextLine();
        if(inputCard.matches("\\d{4}\\-\\d{4}\\-\\d{4}\\-\\d{4}"))
        {
          int inputPIN = in.nextInt();
        };







        Menu menu =new Menu();
        menu.startProgram();
    }
}
