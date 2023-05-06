<template>
	<div>
        <a-row type="flex" :gutter="[24,24]">

            <a-col :span="24" :lg="6">

                <!-- Page Anchors -->
                <a-affix :offset-top=" navbarFixed ? 100 : 10 ">
                    <a-card :bordered="false" class="header-solid mb-24">
                        <a-anchor :targetOffset=" navbarFixed ? 100 : 10 " :affix="false">
                            <a-anchor-link href="#profile">
                                <div slot="title" class="ant-list-item-meta">
                                    <a-icon type="appstore" theme="filled" class="text-gray-6 text-lg" />
                                    <h4 class="ant-list-item-meta-title">
                                        <span class="font-regular">Profile</span>
                                    </h4>
                                </div>
                            </a-anchor-link>
                            <a-anchor-link href="#basic-info">
                                <div slot="title" class="ant-list-item-meta">
                                    <a-icon type="snippets" theme="filled" class="text-gray-6 text-lg" />
                                    <h4 class="ant-list-item-meta-title">
                                        <span class="font-regular">Basic Info</span>
                                    </h4>
                                </div>
                            </a-anchor-link>
                            <a-anchor-link href="#change-profile">
                                <div slot="title" class="ant-list-item-meta">
                                    <a-icon type="unlock" theme="filled" class="text-gray-6 text-lg" />
                                    <h4 class="ant-list-item-meta-title">
                                        <span class="font-regular">Change Profile</span>
                                    </h4>
                                </div>
                            </a-anchor-link>
                            <a-anchor-link href="#payment">
                                <div slot="title" class="ant-list-item-meta">
                                    <a-icon type="safety-certificate" theme="filled" class="text-gray-6 text-lg" />
                                    <h4 class="ant-list-item-meta-title">
                                        <span class="font-regular">Payment</span>
                                    </h4>
                                </div>
                            </a-anchor-link>
                        </a-anchor>
                    </a-card>
                </a-affix>
                <!-- / Page Anchors -->

            </a-col>
            <a-col :span="24" :lg="18">
                <a-card :bordered="false" id="profile" class="card-profile-head" :bodyStyle="{padding: 0,}">
                    <template #title>
                        <a-row type="flex" align="middle">
                            <a-col :span="24" :md="10" class="col-info">
                                <a-avatar :size="74" shape="square" :src="userData.image" />
                                <div class="avatar-info">
                                    <h4 class="font-semibold m-0">{{userData.username}}</h4>
                                </div>
                            </a-col>
                            <a-col :md="4">
                                <a-button @click="jump">change avatar</a-button>
                            </a-col>
                        </a-row>
                    </template>
                </a-card>
                <a-card :bordered="false" id="basic-info" class="header-solid mb-24">
                    <template #title>
                        <h5 class="mb-0 font-semibold">Basic Info</h5>
                    </template>
                    <a-col :span="24" :md="24" class="mb-24">
                        <CardProfileInformation
                            :id="userData.id"
                            :username="userData.username"
                            :age="userData.age"
                            :email="userData.email"
                            :name="userData.name"
                            :password="userData.password"
                            :phoneNumber="userData.phoneNumber"
                            :sex="userData.sex"
                        ></CardProfileInformation>
                    </a-col>
                </a-card>
                <a-card :bordered="false" id="change-profile" class="header-solid mb-24">
                    <template #title>
                        <h5 class="mb-0 font-semibold">Update profile</h5>
                    </template>
                    <a-form
                        :form="form"
                        @submit="handleSubmit"
                    >
                        <a-row :gutter="[24]">
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Password" :colon="false">
                                    <a-input-password
                                        v-decorator="[
                                            'password',
                                            { rules: [{ required: true, message: 'Please input your Password!' }] },
                                        ]"
                                        type="password"
                                        placeholder="******"
                                    >
                                    </a-input-password>
                                </a-form-item>
                            </a-col>
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Repeat Password" :colon="false">
                                    <a-input-password
                                        v-decorator="[
                                            'Confirm password',
                                            { rules: [{ required: true, message: 'Please input your Password!' }] },
                                        ]"
                                        type="password"
                                        placeholder="******"
                                    >
                                    </a-input-password>
                                </a-form-item>
                            </a-col>
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Name" :colon="false">
                                    <a-input
                                        v-decorator="[
                                            'name',
                                            { rules: [{ required: true, message: 'Please input your name!' }] },
                                        ]"
                                        placeholder="Name"
                                    >
                                    </a-input>
                                </a-form-item>
                            </a-col>
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Phone Number" :colon="false">
                                    <a-input
                                        v-decorator="[
                                            'phoneNumber',
                                            { rules: [{ required: true, message: 'Please input your phone number!' }] },
                                        ]"
                                        placeholder="phone number"
                                    >
                                    </a-input>
                                </a-form-item>
                            </a-col>
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Age" :colon="false">
                                    <a-input
                                        v-decorator="['age']"
                                        type="number"
                                        placeholder="Age"
                                    >
                                    </a-input>
                                </a-form-item>
                            </a-col>
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Gender" :colon="false">
                                    <a-select
                                        v-decorator="['sex']"
                                        @change="handleSelectChange"
                                    >
                                        <a-select-option value="Male">
                                            Male
                                        </a-select-option>
                                        <a-select-option value="Female">
                                            Female
                                        </a-select-option>
                                    </a-select>
                                </a-form-item>
                            </a-col>
                        </a-row>
                        <a-row :gutter="[24]">
                            <a-col :span="12">
                            </a-col>
                            <a-col :span="12" class="text-right">
                                <a-button type="primary" html-type="submit" class="px-25">SUBMIT</a-button>
                            </a-col>
                        </a-row>
                    </a-form>
                </a-card>
                <a-card :bordered="false" id="payment" class="header-solid mb-24">
                    <template #title>
                        <a-row type="flex" align="middle">
                            <a-col :span="24" :md="12">
                                <h6 class="font-semibold m-0">Payment Methods</h6>
                            </a-col>
                            <a-col :span="24" :md="12" style="display: flex; align-items: center; justify-content: flex-end">
                                <a-button type="primary">
                                    ADD NEW CARD
                                </a-button>
                            </a-col>
                        </a-row>
                    </template>
                    <a-row :gutter="[24, 24]">
                        <a-col :span="24" :md="12">
                            <a-card class="payment-method-card">
                                <img src="images/logos/mastercard-logo.png" alt="">
                                <h6 class="card-number">**** **** **** 7362</h6>
                                <a-button type="link">
                                    <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path class="fill-gray-7" d="M13.5858 3.58579C14.3668 2.80474 15.6332 2.80474 16.4142 3.58579C17.1953 4.36683 17.1953 5.63316 16.4142 6.41421L15.6213 7.20711L12.7929 4.37868L13.5858 3.58579Z"/>
                                        <path class="fill-gray-7" d="M11.3787 5.79289L3 14.1716V17H5.82842L14.2071 8.62132L11.3787 5.79289Z"/>
                                    </svg>
                                </a-button>
                            </a-card>
                        </a-col>
                        <a-col :span="24" :md="12">
                            <a-card class="payment-method-card">
                                <img src="images/logos/visa-logo.png" alt="">
                                <h6 class="card-number">**** **** **** 3288</h6>
                                <a-button type="link">
                                    <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path class="fill-gray-7" d="M13.5858 3.58579C14.3668 2.80474 15.6332 2.80474 16.4142 3.58579C17.1953 4.36683 17.1953 5.63316 16.4142 6.41421L15.6213 7.20711L12.7929 4.37868L13.5858 3.58579Z"/>
                                        <path class="fill-gray-7" d="M11.3787 5.79289L3 14.1716V17H5.82842L14.2071 8.62132L11.3787 5.79289Z"/>
                                    </svg>
                                </a-button>
                            </a-card>
                        </a-col>
                    </a-row>
                </a-card>
            </a-col>

        </a-row>
	</div>
</template>

<script>
import { getUserProfile, updateUserProfile } from '../api/user'
import CardProfileInformation from '../components/Cards/CardProfileInformation'

export default ({
    components: {
        CardProfileInformation
    },
    data() {
        return {
            form: this.$form.createForm(this),
            profileHeaderBtns: 'overview',
            userData: []
        }
    },
    beforeMount() {
        getUserProfile().then(res => {
            console.log(res.data)
            this.userData = res.data.data
            this.$forceUpdate()
        })
    },
    methods: {
        jump() {
            this.$router.push('/avatar')
        },
        handleChange(info) {
            if (info.file.status !== 'uploading') {
                console.log(info.file, info.fileList)
            }
            if (info.file.status === 'done') {
                this.$message.success(`${info.file.name} file uploaded successfully`)
            } else if (info.file.status === 'error') {
                this.$message.error(`${info.file.name} file upload failed.`)
            }
        },
        handleSubmit(e) {
            e.preventDefault()
            this.form.validateFields((err, values) => {
                if (!err) {
                    console.log('Received values of form: ', values)
                    updateUserProfile(values).then(res => {
                        console.log(res.data)
                        getUserProfile().then(res => {
                            console.log(res.data)
                            this.userData = res.data.data
                            this.$forceUpdate()
                        })
                        this.form.resetFields()
                        this.$message.success('Profile updated successfully.')
                    })
                }
            })
        }
    }
})

</script>

<style>
</style>
