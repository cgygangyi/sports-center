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
