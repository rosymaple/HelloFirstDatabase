package org.example;

import java.sql.*;

public class HelloDatabase {
    public static void main(String[] args) throws SQLException {

       String url = "jdbc:sqlite:hello.sqlite";
       Connection connection = DriverManager.getConnection(url);
       Statement statement = connection.createStatement();

//       String createTableSQL = "CREATE TABLE cats (name TEXT, age INTEGER)";
//       statement.execute(createTableSQL);
//
//       String insertDataSQL = "INSERT INTO cats VALUES ('Maru', 10) ";
//       statement.execute(insertDataSQL);

        // comment out code so you dont accidentally insert 4 Hello Kitty's...
       String insertDataSQL = "INSERT INTO cats VALUES ('Hello Kitty', 40)";       // insert a row into our cats table
       statement.execute(insertDataSQL);        // execute insertDataSQL variable to insert into cats table

       String getAllDataSQL = "SELECT * FROM cats";     // select all data from cats table
       ResultSet allCats = statement.executeQuery(getAllDataSQL);       // we use ResultSet's to return a whole table.

       while (allCats.next()) {     // loop over our ResultSet! (hint: it's allCats table)
           String name = allCats.getString("name");     // pull data from column labeled "name"
           int age = allCats.getInt("age");     // pull data from column labeled "age"
           System.out.println(name + " is " + age + " years old.");     // print our name and age for our user
       }        // end of loop over ResultSet
    }           // end of main method that throws exceptions for SQL code
}           // end of HelloDatabase public class