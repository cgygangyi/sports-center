import Vue from 'vue'
import VueRouter from 'vue-router'
import request from "../utils/request";
import {getAllVenues} from "@/api/venue";

Vue.use(VueRouter)

let routes = [
	{
		// will match everything
		path: '*',
		component: () => import('../views/404.vue'),
	},
	{
		path: '/',
		name: 'Home',
		redirect: '/home',
	},
	{
		path: '/home',
		name: 'Home',
		layout: "dashboard",
		component: () => import('../views/Home.vue'),
	},
	{
		path: '/logout',
		name: 'Logout',
		layout: "dashboard",
		component: () => import('../views/Logout.vue'),
	},
	{
		path: '/venues',
		name: 'Venues',
		layout: "dashboard",
		component: () => import('../views/Venues.vue'),
	},
	{
		path: '/login',
		name: 'login',
		layout: "dashboard",
		component: () => import('../views/Login.vue'),
	},
	{
		path: '/register',
		name: 'register',
		layout: "dashboard",
		component: () => import('../views/Register.vue'),
	},
	{
		path: '/profile',
		name: 'profile',
		layout: "dashboard",
		component: () => import('../views/Profile.vue'),
	},
	{
		path: '/venueDetail',
		name: 'venueDetail',
		layout: "dashboard",
		component: () => import('../views/VenueDetail.vue'),
	},
	{
		path: '/Orders',
		name: 'Orders',
		layout: "dashboard",
		component: () => import('../views/Orders.vue'),
	},
	{
		path: '/equipments',
		name: 'Equipments',
		layout: "dashboard",
		component: () => import('../views/Equipments.vue'),
	},
	{
		path: '/admin/home',
		name: 'admin',
		layout: "admindashboard",
		component: () => import('../views/Admin/AdminHome.vue'),
	},
	{
		path: '/admin/venues',
		name: 'Venues management',
		layout: "admindashboard",
		component: () => import('../views/Admin/AdminVenues.vue'),
	},
	{
		path: '/admin/users',
		name: 'User management',
		layout: "admindashboard",
		component: () => import('../views/Admin/AdminUsers.vue'),
	},
	{
		path: '/admin/states',
		name: 'States management',
		layout: "admindashboard",
		component: () => import('../views/Admin/AdminStates.vue'),
	},
	{
		path: '/admin/addVenue',
		name: 'add venue',
		layout: "admindashboard",
		component: () => import('../views/Admin/AdminAddVenue.vue'),
	}
]

// Adding layout property from each route to the meta
// object so it can be accessed later.
function addLayoutToRoute( route, parentLayout = "default" )
{
	route.meta = route.meta || {} ;
	route.meta.layout = route.layout || parentLayout ;

	if( route.children )
	{
		route.children = route.children.map( ( childRoute ) => addLayoutToRoute( childRoute, route.meta.layout ) ) ;
	}
	return route ;
}

routes = routes.map( ( route ) => addLayoutToRoute( route ) ) ;

const router = new VueRouter({
	mode: 'hash',
	base: process.env.BASE_URL,
	routes,
	scrollBehavior (to, from, savedPosition) {
		if ( to.hash ) {
			return {
				selector: to.hash,
				behavior: 'smooth',
			}
		}
		return {
			x: 0,
			y: 0,
			behavior: 'smooth',
		}
	}
})

router.beforeEach((to, from, next) => {
	let token = localStorage.getItem('token');
	if (token === null || token === '') {
		if (to.path === '/login' || to.path === '/register' || to.path === '/home' || to.path === '/venues' ||
			to.path === '/equipments' || to.path === '/venueDetail' || to.path === '/admin/home' ||
			to.path === '/admin/venues' || to.path === '/admin/users' || to.path === '/admin/states') {
			next();
		} else {
			next('/home');
		}
	} else {
		if (to.path === '/login' || to.path === '/register') {
			next('/home');
		} else {
			next();
		}
	}
});

export default router
