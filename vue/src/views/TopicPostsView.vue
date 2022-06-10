<template>
  <div>
      <TopicPosts/>
      <br/>
      <ReplyForm />
      </div>
</template>

<script>
import TopicPosts from "../components/TopicPosts.vue"
import ReplyForm from "../components/ReplyForm.vue"


export default {
    components: {
        TopicPosts,
        ReplyForm
    }

}
</script>

<style>

</style>