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
                        initialValues=name= Edit to change venue information
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

        </a-table>
    </a-card>
    <!-- / Authors Table Card -->

</template>

<script>

import {editUserProfile} from "@/api/user";

export default ({
    props: {
        data: {
            type: Array,
            default: () => [],
        },
        columns: {
            type: Array,
            default: () => [],
        },
        title: {
            type: String,
            default: '',
        }
    },
    data() {
        return {
            // Active button for the "Authors" table's card header radio button group.
            authorsHeaderBtns: 'all',
            ModalText: 'Content of the modal',
            visible: false,
            confirmLoading: false,
        }
    },

    methods: {
        showModal() {
            this.visible = true;
        },
        handleOk() {
            this.ModalText = 'The modal will be closed after two seconds';
            this.confirmLoading = true;
            setTimeout(() => {
                this.visible = false;
                this.confirmLoading = false;
                this.data[0].name = "test"
            }, 500);
        },
        handleCancel(e) {
            console.log('Clicked cancel button');
            this.visible = false;
        },
    },
})

</script>
