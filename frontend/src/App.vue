<template>
  <div id="app">
    <v-app-bar
        color="deep-purple"
        dark
    >
      <v-app-bar-nav-icon @click="drawer = true"></v-app-bar-nav-icon>

      <v-toolbar-title><div class="logo"><h3>E-moe</h3><svg version="1.0" xmlns="http://www.w3.org/2000/svg"
                                 width="371.000000pt" height="410.000000pt" viewBox="0 0 371.000000 392.000000"
                                 preserveAspectRatio="xMidYMid meet">

        <g transform="translate(0.000000,392.000000) scale(0.100000,-0.100000)"
           fill="#000000" stroke="none">
          <path d="M1281 3421 c-12 -12 -17 -28 -14 -39 8 -33 147 -187 171 -190 29 -4
52 14 52 40 0 22 -130 182 -161 198 -24 13 -26 13 -48 -9z"/>
          <path d="M1728 3432 c-23 -5 -32 -36 -17 -64 7 -13 42 -58 78 -100 52 -62 71
-78 93 -78 31 0 52 29 41 57 -11 30 -142 180 -161 185 -9 2 -25 2 -34 0z"/>
          <path d="M909 2903 c-12 -13 -14 -134 -17 -676 -2 -581 -1 -663 13 -683 l15
-24 674 0 c639 0 674 1 689 18 23 25 21 48 -5 66 -20 14 -99 16 -655 16 l-633
0 0 605 0 605 640 0 640 0 15 24 c13 19 14 29 5 45 -11 21 -14 21 -689 21
-619 0 -680 -1 -692 -17z"/>
          <path d="M1356 2464 c-20 -19 -21 -48 -3 -63 10 -8 201 -12 653 -13 l639 -3 3
-607 2 -608 -645 0 -645 0 -11 -24 c-8 -17 -8 -29 0 -45 l12 -21 673 0 c639 0
674 1 689 18 16 17 17 79 17 688 0 508 -3 673 -12 682 -9 9 -175 12 -684 12
-598 0 -674 -2 -688 -16z"/>
          <path d="M1356 2044 c-19 -18 -20 -28 -6 -55 10 -18 26 -19 470 -19 444 0 460
1 470 19 14 27 13 37 -6 55 -14 14 -70 16 -464 16 -394 0 -450 -2 -464 -16z"/>
          <path d="M1740 812 c-19 -6 -30 -22 -30 -44 0 -21 144 -194 167 -200 25 -7 42
1 53 23 14 25 3 46 -77 139 -65 76 -86 91 -113 82z"/>
          <path d="M2168 809 c-36 -21 -21 -60 59 -152 68 -80 79 -88 107 -85 28 3 31 6
31 35 0 47 -143 218 -178 213 -1 0 -10 -5 -19 -11z"/>
        </g>
      </svg></div></v-toolbar-title>
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
            <v-list-item-title> <router-link to="/users">Список пользователей</router-link></v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-home</v-icon>
            </v-list-item-icon>
            <v-list-item-title> <router-link to="/add">Создать публикацию</router-link></v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-account</v-icon>
            </v-list-item-icon>
            <v-list-item-title>  <router-link to="/register">Зарегистрироваться</router-link></v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-home</v-icon>
            </v-list-item-icon>
            <v-list-item-title> <router-link to="/publicationlist">Список публикаций</router-link></v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-home</v-icon>
            </v-list-item-icon>
            <v-list-item-title> <router-link to="/app"><div>На главную</div></router-link></v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>




<!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
<!--    <Publication msg="Welcome to Your Vue.js App"/>-->
    <router-view></router-view>
    <div class="mainpicture"><img src="./assets/e-moe213.png"></div>
  </div>

</template>

<script>
// import HelloWorld from './components/UsersList.vue'
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
div{

  text-decoration: none;
}
svg{
  width: 80px;
  height: 65px;
  padding: 0px;
  background-color:#a487a0;
margin-left: 20px;
  border: 1px solid #42b983;

  border-radius: 37px;
}
h3{
display: flex;
  align-items: center;
  justify-content: center;
}
.logo{
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
}
.mainpicture{
  background: #a487a0;
  margin: 0px;
}
img{
  margin: 0px;
height: 540px;
  width: 700px;
}

</style>
