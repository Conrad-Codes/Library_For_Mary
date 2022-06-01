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
      if (
        this.filter.genre != "" &&
        document.getElementById("genreCheckBox") != ""
      ) {
        bookList = bookList.filter((books) =>
          books.genre.toLowerCase().includes(this.filter.genre.toLowerCase)
        );
      }
      if (
        this.filter.author != "" &&
        document.getElementById("authorCheckBox") != ""
      ) {
        bookList = bookList.filter((books) =>
          books.author.toLowerCase().includes(this.filter.author.toLowerCase)
        );
      }
      if (
        this.filter.bookID != "" &&
        document.getElementById("bookIDCheckBox") != ""
      ) {
        bookList = bookList.filter((books) =>
          books.bookID.toLowerCase().includes(this.filter.bookID.toLowerCase)
        );
      }
      if (
        this.filter.isbn != "" &&
        document.getElementById("isbnCheckBox") != ""
      ) {
        bookList = bookList.filter((books) =>
          books.isbn.toLowerCase().includes(this.filter.isbn.toLowerCase)
        );
      }
      if (
        this.filter.publishDate != "" &&
        document.getElementById("publishDateCheckBox") != ""
      ) {
        bookList = bookList.filter((books) =>
          books.publishDate
            .toLowerCase()
            .includes(this.filter.publishDate.toLowerCase)
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

  methods: {
    // listAllBooks() {
    //     bookService.getBooks().then( response => {
    //         this.listBooks = response.data;
    //     } )
    // }
  },
};
</script>

<style>
</style>