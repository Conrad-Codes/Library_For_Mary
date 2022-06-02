package com.techelevator.controller;

import com.techelevator.dao.BookDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@PreAuthorize( "isAuthenticated()" )
public class BookController {
    @Autowired
    UserDao userDao;
    @Autowired
    BookDAO bookDAO;

    public BookController( UserDao userDao, BookDAO bookDAO ) {
        this.userDao = userDao;
        this.bookDAO = bookDAO;
    }

    @RequestMapping( path = "/books/{id}", method = RequestMethod.GET )
    public Book getBookByID(@PathVariable int id ) {
        return bookDAO.getBook( id );
    }

    @RequestMapping( path= "/list", method = RequestMethod.GET )
    public List<Book> getListOfAllBooks() {
        return bookDAO.listBooks();
    }
}


