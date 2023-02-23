package org.example;

import java.util.Scanner;

public class Grid {
    char [][]grid = new char[6][7]; // ready
    char player;

    boolean checkIfWin(){




        if (player == 'x'){
            player ='o';
        }else {
            player ='x';
        }
        return false;
    }
    void play(char player){
        Scanner scanner = new Scanner(System.in);
        int selection;

    while (!checkIfWin()){         // vllt in die Main
        System.out.println("Spieler " + player +" ist dran! Wählen Sie die Spalte:");

        selection = scanner.nextInt();
        place(player, selection);
        printGrid();
        //checkIfWin();

    }
    }
    void place(char player, int selection){
        boolean isFree = false;
        int j = 0;
        for (int i = grid.length; '\0' == grid[i][selection]; i--) {
            j = i;
        }
        grid[j][selection] = player;
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
