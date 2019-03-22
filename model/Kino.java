package Kino.model;


import Kino.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;


public class Kino {

    Controller uc = new Controller();
    Scanner input = new Scanner(System.in);

    public Kino() throws SQLException {

        boolean flag = true;
        while(flag){
            System.out.println("Witaj w module Kino");
            System.out.println("D-dodaj kino, P-pokaż kina, U-usuń kino, Q-wyjście");
            String dec = input.nextLine().toUpperCase();

            switch(dec){
                case "D":
                    System.out.println("Podaj nazwę kina do dodania");
                    String nazwa = input.nextLine();
                    uc.dodajKino(nazwa);
                    break;

                case "P":
                    uc.pokazKina();
                    break;

                case "U":
                    System.out.println("Podaj ID kina do usunięcia");
                    int ID = input.nextInt();
                    input.nextLine();
                    uc.usunKina(ID);
                    break;

                case "Q":
                    System.out.println("Powrót do wyboru modułu...");
                    flag = false;
                    break;
            }
        }
    }
}
