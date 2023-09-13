<script setup>
import {ref} from 'vue';
import ProductServices from '../services/productServices';
import { useRouter } from 'vue-router';

const productName = ref('');
const productDescription = ref('');
// const date = ref('');
const startQuantity = ref('');
const soldQuantity = ref('');
const rawPrice = ref('');
const marketPrice = ref('');
const benefits = ref('');
const availableQuantity = ref('');

const router = useRouter();


const saveProduct = async () => {

    const formData = {
        productName: productName.value,
        productDescription: productDescription.value,
        // date: date.value,
        startQuantity: startQuantity.value,
        soldQuantity: soldQuantity.value,
        rawPrice: rawPrice.value,
        marketPrice: marketPrice.value,
        benefits: benefits.value,
        availableQuantity: availableQuantity.value
    };
    try
    {
      console.log("form data", formData)
        await ProductServices.create(formData)
        console.log("Surprise!!! You successfully created (saved) a product!");
        router.push("/")
    }
    catch (error)
    {
        console.error("Error while saving product:",error);
    }
}


</script>

<template>
    <div class="d-flex justify-content-center align-items-center mt-5" >
        <form @submit.prevent="saveProduct">

            <input class="form-control mb-2 bg-light " type="text" v-model="productName" placeholder="Product Name" required />

            <input class="form-control mb-2 bg-light" type="text" v-model="productDescription" placeholder="Description" />

            <!-- <input type="date" class="form-control form-control-m mr-1 mb-2" v-model="date" required /> -->

            <input class="form-control mb-2 bg-light" type="number"  v-model="startQuantity" placeholder="Start quantity" />

            <input class="form-control mb-2 bg-light" type="number"  v-model="soldQuantity" placeholder="Sold units" />

            <input class="form-control mb-2 bg-light" type="number" v-model="rawPrice" placeholder="Raw price of product"/>

            <input class="form-control mb-2 bg-light" type="number" v-model="marketPrice" placeholder="Market price"/>

            <input class="form-control mb-2 bg-light" type="number" v-model="benefits" placeholder="Benefits"/>

            <input class="form-control mb-2 bg-light" type="number" v-model="availableQuantity" placeholder="Available units"/>

            <button type="submit" class="btn btn-success btn-sm  rounded mt-3">Save</button>
        </form>
    </div> 
</template>=