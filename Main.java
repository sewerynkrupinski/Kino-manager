package Kino;

import Kino.model.*;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);
        
        boolean program = true;
        while(program){

            System.out.println("K-moduł Kina, F-moduł filmy, B-moduł bilety, Q-koniec");
            String dec = input.nextLine().toUpperCase();

            switch(dec){
                case "K":
                    Kino kino = new Kino();
                    break;

                case "F":
                    Filmy filmy = new Filmy();
                    break;

                case "B":
                    Bilety bilety = new Bilety();
                    break;

                case "Q":
                    System.out.println("Zakończono działanie programu");
                    program = false;
                    break;
            }
        }
    }
}
