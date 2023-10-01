


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


// export default {
//   data() {
//     return {
//       searchTerm: '', // To store the search input
//       searchResults: [], // To store the matching products
//     };
//   },
//   methods: {
//     async performSearch() {
//       // Call the search method from your service with the search term
//       try {
//         console.log('Search Term:', this.searchTerm);
//         const response = await productService.search({ query: this.searchTerm });
//         console.log('Search Results:', response.data);
//         this.searchResults = response.data;
//       } catch (error) {
//         console.error('Error searching products:', error);
//       }
//     },
//   },
// };
</script>

<template>
    <div>
        <nav class="navbar navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand">Stock Control</a>
                <form class="d-flex" @submit.prevent="performSearch">
                     <input v-model="searchTerm" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search
                    </button>
                </form>
            </div>
        </nav>
        <!-- Display    test dropdown -->
        <div v-if="searchResults.length > 0">
      <h2>Search Results:</h2>
      <ul>
        <li v-for="product in searchResults" :key="product.id">{{ product.productName }}</li>
      </ul>
    </div>
  </div>

    
</template>


<style scoped>
/* .navbar{
    background-image: url('../assets/fondo-desenfocado-productos-coloridos.jpg'); 
} */
</style>