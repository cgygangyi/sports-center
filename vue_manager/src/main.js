import Vue from 'vue'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import App from './App.vue'
import AdminDashboardLayout from './layouts/AdminDashboard.vue'
import router from './router'

import './scss/app.scss'

import * as echarts from 'echarts'

Vue.prototype.$echarts = echarts
Vue.use(Antd)

Vue.config.productionTip = false
Vue.config.silent = true

Vue.component('layout-admindashboard', AdminDashboardLayout)

new Vue({
    el: '#app',
    components: { App },
    template: '<App/>',
    router,
    render: h => h(App)
}).$mount('#app')
