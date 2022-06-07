<template>
  <div>
    <table id="post-table">
      <thead>
        <tr>
          <th v-for="field in fields" :key="field.id">
            {{ field }}
          </th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="post in topicPosts" :key="post.post_id">
          <td>
            {{ post.username }}
          </td>
          <td>{{ post.post }}</td>
          <td>{{ post.postCreatedDate }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ForumService from "../services/ForumService.js";

export default {
  name: "topic-posts",

  data() {
    return {
      topicPosts: [],
      fields: ["User", "Post", "Date Created"],
    };
  },

  created() {
    ForumService.getPostsByTopicId(this.$route.params.id).then((response) => {
      this.topicPosts = response.data;
    });
  },
};
</script>

<style>
</style>