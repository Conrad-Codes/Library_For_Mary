<template>
  <!-- THIS IS THE FORUM PAGE TAB -->
  <div>
    <h1>Welcome to the Forum!</h1>
    <ForumTopics />
  </div>
</template>

<script>
import ForumTopics from "../components/ForumTopics.vue";

export default {
  components: {
    ForumTopics,
  },

  methods: {},

  created() {},
};
</script>

<style>
div.header {
  grid-area: header;
}
div.main {
  grid-area: main;
}
</style>