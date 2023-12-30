import org.example.MyTicTacToeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MyTicTacToeDriverTest {
    private final InputStream systemIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // check 8 win conditions on a board
    @Test
    public void testWinCheckConditions() {
        System.out.print("\nTest winCheck method: ");
        // check 8 win conditions on a board
        boolean allConditionsWorked = true;
        char[][] playerWinBoard = new char[9][8];
        playerWinBoard[0] = new char[]{
                'O', '2', '3',
                'O', '5', '6',
                'O', '8', '9'}; // columns
        playerWinBoard[1] = new char[]{
                '1', 'O', '3',
                '4', 'O', '6',
                '7', 'O', '9'}; // columns
        playerWinBoard[2] = new char[]{
                '1', '2', 'O',
                '4', '5', 'O',
                '7', '8', 'O'}; // columns
        playerWinBoard[3] = new char[]{
                'O', '2', '3',
                '4', 'O', '6',
                '7', '8', 'O'}; // diagonal
        playerWinBoard[4] = new char[]{
                '1', '2', 'O',
                '4', 'O', '6',
                'O', '8', '9'}; // diagonal
        playerWinBoard[5] = new char[]{
                'O', 'O', 'O',
                '4', '5', '6',
                '7', '8', '9'}; // rows
        playerWinBoard[6] = new char[]{
                '1', '2', '3',
                'O', 'O', 'O',
                '7', '8', '9'}; // rows
        playerWinBoard[7] = new char[]{
                '1', '2', '3',
                '4', '5', '6',
                'O', 'O', 'O'};
        int i = 0;
        for (; i < 8; i++) {
            if (!MyTicTacToeDriver.winCheck(playerWinBoard[i])) {
                allConditionsWorked = false;
                break;
            }
        }
        assertTrue(allConditionsWorked, "Player wins is not detected at board index: "+ i+ " Board: " + Arrays.toString(playerWinBoard[i]));
    }

    // Example test (after refactoring userPlacementInput)
    @BeforeEach
    public void setUpInput() {
        String inputData = "1\n2\n3\n4\n5\n6\n7\n8\n9\n";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
    }

    @Test
    public void testUserPlacementInput() {
        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        InputStream tmpInput = System.in;
        Scanner scan = new Scanner(tmpInput);
        boolean inputRegistered = true;
        int i = 0;
        for (; i < 9; i++) {
            MyTicTacToeDriver.userInputAndPlacement(board, scan);
            if (board[i] == 'X'){
                inputRegistered = true;
            } else {
                inputRegistered = false;
                break;
            }
        }
        assertEquals(true, inputRegistered, "User input is not registered at tile number: "+(i+1)+ " The board result:" + Arrays.toString(board));
    }

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(systemIn);
    }


    // main method test
    // draw condition           5 6 1 8 7
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testMainDrawCondition() {

        String inputData = "5\n6\n1\n8\n7\n";
        InputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        MyTicTacToeDriver.main(null);
        String output = outputStreamCaptor.toString();
        if (output.length() >= 32) {
            String last128Chars = output.substring(output.length() - 128);
            assertTrue(output.contains("DRAW"), "\nThe output should contain 'DRAW'. \nLast 128 characters: " + last128Chars);
        } else {
            fail("Output is not long enough to contain the expected text.");
        }
    }

    // main method test
    // Player win condition           5 3 1 8 7
    @Test
    public void testMainWinCondition() {

        String inputData = "5\n3\n1\n8\n7\n";
        InputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        MyTicTacToeDriver.main(null);
        String output = outputStreamCaptor.toString();
        if (output.length() >= 32) {
            String last128Chars = output.substring(output.length() - 128);
            assertTrue(output.contains("WIN"), "\nThe output should contain 'DRAW'. \nLast 128 characters: " + last128Chars);
        } else {
            fail("Output is not long enough to contain the expected text.");
        }
    }
    // main method test
    // computer win condition       2 9 3 7
    @Test
    public void testMainLossCondition() {

        String inputData = "2\n9\n3\n7\n";
        InputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);
        MyTicTacToeDriver.main(null);
        String output = outputStreamCaptor.toString();
        if (output.length() >= 32) {
            String last128Chars = output.substring(output.length() - 128);
            assertTrue(output.contains("LOST"), "\nThe output should contain 'DRAW'. \nLast 128 characters: " + last128Chars);
        } else {
            fail("Output is not long enough to contain the expected text.");
        }
    }
    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
        System.setIn(System.in);
    }



}
