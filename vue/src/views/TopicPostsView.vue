<template>
  <div id="posts-view">
      <TopicPosts/>
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

.posts-view{
    height: 100vh;
}

</style>