<template>
  <!--THIS PORTION IS FOR WHEN YOU CLICK ON THE LINKS ON THE FORUM TOPIC  -->
  <div>
    <h1>Lets Chat!</h1>
    <h2>{{this.topic_name}}</h2>
    <table id="post-table">
      <tr class="forumHeaders">
        <td>User</td>
        <td>Post</td>
        <td>Date Created</td>
      </tr>
      <tr class="forumPost" v-for="post in topicPosts" :key="post.post_id">
        <td class="postUserName">
          {{ post.username }}
        </td>
        <td class="postPost">{{ post.post }}</td>
        <td class="postDateCreated">{{ post.postCreatedDate }}</td>
      </tr>
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
      topic_name: ""
    };
  },

  created() {
    ForumService.getPostsByTopicId(this.$route.params.id).then((response) => {
      this.topicPosts = response.data;
    });

    ForumService.getTopicName(this.$route.params.id).then((response) => {
      this.topic_name = response.data.topic_name;
    })
  },
};
</script>

<style>

.forumHeaders{
  text-decoration: underline;
  font-weight: bold;
  font-family: "Playfair Display SC", serif;
  font-size: 25px;
}
td {
  width:800px;
  text-align: center;
  
}
.forumPost{
  font-family: "Comfortaa", cursive;
}
</style>
