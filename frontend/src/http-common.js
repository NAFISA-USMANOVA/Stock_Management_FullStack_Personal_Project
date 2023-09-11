import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:8080/product_list",
    headers: {
        "Content-type": "application/json"
    }
}) 
// 8080/product