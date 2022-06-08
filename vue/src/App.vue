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
      <router-link class="homeButton" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="Login" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link class="Logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link class="addABook" v-bind:to="{name: 'add-book' }">Add a Book</router-link>
      <router-link class="myReadingList" v-bind:to="{name: 'my-list'}">My Reading List</router-link>
      <router-link class="ForumPage" v-bind:to="{name: 'all-topics'}">Forum</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>

</script>

<style>                                                   
#app{
  background-color: #a4facf;
  display: grid;
  grid-template-areas: 
    " nav . search"
    "main main main"
    "main main main"

}

#nav {
  grid-area: nav;
  display: flex;
  flex-direction: column;
  width: 150px;
  height: 25vh;
  border-right: blueviolet solid 2px;
  border-bottom: blueviolet solid 2px;
  margin: 5px;
  align-items: flex-start;
  justify-content: space-evenly;

  
}

.homeButton{
  font-size: 22px;
  color: black;
  font-family: 'Comfortaa', cursive;
}
.Logout{
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
.ForumPage{
  font-size: 22px;
  color: black;
  font-family: 'Comfortaa', cursive;
}
.Login{
  font-size: 22px;
  color: black;
  font-family: 'Comfortaa', cursive;
}


</style>