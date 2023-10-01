<template>
    <div class="m-3">
      <div class="table-responsive" v-if="product.name">
        <table class="table table-hover">
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
            <!-- Table rows to display product details -->
            <tr v-for="product in products.data" :key="product.id">
                            <td >{{ product.id }}</td>
                            <td>{{ product.productName }}</td>
                            <td>{{ product.productDescription }}</td>
                            <td>{{product.date }}</td>
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
        </table>
      </div>
      <div v-else>
        Loading...
      </div>
    </div>
  </template>
  
  <script>
  export default {
    // Define props or data properties to store product details
    props: {
        productName: String,
        productDescription: String,
        date: String,
        startQuantity: Number,
        soldQuantity: Number,
        rawPrice: Number,
        marketPrice: Number,
        benefits: Number,
        availableQuantity: Number,

      // Define props to receive product details
      product: {
        type: Object,
        required: true,
        default: () => ({  // Provide a default value, like an empty object
      productName: '',
      productDescription: '',
      date: '',
      startQuantity:'',
      soldQuantity:'',
      rawPrice:'',
      marketPrice:'',
      benefits:'',
      availableQuantity:''
    }),
      },
    },
  };
  </script>
  
  <style scoped>
  /* Define styles for the product detail table */
  </style>
  