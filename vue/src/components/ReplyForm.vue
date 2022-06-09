<template>
<!-- THIS IS WHERE YOU REPLY TO A TOPIC -->
  <div class="ReplyForm" v-on:submit.prevent="saveReply">
    <form>
      <label for="reply">Reply</label>
      <div class="input">
        <textarea
          class="reply-input"
          type="text"
          placeholder="Reply"
          v-model="reply.post"
        />
      </div>
      <button>Submit</button>
    </form>
  </div>
</template>
<script>
import ForumService from "../services/ForumService.js";
export default {
  data() {
    return {
      reply: {
        post: "",
        topic_id: "",
      },
    };
  },
  methods: {
    saveReply() {
      const input = document.querySelector(".reply-input");
      if (input.value.length > 500) {
        window.alert("Please limit reply to 500 characters");
        return;
      }
      ForumService.createReply(this.reply)
        .then((response) => {
          if (response.status === 201) {
            this.$router.go();
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
    created(){
        this.reply.topic_id = (this.$route.params.id)
    },
};
</script>

<style>
#reply-form{
  height: 100vh;
}

</style>
