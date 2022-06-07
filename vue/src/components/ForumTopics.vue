<template>
  <div class="topics-list">

    <table id="topic-table">
      <thead>
        <tr>
          <th v-for="field in fields" :key="field.id">
            {{ field }}
          </th>
        </tr>
      </thead>
      <tbody>
          <tr v-for="topic in topics" :key="topic.topic_id">
              <td> 
                  <router-link v-bind:to="{name: 'topic-posts', params: {id: topic.topic_id}}">
                  {{topic.topic_name}}</router-link>
              </td>
              <td> {{topic.createdByUsername}}</td>
              <td> {{topic.topic_date}} </td>
          </tr>

      </tbody>
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
</style>