package com.company;
import java.util.Scanner;
public class nameAge {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        String name;
        int age;

        System.out.print("Hello. What is your name? ");
        name = userInput.next();

        System.out.print("Hey, " + name + "! How old are you? ");
        age = userInput.nextInt();

        System.out.println("Did you know that in 5 years you will be " + (age + 5) + " years old?");
        System.out.println("And 5 years ago you were " + (age - 5) + "! That's insane!!!");



    }
}
