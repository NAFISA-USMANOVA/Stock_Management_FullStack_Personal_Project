import { createRouter, createWebHistory } from 'vue-router'
import ProductList from '../components/ProductList.vue'
import InputForm from '../components/InputForm.vue'
import UpdateProduct from '../components/UpdateProduct.vue'
// import FormComponent from '../components/FormComponent.vue'
import ProductDetails from '../components/ProductDetails.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'product_list',
      component: ProductList
    },
    {
      path: '/input',
      name: 'input_form',
      component: InputForm
    },
    {
      path: '/update/:id',
      name: 'update_product',
      component: UpdateProduct
    },
    {
      path: '/product/:id',
      name: 'ProductDetails',
      component: ProductDetails
    }
    // {
    //   path: '/create',
    //   name: 'create_product',
    //   component: FormComponent
    // },
    // {
    //   path: '/edit/:id',
    //   name: 'edit_product',
    //   component: FormComponent
    // }
  ]
})

export default router
