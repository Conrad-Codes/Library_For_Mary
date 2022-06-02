<template>
  <div class="library">
    <form>
      <input
        type="checkbox"
        v-model="filter.title"
        id="titleCheckBox"
        name="Title"
        value=""
      />
      <label for="titleCheckbox">Title </label>
      <input
        type="checkbox"
        v-model="filter.genre"
        id="genreCheckBox"
        name="Genre"
        value=""
      />
      <label for="genreCheckbox">Genre </label>
      <input
        type="checkbox"
        v-model="filter.author"
        id="authorCheckBox"
        name="Author"
        value=""
      />
      <label for="AuthorCheckbox">Author </label>
      <input
        type="checkbox"
        v-model="filter.bookID"
        id="bookIDCheckBox"
        name="bookID"
        value=""
      />
      <label for="bookIDCheckbox">BookID </label>
      <input
        type="checkbox"
        v-model="filter.isbn"
        id="isbnCheckBox"
        name="Isbn"
        value=""
      />
      <label for="isbnCheckbox">ISBN </label>
      <input
        type="checkbox"
        v-model="filter.publishDate"
        id="publishDateCheckBox"
        name="PublishDate"
        value=""
      />
      <label for="publishDate">PublishDate</label>
    </form>
    <div id="searchOptions">
      <input type="text" v-model="searchTerm" />
    </div>
    <book-card v-for="book in bookList" v-bind:book="book" v-bind:key="book.id" />
  </div>
</template>

<script>
import bookService from "../services/BookService";
import BookCard from "../components/BookCard";

export default {
  name: "library",
  components: {
    BookCard,
  },
  data() {
    return {
      books: [],
      searchTerm: "",
      id: "",
      filter: {
        title: "",
        genre: "",
        author: "",
        bookID: "",
        isbn: "",
        publishDate: "",
      },
    };
  },
  computed: {
    bookList() {
      let bookList = this.books;
      if (this.filter.title === true) {
        bookList = bookList.filter((books) =>
          books.title.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      }

      if ( this.filter.genre === true ) {
        bookList = bookList.filter( (books) => {
          const bookGenres = books.genre_name;
          for( const genres of bookGenres ) {
            if( genres.toLowerCase().includes( this.searchTerm.toLowerCase() ) ) {
              return books;
            }
          }
        } );
      }

      if ( this.filter.author === true ) { 
        bookList = bookList.filter( (books) => {
          const bookAuthors = books.author_name;
          for( const authors of bookAuthors ) {
            if( authors.toLowerCase().includes( this.searchTerm.toLowerCase() ) ) {
              return books;
            }
          }
        } );
      }

      if ( this.filter.bookID === true ) {
        bookList = bookList.filter((books) =>
          books.book_id.toString().includes( this.searchTerm )
        );
      }

      if ( this.filter.isbn === true ) {
        bookList = bookList.filter((books) =>
          books.isbn.toLowerCase()
          .includes(this.searchTerm.toLowerCase())
        );
      }

      if ( this.filter.publishDate === true ) {
        bookList = bookList.filter((books) =>
          books.published_date.toLowerCase()
            .includes(this.searchTerm.toLowerCase())
        );
      }
      return bookList;
    },
  },

  created() {
    bookService.getBooks().then((response) => {
      this.books = response.data;
    });
  },

  methods: {},
};
</script>

<style>
</style>