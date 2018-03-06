import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunLengthEncoderAndDecoder {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        int option = 0;
        String inputString = "";
        char alreadyEncoded = 0;
        String encodedOrDecoded = "";
        while (option != 4) {


            System.out.println("What would you like to do?");
            System.out.println("1.Input string to be encoded");
            System.out.println("2.View encoded string");
            System.out.println("3.View decoded string");
            System.out.println("4.Exit program");
            System.out.print("Option: ");
            if (userInput.hasNextInt()) {
                option = userInput.nextInt();

            }
            else {
                System.out.println("");
                System.out.println("Error! Invalid input. Please enter an integer from 1-4");
                System.out.println("");
                userInput.next();
                continue;
            }

            if (option == 1) {
                inputString = "";
                encodedOrDecoded = "";
                System.out.println("");
                System.out.print("Enter message: ");
                inputString = userInput.next();

            }

            if (option == 2) {
                if (inputString == "") {
                    System.out.println("");
                    System.out.println("No string has been encoded yet!!!");
                    System.out.println("");
                    continue;
                        }
                char[][] encodeRLE = encodeRLE(inputString);
                int encodeLength = findEncodeLength(inputString);
                for (int i = 0; i < encodeLength; ++i) {
                    for (int j = 0; j < encodeRLE[i].length; ++j) {
                        alreadyEncoded = (encodeRLE[i][j]);
                        encodedOrDecoded += alreadyEncoded;
                    }
                }
                System.out.println("");
                System.out.println("The encoded data is: " + encodedOrDecoded);
                System.out.println("");

            }
            if (option == 3) {
                if (inputString == "") {
                    System.out.println("");
                    System.out.println("No string has been encoded yet!!!");
                    System.out.println("");
                    continue;
                }
                char[] decodeRLE = decodeRLE(encodedOrDecoded);
                System.out.println("");
                System.out.print("The decoded data is: ");
                int decodeLength = findDecodeLength(inputString);
                for (int i = 0; i < decodeLength; ++i) {

                    System.out.print(decodeRLE[i]);
                }
                System.out.println("");

            }
            if (option == 4) {
                System.out.println("");
                System.out.print("Program terminated");
                System.exit(0);

            }
            if (option > 4 || option < 1) {
                System.out.println("");
                System.out.println("Error! Invalid input. Please enter an integer from 1-4");
                System.out.println("");
            }
        }
    }

    public static int numOfDigits(int num) {

        int amountOfDigits;

        amountOfDigits = String.valueOf(num).length();

        return amountOfDigits;
    }

    public static char[] toCharArray(int charCount, char strchar) {

        int amountOfDigits = numOfDigits(charCount); //gets the number of digits of charCount in order to determine the size of the array
        char[] numberOfCharacters = new char[amountOfDigits + 1];
        char[] justTheCharacter = new char[1];

        if (charCount > 1) {
            String charCountString = Integer.toString(charCount);
            for (int i = 0; i < amountOfDigits; ++i) {

                numberOfCharacters[i] = charCountString.charAt(i);
            }
            numberOfCharacters[amountOfDigits] = strchar;
            return numberOfCharacters;
        } else if (charCount == 1) {
            justTheCharacter[0] = strchar;
            return justTheCharacter;
        } else {

            return null;
        }


    }

    public static int findEncodeLength(String inputString) {  //number of unique characters in a string

        int uniqueCharacters = 1;

        if (inputString == null) {
            return 0;
        } else {
            int amountOfCharacters = inputString.length();
            for (int i = 1; i < amountOfCharacters; ++i) {
                if (inputString.charAt(i) != inputString.charAt(i - 1)) {

                    ++uniqueCharacters;

                }

            }

            return uniqueCharacters;
        }
    }

    public static int findDecodeLength(String rleString) {   // 4b16X8uS => 29

        int decodedStringLength = 0;
        String characterAmount = "";
        boolean lessThanThree = false;  // If the encoded string has three digits before a character, lessThanThree becomes true which will cause the program to skip the other Digit checks
        int amountOfCharacters = rleString.length();
        int j = 0; // j is used to iterate through numbers with more than two digits
        for (int i = 0; i < amountOfCharacters; ++i) {

            int numbersSkipped = 0; // keeps track of indexes that are skipped when counting 3+ digit character values; this way j and i are equivalent at the beginning of the loop
            if (Character.isDigit(rleString.charAt(i)) && Character.isDigit(rleString.charAt(i + 1)) && lessThanThree == false) {    // when the character has three digits

                while (Character.isDigit(rleString.charAt(j)) && Character.isDigit(rleString.charAt(j + 1))) {

                    characterAmount += rleString.charAt(j);
                    ++j;
                    ++numbersSkipped;
                }
                if (Character.isDigit(rleString.charAt(j)) && Character.isLetter(rleString.charAt(j + 1))) {
                    characterAmount += rleString.charAt(j);
                    ++numbersSkipped;
                    ++j;
                }
                int n = Integer.parseInt(String.valueOf(characterAmount));
                decodedStringLength += n;
                i += numbersSkipped;
                lessThanThree = true;   //skips the other if statements
                characterAmount = ""; // resets the string that contains the integer values
            } else if (Character.isDigit(rleString.charAt(i)) && Character.isDigit(rleString.charAt(i + 1)) && lessThanThree == false) {   // when the character has two digits

                characterAmount += rleString.charAt(i);
                characterAmount += rleString.charAt(i + 1); // concatenates the integer values into string
                int n = Integer.parseInt(String.valueOf(characterAmount)); // converts the string into actual integer
                decodedStringLength += n;
                i++;
                ++j;
                characterAmount = "";
            } else if (Character.isDigit(rleString.charAt(i)) && lessThanThree == false) { // when the character has one digit

                int n = Integer.parseInt(String.valueOf(rleString.charAt(i)));
                decodedStringLength += n;
                j++;
                ++numbersSkipped;
                i += numbersSkipped;
            } else if (i > 0 && Character.isLetter(rleString.charAt(i)) && (Character.isLetter(rleString.charAt(i - 1))) && lessThanThree == false) {    //in case a character is by itself with no number

                decodedStringLength += 1;
            } else if (i == 0 && Character.isLetter(rleString.charAt(i)) && lessThanThree == false) {    // in case index 0 is a character and not a number

                decodedStringLength += 1;
            }

            lessThanThree = false;
            ++j;
        }
        return decodedStringLength;
    }

    public static char[] decodeRLE(String rleString) {

        boolean alreadyPassedThrough = false;
        int amountOfCharacters = 0;
        String characterAmount = "";
        int length = rleString.length();
        int arrayLength = findDecodeLength(rleString);
        char[] decodedString = new char[arrayLength];
        String preArrayString = "";
        int j = 0;
        for (int i = 0; i < length; ++i) {

            int numbersSkipped = 0; // keeps track of indexes that are skipped when counting 3+ digit character values; this way j and i are equivalent at the beginning of the loop
            if (Character.isDigit(rleString.charAt(i)) && Character.isDigit(rleString.charAt(i + 1)) && alreadyPassedThrough == false) {    // when the character has more than two digits

                while (Character.isDigit(rleString.charAt(j)) && Character.isDigit(rleString.charAt(j + 1))) {

                    characterAmount += rleString.charAt(j);
                    ++j;
                    ++numbersSkipped;
                }
                if (Character.isDigit(rleString.charAt(j)) && Character.isLetter(rleString.charAt(j + 1))) {
                    characterAmount += rleString.charAt(j);
                    ++numbersSkipped;
                    ++j;
                }
                int n = Integer.parseInt(String.valueOf(characterAmount));
                amountOfCharacters += n;
                i += numbersSkipped;
                for (int t = 0; t < n; ++t) {
                    preArrayString += rleString.charAt(j);

                }
                alreadyPassedThrough = true;   //skips the other if statements
                characterAmount = ""; // resets the string that contains the integer values
            } else if (Character.isDigit(rleString.charAt(i)) && Character.isDigit(rleString.charAt(i + 1)) && alreadyPassedThrough == false) {   // when the character has two digits

                characterAmount += rleString.charAt(i);
                characterAmount += rleString.charAt(i + 1); // concatenates the integer values into string
                int n = Integer.parseInt(String.valueOf(characterAmount)); // converts the string into actual integer

                for (int t = 0; t < n; ++t) {
                    preArrayString += rleString.charAt(j);

                }
                i++;
                ++j;
                characterAmount = "";
            } else if (Character.isDigit(rleString.charAt(i)) && alreadyPassedThrough == false) { // when the character has one digit

                int n = Integer.parseInt(String.valueOf(rleString.charAt(i)));
                for (int t = 0; t < n; ++t) {
                    preArrayString += rleString.charAt(j + 1);

                }
                j++;
                ++numbersSkipped;
                i += numbersSkipped;
            } else if (i > 0 && Character.isLetter(rleString.charAt(i)) && (Character.isLetter(rleString.charAt(i - 1))) && alreadyPassedThrough == false) {    //in case a character is by itself with no number
                preArrayString += rleString.charAt(i);

            } else if (i == 0 && Character.isLetter(rleString.charAt(i)) && alreadyPassedThrough == false) {    // in case index 0 is a character and not a number

                preArrayString += rleString.charAt(i);
            }

            alreadyPassedThrough = false;
            ++j;
        }

        for (int i = 0; i < preArrayString.length(); ++i) { // converts the created string into the array

            decodedString[i] = preArrayString.charAt(i);
        }
        return decodedString;

    }


    public static String encodeRLEIntoString(String inputString) { // helper method that encodes the input into a string

        int amountOfCharacters = 0;
        String characterAmount = "";
        String preArrayEncodedString = "";

        int j = 0;
        for (int i = 0; i < inputString.length(); ++i) {

            int numbersSkipped = 0; // keeps track of indexes that are skipped when counting 3+ digit character values; this way j and i are equivalent at the beginning of the loop
            if ((j < inputString.length() - 1) && (inputString.charAt(j) == inputString.charAt(j + 1))) {    // when the character has more than two digits
                ++amountOfCharacters;
                while (j != inputString.length() - 1 && inputString.charAt(j) == inputString.charAt(j + 1)) {

                    ++amountOfCharacters;
                    ++j;
                    ++numbersSkipped;

                }

                preArrayEncodedString += Integer.toString(amountOfCharacters);
                preArrayEncodedString += inputString.charAt(j);
                amountOfCharacters = 0;
                i += numbersSkipped;
            } else if ((j < inputString.length() - 1) && (inputString.charAt(j) != inputString.charAt(j + 1))) {   // when the character has two digits

                preArrayEncodedString += inputString.charAt(j);
            } else if (j == inputString.length() - 1) {
                preArrayEncodedString += inputString.charAt(j);
            }
            ++j;
        }
        return preArrayEncodedString;

    }
    public static char[][] encodeRLE(String inputString){ // Uses the previous method's encoded string and converts it into a 2d array

        String preArrayEncodedString = encodeRLEIntoString(inputString);
        int encodeLength = findEncodeLength(inputString);
        char[] substringCharacter= new char[1];
        char[][] encodedArray = new char[encodeLength][10]; //**
        String encodeSubstring = "";
        int numberOfCharacters = 0;
        int substringCount = 0;

        /*Create a loop that creates a substring starting at the first number which would include the corresponding character
          and would end at the next number. Use substring as argument for the toCharArray Method. Then place those arrays
          into the 2d array. */

        boolean lessThanThree = false;  // If the encoded string has three digits before a character, lessThanThree becomes true which will cause the program to skip the other Digit checks
        int j = 0; // j is used to iterate through numbers with more than two digits
        for (int i = 0; j < preArrayEncodedString.length(); ++i) {

             // keeps track of indexes that are skipped when counting 3+ digit character values; this way j and i are equivalent at the beginning of the loop
            if (Character.isDigit(preArrayEncodedString.charAt(i)) && Character.isDigit(preArrayEncodedString.charAt(i + 1)) && lessThanThree == false) {    // when the character has three digits


                while (Character.isDigit(preArrayEncodedString.charAt(j)) && Character.isDigit(preArrayEncodedString.charAt(j + 1))) {

                    encodeSubstring += preArrayEncodedString.charAt(j);

                    ++j;
                    ++i;
                }
                encodeSubstring += preArrayEncodedString.charAt(j);
                encodeSubstring += preArrayEncodedString.charAt(j+1);
                numberOfCharacters = findDecodeLength(encodeSubstring);
                ++j;
                ++i;
            }
            else if (Character.isDigit(preArrayEncodedString.charAt(i)) && Character.isLetter(preArrayEncodedString.charAt(i + 1)) && lessThanThree == false) {   // when the character has two digits

                encodeSubstring += preArrayEncodedString.charAt(i);
                encodeSubstring += preArrayEncodedString.charAt(i + 1); // concatenates the integer values into string
                numberOfCharacters = findDecodeLength(encodeSubstring);
                ++i;
                ++j;
            }
            else if (i == preArrayEncodedString.length()-1 ){
                encodeSubstring += preArrayEncodedString.charAt(i);
                numberOfCharacters = findDecodeLength(encodeSubstring);
            }
            else if (Character.isLetter(preArrayEncodedString.charAt(i)) && Character.isDigit(preArrayEncodedString.charAt(i+1))){
                encodeSubstring += preArrayEncodedString.charAt(i);
                ++numberOfCharacters;

            }

            else if (i == 0){
                encodeSubstring += preArrayEncodedString.charAt(i);
                ++numberOfCharacters;

            }
            else if (Character.isLetter(preArrayEncodedString.charAt(i)) && Character.isLetter(preArrayEncodedString.charAt(i+1)) &&Character.isLetter(preArrayEncodedString.charAt(i-1)) ){
                encodeSubstring += preArrayEncodedString.charAt(i);
                ++numberOfCharacters;

            }
            for (int k=0; k < encodeSubstring.length(); ++k) {

                if (Character.isLetter(encodeSubstring.charAt(k))){

                    substringCharacter[0] = encodeSubstring.charAt(k);
                }

            }
            char substringChar = substringCharacter[0];
             encodedArray[substringCount] = toCharArray(numberOfCharacters, substringChar);
            encodeSubstring = "";
            numberOfCharacters = 0;
            lessThanThree = false;
            substringCount++;
            ++j;
        }


        return encodedArray;
    }
}

