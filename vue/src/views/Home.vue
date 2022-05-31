<template>
<div>
  <div class="home">
    <h1>Welcome to Mary's Maginificent Library</h1>
    <p>Use our search bar to see all the wonderful books Mary offers!</p>
  </div>
  <div id="searchOptions">
  <button type="search">Search Library</button>
  <input type="text">
  </div>

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
      selectedSearch : '',
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
  computed: {
      bookList(){
        let bookList = this.books;
      if(this.filter.title != '') {
        bookList = bookList.filter(books => books.title.toLowerCase().includes(this.filter.title.toLowerCase))
      }
      if(this.filter.genre != '') {
        bookList = bookList.filter(books => books.genre.toLowerCase().includes(this.filter.genre.toLowerCase))
      }
      if(this.filter.author != '') {
        bookList = bookList.filter(books => books.author.toLowerCase().includes(this.filter.author.toLowerCase))
      }
      if(this.filter.bookID != '') {
        bookList = bookList.filter(books => books.bookID.toLowerCase().includes(this.filter.bookID.toLowerCase))
      }
      if(this.filter.isbn != '') {
        bookList = bookList.filter(books => books.isbn.toLowerCase().includes(this.filter.isbn.toLowerCase))
      }
      if(this.filter.publishDate != '') {
        bookList = bookList.filter(books => books.publishDate.toLowerCase().includes(this.filter.publishDate.toLowerCase))
      }
      return bookList;
    }
    
   
    
    

  }
}



</script>
