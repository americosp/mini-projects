package com.company;
import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double heightFeet;
        double heightInches;
        double weightLbs;
        double BMI;

        System.out.print("Your height (feet only): ");
        heightFeet = input.nextInt();

        System.out.print("Your height (inches only): ");
        heightInches = input.nextInt();

        System.out.print("Your weight in pounds: ");
        weightLbs = input.nextInt();

        BMI = (weightLbs / ((heightFeet * 12 + heightInches) * (heightFeet * 12 + heightInches))) * 703;

        System.out.print("Your BMI is " + BMI);







    }
}
