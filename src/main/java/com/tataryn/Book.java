package com.tataryn;

import lombok.Data;


      @Data
    public class Book {
        private int id_book;
        private String name;
        private String author;
        private String name_publishing_house;
        private int year_of_edition;
        private int count_of_pages;
        private double price;
    }


