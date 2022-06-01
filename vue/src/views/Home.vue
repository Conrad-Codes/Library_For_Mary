<template>
  <div>
    <div class="home">
      <h1>Welcome to Mary's Magnificent Library</h1>
      <p>Use our search bar to see all the wonderful books Mary offers!</p>
    </div>
    
    <div>
      <div>
        <library />
      </div>
    </div>
  </div>
</template>


<script>
// import BookService from "../services/BookService";
import Library from "../components/Library";

export default {
  name: "home",
  components: {
    Library,
  },
  data() {
    
  },
  created() {
    // BookService.getBooks().then((response) => {
    //   this.books = response.data;
    // });
  },
  methods: {
    // showBooks(allBooks) {
    //   document.getElementById("displayAllBooks").innerHTML = allBooks;
    // },

    searchBooks() {
      this.filteredArray = this.books.filter(
        (book) => book.name === this.searchTerm
      );
    },
  },

  computed: {
    // bookList() {
    //   let bookList = this.books;
    //   if (
    //     this.filter.title != "" &&
    //     document.getElementById("titleCheckBox") != ""
    //   ) {
    //     bookList = bookList.filter((books) =>
    //       books.title.toLowerCase().includes(this.filter.title.toLowerCase)
    //     );
    //   }
    //   if (
    //     this.filter.genre != "" &&
    //     document.getElementById("genreCheckBox") != ""
    //   ) {
    //     bookList = bookList.filter((books) =>
    //       books.genre.toLowerCase().includes(this.filter.genre.toLowerCase)
    //     );
    //   }
    //   if (
    //     this.filter.author != "" &&
    //     document.getElementById("authorCheckBox") != ""
    //   ) {
    //     bookList = bookList.filter((books) =>
    //       books.author.toLowerCase().includes(this.filter.author.toLowerCase)
    //     );
    //   }
    //   if (
    //     this.filter.bookID != "" &&
    //     document.getElementById("bookIDCheckBox") != ""
    //   ) {
    //     bookList = bookList.filter((books) =>
    //       books.bookID.toLowerCase().includes(this.filter.bookID.toLowerCase)
    //     );
    //   }
    //   if (
    //     this.filter.isbn != "" &&
    //     document.getElementById("isbnCheckBox") != ""
    //   ) {
    //     bookList = bookList.filter((books) =>
    //       books.isbn.toLowerCase().includes(this.filter.isbn.toLowerCase)
    //     );
    //   }
    //   if (
    //     this.filter.publishDate != "" &&
    //     document.getElementById("publishDateCheckBox") != ""
    //   ) {
    //     bookList = bookList.filter((books) =>
    //       books.publishDate
    //         .toLowerCase()
    //         .includes(this.filter.publishDate.toLowerCase)
    //     );
    //   }
    //   return bookList;
    // },
  },
};
</script>
<style>
</style>