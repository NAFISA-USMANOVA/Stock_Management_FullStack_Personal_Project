<script setup>
import {ref,onBeforeMount} from 'vue';
import ProductServices from '../services/productServices';
import { useRouter } from 'vue-router';

const id = this.$route.params.id;     ////?

const productName = ref('');
const productDescription = ref('');
const date = ref('');
const startQuantity = ref('');
const soldQuantity = ref('');
const rawPrice = ref('');
const marketPrice = ref('');
const benefits = ref('');
const availableQuantity = ref('');

const router = useRouter();
//befor mount

onBeforeMount(() => {
      // You can define and retrieve the 'id' variable here before the component is mounted
      const id = this.$route.params.id; // Replace with your actual 'id' retrieval logic
      const formData = {
        productName: productName.value,
        productDescription: productDescription.value,
        date: date.value,
        startQuantity: startQuantity.value,
        soldQuantity: soldQuantity.value,
        rawPrice: rawPrice.value,
        marketPrice: marketPrice.value,
        benefits: benefits.value,
        availableQuantity: availableQuantity.value,
      };
    //   updateProduct(id, formData);
    });

    // return {
    //   // Return any data properties you want to expose to the template
    //   productName,
    //   productDescription,
    //   date,
    //   startQuantity,
    //   soldQuantity,
    //   rawPrice,
    //   marketPrice,
    //   benefits,
    //   availableQuantity,
    // };
//   },
// };


const updateProduct = async () => {

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
        await ProductServices.put(id,formData)
        console.log("Surprise!!! You successfully edited the product!");
        router.push("/")
    }
    catch (error)
    {
        console.error("Error while saving product:",error);
    }
}


</script>

<template>
    <div class="d-flex justify-content-center align-items-center" > 
        <form @submit.prevent="updateProduct">

            <input class="form-control mb-2" type="text" v-model="productName" placeholder="Product Name" required />

            <input class="form-control mb-2" type="text" v-model="productDescription" placeholder="Description" />

            <input type="date" class="form-control form-control-m mr-1 mb-2" v-model="date" required />

            <input class="form-control mb-2" type="number"  v-model="startQuantity" placeholder="Start quantity" />

            <input class="form-control mb-2" type="number"  v-model="soldQuantity" placeholder="Sold units" />

            <input class="form-control mb-2" type="number" v-model="rawPrice" placeholder="Raw price of product"/>

            <input class="form-control mb-2" type="number" v-model="marketPrice" placeholder="Market price"/>

            <input class="form-control mb-2" type="number" v-model="benefits" placeholder="Benefits"/>

            <input class="form-control mb-2" type="number" v-model="availableQuantity" placeholder="Available units"/>

            <button type="submit" class="btn btn-success btn-sm  rounded mt-3">Save changes</button>
        </form>
    </div> 
</template>