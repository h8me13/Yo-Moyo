import Vue from 'vue'
import App from './App.vue'
import VueRouter from "vue-router";
import Publication from "./components/Publication";
import HelloWorld from "./components/UsersList";
import vuetify from '@/plugins/vuetify'
import Registration from "./components/Registration";
import PublicationsList from "./components/PublicationsList";



Vue.use(VueRouter)
const routes = [
  {
    path: '/add',
    component: Publication,
  },
  {
    path:'/users',
    component: HelloWorld
  },
  {
    path:'/register',
    component: Registration
  },
  {
    path:'/PublicationList',
    component: PublicationsList
  }
];

const router = new VueRouter({
  routes,
  mode: "history",
});

Vue.config.productionTip = false

new Vue({router, vuetify,
  render: h => h(App),
}).$mount('#app')
