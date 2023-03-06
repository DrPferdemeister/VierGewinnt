package org.example;

import java.util.Scanner;

public class Grid {
    char [][]grid = new char[6][7]; // ready

    void emptyGrid() {
       for(int i = 0; i < 6; i++) {
           for (int j = 0; j < 7; j++) {
               grid[i][j] = ' ';
           }
       }
    }

    char player = 'x';


    void playGame() {
        boolean gameFinished = false;
        printGrid();
        while (!gameFinished) {
            play(player);
            printGrid();
            gameFinished = checkIfWin();
        }
    }


    boolean checkIfWin(){

       if (vertical()) {
           System.out.println("chicken dinner");
       }
       // horizontal();
       // diagonalUp();
        //  diagonalDown();
        if (player == 'x'){
            player ='o';
        }else {
            player ='x';
        }
        return vertical();
    }

    private boolean vertical() {
        int four = 0;
        for (int i = 0;i < 7; i++){
            for (int j = 5; j >= 0; j--) {
                if (grid[j][i] == ' ') {
                    break;
                } else if (grid[j][i] == player) {
                    four ++;
                } else if (grid[j][i] != player) {
                    four = 0;
                }
                if (four == 4) {
                    return true;
                }
            }

        }
        return false;
    }

    void play(char player){
        Scanner scanner = new Scanner(System.in);
        int selection;

           // vllt in die Main
        System.out.println("Spieler " + player +" ist dran! Wählen Sie die Spalte:");

        selection = scanner.nextInt();
        place(player, selection);

        //checkIfWin();

    }

    void place(char player, int selection){
        int j = 0;
        for (int i = 0; ' ' == grid[i][selection]; i++) {
            j = i;
            if (j == 5 && ' ' == grid[j][selection]) {
                break;
            } else if (j == 5) {
                System.out.println("digga andere Zahl nächstes mal");
                play(player);
            }

        }
        if (' ' == grid[j][selection]) {
            grid[j][selection] = player;
        }
        else {
            System.out.println("digga andere Zahl nächstes mal");
            play(player);
        }
    }
    void printGrid(){
        for (int i = 0; i< grid.length; i++){
            for (int j = 0; j< grid[i].length;j++){
                System.out.print("|("+ grid[i][j] + ")" );
            }
            System.out.println("|");
        }
    }

}
