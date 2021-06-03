<template>
  <div class="form-users">
    <!--    <li v-bind:key="publication.idpublication" v-for="publication in publications">-->
    <!--      <input type="checkbox" :value="publication" v-model="selected"><h5>{{ publication.heading }} {{ publication.text }} {{ publication.image }}</h5><button v-on:click="deletebyidpublication(publication.idpublication)">Удалить</button>-->
    <v-card v-bind:key="publication.idpublication" v-for="publication in publications"
            class="mx-auto"
            max-width="100%"
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
            v-on:click="deletebyidpublication(publication.idpublication)">Удалить
        </v-btn>
      </v-card-actions>
    </v-card>
    <!--    </li>-->
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
  name:"PublicationList",
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

</style>