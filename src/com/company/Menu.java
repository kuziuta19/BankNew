package com.company;
import java.util.Scanner;

public class Menu {


    private Scanner in;

    private ConsoleInformer consoleInformer =new ConsoleInformer();
    private int choiceInput() {
        consoleInformer.yourChoice();
        int yourChoice = in.nextInt();
        while (!(yourChoice >= 0 && yourChoice <= 3)) {
            consoleInformer.invalidInputInMenu();
            yourChoice = in.nextInt();
        }
        return yourChoice;
    }

    public void startProgram(){
        int yourChoice;
        in = new Scanner(System.in);
        do {
            consoleInformer.printMenu();
            yourChoice = choiceInput();
            switch (yourChoice) {
                case 0: {
                    checkMoney();
                    break;
                }
                case 1:{
                    receiveCash();
                    break;}
                case 2:{
                    cardReplenish();
                    break;}
                case 3:{
                    System.exit(0);
                }
            }
        }
        while (yourChoice != 3) ;
    }
    /*public void newGame(){
        in = new Scanner(System.in);
        consoleInformer.enterName("X");
        String nameX = in.nextLine();

        consoleInformer.enterName("O");
        String nameO = in.nextLine();
        Player playerX = new Player(nameX);
        Player playerO = new Player(nameO);
        Game game=new Game(results,playerX,playerO);
        game.NewGame(in);
    }*/
    public void checkMoney(){

    };
    public void receiveCash(){

    };
    public void cardReplenish(){

    };
}
