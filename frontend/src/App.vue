<script setup>
import { RouterView } from 'vue-router' 
import NavbarComponent from './components/NavbarComponent.vue';
</script>

<template>
  <div class="background">
    <NavbarComponent />
    <h1>Stock control</h1>
    <RouterView />
  </div>
</template>

<style scoped>
.background{
  background-color: rgba(31, 128, 141, 0.8);
  width: 100%;
  min-height: 100%;
  }

h1{
  text-align: center;
  color:white;
  padding-top: 20px;
}
</style>
