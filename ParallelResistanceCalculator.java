package com.company;

import java.util.Scanner;

public class ParallelResistanceCalculator {

    public static void main(String[] args)
    {

        Scanner userInput = new Scanner(System.in);

        double resistance1;
        double resistance2;
        double resistance3;
        double totalResistance;

        System.out.print("What is the value of resistor 1? ");
        resistance1 = userInput.nextDouble();

        System.out.print("What is the value of resistor 2? ");
        resistance2 = userInput.nextDouble();

        System.out.print("What is the value of resistor 3? ");
        resistance3 = userInput.nextDouble();

        totalResistance = (1 / ( (1 / resistance1) + (1 / resistance2) + (1 / resistance3) ) );

        System.out.print("The total resitance is " + totalResistance + " Ohms.");



    }
}
