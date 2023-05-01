// apis for items

import request from "../utils/request";

// get all items
export function getAllItems() {
    return request({
        url: '/item/getAllItem',
        method: 'get',
        // header is the token in local storage
        headers: {
            'token': localStorage.getItem('token')
        }
    })
}


// get venue information by id
export function getVenueById(id) {
    return request({
        url: '/venue/getVenueInfo/' + id,
        method: 'get',
    })
}



// add new venue
export function addNewVenue(map) {
    return request({
        url: '/venue/add',
        method: 'post',
        data: map,
    })
}

