<template>
  <div id="app">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Comfortaa&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@500&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display+SC&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gloria+Hallelujah&display=swap" rel="stylesheet">   
    <div id="nav">
      <router-link class="homeButton" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link class="addABook" v-bind:to="{name: 'add-book' }">Add a Book</router-link>&nbsp;|&nbsp;
      <router-link class="myReadingList" v-bind:to="{name: 'my-list'}">My Reading List</router-link>&nbsp;|&nbsp;
      <router-link class="ForumPage" v-bind:to="{name: 'all-forums'}">Forum</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>

</script>

<style>                                                   
#app{
  background-color: #93E9BE;
}

.homeButton{
  font-size: 22px;
  color: black;
  font-family: 'Comfortaa', cursive;
}
.logOut{
  font-size: 22px;
  color: black;
  font-family: 'Comfortaa', cursive;
}
.addABook{
  font-size: 22px;
  color: black;
  font-family: 'Comfortaa', cursive;
}
.myReadingList{
  font-size: 22px;
  color: black;
  font-family: 'Comfortaa', cursive;
}


</style>