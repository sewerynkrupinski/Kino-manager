package Kino.model;

import Kino.controller.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Bilety {

    Controller uc = new Controller();
    Scanner input = new Scanner(System.in);

    public Bilety() throws SQLException {

        System.out.println("Witaj w module Bilety");

        boolean flag = true;
        while (flag) {

            System.out.println("K-kup bilet, P-pokaż bilety, U-usuń bilet, Q-wyjście");
            String dec = input.nextLine().toUpperCase();

            switch (dec) {
                case "K" :
                    uc.pokazKina();
                    System.out.println("Podaj ID kina");
                    int ID = input.nextInt();
                    input.nextLine();
                    uc.pokazFilmy(ID);
                    
                    System.out.println("Podaj ID filmu");
                    int filmID = input.nextInt();
                    input.nextLine();
                    
                    System.out.println("Podaj ilość biletów");
                    String ilosc = input.nextLine();
                    uc.kupBilet(filmID, ilosc);
                    break;

                case "P" :
                    uc.pokazBilety();
                    break;

                case "U" :
                    uc.pokazBilety();
                    System.out.println("Podaj ID biletu do usuniecia");
                    ID = input.nextInt();
                    input.nextLine();
                    uc.usunBilet(ID);
                    break;

                case "Q":
                    System.out.println("powrót do wyboru modułu...");
                    flag = false;
                    break;
            }
        }
    }
}
