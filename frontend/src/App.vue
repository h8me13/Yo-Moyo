<template>
  <div id="app">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <Publication msg="Welcome to Your Vue.js App"/>
  </div>

</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import Publication from './components/Publication.vue'
export default {
  name: 'App',
  components: {

    Publication,
    HelloWorld
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
