import Vue from 'vue'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import App from './App.vue'
import DashboardLayout from './layouts/DashboardLayout.vue'
import AdminDashboardLayout from './layouts/AdminDashboard.vue'
import router from './router'

import './scss/app.scss'

Vue.use(Antd)

Vue.config.productionTip = false

// Adding template layouts to the vue components.
Vue.component('layout-dashboard', DashboardLayout)
Vue.component('layout-admindashboard', AdminDashboardLayout)

new Vue({
    el: '#app',
    components: { App },
    template: '<App/>',
    router,
    render: h => h(App)
}).$mount('#app')
