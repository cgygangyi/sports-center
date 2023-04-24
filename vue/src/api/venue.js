// apis for venues

import request from "../utils/request";

// get all venues
export function getAllVenues() {
    return request({
        url: '/venue/getAll',
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

