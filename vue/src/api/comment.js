// apis for comments

import request from "../utils/request";


export function getVenueCommentById(id) {
    return request({
        url: '/comment/getVenueComment/' + id,
        method: 'get',
    })
}
