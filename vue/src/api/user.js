// apis for user

import request from "../utils/request";

// login function
export function userLogin(map) {
    return request({
        url: '/user/login',
        method: 'post',
        data: map,
    })
}


// register function
export function userRegister(map) {
    return request({
        url: '/user/register',
        method: 'post',
        data: map,
        headers: {
            'token': localStorage.getItem('token')
        }
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

// get all users
export function getAllUsers() {
    return request({
        url: '/user/getAll',
        method: 'get',
    })
}


// log out
export function userLogout() {
    return request({
        url: '/user/logout',
        method: 'get',
    })
}
