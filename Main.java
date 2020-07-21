package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] cells = new char[3][3];


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[j][i] = '_';
            }
        }

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[j][i] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        System.out.print("Enter the coordinates: ");


        String coordinateX = scanner.next();
        String coordinateY = scanner.next();

        boolean digitCheckX = coordinateX.matches("\\d");

        while (!digitCheckX) {
            System.out.println("You should enter numbers!");
            System.out.print("Enter the coordinates: ");

            coordinateX = scanner.next();
            coordinateY = scanner.next();

            digitCheckX = coordinateX.matches("\\d");
        }


        int y = Math.abs(Integer.parseInt(coordinateY) - 3);
        int x = Math.abs(Integer.parseInt(coordinateX) - 1);

        boolean boundsX = Integer.parseInt(coordinateX) < 4;
        boolean boundsY = Integer.parseInt(coordinateY) < 4;
        boolean freeSpace = false;
        boolean conditions = boundsX && boundsY && freeSpace;
        boolean stop = false;
        digitCheckX = coordinateX.matches("\\d");

        int stage = 1;


        while (!stop) {
            while (!conditions) {

                boundsX = Integer.parseInt(coordinateX) < 4;
                boundsY = Integer.parseInt(coordinateY) < 4;

                while (!digitCheckX) {
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates: ");

                    coordinateX = scanner.next();
                    coordinateY = scanner.next();

                    digitCheckX = coordinateX.matches("\\d");
                }

                boundsX = Integer.parseInt(coordinateX) < 4;
                if (!boundsX) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates: ");

                    coordinateX = scanner.next();
                    coordinateY = scanner.next();

                    continue;
                }

                boundsY = Integer.parseInt(coordinateY) < 4;
                if (!boundsY) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates: ");

                    coordinateX = scanner.next();
                    coordinateY = scanner.next();

                    continue;
                }

                y = Math.abs(Integer.parseInt(coordinateY) - 3);
                x = Math.abs(Integer.parseInt(coordinateX) - 1);

                freeSpace = cells[x][y] == '_';
                if (!freeSpace) {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.print("Enter the coordinates: ");

                    coordinateX = scanner.next();
                    coordinateY = scanner.next();

                    continue;
                }
                conditions = boundsX && boundsY && freeSpace;

            }

            if (stage % 2 != 0) {
                cells[x][y] = 'X';
            } else {
                cells[x][y] = 'O';
            }
            stage++;

            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(cells[j][i] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");

            for (int i = 0; i < 3; i++) {
                if (cells[0][i] == cells[1][i] && cells[0][i] == cells[2][i]) {
                    if (cells[0][i] == 'X') {
                        System.out.println("X wins.");
                        stop = true;
                        break;
                    } else if (cells[0][i] == 'O') {
                        System.out.println("O wins.");
                        stop = true;
                        break;
                    }
                }
            }

            if (!stop) {
                for (int i = 0; i < 3; i++) {
                    if (cells[i][0] == cells[i][1] && cells[i][0] == cells[i][2]) {
                        if (cells[i][0] == 'X') {
                            System.out.println("X wins.");
                            stop = true;
                            break;
                        } else if (cells[i][0] == 'O') {
                            System.out.println("O wins.");
                            stop = true;
                            break;
                        }
                    }
                }
            }

            if (!stop) {
                if (cells[0][0] == cells[1][1] && cells[0][0] == cells[2][2]) {
                    if (cells[0][0] == 'X') {
                        System.out.println("X wins.");
                        stop = true;
                    } else if (cells[0][0] == 'O') {
                        System.out.println("O wins.");
                        stop = true;
                    }
                }
            }

            if (!stop) {
                if (cells[0][2] == cells[1][1] && cells[0][2] == cells[2][0]) {
                    if (cells[0][2] == 'X') {
                        System.out.println("X wins.");
                        stop = true;
                    } else if (cells[0][2] == 'O') {
                        System.out.println("O wins.");
                        stop = true;
                    }
                }
            }

            if (!stop) {
                if (stage == 10) {
                    System.out.println("Draw.");
                    stop = true;
                } else {
                    System.out.print("Enter the coordinates: ");

                    coordinateX = scanner.next();
                    coordinateY = scanner.next();

                    boundsX = Integer.parseInt(coordinateX) < 4;
                    boundsY = Integer.parseInt(coordinateY) < 4;
                    freeSpace = false;
                    conditions = boundsX && boundsY && freeSpace;
                }
            }
        }
    }
}