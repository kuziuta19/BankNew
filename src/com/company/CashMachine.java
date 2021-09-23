package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CashMachine {

    private ConsoleInformer consoleInformer =new ConsoleInformer();

    public Map<String, Card> cards = new HashMap<String, Card>();
    CashMachine(){
                getFileState();
    }

    private long limit = 1000000000;

    public void receiveMoney(String cardNumber, long cash){
        this.cards.get(cardNumber).receiveMoney(cash);
        this.limit = this.limit-cash;
    }
    public boolean checkMoney(long money){
                if (money<this.limit)
                    return true;
                else return false;
    }
    public void putStateToFile(Map<String, Card> cards){
        try{
            File fileOne=new File("fileone.txt");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(cards);
            oos.flush();
            oos.close();
            fos.close();

        }catch(Exception e){}

    }
    public void putStateToFile(){
        try{
            File fileTwo=new File("C:\\Users\\k702_3\\IdeaProjects\\Next\\src\\files\\filetwo.txt");
            FileOutputStream fos=new FileOutputStream(fileTwo);
            PrintWriter pw=new PrintWriter(fos);
            pw.println(this.limit);


            for(Map.Entry<String,Card> m :this.cards.entrySet()){
                pw.println(m.getKey()+" "+m.getValue().getPin()
                        +" "+m.getValue().getSum()
                        +" "+m.getValue().getBlockedState());
            }

            pw.flush();
            pw.close();
            fos.close();
        }catch(Exception e){}
    }
    public void getFileState(){
        try{
            File toRead=new File("C:\\Users\\k702_3\\IdeaProjects\\Next\\src\\files\\filetwo.txt");
            FileInputStream fis=new FileInputStream(toRead);

            Scanner sc=new Scanner(fis);

            if(sc.hasNextLine()) {
                this.limit=Long.parseLong(sc.nextLine());


                while (sc.hasNextLine()) {

                    String cardNumber = null;
                    int pin = 0;
                    long sum = 0;
                    String[] currentLine;
                    currentLine = sc.nextLine().split(" ");
                    for(int i=0;i<currentLine.length;i++){
                        if(i == 0){
                            cardNumber = currentLine[i];}
                        if(i == 1){
                            pin = Integer.parseInt(currentLine[i]);}
                        if (i == 2){
                            sum = Long.parseLong(currentLine[i]);}
                    }
                    Card a = new Card(cardNumber,pin,sum);

                    this.cards.put(a.getNumber(),a);


                }
                fis.close();

                //print All data in MAP
                /* for (Map.Entry<String, Card> m : this.cards.entrySet()) {
                    System.out.println(m.getKey() + " : " + m.getValue());
                }*/
            }
    }catch(Exception e){}
    }
    public void startCashMachine() throws IOException, InterruptedException {

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

                             consoleInformer.yourPin();
                             int inputPIN = in.nextInt();

                             if (this.cards.get(inputCard).checkPin(inputPIN)) {
                                 Menu menu = new Menu(this.cards.get(inputCard));
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
