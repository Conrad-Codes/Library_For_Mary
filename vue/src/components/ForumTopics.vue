<template>
  <!-- THIS IS FOR WHEN YOU ARE VIEWING THE FORUM INITIAL TABLE -->
  <div class="topics-list">
    <button class="AddATopicButton"> <router-link  v-bind:to="{name: 'add-a-topic' }">Share Your Thoughts!</router-link>
    </button>
    <table class="topicTable" id="topic-table">
      <thead>
        <tr class="forumField">
          <th v-for="field in fields" :key="field.id">
            {{ field }}
          </th>
        </tr>
      </thead>
      <tbody>
          <tr v-for="topic in topics" :key="topic.topic_id">
              <td> 
                  <router-link class="forumTopicLink" v-bind:to="{name: 'topic-posts', params: {id: topic.topic_id}}">
                  {{topic.topic_name}}</router-link>
              </td>
              <td class="createdForumUserName"> {{topic.createdByUsername}}</td>
              <td class="mFPTopicDate"> {{topic.topic_date}} </td>
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
    }
  },

  created() {
    ForumService.getAllTopics().then((response) => {
      this.topics = response.data;
    });
  },
};
</script>

<style>
.mFPTopicDate{
  font-family: "Comfortaa", cursive;
 
}
.topicTable{
  text-align: center;
  
  
  /* font-family: "Playfair Display SC", serif; */
} 
 /* .forumField{
 
  
}  */
.createdForumUserName{
  
  font-family: "Comfortaa", cursive;
  
} 
.forumTopicLink{
  margin-right: 1rem;
   font-family: "Playfair Display SC", serif;

}
th{
 font-family: "Cinzel", serif; 

 
 text-align: center;
}
tr{
  text-align: center;
  justify-content: center;
}
.topicsList{
  text-align: center;
  justify-content: center;
  left: 50%;
  right: 50%;
  justify-content: space-evenly;
  
}
.AddATopicButton{
  text-align: center;
  font-size: 15px;
  
  margin-left: auto;
  justify-content: center;
  justify-items: center;
  
}
div.topicsList{
  justify-content: center;
}


</style>