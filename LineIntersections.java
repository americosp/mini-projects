package com.company;
import java.util.Scanner;
public class LineIntersections {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        double m1; double b1; double m2; double b2;
        double x; double y;

        System.out.print("Enter m for Line 1: ");
        m1 = userInput.nextDouble();

        System.out.print("Enter b for Line 1: ");
        b1 = userInput.nextDouble();

        System.out.print("Enter m for Line 2: ");
        m2 = userInput.nextDouble();

        System.out.print("Enter b for Line 2: ");
        b2 = userInput.nextDouble();

        x = (b1 - b2) / (m2 - m1);
        y = m1 * x + b1;

        System.out.print("The intersection point is (" + x + " , " + y + ").");







    }

}
