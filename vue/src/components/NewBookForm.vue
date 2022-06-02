<template>
  <form class="new-book-form" v-on:submit.prevent="saveBook">
      <legend>Add a Book:</legend>
      <br>
      <label id="titleLabel" for="title">Title:</label><br>
      <input class="title-input" type="text" placeholder="Title" v-model="book.title"/><br>
      <label for="author">Author:</label><br>
      <input class="author-input" type="text" placeholder="Author" v-model="book.author"/><br>
      <label for="series">Series:</label><br>
      <input class="series-input" type="text" placeholder="Series" v-model="book.series"/><br>
      <label for="genre">Genre:</label><br>
      <input class="genre-input" type="text" placeholder="Genre" v-model="book.genre"/><br>
      <label for="datePublished">Date Published:</label><br>
      <input class="datePublished-input" type="text" placeholder="MM-DD-YYYY" v-model="book.datePublished"/><br>
      <br>
      <button>Submit</button>
  </form>
</template>

<script>

export default {
    name: "new-book-form",
    data() {
        return {
            book: {
                title: '',
                author: '',
                series:  '',
                genre: '',
                datePublished: ''
            }
        }
    },
    methods: {
        saveBook() {
           const bookID = this.$route.params.id;
           this.book.bookID = bookID
           this.$store.commit('SAVE_BOOK', this.book);
           this.book = {
                title: '',
                author: '',
                series:  '',
                genre: '',
                datePublished: ''
           };
           this.$router.push({name: 'add-book', params: {id: bookID}})
        }
    }
}
</script>

<style>

label{
   font-size: 25px;
}

input{
    font-size: 25px
}

legend{
    font-size: 40px;
}

form{
    text-align: center;
}

</style>