<script setup>
import { RouterView } from 'vue-router' // RouterLink,
// import {ref} from 'vue';
import NavbarComponent from './components/NavbarComponent.vue';
</script>

<template>
  <div id="app" class="background-photo">
    <NavbarComponent />
    <RouterView />
  </div>
</template>

<style scoped>
.background-photo{
  background-image:url('./assets/dandelion-fondo.jpg');
  height: 100vh;
}
</style>
