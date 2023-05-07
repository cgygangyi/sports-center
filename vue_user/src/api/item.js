// apis for items

import request from '../utils/request'

// get all items
export function getAllItems() {
    return request({
        url: '/item/getAllItem',
        method: 'get',
        data: { status: 'user' },
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
        data: { status: 'user' }
    })
}
