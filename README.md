# „Kino-manager”
> Aplikacja do zarządzania listą kin – uruchamiana z konsoli 

## Spis treści
* [Główne informacje](#glowne-informacje)
* [Technologie](#technologie)
* [Setup](#setup)
* [Mozliwości](#mozliwosci)
* [Status](#status)
* [Inspiracja](#inspiracja)
* [Autor](#autor)

## Główne informacje
Prosta aplikacja napisana w języku Java, służąca do zarządzania listą kin. Aplikacja nie posiada interfejsu graficznego – wywoływana jest z konsoli.

## Technologie
* Język - Java Version 8 Update 181
* IDE – NetBeans IDE 8.2,
* Zastosowane narzędzia – JDBC, mySQL WorkBench, util.Scanne

## Setup
Aplikacja składa się z 6 klas oraz jednego schematu SQL. Pliki należy umieścić w pakunku Kino w 4 folderach: folder główny-klasa Main.java oraz kino.sql, wewnątrz folder controller – klasa Controller.java, folder database – klasa DBConnect.java, folder model – klasy Bilety.java, Filmy.java, Kino.java Następnie należy utworzyć lokalną bazę danych korzystając ze schematu SQL. Aplikację uruchomić przez IDE lub z wiersza poleceń. W razie potrzeby zmienić hasło dostępu do bazy danych w pliku DBConnect.java

## Mozliwości
Możliwości aplikacji:
* Dodawanie nowego kina do bazy danych
* Wyświetlanie listy kin
* Usuwanie kin
* Dodawanie i usuwanie filmów z danego kina
* Wyświetlanie listy filmów wraz z kinami w których są grane
* Usuwanie filmów po ID
* Dodawanie biletów na dany film w danym kinie
* Wyświetlanie listy biletów i ich usuwanie

To-do list:
* 

## Status
Projekt ukończony, stabilny

## Inspiracja
Projekt wykonany jako zaliczenie bootcampu programistycznego 

## Autor
Stworzony przez: Seweryn Krupiński 

