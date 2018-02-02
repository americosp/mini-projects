import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        P1Random rng = new P1Random();
        Scanner userInput = new Scanner(System.in);

        int option = 0, gameNumber = 1, hand, dealersNumber;
        int playerWins = 0, dealerWins = 0, ties = 0, myNumber;


        while (option != 4) {

            boolean gameEnd = false;        //reassigns gameEnd to false in order to loop into the next while loop again

            myNumber = rng.nextInt(13) + 1;
            hand = 0;
            System.out.println("---------------------{START GAME #" + gameNumber + "}--------------------");
            System.out.print("\n");

            if (myNumber == 1) {
                System.out.println("Your card is a ACE!");
                hand += myNumber;
                System.out.println("Your hand is: " + hand);
                System.out.println();
            }

            if (myNumber >= 2 && myNumber <= 10) {
                System.out.println("Your card is a " + myNumber + "!");
                hand += myNumber;
                System.out.println("Your hand is: " + hand);
                System.out.println();
            }

            if (myNumber == 11) {
                System.out.println("Your card is a JACK!");
                myNumber = 10;
                hand += myNumber;
                System.out.println("Your hand is: " + hand);
                System.out.println("");
            }

            if (myNumber == 12) {
                System.out.println("Your card is a QUEEN!");
                myNumber = 10;
                hand += myNumber;
                System.out.println("Your hand is: " + hand);
                System.out.println("");
            }

            if (myNumber == 13) {
                System.out.println("Your card is a KING!");
                myNumber = 10;
                hand += myNumber;
                System.out.println("Your hand is: " + hand);
                System.out.println("");
            }

            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            option = userInput.nextInt();
            System.out.println();


        while (!gameEnd) {             //runs this loop until someone wins which sets game End to true

            switch (option) {

                case 1:

                    myNumber = rng.nextInt(13) + 1;

                    if (myNumber == 1) {
                        System.out.println("Your card is a ACE!");
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand);
                        System.out.println();
                    }

                    if (myNumber >= 2 && myNumber <= 10) {
                        System.out.println("Your card is a " + myNumber + "!");
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand);
                        System.out.println();
                    }

                    if (myNumber == 11) {
                        System.out.println("Your card is a JACK!");
                        myNumber = 10;
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand);
                        System.out.println();
                    }

                    if (myNumber == 12) {
                        System.out.println("Your card is a QUEEN!");
                        myNumber = 10;
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand);
                        System.out.println();
                    }

                    if (myNumber == 13) {
                        System.out.println("Your card is a KING!");
                        myNumber = 10;
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand);
                        System.out.println();
                    }

                    if (hand == 21) {
                        System.out.println("BLACKJACK! You win!\n");
                        gameNumber++;
                        playerWins++;
                        gameEnd = true;
                        continue;
                    }

                    if (hand > 21) {
                        System.out.println("You exceeded 21! You lose.\n");
                        gameNumber++;
                        dealerWins++;
                        gameEnd = true;
                        continue;
                    }

                        System.out.println("1. Get another card");
                        System.out.println("2. Hold hand");
                        System.out.println("3. Print statistics");
                        System.out.println("4. Exit");
                        System.out.println();
                        System.out.print("Choose an option: ");
                        option = userInput.nextInt();
                        System.out.println();

                        break;

                case 2:

                    dealersNumber = rng.nextInt(27) ;
                    System.out.println("Dealer's hand: " + dealersNumber);
                    System.out.println("Your hand is: " + hand);

                    if (dealersNumber > 21) {
                        System.out.println("");
                        System.out.println("You win!\n");
                        playerWins++;
                        gameNumber++;
                        gameEnd = true;
                        continue;
                        }

                    else if (hand == dealersNumber) {
                        System.out.println("");
                        System.out.println("It's a tie! No one wins!\n");
                        ties++;
                        gameNumber++;
                        gameEnd = true;
                        }

                    else if (hand > dealersNumber) {
                        System.out.println("");
                        System.out.println("You win!\n");
                        playerWins++;
                        gameNumber++;
                        gameEnd = true;
                        }

                    else if (dealersNumber > hand) {
                        System.out.println("");
                        System.out.println("Dealer wins!\n");
                        dealerWins++;
                        gameNumber++;
                        gameEnd = true;
                        }

                    break;

                case 3:

                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + ties);
                    System.out.println("Total # of games played is: " + (gameNumber - 1));
                    System.out.println("Percentage of Player wins: " + ((double)playerWins / ((double)(gameNumber-1)) * 100) + "%");

                    System.out.println();
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.println();
                    System.out.print("Choose an option: ");
                    option = userInput.nextInt();

                    break;

                case 4:

                    System.exit(0);
                    break;



                default:

                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.\n");

                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.println();
                    System.out.print("Choose an option: ");
                    option = userInput.nextInt();
                    System.out.println();

                    break;

                    }
                }
            }
        }
    }
