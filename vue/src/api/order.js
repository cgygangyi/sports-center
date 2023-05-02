// apis for orders

import request from '../utils/request'

// get orders of current user
export function getUserOrders() {
    return request({
        url: '/order/checkOrder',
        method: 'get',
        // header is the token in local storage
        headers: {
            token: localStorage.getItem('token')
        }
    })
}

// book venue by id
export function bookVenue(id) {
    return request({
        url: '/order/makeOrder/' + id,
        method: 'post',
        headers: {
            token: localStorage.getItem('token')
        }
    })
}
