<template>
  <div class="entireHome">
    <div class="home">
      <h1 class="Mary">Welcome to Mary's Magnificent Library</h1>
      <p>Home of your next favorite book!</p>
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

  created() {
  },
  methods: {

    searchBooks() {
      this.filteredArray = this.books.filter(
        (book) => book.name === this.searchTerm
      );
    },
  },

  computed: {},
};
</script>
<style>

.entireHome{
  background-color:#98FB98;
  
}

h1{
  text-align: center;
  font-family:cursive;
  font-size: 50px;
}

p{
  text-align: center;
  font-family: 'Comfortaa', cursive;
  font-size: 25px;
}

.home{
  padding-top: 10px;
}

.Mary{
  font-family: 'Gloria Hallelujah', cursive;
}
</style>