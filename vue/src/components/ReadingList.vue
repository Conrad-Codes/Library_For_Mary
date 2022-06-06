<template>
  <div class="book-container">
    <!-- {{this.$store.state.token}}
    {{this.$store.state.user}}
    {{this.books}} -->
    <book-card v-for="book in books"  v-bind:key="book.id" />
  </div>
</template>

<script>
import BookCard from '@/components/BookCard.vue';
import BookService from '../services/BookService.js'

export default {
    name: 'reading-list',
    components: {
        BookCard
    },
    data(){
        return{
         books: []
        }
    },

    created(){
    // added user into parameter
    BookService.viewSavedList()
      .then( (response) => {
        if( response.status === 200 ) {
          console.log( response );
         this.books = response.data;
        }
      })
      .catch ( error => console.log( error ) );
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>