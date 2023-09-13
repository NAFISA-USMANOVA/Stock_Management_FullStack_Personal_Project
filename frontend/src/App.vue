<script setup>
import { RouterView } from 'vue-router' 
// import {ref} from 'vue';
import NavbarComponent from './components/NavbarComponent.vue';
</script>

<template>
  <div class="background">
  <!-- <div id="app" class="background-photo"> -->
    <NavbarComponent />
    <RouterView />
  </div>
</template>

<style scoped>
.background{
  background-color: rgb(214, 239, 204);
  border-spacing: 5px;
  width: auto;
  height:100vh;
}
/* .background-photo{
  background-image:url('./assets/dandelion-fondo.jpg');
  height: 100vh;
} */
</style>
