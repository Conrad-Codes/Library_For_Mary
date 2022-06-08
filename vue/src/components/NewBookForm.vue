<template>
  <form class="new-book-form" v-on:submit.prevent="saveBook">
    <div class="add-book-form">
      <legend>Add a Book:</legend>

      <label id="titleLabel" for="title">Title:</label>
      <div class="input autocomplete">
        <input
          class="title-input "
          type="text"
          placeholder="Title"
          v-model="book.title"
          @input="onChange"
        />
        <ul
          v-show= "isTitleOpen"
          class="autocomplete-results title-results">
          <li 
            v-for="(result, i) in titleResults"
            :key=i
            class="autocomplete-result title-result"
            >
            {{result}}
          </li>
        </ul>
      </div>

      <label for="author_name">Author:</label>
        <div v-for="(author,index) in book.author_name" v-bind:key="`author-${index}`" class="input">
        <input
          class="author_name-input"
          type="text"
          placeholder="Author"
          v-model="book.author_name[index]"
        />
        <svg
          @click="addAuthor()"
          xmlns="http://www.w3.org/2000/svg"
          viewBox="0 0 24 24"
          width="24"
          height="24"
          class="ml-2 cursor-pointer"
        >
          <path fill="none" d="M0 0h24v24H0z" />
          <path
            fill="green"
            d="M11 11V7h2v4h4v2h-4v4h-2v-4H7v-2h4zm1 11C6.477 22 2 17.523 2 12S6.477 2 12 2s10 4.477 10 10-4.477 10-10 10zm0-2a8 8 0 1 0 0-16 8 8 0 0 0 0 16z"
          />
        </svg>
      </div>

      <label for="series">Series:</label>
      <div class="input">
        <input
          class="series-input"
          type="text"
          placeholder="Series"
          v-model="book.series"
        /><br />
      </div>

      <label for="genre_name">Genre:</label>
      <div class="input">
        <input
          class="genre_name-input"
          type="text"
          placeholder="Genre"
          v-model="book.genre_name"
        /><br />
      </div>
      <label for="published_date">Date Published:</label>
      <div class="input">
        <input
          class="published_date-input"
          type="date"
          placeholder="YYYY-MM-DD"
          v-model="book.published_date"
        />
      </div>

      <label class="description">Description:</label>
      <div class="input">
        <textarea
          class="description-input"
          type="text"
          placeholder="Description"
          v-model="book.description"
        >
        </textarea>
      </div>
      <label class="cover_art">Cover Art:</label><br />
      <div class="input">
        <input
          class="cover_art-input"
          type="text"
          placeholder="CoverArt"
          v-model="book.cover_art"
        />
      </div>
      <br />
      <button>Submit</button>
    </div>
  </form>
</template>

<script>
import BookService from "../services/BookService.js";

export default {
  name: "new-book-form",

  data() {
    return {
      titleResults: [],
      titleItems: [],
      isTitleOpen: false,
      books: [],
      book: {
        title: "",
        author_name: [""],
        series: "",
        genre_name: "",
        published_date: "",
        description: "",
        cover_art: "",
      },
    };
  },
  methods: {
    filterTitleResults() {
      this.titleResults = this.titleItems.filter(item => item.toLowerCase().indexOf(this.book.title.toLowerCase()) > -1);
    },
    onTitleChange() {
      this.filterTitleResults();
      this.isTitleOpen = true;
    },

    addAuthor() {
        this.book.author_name.push("");
    },
    saveBook() {
      const input = document.querySelector(".description-input");
      if (input.value.length > 500){
        window.alert("Please limit description to 500 characters")
        return
      }
      BookService.createBook(this.book)
        .then((response) => {
          if (response.status === 201) {
            this.$router.push("/");
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },

  created() {
    BookService.getBooks().then((response) => {
      this.books = response.data;
    });

    this.books.forEach(item => this.titleItems.push(item.title));
  },
  
};
</script>

<style>
.autocomplete {
    position: relative;
  }

  .autocomplete-results {
    padding: 0;
    margin: 0;
    border: 1px solid #eeeeee;
    height: 120px;
    min-height: 1em;
    max-height: 6em;    
    overflow: auto;
  }

  .autocomplete-result {
    list-style: none;
    text-align: left;
    padding: 4px 2px;
    cursor: pointer;
  }

  .autocomplete-result:hover {
    background-color: #4AAE9B;
    color: white;
  }

label {
  font-size: 25px;
 
}

input, textarea{
  font-size: 25px;
   border-radius: 25px;
  border: solid #c8a2c8 2px
}

legend {
  font-size: 40px;
}

form {
  text-align: center;
  
}

/* .add-book-form{
  border-radius: 25px;
  border: solid #c8a2c8 2px
} */
</style>