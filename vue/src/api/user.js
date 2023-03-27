// apis for user

import request from "../utils/request";

// login function
export function userLogin(map) {
    return request({
        url: '/user/login',
        method: 'post',
        data: map
    })
}


// register function
export function userRegister(map) {
    return request({
        url: '/user/register',
        method: 'post',
        data: map
    })
}

// get user session
export function getUserSession(id) {
    return request({
        url: '/user/getSession/' + id,
        method: 'get',
    })
}

// edit user profile
export function editUserProfile(map) {
    return request({
        url: '/user/editProfile',
        method: 'post',
        data: map
    })
}
