<template>
  <div class="card">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class ="series-name"> {{book.series}}</h3>
    <img class="cover-art" v-bind:src="book.cover_art" />
    <h3 class="book-author">{{ book.author_name.toString() }}</h3>
    <p class="book-description">{{book.description}}</p>
  </div>
</template>

<script>
export default {
  name: "book-card",
  props: {
    book: Object,
  },
  methods: {},
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


</style>