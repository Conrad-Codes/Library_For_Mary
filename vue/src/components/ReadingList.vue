<template>
  <div class="saved-book-container book-container">
    <book-card v-for="book in books" v-bind:book="book" v-bind:key="book.id"/>
  </div>
</template>

<script>
import BookCard from "@/components/BookCard.vue";
import BookService from "../services/BookService.js";

export default {
  name: "reading-list",
  components: {
    BookCard,
  },
  data() {
    return {
      books: [],
    };
  },

  created() {
    BookService.viewSavedList()
      .then((response) => {
        if (response.status === 200) {
          console.log(response);
          this.books = response.data;
        }
      })
      .catch((error) => console.log(error));
  },

  methods: {
    // delete this if work on bookCArd
    updateCurrentlyReading( book ) {
      BookService.updateCurrentlyReading( book )
        .then( ( response ) => {
          if( response.status !== 200 ) {
            console.log( "Error")
          }
        } )
    }
  }
};
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>