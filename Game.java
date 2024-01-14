
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private void ticTacToe(char[][] board, String player1, String player2) {

        boolean GameOver = false;
        Scanner scanner = new Scanner(System.in);
        String player = player1;
        int numberOfTurns = 0;
        if (player1.equals(player2)) {
            System.out.println(
                    "Told you not to give the same name\n Now both the symbols are same\n Enjoy the Game!!!!!!");
        }
        while (!GameOver) {
            printBoard(board);
            if (numberOfTurns == 9) {
                System.out.println("All the cells are filled....");
                System.out.println("Start a new game!!!");
                System.exit(1);
            }
            System.out.print("Enter " + player + "'s choice: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row > 2 || col > 2) {
                System.out.println("Choice should be less than or equal to 2....");
                System.out.println("Try Again!!!!");
                continue;
            }
            if (board[row][col] == ' ') {

                board[row][col] = player.charAt(0);
                numberOfTurns++;
            } else {
                System.out.println("Cell is not Empty...\nTry another cell!!!!!");
                continue;
            }
            boolean checkIfGameIsOver = isGameOver(board, player);
            if (!checkIfGameIsOver) {
                player = player == player1 ? player2 : player1;
            } else {
                break;
            }
        }
        scanner.close();
    }

    private static boolean isGameOver(char[][] board, String player) {

        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player.charAt(0) && board[row][1] == player.charAt(0)
                    && board[row][2] == player.charAt(0)) {
                printBoard(board);
                System.out.println("Congratulations!!!!\n" + player.toUpperCase() + " has won the game");
                System.out.println("Game Over!!!!!");
                return true;
            }
        }

        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player.charAt(0) && board[1][col] == player.charAt(0)
                    && board[2][col] == player.charAt(0)) {
                printBoard(board);
                System.out.println("Congratulations!!!!\n" + player.toUpperCase() + " has won the game");
                System.out.println("Game Over!!!!");
                return true;
            }
        }

        if (board[0][0] == player.charAt(0) && board[1][1] == player.charAt(0) && board[2][2] == player.charAt(0)) {
            printBoard(board);
            System.out.println("Congratulations!!!!\n" + player.toUpperCase() + " has won the game");
            System.out.println("Game Over!!!!!");
            return true;
        }
        if (board[0][2] == player.charAt(0) && board[1][1] == player.charAt(0) && board[2][0] == player.charAt(0)) {
            printBoard(board);
            System.out.println("Congratulations!!!!\n" + player.toUpperCase() + " has won the game");
            System.out.println("Game Over!!!!!");
            return true;
        }

        return false;
    }

    private static void printBoard(char[][] board) {
        System.out.println();
        for (char[] ch : board) {
            System.out.println(Arrays.toString(ch));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] Board = new char[3][3];
        for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[0].length; col++) {
                Board[row][col] = ' ';
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Try Not give the same name..!!!");
        System.out.print("Enter First Player Name: ");
        String player1 = sc.nextLine();
        System.out.print("Enter Second Player Name: ");
        String player2 = sc.nextLine();
        Game game = new Game();
        game.ticTacToe(Board, player1, player2);
        sc.close();
    }

}
