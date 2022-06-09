
<template>
<div class="lists">
    <h1 class="Mary">What Are You Reading From Mary's Magnificent Library</h1>
    <h2>Currently Reading</h2>
    <currently-reading-list/>
    <h2>Reading List</h2>
    <reading-list/>
</div>
</template>

<script>
import CurrentlyReadingList from '../components/CurrentlyReadingList.vue'
import ReadingList from '../components/ReadingList.vue'


export default{
//  name: 'my-list',
 components: {
     CurrentlyReadingList,
     ReadingList,
     
 },
 created(){
   
 },


 
}


</script>
<style>

/* .lists{
display: flex;
flex-direction: row;

} */
</style>