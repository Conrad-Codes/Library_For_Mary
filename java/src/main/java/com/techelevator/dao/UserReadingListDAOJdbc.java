package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserReadingListDAOJdbc implements UserReadingListDAO {
    private JdbcTemplate jdbcTemplate;

    public UserReadingListDAOJdbc (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    };

    @Override
    public List<Book> getUserReadingList( int userID ) {
        List<Book> usersReadingList = new ArrayList<>();
        String sql = "SELECT book.book_id, book.title, book.description\n" +
                ", book.published_date, book.cover_art, book.series_id, book.genre_id \n" +
                "FROM users\n" +
                "JOIN user_reading_list\n" +
                "ON users.user_id = user_reading_list.user_id\n" +
                "JOIN reading_list\n" +
                "ON user_reading_list.list_id = reading_list.list_id\n" +
                "JOIN book\n" +
                "ON reading_list.book_id = book.book_id\n" +
                "WHERE users.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet( sql, userID );
        while( results.next() ) {
            Book book = mapRowToBook(results);
            usersReadingList.add(book);
        }
        return usersReadingList;
    }

    @Override
    public void addBookToUserReadingList(int userID, int bookID) {
        String sql = "";
        jdbcTemplate.update( sql, userID, bookID );
    }

    private List <String> listOfAuthorsByBookID( int bookID ) {
        List <String> authors = new ArrayList<>();
        String sql = "SELECT author_name FROM author "
                +"JOIN book_author ON author.author_id = book_author.author_id "
                +"WHERE book_id = ( SELECT book_id FROM book WHERE book_id = ? );";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookID);
        while(results.next()) {
            String author = results.getString("author_name");
            authors.add(author);
        }
        return authors;
    }

    private String getGenreByBookID(int bookID ) {
        String genre = "";
        String sql = "SELECT genre_name FROM genre "
                + "WHERE genre_id = (SELECT genre_id FROM book WHERE book_id = ?);";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookID);
        if (results.next()) {
            genre = results.getString("genre_name");
        }
        return genre;
    }

    private String getBookSeriesBySeriesId(int seriesID){
        String series = "";
        String sql = "SELECT series_name FROM series WHERE series_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, seriesID);

        if(results.next()){
            series = results.getString("series_name");
        }
        return series;
    }


    private Book mapRowToBook( SqlRowSet rowSet ) {
        Book book = new Book();

        book.setId( rowSet.getInt("book_id") );
        book.setTitle(rowSet.getString("title"));
        book.setDescription(rowSet.getString("description"));
        book.setImgUrl(rowSet.getString("cover_art"));
        book.setInitialPublishDate(rowSet.getDate("published_date").toLocalDate());
        book.setAuthors( listOfAuthorsByBookID( rowSet.getInt("book_id") ) );
        book.setGenre( getGenreByBookID( rowSet.getInt("book_id") ) );
        book.setSeries( getBookSeriesBySeriesId(rowSet.getInt("series_id") ) );
        return book;
    }




}
