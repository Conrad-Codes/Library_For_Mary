<template>
<div>
  <div class="home">
    <h1>Welcome to Mary's Magnificent Library</h1>
    <p>Use our search bar to see all the wonderful books Mary offers!</p>
  </div>
  <form>
    <input type="checkbox" id="titleCheckBox" name="Title" value="">
    <label for="titleCheckbox">Title  </label>
    <input type="checkbox" id="genreCheckBox" name="Genre" value="">
    <label for="genreCheckbox">Genre  </label>
    <input type="checkbox" id="authorCheckBox" name="Author" value="">
    <label for="AuthorCheckbox">Author  </label>
    <input type="checkbox" id="bookIDCheckBox" name="bookID" value="">
    <label for="bookIDCheckbox">BookID  </label>
    <input type="checkbox" id="isbnCheckBox" name="Isbn" value="">
    <label for="isbnCheckbox">ISBN </label>
    <input type="checkbox" id="publishDateCheckBox" name="PublishDate" value="">
    <label for="publishDate">PublishDate</label>
  </form>
   <div id="searchOptions">
  <button type="search" v-on:click="searchBooks">Search Library</button>
  <input type="text" v-model='searchTerm'>
  </div>
  <ol>
  
    {{bookList}}
  </ol>

</div>
  
</template>


<script>
import BookService from '../services/BookService';

export default {
  name: "home",
  components: {

  },
  data(){
    return {
      // selectedSearch : '',
      searchTerm: '',
      id: '',
      filter: {
        title: '',
        genre: '',
        author: '',
        bookID: '',
        isbn: '',
        publishDate: ''
      }
    }
  },
  created(){
    BookService.getBooks().then(response => {
      this.books = response.data;
    })
  },
  methods:{
     showBooks(allBooks) {
      document.getElementById("displayAllBooks").innerHTML = allBooks;
    },

    searchBooks(){

     this.filteredArray = this.books.filter( (book) => book.name === this.searchTerm)

    }
  },

  computed: {
      bookList(){
        let bookList = this.books;
      if(this.filter.title != '' && document.getElementById("titleCheckBox") != '') {
        bookList = bookList.filter(books => books.title.toLowerCase().includes(this.filter.title.toLowerCase))
      }
      if(this.filter.genre != '' && document.getElementById("genreCheckBox") != '') {
        bookList = bookList.filter(books => books.genre.toLowerCase().includes(this.filter.genre.toLowerCase))
      }
      if(this.filter.author != ''&& document.getElementById("authorCheckBox") != '') {
        bookList = bookList.filter(books => books.author.toLowerCase().includes(this.filter.author.toLowerCase))
      }
      if(this.filter.bookID != ''&& document.getElementById("bookIDCheckBox") != '') {
        bookList = bookList.filter(books => books.bookID.toLowerCase().includes(this.filter.bookID.toLowerCase))
      }
      if(this.filter.isbn != '' && document.getElementById("isbnCheckBox") != '') {
        bookList = bookList.filter(books => books.isbn.toLowerCase().includes(this.filter.isbn.toLowerCase))
      }
      if(this.filter.publishDate != '' && document.getElementById("publishDateCheckBox") != '') {
        bookList = bookList.filter(books => books.publishDate.toLowerCase().includes(this.filter.publishDate.toLowerCase))
      }
      return bookList;
    }
    
   
    
    

  }
}



</script>
<style scoped>

#home{
  color: rgb(81, 177, 145);
}
</style>