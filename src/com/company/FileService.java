package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public  class FileService {
    CashMachine ATM;

    FileService(CashMachine ATM){
        this.ATM =ATM;
    }
    public CashMachine putStateToFile(){
        try{
            File fileTwo=new File("filetwo.txt");
            FileOutputStream fos=new FileOutputStream(fileTwo);
            PrintWriter pw=new PrintWriter(fos);
            pw.println(this.ATM.getLimit());


            for(Map.Entry<String,Card> m :this.ATM.cards.entrySet()){
                pw.println(m.getKey()+" "+m.getValue().getPin()
                        +" "+m.getValue().getSum()
                        +" "+m.getValue().getBlockedState());
            }

            pw.flush();
            pw.close();
            fos.close();
        }catch(Exception e){}
        return ATM;
    }
    public CashMachine getFileState(){
        try{
            File toRead=new File("filetwo.txt");
            FileInputStream fis=new FileInputStream(toRead);

            Scanner sc=new Scanner(fis);

            if(sc.hasNextLine()) {
                this.ATM.setLimit(Long.parseLong(sc.nextLine()));


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

                    this.ATM.cards.put(a.getNumber(),a);


                }
                fis.close();

                //print All data in MAP
                /* for (Map.Entry<String, Card> m : this.cards.entrySet()) {
                    System.out.println(m.getKey() + " : " + m.getValue());
                }*/
            }
        }catch(Exception e){}
        return ATM;
    }
}
