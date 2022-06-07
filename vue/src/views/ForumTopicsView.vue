<template>
  <div>
    <h1>Welcome to the Forum!</h1>
    <router-link class="AddATopicButton" v-bind:to="{name: 'add-a-topic' }">Share Your Thoughts!</router-link>
    <ForumTopics/>
  </div>
</template>

<script>
import ForumTopics from "../components/ForumTopics.vue";


export default {
  components: {
    ForumTopics,
   
  },
  data(){
    
  },

  methods:{
    
  },

  created(){

  }
};
</script>

<style>

</style>