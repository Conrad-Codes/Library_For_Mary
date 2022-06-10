<template>
  <!-- THIS IS FOR WHEN YOU ARE VIEWING THE FORUM INITIAL TABLE -->
  <div class="topics-list">
    <button class="AddATopicButton">
      <router-link class="AddATopicButton" v-bind:to="{ name: 'add-a-topic' }"
        >Share Your Thoughts!</router-link
      >
    </button>
    <table class="topicTable" id="topic-table">
      <tr class="table_headers">
        <td>Topics</td>
        <td>Created By</td>
        <td>Date Created</td>
      </tr>

      <tr v-for="topic in topics" :key="topic.topic_id">
        <td class="topic_cell">
          <router-link
            class="forumTopicLink"
            v-bind:to="{ name: 'topic-posts', params: { id: topic.topic_id } }"
          >
            {{ topic.topic_name }}</router-link
          >
        </td>
        <td class="createdForumUserName">{{ topic.createdByUsername }}</td>
        <td class="mFPTopicDate">{{ topic.topic_date }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import ForumService from "../services/ForumService.js";

export default {
  name: "topic-list",
  data() {
    return {
      topics: [],
      fields: ["Topic", "Created By", "Date Created"],
    };
  },

  created() {
    ForumService.getAllTopics().then((response) => {
      this.topics = response.data;
    });
  },
};
</script>

<style>
.topicTable {
  text-align: center;
}
.allThree {
  grid-template-columns: auto auto auto;
  grid-template-rows: auto auto auto;
  grid-template-areas:
    "forumTopicTitle createdByTitle dateCreatedTitle"
    "forumTopicLink forumCreatedBy forumDateCreated";
}

td {
  width: 800px;
}
tr {
  font-family: "Comfortaa", cursive;
  font-size: 20px;
}

.topic_cell {
  text-align: left center;
}

.table_headers {
  text-decoration: underline;
  font-weight: bold;
  font-family: "Playfair Display SC", serif;
  font-size: 25px;
}

*/ .AddATopicButton {
  font-size: 15px;

}
button.AddATopicButton{
  position: relative;
    margin: 0;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
</style>

   