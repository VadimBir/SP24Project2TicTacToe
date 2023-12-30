package org.example;

import java.util.Scanner;
import java.util.Random;

// Random seed 13 is used for testing
// player win condition     5 3 1 8 7
// computer win condition   2 9 3 7
// draw condition           5 6 1 8 7
public class MyTicTacToeDriver {
    public static void main(String[] args) {
        Random randomObj = new Random(13); // Keep the line must use this random object
        Scanner scannerObj = new Scanner(System.in); // Keep the line must use this scanner object
        char[] boardArray = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}; // Keep the array and use it

        System.out.println("Programming Fundamentals");
        System.out.println("NAME: <your name>");    // replace with your name
        System.out.println("PROGRAMMING ASSIGNMENT 2");
        System.out.println("Welcome to Tic Tac Toe game!");

        // Write Tic Tac Toe game here
        displayBoard(boardArray); // Example use of displayBoard method

        // Uncomment to use
        // userPlacementInput(boardArray, scannerObj); // Example use of userPlacementInput method

        // Uncomment to use
        // computerRNGPlacement(boardArray, randomObj); // Example use of computerRNGPlacement method

        // Any other functions are up to you to create and use

        // When Printing the final message you must use the following format that must be in the last 128 character output
        // "WIN", for player win condition has to be a part of the 128 last characters of the output
        // "LOST", for player lost condition has to be a part of the 128 last characters of the output
        // "DRAW", for draw condition has to be a part of the 128 last characters of the output
    }

    public static void displayBoard(char[] boardArray) {
        System.out.println("Board:");
        for (int i = 0; i < boardArray.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(boardArray[i] + " ");
        }
        System.out.println("\n");
    }

    public static boolean winCheck(char[] boardArray) {
        // Code a boolean function that checks if the boardArray is a win for either player
        // Input is a boardArray
        // Output is a true/false value
        // e.g. if boardArray is {'X', 'X', 'X', '4', '5', '6', '7', '8', '9'} then return true
        return false;
    }

    public static void userInputAndPlacement(char[] boardArray, Scanner scanner) {
        // player win condition     5 3 1 8 7
        // computer win condition   2 9 3 7
        // draw condition           5 6 1 8 7
        // Code a function that asks the user for a position to place their X
        // Scanner needs to be passed in as a parameter to this function dont create a scanner each time

        // scanner.nextInt() you can use the object to get the next integer as it is

        // no need to return the boardArray as it is passed by reference (memory address)
    }

    public static void computerRNGPlacement(char[] boardArray, Random random) {
        // Code a function that places an O in a random position on the board
        // Random needs to be passed in as a parameter to this function dont create a random each time
        // random.nextInt(N) you can use the object to generate a random number between 0 and N-1 as it is

        // no need to return the boardArray as it is passed by reference (memory address)
    }
}