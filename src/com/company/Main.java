package com.company;


import java.io.IOException;

public class Main{


        public static void main(String[] args) throws IOException, InterruptedException {


            CashMachine ATM = new CashMachine();

            ATM.startCashMachine();
            ATM.closeCashMachine();

        }



    }
