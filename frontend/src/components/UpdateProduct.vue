<script setup>
import {ref, onBeforeMount} from 'vue';
import productServices from '../services/productServices';
import { useRoute, useRouter } from 'vue-router'; 

const route = useRoute();
const router = useRouter();
const productId = route.params.id;

const productName = ref('');
const productDescription = ref('');
const date = ref('');
const startQuantity = ref('');
const soldQuantity = ref('');
const rawPrice = ref('');
const marketPrice = ref('');
const benefits = ref('');
const availableQuantity = ref('');

const loadProductData = async () => { 
    console.log('loadProductData Id',productId);

    try {
    const response = await productServices.get(productId);
    const formData = response.data; 
      
    productName.value = formData.productName,
    productDescription.value = formData.productDescription,
    date.value = formData.date,    
    startQuantity.value = formData.startQuantity,
    soldQuantity.value = formData.soldQuantity,
    rawPrice.value = formData.rawPrice,
    marketPrice.value = formData.marketPrice,
    benefits.value = formData.benefits,
    availableQuantity.value = formData.availableQuantity
    } catch (error) {
    console.error("Error while getting product data: ", error);
    }
}
onBeforeMount(async () => {
    loadProductData();
});

const updateProduct = async(event) => { 
    alert(`The product with ID ${productId} is edited successfully.`);
    console.log("Product Id to EDIT: " +  productId);  
    event.preventDefault();   //para evitar la recarga de la página cuando se envía formulario. IMPORTANTE!!!

    // crear un objeto con props
const editedData = {
    productName : productName.value,
    productDescription : productDescription.value,
    date : date.value,                  
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
    console.log("Date: "+ productId, date); 
    console.log("The product is updated with Id " + productId, editedData.productName) ;
    router.push("/");

    } catch (error){
    console.error("Error occured while updating the product", error);
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
    <div class="d-flex justify-content-center align-items-center" > 
        <form @submit="updateProduct">

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

            <button type="submit" class="btn btn-success btn-sm  rounded mt-3">Save changes</button>
        </form>
    </div> 
</template>