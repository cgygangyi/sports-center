// apis for orders

import request from '../utils/request'

// get orders of current user
export function getUserOrders() {
    return request({
        url: '/order/getAllOrder',
        method: 'get',
        // header is the token in local storage
        headers: {
            token: localStorage.getItem('token')
        }
    })
}

// get venue orders that have not been commented
export function getUncommentedVenueOrders() {
    return request({
        url: '/order/getAllUncommentOrder',
        method: 'get',
        // header is the token in local storage
        headers: {
            token: localStorage.getItem('token')
        }
    })
}

// get item orders of current user
export function getUserItemOrders() {
    return request({
        url: '/itemOrder/getAllOrder',
        method: 'get',
        // header is the token in local storage
        headers: {
            token: localStorage.getItem('token')
        }
    })
}

// get item orders that have not been commented
export function getUncommentedItemOrders() {
    return request({
        url: '/itemOrder/getAllUncommentOrder',
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

// delete order by id
export function deleteOrder(id) {
    return request({
        url: '/order/deleteOrder/' + id,
        method: 'post',
        headers: {
            token: localStorage.getItem('token')
        }
    })
}

// delete item order by id
export function deleteItemOrder(id) {
    return request({
        url: '/itemOrder/deleteOrder/' + id,
        method: 'post',
        headers: {
            token: localStorage.getItem('token')
        }
    })
}

// make item order
export function makeItemOrder(id, data) {
    return request({
        url: '/itemOrder/makeOrder/' + id,
        method: 'post',
        headers: {
            token: localStorage.getItem('token')
        },
        data: data
    })
}