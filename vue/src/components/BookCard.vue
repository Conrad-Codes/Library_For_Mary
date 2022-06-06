<template>
  <div class="card" v-on:click="updateCurrentlyReading(book)">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="series-name">{{ book.series }}</h3>
    <img class="cover-art" v-bind:src="book.cover_art" />
    <h3 class="book-author">{{ book.author_name.toString() }}</h3>
    <p class="book-description">{{ book.description }}</p>
    
    <button
      id="addToMyList"
      @click="toggleReadingList(book)"
      v-show= isLoggedIn
      >{{bookInList(book.book_id) === false ? "Add To List" : "Remove From List"}}
      <!-- <p class="addingBook" v-show="a">Add To Reading List</p>
      <p class="removingBook" v-show="!a">Remove From Reading List</p> -->
    </button>
    </div>
    <!-- <button class="btn" v-if@click="saveBookOrRemoveBook">Mark as Read</button> -->
  
</template>

<script>
import BookService from "../services/BookService.js";


export default {
  name: "book-card",
  props: {
    book: Object,
    
  },
  data() {
    return {
      bookFound: false,
      booksList: [],
      login: false
      // a: true
    };
  },
  created() {
    if (this.$store.state.token != ""){
    BookService.viewSavedList().then( response => {
              this.booksList = response.data
              
            });
    }
  },

  computed: {
    isLoggedIn() {
      return (this.$store.state.token != "")
    }
  },



  methods: {
    
    bookInList(id){
      this.bookFound = false;
      this.booksList.forEach(  entry => {
        if (entry.book_id === id){
          this.bookFound = true;
        }
      });
      return this.bookFound;
    },

    //check all books ahead of time
    toggleReadingList(book) {
      if(this.bookFound){
        BookService.deleteBookFromMyList(book).then((response) => {
              if (response.status === 200) {
                alert("Book removed from your reading list")
                this.$router.go();
              }
            })
      } else if (this.bookFound === false){
        BookService.addBookToMyList(book)
          .then((response) => {
            if (response.status === 201) {
              alert("Book added to your reading list")
              this.$router.go();
            }
          })
      }
      // if (this.a === true) {
      //   alert("Added to Your Reading List");
      //   BookService.addBookToMyList(this.book)
      //     .then((response) => {
      //       if (response.status === 201) {
      //         this.$router.push("/");
      //       }
      //     })
      //     .catch((error) => {
      //       console.error(error);
      //     });
      // } else {
      //   if (this.a === false) {
      //     alert("Removed From List");
      //     BookService.deleteBookFromMyList(this.book)
      //       .then((response) => {
      //         if (response.status === 201) {
      //           this.$router.push("/user/list");
      //         }
      //       })
      //       .catch((error) => {
      //         console.error(error);
      //       });
      //   }
      // }
    },

    deleteBookFromList() {},
    
    updateCurrentlyReading( book ) {
      BookService.updateCurrentlyReading( book )
        .then( ( response ) => {
          if( response.status !== 200 ) {
            console.log( "Error")
          }
          else {
            alert(`${book.title} added to currently reading`)
          }
        } )
    }
  },
};
</script>

<style>
.card {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 5px;
  margin: 5px;
  color: black;
  border-radius: 25px;
}

.cover-art {
  width: 250px;
  height: 350px;
}

.book-description {
  font-family: "Comfortaa", cursive;
}

.book-title {
  font-family: "Cinzel", serif;
}

.book-series {
  font-family: "Playfair Display SC", serif;
}

p.addingBook {
  border-radius: 25px;
  border: solid #c8a2c8 2px;
  padding-bottom: 2px;
}

.addToMyList {
  border-radius: 25px;
  border: solid #c8a2c8 2px;
  padding-bottom: 2px;
}

p.removingBook {
  border-radius: 25px;
  border: solid #c8a2c8 2px;
  padding-bottom: 2px;
  background-color: #C8A2C8;

}

button{
  border-radius: 25px;
  border: solid #c8a2c8 2px;
  padding-bottom: 2px;
}
</style>