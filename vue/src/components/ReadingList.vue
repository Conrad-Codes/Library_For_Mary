<template>
  <div class="book-container">
      {{this.books}}
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
         books: [],
        }
       
        
    },

    created(){
    BookService.viewSavedList().then((response) => {
      this.books = response.data;
      
    });
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