import request from "../utils/request";
export function userLogin(map) {
    return request({
        url: '/login',
        method: 'post',
        data: map
    })
}
