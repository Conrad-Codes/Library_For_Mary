<template>
  <div class="current-book-container book-container">
    <book-card v-for="book in books" v-bind:book="book" v-bind:key="book.id" />
  </div>
</template>

<script>
import BookCard from '@/components/BookCard.vue';
import BookService from '../services/BookService.js'

export default {
  name: 'current-reading-list'
  , components: {
    BookCard
  }
  , data() {
    return {
      books: []
    }
  }
  , created() {
    BookService.viewCurrentlyReadingBooks()
      .then( ( response ) => {
        if( response.status === 200 ) {
          this.books = response.data;
        }
      } )
  }
}
</script>

<style>

div.saved-book-container > div.card:hover {
  background-color: whitesmoke;
}
div.current-book-container > div.card:hover {
  background-color: whitesmoke;
}
div.current-book-container{
  display: flex;
  /* flex-direction: row; */
  justify-content: center;
}

</style>