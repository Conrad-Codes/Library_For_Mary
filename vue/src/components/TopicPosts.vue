<template>
<!--THIS PORTION IS FOR WHEN YOU CLICK ON THE LINKS ON THE FORUM TOPIC  -->
  <div>
    {{this.$route.params.id}}
    <table id="post-table">
      <thead>
        <tr>
          <th class="fieldId" v-for="field in fields" :key="field.id">
            {{ field }}
          </th>
        </tr>
      </thead>
      <tbody>
        <tr class="forumPost" v-for="post in topicPosts" :key="post.post_id">
          <td class="postUserName">
            {{ post.username }}
          </td>
          <td class="postPost">{{ post.post }}</td>
          <td class="postDateCreated">{{ post.postCreatedDate }}</td>
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
 
.postUserName{
  font-family: "Playfair Display SC", serif ;
}
</style>