<template>
  <div class="card">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="series-name">{{ book.series }}</h3>
    <img class="cover-art" v-bind:src="book.cover_art" />
    <h3 class="book-author">{{ book.author_name.toString() }}</h3>
    <p class="book-description">{{ book.description }}</p>
    <div>
      <button
        class="toggleButton"
        @click="toggleReadingList(book)"
        v-show="isLoggedIn"
      >
        {{
          bookInReadingList(book.book_id) === false
            ? "Add To List"
            : "Remove From List"
        }}
        <!-- <p class="addingBook" v-show="a">Add To Reading List</p>
      <p class="removingBook" v-show="!a">Remove From Reading List</p> -->
      </button>

      <button
        class="toggleButton"
        @click="toggleCurrentlyReading(book)"
        v-show="isLoggedIn && bookInReadingList(book.book_id)"
      >
        {{
          bookInCurrentReadingList(book.book_id) === false
            ? "Add to Currently Reading"
            : "Remove From Currently Reading"
        }}
      </button>
    </div>
  </div>
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
      currentReadingList: [],
      isReadingBook: false
      // a: true
    };
  },
  created() {
    if (this.$store.state.token != "") {
      BookService.viewSavedList().then((response) => {
        this.booksList = response.data;
      });

      BookService.viewCurrentlyReadingBooks().then((response) => {
          this.currentReadingList = response.data;
      });
    }
  },

  computed: {
    isLoggedIn() {
      return this.$store.state.token != "";
    },
  },

  methods: {
    bookInReadingList(id) {
      this.bookFound = false;
      this.booksList.forEach((entry) => {
        if (entry.book_id === id) {
          this.bookFound = true;
        }
      });
      return this.bookFound;
    },

    bookInCurrentReadingList(id) {
      this.isReadingBook = false;
      this.currentReadingList.forEach((entry) => {
        if (entry.book_id === id) {
          this.isReadingBook = true;
        }
      });
      return this.isReadingBook;
    },

    //check all books ahead of time
    toggleReadingList(book) {
      if (this.bookFound) {
        BookService.deleteBookFromMyList(book).then((response) => {
          if (response.status === 200) {
            alert(`${book.title} removed from your reading list`);
            this.$router.go();
          }
        });
      } else if (this.bookFound === false) {
        BookService.addBookToMyList(book).then((response) => {
          if (response.status === 201) {
            alert(`${book.title} added to your reading list`);
            this.$router.go();
          }
        });
      }
    },

    toggleCurrentlyReading(book) {
      BookService.toggleCurrentlyReading(book).then((response) => {
        if (response.status !== 200) {
          console.log("Error");
        } else {
          this.isReadingBook = !this.isReadingBook;
          if (this.isReadingBook){
            alert(`${book.title} added to currently reading list`);
          this.$router.go();
          }else {
          alert(`${book.title} removed from currently reading list`);
          this.$router.go();
        }
        }
      });
    },
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
  font-size: 15px;
}

.cover-art {
  width: 225px;
  height: 325px;
}

.book-description {
  font-family: "Comfortaa", cursive;
  font-size: 15PX;
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
}

.toggleButton {
  margin: 3px;
}

button{
  border-radius: 25px;
  border: solid #c8a2c8 2px;
  padding-bottom: 2px;
}
</style>