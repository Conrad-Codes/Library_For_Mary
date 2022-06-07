<template>
  <form class="add-a-topic">
    <div>
      <legend>Create a Post</legend>
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
        <input
          class="post-input"
          type="text"
          placeholder="Post"
          v-model="topic.initial_post"
        />
      </div>
      <br />
      <button>Submit</button>
    </div>
  </form>
</template>

<script>
export default {
  data() {
    return {
      topic: {
        topic_name: "",
        initial_post: "",
      },
    };
  },
};
</script>
