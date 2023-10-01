<script setup>
import productService from '../services/productServices.js';
import { ref } from 'vue';

const searchTerm = ref('');
const searchResults = ref([]);

const performSearch = async () => {
  try {
    const response = await productService.search({ query: searchTerm.value });
    searchResults.value = response.data;
  } catch (error) {
    console.error('Error searching products:', error);
  }
};
</script>
<template>
    <div>
        <nav class="navbar fixed-top navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand">Stock Control</a>
                <form class="d-flex" @submit.prevent="performSearch">
                     <input v-model="searchTerm" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search
                    </button>
                </form>
            </div>
             <!-- Display -->
        <div class="result" v-if="searchResults.length > 0">
          <!-- <h4>Search Results:</h4> -->
          <ul>
            <li v-for="product in searchResults" :key="product.id">
                <router-link :to="{ name: 'ProductDetails', params: { id: product.id } }">{{ product.productName }}
                </router-link>
            </li>
          </ul>
        </div>
        <div class="result" v-else>No product found for this search:  {{ searchTerm }}</div>

        </nav>
  </div>
</template>
<style scoped>
.result{
  margin-left:52%;
}
</style>