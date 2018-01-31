package com.company;

import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        P1Random rng = new P1Random();
        Scanner userInput = new Scanner(System.in);

        int gameMenu = 0;
        int gameNumber = 1;
        int myNumber = rng.nextInt(13) + 1;
        int dealersNumber = 0;
        int myTotal = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int ties = 0;

        //String cardName = assignCard(the card number value);

        while (gameMenu != 4) {

            if (gameMenu == 0) {
                System.out.println("START GAME #" + gameNumber + "!");
                System.out.print("\n");


                System.out.println("Your card is a " + myNumber + "!");
                System.out.println("Your hand is: " + myNumber);
                System.out.println();

                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Choose an option: ");
                gameMenu = userInput.nextInt();
                System.out.println();

                myTotal = myNumber;

            }


            switch (gameMenu) {
                case 1:

                    myNumber = rng.nextInt(13) + 1;

                    if (myNumber >= 2 && myNumber <= 9) {
                        System.out.println("Your card is a " + myNumber + "!");
                        myTotal += myNumber;
                        System.out.println("Your hand is: " + myTotal);
                        System.out.println();

                        System.out.println("1. Get another card");
                        System.out.println("2. Hold hand");
                        System.out.println("3. Print statistics");
                        System.out.println("4. Exit");
                        System.out.println();
                        System.out.print("Choose an option: ");
                        gameMenu = userInput.nextInt();
                        System.out.println();
                        continue;
                    }

                    if (myNumber == 1)  {
                        System.out.println("Your card is a ACE!");
                        myTotal += myNumber;
                        System.out.println("Your hand is: " + myTotal);
                        System.out.println();

                        System.out.println("1. Get another card");
                        System.out.println("2. Hold hand");
                        System.out.println("3. Print statistics");
                        System.out.println("4. Exit");
                        System.out.println();
                        System.out.print("Choose an option: ");
                        gameMenu = userInput.nextInt();
                        System.out.println();

                    }

                    if (myTotal == 21) {
                        System.out.print("BLACKJACK! You win!");
                        gameNumber++;
                        continue;
                    }

                    if (myTotal > 21) {
                        System.out.print("You exceeded 21! You lose.");
                        gameNumber++;
                        continue;
                    }

                case 2:

                    dealersNumber = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealersNumber );
                    System.out.println("Your hand is " + myTotal);

                    if (dealersNumber > 21) {
                        System.out.println("");
                        System.out.println("You win! \n");
                        playerWins++;
                        gameNumber++;
                        gameMenu = 0;
                        continue;
                    }

                    else if (myTotal == dealersNumber) {
                        System.out.print("It's a tie! No one wins!");
                        ties++;
                        gameNumber++;
                        break;
                    }

                    else if (myTotal > dealersNumber)   {
                        System.out.print("You win!");
                        playerWins++;
                        gameNumber++;
                        break;
                    }

                    else if (dealersNumber > myTotal)   {
                        System.out.print("Dealer wins!");
                        dealerWins++;
                        gameNumber++;
                        break;
                    }

                    break;

                case 3:

                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    System.out.println();
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.println();
                    System.out.print("Choose an option: ");
                    gameMenu = userInput.nextInt();
                    System.out.println();

            }
            }




         /*dealersNumber = rng.nextInt(11) + 16;
             System.out.println("Dealer's hand: " + dealersNumber );
             System.out.println("Your hand is " + myNumber); */
        }

    }

    /*public static String assignCard(int cardNum) {
        switch (cardNum) {
            case 1:
                return "ACE!";
            break;

        }

    }*/



