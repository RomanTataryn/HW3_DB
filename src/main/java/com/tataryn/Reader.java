package com.tataryn;

import lombok.Data;

@Data
public class Reader {
    private int id_reader;
    private String firstName;
    private String lastName;
    private String passport_number;
    private int year_of_birth;
}
