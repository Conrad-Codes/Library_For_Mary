<template>
<!--THIS PORTION IS FOR WHEN YOU CLICK ON THE LINKS ON THE FORUM TOPIC  -->
  <div>
   <h1>Lets Chat!</h1>
    <table id="post-table">
      <!-- <div>  -->
      <thead>
        <tr>
          <th class="fieldId" v-for="field in fields" :key="field.id">
            {{ field }}
          </th>
        </tr>
      </thead>
      <!-- <div> -->
      <tbody>
       <!-- <div>  -->
       <!-- <div>  -->
        <tr class="forumPost" v-for="post in topicPosts" :key="post.post_id">
          <td class="postUserName">
            {{ post.username }}
          </td>
        <!-- </div> -->
        <!-- <div>   -->
          <td class="postPost">{{ post.post }}</td>
        <!-- </div> -->
        <!-- <div> -->
        <td class="postDateCreated">{{ post.postCreatedDate }}</td>
        <!-- </div> -->
        </tr>
       
       <!-- </div>  -->
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
.postUserName {
  font-family: "Playfair Display SC", serif;
}
</style>