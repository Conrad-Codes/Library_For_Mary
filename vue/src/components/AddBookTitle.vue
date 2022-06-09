     <template>
  <div>
      {{this.newTitle}}
    <label id="titleLabel" for="title">Title:</label>
    <div class="input autocomplete">
      <input
        class="title-input"
        type="text"
        placeholder="Title"
        v-model="newTitle"
        @input="onTitleChange"
      />
      <ul v-show="isTitleOpen" class="autocomplete-results title-results">
        <li
          v-for="(result, i) in titleResults"
          :key="i"
          class="autocomplete-result title-result"
          @click="setTitleResult(result)"
        >
          {{ result }}
        </li>
      </ul>
    </div>
  </div>
</template>
          
     <script>
// import BookService from "../services/BookService.js";

export default {
  name: "titleInput",
  props: {
    items: {
      type: Array,
      required: false,
      default: () => [],
    },
    title: {
        type: String,
        default: () => ""}
  },

  data() {
    return {
      titleResults: [],
      titleItems: [],
      isTitleOpen: false,
      books: [],
      newTitle: ""
    };
  },
  methods: {
    handleClickOutside(event) {
      if (!this.$el.contains(event.target)) {
        this.isTitleOpen = false;
        this.$emit(this.newTitle)
      }
    },

    setTitleResult(result) {
      this.newTitle = result;
      this.isTitleOpen = false;
    },

    filterTitleResults() {
      this.titleResults = this.items.filter(item => item.toLowerCase().indexOf(this.newTitle.toLowerCase()) > -1);
    },

    onTitleChange() {
      this.filterTitleResults();
      this.isTitleOpen = true;
    },

//     addAuthor() {
//         this.book.author_name.push("");
//     },
//     saveBook() {
//       const input = document.querySelector(".description-input");
//       if (input.value.length > 500){
//         window.alert("Please limit description to 500 characters")
//         return
//       }
//       BookService.createBook(this.book)
//         .then((response) => {
//           if (response.status === 201) {
//             this.$router.push("/");
//           }
//         })
//         .catch((error) => {
//           console.error(error);
//         });
//     },
//   },

//   created() {
//     BookService.getBooks().then((response) => {
//       this.books = response.data;

//       this.books.forEach(item => { 
//       this.titleItems.push(item.title)}
//       );
      
//     });
//     // window.alert(this.books);
//     // for (let i=0; i<this.books.length; i++){
//     //   window.alert("hi");
//     //   this.titleItems.push(this.book[i].title);
//     // }
//     // this.books.forEach(item => { 
//     //   window.alert(item);
//     //   this.titleItems.push(item.title)}
//     //   );
//     // window.alert("last step");
  },

  mounted() {
    document.addEventListener('click', this.handleClickOutside);
  },
  destroyed() {
    document.removeEventListener('click', this.handleClickOutside);
  }
  
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