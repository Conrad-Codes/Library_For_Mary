<template>
  <div class="card">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class ="series-name"> {{book.series}}</h3>
    <img class="cover-art" v-bind:src="book.cover_art" />
    <h3 class="book-author">{{ book.author_name.toString() }}</h3>
    <p class="book-description">{{book.description}}</p>
    <button id="addToMyList"   @click="saveBookOrRemoveBookToMyList(); a = !a;">
      <p class="addingBook" v-show="a">Add To Reading List </p>
      <p class="removingBook" v-show="!a">Remove From Reading List </p>
    </button>
  </div>
</template>

<script>
import BookService from '../services/BookService.js';

export default {
  name: "book-card",
  props: {
    book: Object,
  },
  data(){
    return {
      a: true
    }
  },
  created(){
    
    },
    // const btn = document.getElementById('addToMyList');
    // btn.addEventListener('click', function handleClick() {
    //   const initialText = 'Add To My Reading List';
    //   if(btn.textContent.includes(initialText)) {
    //     btn.textContent = 'Remove From Reading List'
    //   } else {
    //     btn.textContent = initialText;
    //   }
    // });
  
  
  methods: {

    
    //check all books ahead of time
    saveBookOrRemoveBookToMyList(){
      if(this.a === true) {
      alert("Added to Your Reading List");
      BookService
      .addBookToMyList(this.book)
      .then(response => {
             if (response.status === 201) {
            this.$router.push("/")
             }
        })
        .catch(error => {
          console.error(error);
        });
        
      } else {
        if(this.a === false){
        alert("Removed From List");
        BookService
      .deleteBookFromMyList(this.book)
      .then(response => {
             if (response.status === 201) {
            this.$router.push("/user/list")
             }
        })
        .catch(error => {
          console.error(error);
        });
      }
      }
    },

    deleteBookFromList(){
      
      }
      
     },
  
};
</script>

<style>
.card{
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 5px;
  margin: 5px;
  color: black;
  border-radius: 25px;
}

.cover-art{
  width: 250px;
  height: 350px;
}

.book-description{
  font-family: 'Comfortaa', cursive;
}

.book-title{
  font-family: 'Cinzel', serif;
}

.book-series{
  font-family: 'Playfair Display SC', serif;
}

p.addingBook{
  border-radius: 25px;
  border: solid #C8A2C8 2px;
  padding-bottom: 2px;
}

.addToMyList{
  border-radius: 25px;
  border: solid #C8A2C8 2px;
  padding-bottom: 2px;
}

p.removingBook{
  border-radius: 25px;
  border: solid #C8A2C8 2px;
  padding-bottom: 2px;
}



</style>