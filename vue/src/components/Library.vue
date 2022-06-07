<template>
  <div class="library">
    <form id="filterOptions">
      <input
        type="radio"
        id="title"
        name="category_search"
        value="title"
        v-model="radioVal"
      />
      <label for="title">Title</label>

      <input
        type="radio"
        id="author"
        name="category_search"
        value="author"
        v-model="radioVal"
      />
      <label for="author">Author</label>

      <input
        type="radio"
        id="series"
        name="category_search"
        value="series"
        v-model="radioVal"
      />
      <label for="series">Series</label>

      <input
        type="radio"
        id="genre"
        name="category_search"
        value="genre"
        v-model="radioVal"
      />
      <label for="genre">Genre</label>

      <input
        type="radio"
        id="publishDate"
        name="category_search"
        value="publishDate"
        v-model="radioVal"
      />
      <label for="publishDate">Date Published</label>

      <input
        type="radio"
        id="dateAdded"
        name="category_search"
        value="dateAdded"
        v-model="radioVal"
      />
      <label for="dateAdded">Date Added</label>

    </form>

    <div id="searchOptions">
      <input type="text" v-model="searchTerm" placeholder="Search" />
    </div>
    <div class="book-container">
      <book-card
        v-for="book in bookList"
        v-bind:book="book"
        v-bind:key="book.id"
        
      />
      
    </div>
  <div>
    <br>
   
  </div> 
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
      radioVal: "title",
      books: [],
      searchTerm: "",
      id: "",
    };
  },
  computed: {
    bookList() {
      let bookList = this.books;
      if (this.radioVal === "title") {
        bookList = bookList.filter((books) =>
          books.title.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      }

      if (this.radioVal === "genre") {
        bookList = bookList.filter((books) => {
          const bookGenres = books.genre_name;
          for (const genres of bookGenres) {
            if (genres.toLowerCase().includes(this.searchTerm.toLowerCase())) {
              return books;
            }
          }
        });
      }

      if (this.radioVal === "author") {
        bookList = bookList.filter((books) => {
          const bookAuthors = books.author_name;
          for (const authors of bookAuthors) {
            if (authors.toLowerCase().includes(this.searchTerm.toLowerCase())) {
              return books;
            }
          }
        });
      }

      if (this.radioVal === "publishDate") {
        bookList = bookList.filter((books) =>
          books.published_date
            .toLowerCase()
            .includes(this.searchTerm.toLowerCase())
        );
      }

      if (this.radioVal === "series") {
        bookList = bookList.filter((books) =>
          books.series.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      }

      if (this.radioVal === "dateAdded") {
        bookList = bookList.filter((books) =>
          books.date_created > this.searchTerm);
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
div.book-container {
  display: flex;
  justify-content:start;
  flex-wrap: wrap;
}

div.card {
   border: solid #C8A2C8 2px;
   width: 350px;
}

.library{
  background-color: #93E9BE;
 font-family: 'Comfortaa', cursive;
}
#filterOptions{
  position: absolute;
  top: 5.5px;
  right: 8px;
}

#searchOptions{
  position: absolute;
  top: 30px;
  right: 12px;
  
}
</style>