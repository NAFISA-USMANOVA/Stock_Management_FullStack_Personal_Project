 
<script setup>
import {onBeforeMount, ref, watch} from 'vue';
import productServices from '../services/productServices';
import { debounce } from 'lodash'; //?? 
// import axios from 'axios';

const products = ref([]);

const highlightedRowId = ref(null);
const highlightRow = (productId) => {
  highlightedRowId.value = productId;
};

const unhighlightRow = () => {
  highlightedRowId.value = null; 
};

const deleteProduct = async(id) => {
    await productServices.delete(id);
    products.value.data = products.value.data.filter((product) => product.id !== id);
};

onBeforeMount(async() => {
    products.value = await productServices.getAll(); 
});



//Search
const searchQuery = ref(null);
const searchResults =ref([]);

const search = async () => {
  try {
    const response = await productServices.search({ query: searchQuery.value });
    // console.log("searchQuery.value: " + searchQuery.value);
    searchResults.value = response.data;//searchResults products 
    console.log("response.data: " + JSON.stringify(response.data));
    //   response.data = products.value;
    //   console.log("products.value: " + JSON.stringify(products.value));
  } catch (error) {
    console.error('Error searching products:', error);
  }
};
watch(searchQuery, debounce(() => {
    search();
},1000))
</script>
<template> 
    <div class="m-3">
        <div class="d-flex justify-content-between ">
            <div  style="margin-top:10px;">
                <router-link to="/input">
                    <button type="submit" class="btn btn-primary rounded">New Product</button>
                </router-link>
            </div>
            <div style="margin-top:10px;">
                <input type="text" v-model="searchQuery" class="form-control" placeholder="Search...">
                <!-- <button @click.prevent="search(query)">Submit</button> -->
            </div>
        </div>
        <div>
            <div class="table-responsive">
                <table class="table table-hover">

                    <!-- Search -->
                        <tr v-for="product in searchResults" :key="product.id" class="search_result">
                        <td>{{ product.id }}</td>
                        <td>{{ product.productName }}</td>
                        <td>{{ product.productDescription }}</td>
                        <td>{{ product.date }}</td>
                        <td>{{ product.startQuantity }}</td>
                        <td>{{ product.soldQuantity }}</td>
                        <td>{{ product.rawPrice }}</td>
                        <td>{{ product.marketPrice }}</td>
                        <td>{{ product.benefits }}</td>
                        <td>{{ product.availableQuantity }}</td>
                        <td class="icons">
                            <a class="btn  fas fa-pen py-1 px-1" :href="`/update/${product.id}`"></a>
                            <a @click="deleteProduct(product.id)" class="btn fa fa-trash-alt py-1 px-1"></a>
                        </td>
                    </tr>
                    
                    <thead>
                        <tr class="blue_characters">
                            <th>ID</th>
                            <th>Product name</th>
                            <th>Description</th>
                            <th>Entry date</th>
                            <th>Start quantity</th>
                            <th>Sold units</th>
                            <th>Raw price (€)</th>
                            <th>Market price (€)</th>
                            <th>Benefits (€)</th>
                            <th>Available units</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="product in products.data" :key="product.id"  @mouseenter="highlightRow(product.id)" @mouseleave="unhighlightRow(product.id)">
                            <td >{{ product.id }}</td>
                            <td>{{ product.productName }}</td>
                            <td>{{ product.productDescription }}</td>
                            <td>{{ product.date }}</td>
                            <td>{{ product.startQuantity }}</td>
                            <td>{{ product.soldQuantity }}</td>
                            <td>{{ product.rawPrice }}</td>
                            <td>{{ product.marketPrice }}</td>
                            <td>{{ product.benefits }}</td>
                            <td>{{ product.availableQuantity }}</td>
                            <td class="icons">
                                <a class="btn  fas fa-pen py-1 px-1" :href="`/update/${product.id}`"></a>
                                <a @click="deleteProduct(product.id)" class="btn fa fa-trash-alt py-1 px-1"></a>
                            </td>
                        </tr>

                        
                    </tbody>

                    <tfoot>
                        <tr class="blue_characters rounded">
                            <th>ID</th>
                            <th class="date_column">Product name</th>
                            <th>Description</th>
                            <th class="date_column">Entry date</th>
                            <th>Start quantity</th>
                            <th>Sold units</th>
                            <th>Raw price (€)</th>
                            <th>Market price (€)</th>
                            <th>Benefits (€)</th>
                            <th>Available units</th>
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
        <div class="row w-100 text-center" style="margin-top:10px;">
            <router-link to="/input">
                <button type="submit" class="btn btn-primary rounded button2">New Product</button>
            </router-link>
        </div>
    </div>
</template>
<style scoped>
.table {
    margin-top: 40px;
    width: 100%;
    font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    text-align:center;
}
.blue_characters th {
  color: rgb(187, 115, 185); 
}
.date_column{
    width: 10%;
}
.button2{
    margin-bottom: 20px;
}
.search_result{
    background-color: rgb(191, 223, 202);
    color:rgb(95, 22, 163);
    border-color: rgb(165, 71, 71);
    border-width: 2px;
}
</style>