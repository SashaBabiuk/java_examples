package tictactoe;

import java.util.Scanner;

public class TicTakToe {
    private char[][] area;

    public TicTakToe(){
        this.area = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.area[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col, char player) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || area[row][col] != ' ') {
            return false;
        }
        area[row][col] = player;
        return true;
    }

    public void showArea(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(area[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    public boolean isAreaFull(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.area[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public boolean isWinnerExist(){
        for (int i = 0; i < 3; i++) {
            if (area[i][0] != ' ' && area[i][0] == area[i][1] && area[i][1] == area[i][2] ||
                    area[0][i] != ' ' && area[0][i] == area[1][i] && area[1][i] == area[2][i]) {
                return true;
            }
        }

        if (area[0][0] != ' ' && area[0][0] == area[1][1] && area[1][1] == area[2][2]) {
            return true;
        }
        if (area[0][2] != ' ' && area[0][2] == area[1][1] && area[1][1] == area[2][0]) {
            return true;
        }

        return false;
    }
}


class Main {
    public static void main(String[] args) {
        TicTakToe game = new TicTakToe();
        Scanner scanner = new Scanner(System.in);

        int flag = (int) (Math.random() * 10);
        boolean gameWon = false;

        while (!game.isAreaFull() && !gameWon) {
            game.showArea();
            move(flag, game, scanner);
            gameWon = game.isWinnerExist();
            if (gameWon) {
                System.out.println((flag % 2 == 0 ? "Player 1" : "Player 2") + " wins!");
            }
            flag++;
        }

        if (!gameWon) {
            System.out.println("It's a draw!");
        }

        game.showArea();
    }

    public static void move(int flag, TicTakToe game, Scanner scanner) {
        boolean validMove = false;
        while (!validMove) {
            if (flag % 2 == 0) {
                System.out.println("Player 1 move");
                validMove = game.makeMove(getRow(scanner), getColumn(scanner), 'X');
            } else {
                System.out.println("Player 2 move");
                validMove = game.makeMove(getRow(scanner), getColumn(scanner), 'O');
            }

            if (!validMove) {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static int getRow(Scanner scanner) {
        System.out.println("Enter row (0, 1, or 2):");
        return scanner.nextInt();
    }

    public static int getColumn(Scanner scanner) {
        System.out.println("Enter column (0, 1, or 2):");
        return scanner.nextInt();
    }
}
