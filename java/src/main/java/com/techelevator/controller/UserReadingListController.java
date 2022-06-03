package com.techelevator.controller;

import com.techelevator.dao.BookDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.UserReadingListDAO;
import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize( "isAuthenticated()" )
public class UserReadingListController {
    @Autowired
    UserDao userDao;
    @Autowired
    UserReadingListDAO userReadingListDAO;

    public UserReadingListController(UserDao userDao, UserReadingListDAO userReadingListDAO) {
        this.userDao = userDao;
        this.userReadingListDAO = userReadingListDAO;
    }

    @RequestMapping(path = "/user/list", method = RequestMethod.GET )
    public List<Book> getUserReadingList(Principal principal) {
        return userReadingListDAO.getUserReadingList(userDao.findIdByUsername(principal.getName()));
    }

}
