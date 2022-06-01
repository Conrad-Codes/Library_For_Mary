<template>
  <div class= "card">
<h2 class= "book-title">{{book.title}} </h2>
<!-- <img v-bind: src= {{book.cover_art}} -->
<h3 class = "book-author"> {{book.author}} </h3>
      </div>
</template>

<script>
export default {
    name: 'book-card',
    props: {
        book: Object
    }
}
</script>

<style>

</style>