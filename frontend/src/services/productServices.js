import http from '../http-common';

class ProductDataService {
    getAll() {
      return http.get();
    }
  
    get(id) {
      return http.get(`/${id}`); //??
    }
  
    create(productData) {
      return http.post(`/save`, productData);
      // return http.post(`/create`, productData);
    }
  
    update(id, productData) {   
    // edit(id, productData) {   
      return http.put(`/update/${id}`, productData);
      // return http.put(`/edit/${id}`, productData);
    }
  
    delete(id) {
      return http.delete(`/delete/${id}`);
    }
  }
  
  export default new ProductDataService();