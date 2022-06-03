<template>
<div>
    <reading-list/>
  <router-link v-bind:to="{name: 'add-book', params: {id: bookID}}">
  </router-link>
</div>

<!-- do we need this?? -->

</template>

<script>
import ReadingList from "../components/ReadingList.vue";

export default {
  name: "my-books",
  components: {ReadingList},
  
    
}


</script>