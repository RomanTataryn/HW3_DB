package com.tataryn;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Accounting {
    private int id;
    private LocalDate dateOfIssuance;
    private LocalDate returnedDate;
    private int idReader;
    private int idBook;
}
