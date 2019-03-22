package Kino.controller;

import Kino.database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {

    DBConnect dao = new DBConnect();

    //MODUŁ KINA

    public void dodajKino(String nazwa) throws SQLException {

        String insertSQL = "INSERT INTO kino.kino(nazwa) VALUES (?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, nazwa);
        st.execute();
        st.close();

        System.out.println("Chcesz zatwierdzić wprowadzone dane? T/N");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toUpperCase();
            if (dec.equals("T")){
                dao.getCon().commit();
            }
            else{
                dao.getCon().rollback();
            }
    }

    public void pokazKina() throws SQLException {

        String selectSQL = "SELECT * FROM kino.kino";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(selectSQL);
            while(rs.next()){
                System.out.println(rs.getString("ID")+" Nazwa kina: "+rs.getString("nazwa"));
            }
        st.close();
    }

    public void usunKina(int ID) throws SQLException {

        String delSQL = "DELETE FROM kino.kino WHERE ID=?";
        PreparedStatement st = dao.getCon().prepareStatement(delSQL);
        st.setInt(1, ID);
        st.execute();
        st.close();

        System.out.println("Czy chcesz usunąć dane? T/N");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toUpperCase();
            if (dec.equals("T")){
                dao.getCon().commit();
            }
            else{
                dao.getCon().rollback();
            }
    }

    //MODUŁ FILMY

    public void dodajFilm(int ID, String nazwaFilmu) throws SQLException {

        String insertSQL = "INSERT INTO kino.filmy (nazwa, kino_ID) VALUES (?, ?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, nazwaFilmu);
        st.setInt(2, ID);
        st.execute();
        st.close();

        System.out.println("Chcesz zatwierdzić wprowadzone dane? T/N");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toUpperCase();
            if (dec.equals("T")){
                dao.getCon().commit();
            }
            else{
                dao.getCon().rollback();
            }
    }

    public void pokazFilmy() throws SQLException {

        String selectSQL = "SELECT f.ID, f.nazwa, k.nazwa FROM kino.kino k INNER JOIN kino.filmy f ON k.ID = f.kino_ID;";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(selectSQL);
            while(rs.next()){
                System.out.println(rs.getString("f.ID")+" "+ rs.getString("f.nazwa")+" "+ rs.getString("k.nazwa"));
            }
        st.close();
    }


    public void usunFilm(int filmID) throws SQLException {

        String delSQL = "DELETE FROM kino.filmy WHERE ID=?";
        PreparedStatement st = dao.getCon().prepareStatement(delSQL);
        st.setInt(1, filmID);
        st.execute();
        st.close();

        System.out.println("Czy chcesz usunąć dane? T/N");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toUpperCase();
            if (dec.equals("T")){
                dao.getCon().commit();
            }
            else{
                dao.getCon().rollback();
            }
    }

    // MODUŁ BILETY

    public void pokazFilmy(int ID) throws SQLException {

        String selectSQL = "SELECT f.ID, f.nazwa FROM kino k INNER JOIN filmy f ON k.ID = f.kino_ID where k.ID="+ID+";";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(selectSQL);
            while(rs.next()){
                System.out.println(rs.getString("f.ID")+" "+ rs.getString("f.nazwa"));
            }
            st.close();
    }

    public void kupBilet(int filmID, String ilosc) throws SQLException {

        String insertSQL = "INSERT INTO bilety(ilosc, filmy_ID) VALUES (?, ?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, ilosc);
        st.setInt(2, filmID);
        st.execute();
        st.close();

        System.out.println("Chcesz zatwierdzić wprowadzone dane? T/N");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toUpperCase();
            if (dec.equals("T")){
                dao.getCon().commit();
            }
            else{
                dao.getCon().rollback();
            }
    }

    public void pokazBilety() throws SQLException {

        String selectSQL = "SELECT b.ID, b.ilosc, f.nazwa, k.nazwa FROM bilety b INNER JOIN filmy f ON b.filmy_ID = f.ID INNER JOIN kino k ON f.kino_ID = k.ID";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(selectSQL);
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("b.ID")+" ilość: "+rs.getString("b.ilosc")+" film: "+ rs.getString("f.nazwa")+ " nazwa kina: "+rs.getString("k.nazwa"));
            }
            st.close();
    }

    public void usunBilet(int ID) throws SQLException {

        String delSQL = "DELETE FROM bilety WHERE ID=?";
        PreparedStatement st = dao.getCon().prepareStatement(delSQL);
        st.setInt(1, ID);
        st.execute();
        st.close();

        System.out.println("Czy chcesz usunąć dane? T/N");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toUpperCase();
            if (dec.equals("T")){
                dao.getCon().commit();
            }
            else{
                dao.getCon().rollback();
            }
    }
}
