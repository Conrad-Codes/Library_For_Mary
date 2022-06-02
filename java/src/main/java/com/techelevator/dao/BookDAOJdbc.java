package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAOJdbc implements BookDAO {

    private JdbcTemplate jdbcTemplate;

    public BookDAOJdbc( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Each book has:
     * String title
     * List of authors
     * String isbn
     * List of genres
     * String description
     * Date initialPublishDate
     * String imgUrl
     * String series
     * @return List books
     */
    @Override
    public List<Book> listBooks() {
        List <Book> books = new ArrayList<>();
        String sql = "SELECT book_id, title, isbn, description, published_date, cover_art, series_id FROM book;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Book book = mapRowToBook(results);
            books.add(book);
        }
        return books;
    }

    @Override
    public Book getBook(int bookID) {
        Book foundBook = null;
        String sql = "SELECT * FROM book WHERE book_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet( sql, bookID );
        if( results.next() ) {
            foundBook = mapRowToBook(results);
        }
        return foundBook;
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

    private List<String> listOfGenresByBookID( int bookID ) {
        List<String> genres = new ArrayList<>();
        String sql = "SELECT genre_name FROM genre "
                + "JOIN book_genre ON genre.genre_id = book_genre.genre_id "
                + "WHERE book_id = (SELECT book_id FROM book WHERE book_id = ?);";
       SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookID);
        while(results.next()) {
            String genre = results.getString("genre_name");
            genres.add(genre);
        }
        return genres;
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

    private Book mapRowToBook(SqlRowSet rowSet) {
        Book book = new Book();

        book.setId( rowSet.getInt("book_id") );
        book.setTitle(rowSet.getString("title"));
        book.setIsbn(rowSet.getString("isbn"));
        book.setDescription(rowSet.getString("description"));
        book.setImgUrl(rowSet.getString("cover_art"));
        book.setInitialPublishDate(rowSet.getDate("published_date").toLocalDate());
        book.setAuthors( listOfAuthorsByBookID( rowSet.getInt("book_id") ) );
        book.setGenres( listOfGenresByBookID( rowSet.getInt("book_id") ) );
        book.setSeries(getBookSeriesBySeriesId(rowSet.getInt("series_id")));
        return book;
    }
}
