
<template>
 <div class="main">
    <h1 class="Mary">Add To Mary's Magnificent Library</h1>
    <h2> Want To Expand The Library? </h2>
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
h2{
    text-align: center;
}

</style>