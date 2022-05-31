package com.techelevator.model;

import java.util.Date;
import java.util.List;

public class Book {

    private int id;
    private String title;
    private List<String> authors;
    private String isbn;
    private List<String> genres;
    private String description;
    private Date initialPublishDate;
    private String imgUrl;

    public Book() {};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List <String> getGenres() {
        return genres;
    }

    public void setGenres(List <String> genres) {
        this.genres = genres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInitialPublishDate() {
        return initialPublishDate;
    }

    public void setInitialPublishDate(Date initialPublishDate) {
        this.initialPublishDate = initialPublishDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return title;
    }
}
