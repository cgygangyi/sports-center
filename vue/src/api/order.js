// apis for orders

import request from "../utils/request";

// get orders of current user
export function getUserOrders() {
    return request({
        url: '/order/checkOrder',
        method: 'get',
        // header is the token in local storage
        headers: {
            'token': localStorage.getItem('token')
        }
    })
}
