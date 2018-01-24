package com.company;
import java.util.Scanner;
public class CircleProperties {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        double circleRadius;
        double xPoint;
        double yPoint;


        System.out.print("Enter circle radius: ");
        circleRadius = userInput.nextDouble();

        System.out.print("Enter x center point: ");
        xPoint = userInput.nextDouble();

        System.out.print("Enter y center point: ");
        yPoint = userInput.nextDouble();

        System.out.println("The circle's diameter is  " + (circleRadius * 2) );

        System.out.println("The circle's area is  " + (Math.PI * circleRadius * circleRadius) );

        System.out.println("The circle's circumference is  " + (circleRadius * 2 * Math.PI) );

        System.out.println("The circle's equation is (x - " + xPoint + ")² + (y - " + yPoint + ")² = " + Math.pow(circleRadius, 2) );

        System.out.println("The circle's vertex is at the point (" + xPoint + " , " + yPoint + ").");
    }
}
