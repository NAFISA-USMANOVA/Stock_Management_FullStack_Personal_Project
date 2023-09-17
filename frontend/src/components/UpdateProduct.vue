<script setup>
import {ref, onBeforeMount} from 'vue';
import productServices from '../services/productServices';
import { useRoute, useRouter } from 'vue-router'; 

const route = useRoute();
const router = useRouter();

const productName = ref('');
const productDescription = ref('');
const date = ref('');
const startQuantity = ref('');
const soldQuantity = ref('');
const rawPrice = ref('');
const marketPrice = ref('');
const benefits = ref('');
const availableQuantity = ref('');

// Sample backend date string
const backendDateStr = '2023-09-11T14:30:00';
// Parse the backend date string into a Date object
const dateObject = new Date(backendDateStr);
const year = dateObject.getFullYear();
const month = dateObject.getMonth() + 1;
const day = dateObject.getDate();
// Format the components as needed for my dropdown date picker
const formattedDate = `${year}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}`;

const productId = route.params.id; // Obtienemos ID del producto desde la ruta
const loadProductData = async () => {  //Traer los datos del producto para la edición
    console.log('loadProductData Id',productId);

    try {
    const response = await productServices.get(productId);
    const formData = response.data;  //datos que vienen de back   ?
            
    productName.value = formData.productName,
    productDescription.value = formData.productDescription,
    date.value = formData.formattedDate,    //formData.formattedDate
    startQuantity.value = formData.startQuantity,
    soldQuantity.value = formData.soldQuantity,
    rawPrice.value = formData.rawPrice,
    marketPrice.value = formData.marketPrice,
    benefits.value = formData.benefits,
    availableQuantity.value = formData.availableQuantity
    } catch (error) {
    console.error("Error al obtener los datos del producto: ", error);
    }
}
onBeforeMount(async () => {
    loadProductData();
});

const updateProduct = async(event) => { /// id
    console.log(`updateProduct ${productId}`);
    console.log("Product Id to EDIT: " +  productId);  ///CONSOLE
    event.preventDefault();   //para evitar la recarga de la página cuando se envía formulario. IMPORTANTE!!!

    // crear un objeto con propiedades
const editedData = {
    productName : productName.value,
    productDescription : productDescription.value,
    formattedDate : formattedDate.value,            ///formattedDate
    startQuantity : startQuantity.value,
    soldQuantity : soldQuantity.value,
    rawPrice : rawPrice.value,
    marketPrice : marketPrice.value,
    benefits : benefits.value,
    availableQuantity : availableQuantity.value 
    };
    //solicitud HTTP para actualizar el producto (response.data)
    try {
    await productServices.update(productId, editedData);
    console.log("The product is updated with Id " + productId, editedData.productName) ;
    router.push("/");

    } catch (error){
    console.error("Error occured while updating the product", error);
    }

}
</script>

<template>
    <div class="d-flex justify-content-center align-items-center" > 
        <form @submit="updateProduct">

            <input class="form-control mb-2" type="text" v-model="productName" placeholder="Product Name" required />

            <input class="form-control mb-2" type="text" v-model="productDescription" placeholder="Description" />

            <!-- <input type="date" class="form-control form-control-m mr-1 mb-2" v-model="date" required /> -->

            <input class="form-control mb-2" type="number"  v-model="startQuantity" placeholder="Start quantity" />

            <input class="form-control mb-2" type="number"  v-model="soldQuantity" placeholder="Sold units" />

            <input class="form-control mb-2" type="number" v-model="rawPrice" placeholder="Raw price of product"/>

            <input class="form-control mb-2" type="number" v-model="marketPrice" placeholder="Market price"/>

            <input class="form-control mb-2" type="number" v-model="benefits" placeholder="Benefits"/>

            <input class="form-control mb-2" type="number" v-model="availableQuantity" placeholder="Available units"/>

            <button type="submit" class="btn btn-success btn-sm  rounded mt-3">Save changes</button>
            <!-- @click="updateProduct(route.params.id)"  -->
        </form>
    </div> 
</template>