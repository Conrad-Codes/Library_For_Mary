<template>
 <!-- THIS IS WHERE YOU POST A NEW TOPIC -->
  <form class="add-a-topic" v-on:submit.prevent="addTopic">
    <div>
      <br/>
      <legend>Whats On Your Mind?</legend>
      <br/>
      <label id="forumTitle">Title:</label>
      <div class="TitleInput">
        <input
          class="title-input"
          type="text"
          placeholder="Title"
          v-model="topic.topic_name"
        />
      </div>
      <br />
      <label id="forumPost">Post:</label>
      <div class="PostInput">
        <textarea
          class="post-input"
          type="text"
          placeholder="Post"
          v-model="topic.initial_post"
        >
        </textarea>
      </div>
      <button>Submit</button>
      <br/>
      <br/>
    </div>
  </form>
</template>

<script>
import ForumService from "../services/ForumService.js"

export default {
  name: "new-topic-form",

  data() {
    return {
      topic: {
        topic_name: "",
        initial_post: "",
      },
    };
  },

  methods: {
    addTopic() {
      ForumService.createTopic(this.topic).then(
        response => {
          if (response.status === 201){
            this.$router.push("/forum");
          }else {
            alert(response.status);
          }
        }
      )
    }
  }
};
</script>

<style>

</style>
