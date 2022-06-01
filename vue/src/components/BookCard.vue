<template>
  <div class="card">
    <h2 class="book-title">{{ book.title }}</h2>
    <img class="cover-art" v-bind:src="book.cover_art" />
    <h3 class="book-author">{{ book.author_name.toString() }}</h3>
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
</style>