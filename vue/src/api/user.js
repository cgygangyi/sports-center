// apis for user

import request from '../utils/request'

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
        data: map,
        headers: {
            token: localStorage.getItem('token')
        }
    })
}

// get user profile
export function getUserProfile() {
    return request({
        url: '/user/getUserInfo',
        method: 'get',
        headers: {
            token: localStorage.getItem('token')
        }
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
        method: 'get'
    })
}

// log out
export function userLogout() {
    return request({
        url: '/user/logout',
        method: 'get'
    })
}

// update user profile
export function updateUserProfile(map) {
    return request({
        url: '/user/updateInfo',
        method: 'post',
        data: map,
        headers: {
            token: localStorage.getItem('token')
        }
    })
}
