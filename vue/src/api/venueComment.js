// apis for comments

import request from '../utils/request'

export function getVenueCommentById(id) {
    return request({
        url: '/comment/getVenueComment/' + id,
        method: 'get',
        headers: {
            token: localStorage.getItem('token')
        }
    })
}

// make comment
export function makeVenueComment(id, map) {
    return request({
        url: '/comment/makeComment/' + id,
        method: 'post',
        data: map,
        headers: {
            token: localStorage.getItem('token')
        }
    })
}
