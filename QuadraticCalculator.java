package com.company;

import java.util.Scanner;

public class QuadraticCalculator {

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        double a;
        double b;
        double c;
        double x1;
        double x2;

        System.out.print("The Quadratic Formula is : x = (-b \u00B1 \u221A(b\u00B2 - 4ac)) / 2a \n");

        System.out.print("What is the value of 'a'? ");
        a = userInput.nextInt();

        System.out.print("What is the value of 'b'? ");
        b = userInput.nextInt();

        System.out.print("What is the value of 'c'? ");
        c = userInput.nextInt();

        x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);

        if (Double.isNaN(x1)) {
            throw new ArithmeticException(x1 + " is not a number!");
        }
        if (Double.isNaN(x1)) {
            throw new ArithmeticException(x2 + " is not a number!");
        }

        System.out.print("The zeros of the function are " + x1 + " and " + x2 + ".");



    }

}
