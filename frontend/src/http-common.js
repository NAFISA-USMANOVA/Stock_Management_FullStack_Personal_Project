import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:9060/product_list",
    headers: {
        "Content-type": "application/json"
    }
}) 


