package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface UserReadingListDAO {

    public List<Book> getUserReadingList( int userID );

    public boolean addBookToUserReadingList( int userID, int bookID );

    public boolean deleteBookFromUserReadingList( int userID, int bookID );

}
