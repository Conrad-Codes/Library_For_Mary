<template>
  <div id="login" class="text-center">
    <h1 class="Mary">Login To Mary's Magnificent Library</h1>
    <form class="form-signin" @submit.prevent="login">
      <br>
      <router-link :to="{ name: 'register' }">Want more access? Create an account!</router-link>
      <h1 class="h3 mb-3 font-weight-normal">Have an account? Please sign in here:</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only1">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only2">   Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      
      <button type="submit">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import BookService from '../services/BookService';

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            BookService.viewSavedList().then( response => {
              this.$store.commit("SET_USER_LIST", response.data)
            });
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style>
.text-center {
font-size: 50px;
}
.sr-only1 {
  ;
}

</style>


