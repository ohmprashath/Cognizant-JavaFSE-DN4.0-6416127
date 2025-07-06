package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String name;

    public BookService(String name) {
    	this.name=name;
    }
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
    	System.out.println("name: "+name);
        bookRepository.getAllBooks();
    }
}
