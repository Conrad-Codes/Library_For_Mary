
<template>
<div>
    <h1>Currently Reading</h1>
    <currently-reading-list/>
    <h1>Reading List</h1>
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
   
 }


 
}
</script>