package Kino.model;

import Kino.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Filmy {

    Controller uc = new Controller();
    Scanner input = new Scanner(System.in);

    public Filmy() throws SQLException {

        System.out.println("Witaj w module Filmy");

        boolean flag = true;
        while (flag) {

            System.out.println("D-dodaj film, P-pokaż filmy, U-usuń film, Q-wyjście");
            String dec = input.nextLine().toUpperCase();

            switch (dec) {
                case "D":
                    System.out.println("Podaj ID kina do dodania filmu");
                    int ID = input.nextInt();
                    input.nextLine();
                    
                    System.out.println("Podaj nazwę filmu do dodania");
                    String nazwaFilmu = input.nextLine();
                    uc.dodajFilm(ID, nazwaFilmu);
                    break;

                case "P":
                    uc.pokazFilmy();
                    break;

                case "U" :
                    System.out.println("Podaj ID filmu do usunięcia");
                    int filmID = input.nextInt();
                    input.nextLine();
                    uc.usunFilm(filmID);
                    break;

                case "Q":
                    System.out.println("powrót do wyboru modułu...");
                    flag = false;
                    break;
            }
        }
    }
}

