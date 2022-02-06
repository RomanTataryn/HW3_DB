package com.tataryn;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("First query: ReadersList");
        DbSelect.getAllReaders();
        System.out.println("Second query: Selected List of books");
        DbSelect.getSelectBooks();
        System.out.println("Third query: Information about reader by idReader");
        DbSelect.informationAboutReaderByIdReader();
        System.out.println("Fourth query: Information about books taken and returned by the reader");
        DbSelect.informationAboutAccountingByIdReader();
        System.out.println("Fifth query: Information about reader by Year of birth");
        DbSelect.informationAboutReaderByBirthYear();
    }
}
