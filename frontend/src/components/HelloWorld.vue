<template>
  <div >
    <li v-bind:key="user.iduser" v-for="user in users">
      <input type="checkbox" :value="user" v-model="selected">- {{ user.name }} {{ user.surname }}<button v-on:click="deletebyiduser(user.iduser)">Х</button>
    </li>
    {{name}}
    <label>Имя</label>
    <input v-model="name">
    {{surname}}
    <label>Фамилия</label>
    <input v-model="surname">
    {{login}}
    <label>Логин</label>
    <input v-model="login">
    {{password}}
    <label>Пароль</label>
    <input v-model="password">
    <button v-on:click="addUser()">Добавить</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      users :[],
      selected: [],
      name : '',
      surname:'',
      login : '',
      password : ''
    }
  },
  name:"main",
  methods : {
    deletebyiduser(id) {
      axios.delete("http://localhost:8090/users/deletebyid?iduser=" + id, {
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      }).then(response => {
        console.log(response)

          axios.get("http://localhost:8090/users/all").then(response => {
            console.log(response)
            this.users = response.data
          })}
      )
    },


/*   /!* deleteSelectedUsers() {
      axios.delete("http://localhost:8080/users/deletebyid",{headers : {
          'Accept' : 'application/json',
          'Content-Type' : 'application/json'
        },data:this.selected})*!/
    },*/
    addUser() {
      axios.post("http://localhost:8090/users/new",{name : this.name, surname : this.surname ,login : this.login,password : this.password}).then(response => {
        console.log(response)
        axios.get("http://localhost:8090/users/all").then(response => {
          console.log(response)
          this.users = response.data
        })}
      )
    },
  },
  mounted() {
    axios.get("http://localhost:8090/users/all").then(response => {
      console.log(response)
      this.users = response.data
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
button{
padding: 5px;
}
</style>
