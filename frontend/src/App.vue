<script setup>
import { RouterView } from 'vue-router' 
import NavbarComponent from './components/NavbarComponent.vue';
</script>

<template>
  <div class="background">
    <NavbarComponent />
    <RouterView />
  </div>
</template>

<style scoped>
.background{
  background-color: rgba(191, 200, 195, 0.8);
  border-spacing: 5px;
  width: auto;
  height:100vh;
}
</style>
