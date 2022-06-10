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
  <div class="ultraBanner">
  <div class="banner" id="secondImage">
    <h1 class="marysHeader">Mary's Magnificent Library</h1>
  </div>
  </div>     
    <div id="nav">
      <router-link class="homeButton" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;│&nbsp;
      <router-link class="Login" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link class="Logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;│&nbsp;
      <router-link class="ForumPage" v-bind:to="{name: 'all-topics'}">Forum</router-link>&nbsp;&nbsp;│&nbsp;
      <router-link class="myReadingList" v-bind:to="{name: 'my-list'}">My Reading List</router-link>&nbsp;│&nbsp;
      <router-link class="addABook" v-show="this.$store.state.user.username === 'admin'" v-bind:to="{name: 'add-book' }">Add a Book</router-link>
    
  </div>  
    <router-view />
  </div>
</template>

<script>

</script>

<style>                                                   
#app{
  background-color: #a4facf;
  min-height: 100vh;
  /* display: grid;
  grid-template-areas: 
    " nav . search"
    "main main main"
    "main main main" */
    min-height: 100vh;

}

#nav {
  grid-area: nav;
  display: flex;
  flex-direction: row;
  text-align: center;
  justify-content: center;
  /* width: 150px;
  height: 25vh; */
  /* border-right: blueviolet solid 2px;
  border-bottom: blueviolet solid 2px; */
  margin: 5px;
  align-items: flex-start;
  
  

  
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
.banner{
  background-image:
  url(https://www.clipartmax.com/png/full/19-199198_worm-clipart-transparent-worm-in-apple-clipart.png);
  background-size: contain;
  background-position:center left ;
  background-repeat:no-repeat;
  
  
  
  width: 100%;
  height: auto;
  margin-left: auto;
  margin-right: auto;
  
}
.ultraBanner{
  background-image:
  url(https://www.clipartmax.com/png/full/19-199198_worm-clipart-transparent-worm-in-apple-clipart.png);
  background-size: contain;
  background-position:center right ;
  background-repeat: no-repeat;
  
}


</style>