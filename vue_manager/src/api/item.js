// apis for items

import request from '../utils/request'

// get all items
export function getAllItems() {
    return request({
        url: '/item/getAllItem',
        method: 'get',
        data: { status: 'admin' },
        // header is the token in local storage
        headers: {
            token: localStorage.getItem('token')
        }
    })
}

// get item info by id
export function getItemInfo(id) {
    return request({
        url: '/item/getItemInfo/' + id,
        method: 'get',
        data: { status: 'admin' }
    })
}

// manager add an item
export function addItem(map) {
    return request({
        url: '/item/addItem',
        method: 'post',
        data: map,
        headers: {
            token: localStorage.getItem('token')
        }
    })
}
