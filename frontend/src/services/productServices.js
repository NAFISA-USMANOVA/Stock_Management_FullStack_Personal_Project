import http from '../http-common';

class ProductDataService {
    getAll() {
      return http.get(`/all`); //`/all`
    }
  
    get(id) {
      return http.get(`/${id}`); 
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
///    SEARCH Function
    search(query) {
      return http.get('/search',{params: query});
    }
  }
  
  export default new ProductDataService();