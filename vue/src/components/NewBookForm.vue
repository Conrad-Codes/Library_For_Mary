<template>
  <form class="new-book-form" v-on:submit.prevent="saveBook">
      <legend>Add a Book:</legend>
      <br>
      <label id="titleLabel" for="title">Title:</label><br>
      <input class="title-input" type="text" placeholder="Title" v-model="book.title"/><br>
      <label for="author_name">Author:</label><br>
      <input class="author_name-input" type="text" placeholder="Author" v-model="book.author_name"/><br>
      <label for="series">Series:</label><br>
      <input class="series-input" type="text" placeholder="Series" v-model="book.series"/><br>
      <label for="genre_name">Genre:</label><br>
      <input class="genre_name-input" type="text" placeholder="Genre" v-model="book.genre_name"/><br>
      <label for="published_date">Date Published:</label><br>
      <input class="published_date-input" type="date" placeholder="YYYY-MM-DD" v-model="book.published_date"/><br>
      <label class="description">Description:</label><br>
      <input class="description-input" type="text" placeholder="Description" v-model="book.description"/><br>
      <label class="cover_art">Cover Art:</label><br>
      <input class="cover_art-input" type="text" placeholder="CoverArt" v-model="book.cover_art"/><br>
      <br>
      <button>Submit</button>
  </form>
</template>

<script>
import BookService from '../services/BookService.js';


export default {
    name: "new-book-form",
   
    data() {
        return {
            book: {
                title: '',
                author_name: [''],
                series:  '',
                genre_name: '',
                published_date: '',
                description: '',
                cover_art: ''
            }
        }
    },
    methods: {
        saveBook() {
            BookService
            .createBook(this.book)
            .then(response => {
             if (response.status === 201) {
            this.$router.push("/");
          }
        })
        .catch(error => {
          console.error(error);
        });
        //    const bookID = this.$route.params.id;
        //    this.book.bookID = bookID
        //    this.book = {
        //         title: '',
        //         author: '',
        //         series:  '',
        //         genre_name: '',
        //         datePublished: ''
        //    };
        //    this.$router.push('/add-book');
        },
        
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