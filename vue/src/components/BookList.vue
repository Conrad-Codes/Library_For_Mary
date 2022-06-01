<template>
  <div class= "library" >
      <book-card v-for="book in books" v-bind:book="book" v-bind:key="book.id" />
  </div>
</template>

<script>
import bookService from "../services/BookService";
import BookCard from '../components/BookCard';

export default {
 name: "book-list"
 ,
 components: {
     BookCard
 },
 data() {
     return {
         books: []
     }
 }

 , created() {
     bookService.getBooks().then( response => {
             this.books = response.data;
     } )

 }

 , methods: {
    // listAllBooks() {
    //     bookService.getBooks().then( response => {
    //         this.listBooks = response.data;
    //     } )
    // }
 } 
}
</script>

<style>

</style>