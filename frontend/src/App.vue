<template>
  <div id="app">
    <v-app-bar
        color="deep-purple"
        dark
    >
      <v-app-bar-nav-icon @click="drawer = true"></v-app-bar-nav-icon>

      <v-toolbar-title>Title</v-toolbar-title>
    </v-app-bar>

    <v-navigation-drawer
        v-model="drawer"
        absolute
        temporary
    >
      <v-list
          nav
          dense
      >
        <v-list-item-group
            v-model="group"
            active-class="deep-purple--text text--accent-4"
        >
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-home</v-icon>
            </v-list-item-icon>
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-account</v-icon>
            </v-list-item-icon>
            <v-list-item-title>  <router-link to="/register">Зарегистрироваться</router-link></v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
    <v-btn
        elevation="2"
    ></v-btn>
    <router-link to="/add">Создать публикацию</router-link>
    <router-link to="/users">Список пользователей</router-link>

<!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
<!--    <Publication msg="Welcome to Your Vue.js App"/>-->
    <router-view></router-view>
  </div>

</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
// import Publication from './components/Publication.vue'
export default {
  name: 'App',
  components: {

    // Publication,
    // HelloWorld
  },
  data: () => ({
    drawer: false,
    group: null,
  }),
  mounted() {
    JSON.parse(localStorage.getItem('user'));

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}
</style>
