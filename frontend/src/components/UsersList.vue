<template>
<!--  <div class="form">
    <div class="form-users">
        <li v-bind:key="user.iduser" v-for="user in users">
      <input type="checkbox" :value="user" v-model="selected"><h5> {{ user.name }} {{ user.surname }}</h5><button v-on:click="deletebyiduser(user.iduser)">Удалить</button>
       </li>
    </div>
  </div>-->
  <div><v-card v-bind:key="user.iduser" v-for="user in users"
      class="mx-auto"
      max-width="100%"
      tile
  >
    <v-list-item>
      <v-list-item-content>
        <v-list-item-title>{{ user.name }} {{ user.surname }}
          <v-btn
            :loading="loading"
            class="ma-1"
            color="error"
            plain
            @click="remove"
            v-on:click="deletebyiduser(user.iduser)">Удалить
        </v-btn></v-list-item-title>
      </v-list-item-content>
    </v-list-item>
  </v-card>
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
        localStorage.setItem('user',JSON.stringify(response.data))
        axios.get("http://localhost:8090/users/all").then(response => {
          console.log(response)
          this.users = response.data
        })}
      )
    },
    async remove () {
      this.loading = true

      await new Promise(resolve => setTimeout(resolve, 100))

      this.loading = false
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
template{

/*}
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: flex;
  flex-direction: row;
  margin: 0 10px;
  width: 200px;
  height: 30px;
  border: 1px solid #42b983;
  border-radius: 37px;
  background: aqua;

}
a {
  color: #42b983;
}
button{
  padding: 5px;
  display: flex;
  align-items: center;
  border: 1px solid #42b983;
  background: transparent;
  border-radius: 37px;
}
 input {
   border: 1px solid #42b983;
   background: transparent;
   border-radius: 37px;


}
h5{
  display: flex;
  justify-content: center;
  font-size: 10px;
  align-items: center;
  width: 70px;
}
.form{
  display: flex;
  flex-direction: row;
  margin: 0px;
  padding: 0px;
  height: 100%;
  width: 100%;
}
.form-users{
  width:100%;

}
.form-registration{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 1px solid #42b983;
  background: transparent;
  border-radius: 37px;
}
h2{
  font-size: 10px;
  margin: 5px;
}*/

}
button {


}
</style>
