<template>
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
<<<<<<< HEAD

<script>
import ForumService from "../services/ForumService.js";

=======
<script>
import ForumService from "../services/ForumService.js";
>>>>>>> main
export default {
  data() {
    return {
      reply: {
        post: "",
        topic_id: "",
      },
    };
  },
<<<<<<< HEAD

=======
>>>>>>> main
  methods: {
    saveReply() {
      const input = document.querySelector(".reply-input");
      if (input.value.length > 500) {
<<<<<<< HEAD
        window.alert("Please limit description to 500 characters");
=======
        window.alert("Please limit reply to 500 characters");
>>>>>>> main
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
<<<<<<< HEAD

    // created(){
    //     this.reply.topic_id = (this.$route.params.id)
    // },
};
</script>
=======
    created(){
        this.reply.topic_id = (this.$route.params.id)
    },
};
</script>

<style>

</style>
>>>>>>> main
