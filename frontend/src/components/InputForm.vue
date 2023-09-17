<script setup>
import {ref} from 'vue';
import productServices from '../services/productServices';
import { useRouter } from 'vue-router';

const productName = ref('');
const productDescription = ref('');
const date = ref('');
const startQuantity = ref('');
const soldQuantity = ref('');
const rawPrice = ref('');
const marketPrice = ref('');
const benefits = ref(0);
const availableQuantity = ref('');

const router = useRouter();


const saveProduct = async () => {

    const formData = {
        productName: productName.value,
        productDescription: productDescription.value,
        date: date.value,
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
        await productServices.create(formData)
        alert("The product is saved successfully!");
        router.push("/")
    }
    catch (error)
    {
        console.error("Error while saving product:",error);
    }
}
const benefitCalculator = () => {
    const salePrice = marketPrice.value;
    const approuchPrice =rawPrice.value;
    const unitsSold = soldQuantity.value;
    const benefitRate = (salePrice - approuchPrice) * unitsSold;
    benefits.value=benefitRate;
};
const unitsCalculator = () => {
    const unitsApprouched = startQuantity.value;
    const unitsSold = soldQuantity.value;
    const unitsLeft = unitsApprouched - unitsSold;
    availableQuantity.value=unitsLeft;
};


</script>

<template>
    <div class="d-flex justify-content-center align-items-center mt-5" >
        <form @submit.prevent="saveProduct">
            <label for="productName">Product Name</label>
            <input class="form-control mb-2 bg-light " type="text" v-model="productName" required autocomplete="productName" />

            <label for="productDescription">Description</label>
            <input class="form-control mb-2 bg-light" type="text" v-model="productDescription" />

            <label for="date">Date</label>
            <input type="date" class="form-control form-control-m mr-1 mb-2" v-model="date"  />

            <label for="startQuantity">Start quantity of product</label>
            <input class="form-control mb-2 bg-light" type="number"  v-model="startQuantity" @change="unitsCalculator()"/>

            <label for="soldQuantity">Sold units of product</label>
            <input class="form-control mb-2 bg-light" type="number"  v-model="soldQuantity" id="soldQuantity" @input="benefitCalculator()"   @change="unitsCalculator()"/>

            <label for="rawPrice">Raw price of product (€)</label>
            <input class="form-control mb-2 bg-light" type="number" v-model="rawPrice" id="rawPrice" @input="benefitCalculator()"/>

            <label for="marketPrice">Market price (€)</label>
            <input class="form-control mb-2 bg-light" type="number" v-model="marketPrice" id="marketPrice" @input="benefitCalculator()"/>

            <label for="benefits">Benefits (€)</label>
            <input class="form-control mb-2 bg-light" type="number" v-model="benefits" id="benefits"/>

            <label for="availableQuantity">Available units of product</label>
            <input class="form-control mb-2 bg-light" type="number" v-model="availableQuantity"/>

            <button type="submit" class="btn btn-success btn-sm  rounded mt-3">Save</button>
        </form>
    </div> 
</template>