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
     * List of authors <
     * String isbn
     * String genres <
     * String description
     * Date initialPublishDate
     * String imgUrl
     * @return List books
     */
    @Override
    public List<Book> listBooks() {
        List <Book> books = new ArrayList<>();
        String sql = "SELECT * from book ORDER BY title";
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

        for( Book book : listBooks() ) {
            if( book.getId() == bookID ) {
                foundBook = book;
                break;
            }
        }

        return foundBook;
    }

    @Override
    public Book getBookByTitle(String bookTitle) {
        if( bookTitle == null || bookTitle.equals("") ) {
            System.out.println();
            return null;
        }

        List<Book> books = listBooks();
        Book foundBook = null;

        for (int i = 0; i < books.size(); i++) {
            if ( books.get( i ).getTitle().toLowerCase().equals(bookTitle.toLowerCase()) ) {
                foundBook = books.get( i );
                break;
//          System.out.println(bookTitle);
            }
        }

        return foundBook;
    }

    @Override
    public Book getBooksByAuthor(String authorName) {
        return null;
    }

    @Override
    public Book getBooksByGenre(String genreType) {
        return null;
    }

    private List <String> listOfAuthorsByBookID( int bookID ) {
        List <String> authors = new ArrayList<>();
        String sql = "SELECT author_name FROM author "
                +"JOIN book_author ON author.author_id = book_author.author_id "
                +"WHERE book_id = ( SELECT id FROM book WHERE id = ? )";
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
                + "JOIN book_genre ON genre.genre_id = book_genre.book_genre_id" +
                "WHERE book_id = (SELECT id FROM book WHERE id = ?)";

       SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookID);
        while(results.next()) {
            String genre = results.getString("genre_name");
            genres.add(genre);
        }

        return genres;
    }

    private Book mapRowToBook(SqlRowSet rowSet) {

        Book book = new Book();
        book.setId( rowSet.getInt("id") );
        book.setTitle(rowSet.getString("title"));
//        book.setAuthors(rowSet.getString);
        book.setAuthors( listOfAuthorsByBookID( rowSet.getInt("id") ) );
        book.setIsbn(rowSet.getString("isbn"));
//        book.setGenres(rowSet.getString);
        book.setGenres(listOfGenresByBookID(rowSet.getInt("id")));
        book.setDescription(rowSet.getString("description"));
        book.setImgUrl(rowSet.getString("cover_art"));
        book.setInitialPublishDate(rowSet.getDate("publish_date"));
        return book;

    }




}
