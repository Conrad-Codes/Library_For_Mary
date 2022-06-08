
<template>
 <div class="main">
    <h1> Want To Expand The Library? </h1>
    <new-book-form/>
</div>
</template>

<script>
import NewBookForm from "../components/NewBookForm.vue";

export default {
    components: {
        NewBookForm,
    
    },

    
}

</script>

<style>
.main{
    grid-area: main;;
}

</style>