<template>
  <div class="form">
    <div class="form-users">
<!--    <li v-bind:key="publication.idpublication" v-for="publication in publications">-->
<!--      <input type="checkbox" :value="publication" v-model="selected"><h5>{{ publication.heading }} {{ publication.text }} {{ publication.image }}</h5><button v-on:click="deletebyidpublication(publication.idpublication)">Удалить</button>-->
      <v-card v-bind:key="publication.idpublication" v-for="publication in publications"
          class="mx-auto"
          max-width="344"
          outlined
      >
        <v-list-item three-line>
          <v-list-item-content>
            <div class="text-overline mb-4">
              {{ publication.heading }}
            </div>
            <v-list-item-subtitle>{{ publication.text }}</v-list-item-subtitle>
          </v-list-item-content>

          <v-list-item-avatar
              tile
              size="80"
              color="grey"
          ></v-list-item-avatar>
        </v-list-item>

        <v-card-actions>
          <v-btn
              outlined
              rounded
              text
          >
            Button
          </v-btn>
        </v-card-actions>
      </v-card>
<!--    </li>-->
    </div>
    <div class="form-validation">
      <h2>Создать пост</h2>
    {{heading}}
    <label>Заголовок</label>
    <input v-model="heading">
    {{text}}
    <label>Текст</label>
    <input v-model="text">
    {{image}}
    <label>Картинка</label>
    <input v-model="image">
    <button v-on:click="addPublication()">Опубликовать</button>
  </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      publications :[],
      selected: [],
      heading : '',
      text:'',
      image : ''
    }
  },
  name:"Publication",
  methods : {
    deletebyidpublication(id) {
      axios.delete("http://localhost:8090/Publications/deletebyid?idpublication=" + id, {
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      }).then(response => {
        console.log(response)

        axios.get("http://localhost:8090/Publications/all").then(response => {
          console.log(response)
          this.publications = response.data
        })}
      )
    },


    /*   /!* deleteSelectedUsers() {
          axios.delete("http://localhost:8080/users/deletebyid",{headers : {
              'Accept' : 'application/json',
              'Content-Type' : 'application/json'
            },data:this.selected})*!/
        },*/
    addPublication() {
      axios.post("http://localhost:8090/Publications/new",{heading : this.heading, text : this.text ,image : this.image, creater: {idcreater: 1}, category: {idcategory: 1}}).then(response => {
        console.log(response)
        axios.get("http://localhost:8090/Publications/all").then(response => {
          console.log(response)
          this.publications = response.data
        })}
      )
    },
  },
  mounted() {
    axios.get("http://localhost:8090/Publications/all").then(response => {
      console.log(response)
      this.publications = response.data
    })
  }
}

</script>

<style scoped>
/*template{*/

/*}*/
/*h3 {*/
/*  margin: 40px 0 0;*/
/*}*/
/*ul {*/
/*  list-style-type: none;*/
/*  padding: 0;*/
/*}*/
/*li {*/
/*  display: flex;*/
/*  flex-direction: row;*/
/*  margin: 0 10px;*/
/*  width: 200px;*/
/*  height: 30px;*/
/*  border: 1px solid #42b983;*/
/*  border-radius: 37px;*/
/*  background: aqua;*/

/*}*/
/*a {*/
/*  color: #42b983;*/
/*}*/
/*button{*/
/*  padding: 5px;*/
/*  display: flex;*/
/*  align-items: center;*/
/*  border: 1px solid #42b983;*/
/*  background: transparent;*/
/*  border-radius: 37px;*/
/*}*/
/*input {*/
/*  border: 1px solid #42b983;*/
/*  background: transparent;*/
/*  border-radius: 37px;*/


/*}*/
/*h5{*/
/*  display: flex;*/
/*  justify-content: center;*/
/*  font-size: 10px;*/
/*  align-items: center;*/
/*  width: 70px;*/
/*}*/
/*.form{*/
/*  display: flex;*/
/*  flex-direction: row;*/

/*  width: 100%;*/
/*}*/
/*.form-users{*/
/*  width:100%;*/

/*}*/
/*.form-validation{*/
/*  display: flex;*/
/*  flex-direction: column;*/
/*  justify-content: center;*/
/*  align-items: center;*/
/*  border: 1px solid #42b983;*/
/*  background: transparent;*/
/*  border-radius: 37px;*/
/*}*/
/*h2{*/
/*  font-size: 10px;*/
/*  margin: 5px;*/
/*}*/
</style>
