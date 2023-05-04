<template>

    <!-- Authors Table Card -->
    <a-card :bordered="false" class="header-solid h-full" :bodyStyle="{padding: 0,}">
        <template #title>
            <a-row type="flex" align="middle">
                <a-col :span="24" :md="12">
                    <h5 class="font-semibold m-0">{{title}}</h5>
                </a-col>
            </a-row>
        </template>
        <a-table :columns="columns" :data-source="data" :pagination="false">
            <template slot="key" slot-scope="key">
                <div class="table-avatar-info">
                    <div class="avatar-info">
                        <h6>{{ key }}</h6>
                        <p>{{ author.email }}</p>
                    </div>
                </div>
            </template>
            <template slot="func" slot-scope="func">
                <div class="author-info">
                    <h6 class="m-0">{{ func.job }}</h6>
                    <p class="m-0 font-regular text-muted">{{ func.department }}</p>
                </div>
            </template>

            <template slot="status" slot-scope="status">
                <a-tag class="tag-status" :class="status ? 'ant-tag-primary' : 'ant-tag-muted'">
                    {{ status ? "ONLINE" : "OFFLINE" }}
                </a-tag>
            </template>

            <template slot="editBtn" slot-scope="row">
                <a-button type="link" slot="extra" @click="showModal" :data-id="row.key" class="btn-edit">
                    <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path class="fill-muted" d="M13.5858 3.58579C14.3668 2.80474 15.6332 2.80474 16.4142 3.58579C17.1953 4.36683 17.1953 5.63316 16.4142 6.41421L15.6213 7.20711L12.7929 4.37868L13.5858 3.58579Z" fill="#111827"/>
                        <path class="fill-muted" d="M11.3787 5.79289L3 14.1716V17H5.82842L14.2071 8.62132L11.3787 5.79289Z" fill="#111827"/>
                    </svg>
                </a-button>
                <a-modal
                    title="Edit Profile"
                    :visible="visible"
                    :confirm-loading="confirmLoading"
                    @ok="handleOk"
                    @cancel="handleCancel"
                >
                    <!--            <p>Edit to change your profile</p>-->
                    <a-form
                        id="components-form-demo-normal-login"
                        :form="form"
                        class="login-form my-25"
                        @submit="handleSubmit"
                        initialValues='name= Edit to change venue information'
                    >
                        <a-form-item class="mb-10">
                            <a-input
                                v-decorator="[
                            'name',
                            { rules: [{ required: true, message: 'Please input your email!' }] },
                            ]"
                                placeholder="Name"
                                :value="data[0].name"
                            >
                            </a-input>
                        </a-form-item>
                        <a-form-item class="mb-10">
                            <a-input
                                v-decorator="[
                            'address',
                            { rules: [{ required: true, message: 'Please input your name!' }] },
                            ]"
                                placeholder="Address"
                                :value="data[0].address"
                            >
                            </a-input>
                        </a-form-item>
                        <a-form-item class="mb-10">
                            <a-input
                                v-decorator="[
                            'price',
                            { rules: [{ required: true, message: 'Please input your phoneNumber!' }] },
                            ]"
                                placeholder="price"
                                :value="data[0].price"
                            >
                            </a-input>
                        </a-form-item>
                    </a-form>
                </a-modal>
            </template>
            <template slot="changeStateBtn" slot-scope="row">
                <a-button type="link" slot="extra" @click="showModal" :data-id="row.key" class="btn-edit">
                    <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path class="fill-muted" d="M13.5858 3.58579C14.3668 2.80474 15.6332 2.80474 16.4142 3.58579C17.1953 4.36683 17.1953 5.63316 16.4142 6.41421L15.6213 7.20711L12.7929 4.37868L13.5858 3.58579Z" fill="#111827"/>
                        <path class="fill-muted" d="M11.3787 5.79289L3 14.1716V17H5.82842L14.2071 8.62132L11.3787 5.79289Z" fill="#111827"/>
                    </svg>
                </a-button>
                <a-modal
                    title="Edit State"
                    :visible="visible"
                    :confirm-loading="confirmLoading"
                    @ok="handleOk"
                    @cancel="handleCancel"
                >
                    <AdminTimePicker :data="ModalData"></AdminTimePicker>
                </a-modal>
            </template>
        </a-table>
    </a-card>
    <!-- / Authors Table Card -->

</template>

<script>
import moment from 'moment'
import { getVenueById } from '@/api/venue'
import AdminTimePicker from '@/components/Cards/AdminTimePicker.vue'
import { getVenueTime } from '@/api/venueState'
import { bookVenue } from '@/api/order'
import {getVenueCommentById} from "@/api/venueComment";

export default ({
    components: {
        AdminTimePicker
    },
    props: {
        data: {
            type: Array,
            default: () => []
        },
        columns: {
            type: Array,
            default: () => []
        },
        title: {
            type: String,
            default: ''
        }
    },
    data() {
        return {
            // Active button for the "Authors" table's card header radio button group.
            authorsHeaderBtns: 'all',
            ModalText: 'Content of the modal',
            visible: false,
            confirmLoading: false,
            ModalData: []

        }
    },
    beforeMount() {
        getVenueById(this.$route.query.id).then(res => {
            this.venueData = res.data.data
            this.description = this.venueData.introduction.split('\n')
            console.log(this.venueData)
        })
        getVenueCommentById(this.$route.query.id).then(res => {
            this.comments = res.data.data
            console.log(this.comments)
        })
    },
    methods: {

        showModal() {
            if (localStorage.getItem('token') === null || localStorage.getItem('token') === '') {
                this.$message.warning('Please login first!')
                return
            }

            this.ModalText = 'Please click to select a time slot(just one for each choose)'
            getVenueTime(this.$route.query.id).then((response) => {
                console.log(response.data)
                if (response.data === '') {
                    this.$message.warning('Please login first!')
                } else {
                    this.ModalData = response.data
                    this.visible = true
                }
                console.log(this.ModalData)
            }).catch((error) => {
                console.log(error)
            })
        },
        handleOk(e) {
            const id = sessionStorage.getItem('chosen')
            if (id === null || id === '') {
                this.$message.warning('Please choose a time slot!')
                return
            }
            bookVenue(id).then((response) => {
                console.log(response)
                if (response.data === '') {
                    this.$message.warning('Please login first!')
                } else {
                    this.ModalText = 'Booking......'
                    this.confirmLoading = true
                    setTimeout(() => {
                        this.visible = false
                        this.confirmLoading = false
                        this.$message.success('Successfully booked!')
                    }, 1000)
                }
            }).catch((error) => {
                console.log(error)
            })
        },
        handleCancel(e) {
            console.log('Clicked cancel button')
            this.visible = false
        }
    }
})
// export default ({
//     props: {
//         data: {
//             type: Array,
//             default: () => []
//         },
//         columns: {
//             type: Array,
//             default: () => []
//         },
//         title: {
//             type: String,
//             default: ''
//         }
//     },
//     data() {
//         return {
//             // Active button for the "Authors" table's card header radio button group.
//             authorsHeaderBtns: 'all',
//             ModalText: 'Content of the modal',
//             visible: false,
//             confirmLoading: false
//         }
//     },
//
//     methods: {
//         showModal() {
//             this.visible = true
//         },
//         handleOk() {
//             this.ModalText = 'The modal will be closed after two seconds'
//             this.confirmLoading = true
//             setTimeout(() => {
//                 this.visible = false
//                 this.confirmLoading = false
//                 // eslint-disable-next-line vue-mutating-props
//                 this.data[0].name = 'test'
//             }, 500)
//         },
//         handleCancel(e) {
//             console.log('Clicked cancel button')
//             this.visible = false
//         }
//     }
// })
</script>
