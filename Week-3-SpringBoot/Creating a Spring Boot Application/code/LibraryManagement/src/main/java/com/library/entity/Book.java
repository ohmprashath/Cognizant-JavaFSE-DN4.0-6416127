package com.library.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private double price;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
