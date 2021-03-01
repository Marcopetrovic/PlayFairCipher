package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("1 for ENCRYPT or 2 for DECRYPT, other input will end the program");
        String action = in.nextLine();


        switch(action) {
            case "1":
                runnerEnc();
                break;
            case "2":
                runnerDe();
                break;
            default:
        }
    }

    public static void runnerEnc(){

        System.out.println("Two letters you want to encrypt");
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int sLenght = s.length();

        if(sLenght % 2 == 0){
            System.out.println("Messege proccessed......");
        } else{
            System.out.println("DUD");
            System.exit(0);
        }


        int char1row = -1;
        int char1col = -1;
        int char2row = -1;
        int char2col = -1;
        int charscol = -1;
        /*int ascii = -1;

        int sLenght = s.length();
        for(int i = 0; i < sLenght ; i++){
            char character = s.charAt(i);
            ascii = (int) character;
            System.out.println(ascii);
        }


         */


        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        int ascii1 = (int) c1;
        int ascii2 = (int) c2;



        int[][] table = new int[5][5];

        int character = 65;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (character != 74) {
                    table[row][col] = character++;
                } else {
                    character++;
                    table[row][col] = character++;
                }
            }
        }

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (ascii1 == table[row][col]) {
                    char1row = row;
                    char1col = col;
                }
                if (ascii2 == table[row][col]) {
                    char2row = row;
                    char2col = col;
                }
            }
        }


        if (char1row == char2row) {
            sameRowEnc(char1row, char2row, char1col, char2col, table);
        }
        else if (char1col == char2col){
            sameColEnc(char1row, char2row, char1col, char2col, table);
        }
        else if (char1col != char2col) {
            cross(char1row, char2row, char1col, char2col, charscol, table);
        }

    }

    public static void runnerDe(){

       System.out.println("Two letters you want to encrypt");
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int sLenght = s.length();

        if(sLenght % 2 == 0){
            System.out.println("Messege proccessed......");
        } else{
            System.out.println("DUD");
            System.exit(0);
        }

        int char1row = -1;
        int char1col = -1;
        int char2row = -1;
        int char2col = -1;
        int charscol = -1;
        /* int ascii = -1;

        int sLenght = s.length();
        for(int i = 0; i < sLenght ; i++){
            char character = s.charAt(i);
            ascii = (int) character;
            System.out.println(ascii);
        }

        */

        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        int ascii1 = (int) c1;
        int ascii2 = (int) c2;

        int[][] table = new int[5][5];

        int character = 65;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (character != 74) {
                    table[row][col] = character++;
                } else {
                    character++;
                    table[row][col] = character++;
                }
            }
        }

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (ascii1 == table[row][col]) {
                    char1row = row;
                    char1col = col;
                }
                if (ascii2 == table[row][col]) {
                    char2row = row;
                    char2col = col;
                }
            }
        }

        if (char1row == char2row) {
            sameRowDe(char1row, char2row, char1col, char2col, table);
        }
        else if (char1col == char2col){
            sameColDe(char1row, char2row, char1col, char2col, table);
        }
        else if (char1col != char2col) {
            cross(char1row, char2row, char1col, char2col, charscol, table);
        }

    }

    public static void sameRowEnc(int char1row, int char2row, int char1col, int char2col, int table[][]){


            if (char1row == char2row) {
                if (char1col == 4) {
                    char1col = 0;
                } else char1col++;
            }

            if (char1row == char2row) {
                if (char2col == 4) {
                    char2col = 0;
                }else char2col++;
            }
        System.out.println((char) table[char1row][char1col] + " " + (char) table[char2row][char2col]);
    }

    public static void sameRowDe(int char1row, int char2row, int char1col, int char2col, int table[][]){
        if (char1row == char2row) {
            if (char1col == 0) {
                char1col = 4;
            }else char1col--;
        }

        if (char1row == char2row) {
            if (char2col == 0) {
                char2col = 4;
            }else char2col--;
        }
        System.out.println((char) table[char1row][char1col] + " " + (char) table[char2row][char2col]);
    }

    public static void sameColEnc(int char1row, int char2row, int char1col, int char2col, int table[][]){

        if (char1col == char2col) {
            if (char1row == 4) {
                char1row = 0;
            } else char1row++;
        }

        if (char1col == char2col) {
            if (char2row == 4) {
                char2row = 0;
            } else char2row++;
        }
        System.out.println((char) table[char1row][char1col] + " " + (char) table[char2row][char2col]);
    }

    public static void sameColDe(int char1row, int char2row, int char1col, int char2col, int table[][]){

        if (char1col == char2col) {
            if (char1row == 0) {
                char1row = 4;
            } else char1row--;
        }

        if (char1col == char2col) {
            if (char2row == 0) {
                char2row = 4;
            } else char2row--;
        }

        System.out.println((char) table[char1row][char1col] + "" + (char) table[char2row][char2col]);
    }

    public static void cross(int char1row, int char2row, int char1col, int char2col, int charscol, int table[][]){


        if(char1col != char2col){
            charscol = char1col;
            char1col = char2col;
            char2col = charscol;
        }
        System.out.println((char) table[char1row][char1col] + " " + (char) table[char2row][char2col]);
    }

    }

