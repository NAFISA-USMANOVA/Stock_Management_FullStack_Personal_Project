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
    }
  
    update(id, productData) {   
      return http.put(`/update/${id}`, productData);
    }
  
    delete(id) {
      return http.delete(`/delete/${id}`);
    }
  }
  
  export default new ProductDataService();