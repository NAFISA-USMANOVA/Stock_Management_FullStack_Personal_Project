 
<script setup>
import {onBeforeMount, ref} from 'vue';
import productServices from '../services/productServices';
const products = ref([]);

// const product = ref();


// const updateProduct = async(id) => {
//     await productServices.update(id);
//     product.value.data(id); ///?
//     console.log("The product is updated" + id) ;
// }



const deleteProduct = async(id) => {
    await productServices.delete(id);
    products.value.data.pop(id);
    console.log("You successfully deleted the product with id " + id);
};

onBeforeMount(async() => {
    products.value = await productServices.getAll(); 
});

</script>
<template> 
    <div class="m-3">
        <router-link to="/input">
            <button type="submit" class="btn btn-primary btn-sm  rounded mt-3">New Product</button>
        </router-link>
        <div>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th class="rounded-start">ID</th>
                            <th>Product name</th>
                            <th>Description</th>
                            <!-- <th>Entry date</th> -->
                            <th>Start quantity</th>
                            <th>Sold units</th>
                            <th>Raw price</th>
                            <th>Market price</th>
                            <th>Benefits</th>
                            <th>Available units</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="product in products.data" :key="product.id">
                            <td class="rounded-start">{{ product.id }}</td>
                            <td>{{ product.productName }}</td>
                            <td>{{ product.productDescription }}</td>
                            <!-- <td>{{ product.date }}</td> -->
                            <td>{{ product.startQuantity }}</td>
                            <td>{{ product.soldQuantity }}</td>
                            <td>{{ product.rawPrice }}</td>
                            <td>{{ product.marketPrice }}</td>
                            <td>{{ product.benefits }}</td>
                            <td>{{ product.availableQuantity }}</td>
                            <td class="rounded-end">
                                <!-- <router-link :to="{path: `/update/`+id}" class="btn btn-seccess  fas fa-pen py-2 px-2">Edit</router-link> -->
                                <a class="btn btn-warning  fas fa-pen py-2 px-2" :href="`/update/${product.id}`"></a>
                                <a @click="deleteProduct(product.id)" class="btn btn-danger fa fa-trash-alt py-2 px-2"></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>
<style scoped>
.table {
    width: 100%;
    font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
 }
</style>