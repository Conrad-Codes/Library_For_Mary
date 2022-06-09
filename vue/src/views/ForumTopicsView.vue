<template>
  <!-- THIS IS THE FORUM PAGE TAB -->
  <div>
    <h1 class="Mary">Mary's Fictitious Forum</h1>
    <h2>Welcome to the Forum!</h2>
    <ForumTopics />
  </div>
</template>

<script>
import ForumTopics from "../components/ForumTopics.vue";


export default {
  components: {
    ForumTopics,
   
  },

  methods:{
    
  },

  created(){

  }
};
</script>

<style>

</style>