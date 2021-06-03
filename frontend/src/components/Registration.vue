<template>
  <v-form

      ref="form"
      v-model="valid"
      lazy-validation
  >
    <v-text-field
        v-model="name"
        :counter="10"
        :rules="nameRules"
        label="Name"
        required
    ></v-text-field>

    <v-text-field
        v-model="surname"
        :rules="surnameRules"
        label="surname"
        required
    ></v-text-field>
    <v-text-field
        v-model="login"
        :rules="loginRules"
        label="login"
        required
    ></v-text-field>
    <v-text-field
        v-model="password"
        :rules="passwordRules"
        label="password"
        required
    ></v-text-field>
    <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="validate"
        v-on:click="addUser()"
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
    name: '',
    nameRules: [
      v => !!v || 'Name is required',
      v => (v && v.length <= 10) || 'Name must be less than 10 characters',
    ],
    surname: '',
    surnameRules: [
      v => !!v || 'Surname is required',
      v => (v && v.length <= 10) || 'Surname must be less than 10 characters',
    ],
    login: '',
    loginRules: [
      v => !!v || 'Login is required',
      v => (v && v.length <= 10) || 'login must be less than 10 characters',
    ],
    password: '',
    passwordRules: [
      v => !!v || 'password is required',
      v => (v && v.length <= 10) || 'password must be less than 10 characters',
    ],
    checkbox: false,
  }),
  name:"register",
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
    },
    mounted() {
      axios.get("http://localhost:8090/users/all").then(response => {
        console.log(response)
        this.users = response.data
      })
    }
}
</script>

<style scoped>

</style>