package com.tataryn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbSelect {
    public static final String url = "jdbc:mysql://localhost:3306/library";
    public static final String userName = "root";
    public static final String password = "qwerty_777";

    public static Connection getConnection() throws SQLException {


            return DriverManager.getConnection(url, userName, password);


    }

    public static List<Reader> getAllReaders() {
        List<Reader> readerList = new ArrayList<>();
        final String sql ="SELECT id_reader, last_name, first_name,passport_number, year_of_birth from readers ";
        try (

           final  PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
           final ResultSet resultSet = preparedStatement.executeQuery(sql))
        { while (resultSet.next()) {
                Reader reader = buildreader(resultSet);
                readerList.add(reader);
            }
            System.out.println(readerList);



        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return readerList;
    }

    private static Reader buildreader(ResultSet resultSet) throws SQLException {
        Reader reader = new Reader();
        reader.setId_reader(resultSet.getInt("id_reader"));
        reader.setFirstName(resultSet.getString("first_name"));
        reader.setLastName(resultSet.getString("last_name"));
        reader.setPassport_number(resultSet.getString("passport_number"));
        reader.setYear_of_birth(resultSet.getInt("year_of_birth"));
        return reader;
    }

    public static List<Book> getSelectBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_book, author, name,"
                    + " name_publishing_house, year_of_edition, count_of_pages, price" +
                    " from books WHERE price >? AND year_of_edition >?");
            preparedStatement.setDouble(1, 60);
            preparedStatement.setInt(2, 2000);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = buildBook(resultSet);
                bookList.add(book);
            }
            System.out.println(bookList);
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bookList;
    }

    private static Book buildBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId_book(resultSet.getInt("id_book"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setName_publishing_house(resultSet.getString("name_publishing_house"));
        book.setYear_of_edition(resultSet.getInt("year_of_edition"));
        book.setCount_of_pages(resultSet.getInt("count_of_pages"));
        book.setPrice(resultSet.getInt("price"));
        return book;
    }

    public static void informationAboutReaderByIdReader() {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT last_name, first_name,"
                    + " passport_number from Readers WHERE id_reader=3 ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("last_name"));
                System.out.print(" ");
                System.out.print(resultSet.getString("first_name"));
                System.out.print(", ");
                System.out.print(resultSet.getString("passport_number"));
                System.out.println("");
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void informationAboutAccountingByIdReader() {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT accounting.date_of_issuance," +
                    " accounting.returned_date, books.name from accounting inner join books on" +
                    " books.id_book=accounting.id_book where id_Reader=3 ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getDate("date_of_issuance"));
                System.out.print(", ");
                System.out.print(resultSet.getDate("returned_date"));
                System.out.print(", ");
                System.out.println(resultSet.getString("name"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void informationAboutReaderByBirthYear() {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT last_name, first_name," +
                    " year_of_birth from Readers WHERE year_of_birth>? ");
            preparedStatement.setInt(1, 2000);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("last_name"));
                System.out.print(" ");
                System.out.print(resultSet.getString("first_name"));
                System.out.print(", ");
                System.out.println(resultSet.getInt("year_of_birth"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}








