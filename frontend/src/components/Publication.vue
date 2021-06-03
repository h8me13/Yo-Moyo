<template>
<!--  <div class="form">

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
  </div>-->
  <v-form

      ref="form"
      v-model="valid"
      lazy-validation
  >
    <v-text-field
        v-model="heading"
        :counter="10"
        :rules="headingRules"
        label="heading"
        required
    ></v-text-field>

    <v-text-field
        v-model="text"
        :rules="textRules"
        label="text"
        required
    ></v-text-field>
    <v-text-field
        v-model="image"
        :rules="imageRules"
        label="image"
        required
    ></v-text-field>
    <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="validate"
        v-on:click="addPublication()"
    >
      Validate
    </v-btn>

    <v-btn
        color="error"
        class="mr-4"
        @click="reset"
    >
      Reset Form
    </v-btn>

    <v-btn
        color="warning"
        @click="resetValidation"
    >
      Reset Validation
    </v-btn>
  </v-form>
</template>

<script>
import axios from "axios";

export default {
  data: () => ({
    valid: true,
    text: '',
    textRules: [
      v => !!v || 'text is required',
      v => (v && v.length > 10) || 'text must be more than 10 characters',
    ],
    checkbox: false,
  }),
  name:"Publication",
  methods: {
    validate () {
      this.$refs.form.validate()
    },
    reset () {
      this.$refs.form.reset()
    },
    resetValidation () {
      this.$refs.form.resetValidation()
    },
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
