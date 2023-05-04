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
                            <a-anchor-link href="#change-password">
                                <div slot="title" class="ant-list-item-meta">
                                    <a-icon type="unlock" theme="filled" class="text-gray-6 text-lg" />
                                    <h4 class="ant-list-item-meta-title">
                                        <span class="font-regular">Change Password</span>
                                    </h4>
                                </div>
                            </a-anchor-link>
                            <a-anchor-link href="#2fa">
                                <div slot="title" class="ant-list-item-meta">
                                    <a-icon type="safety-certificate" theme="filled" class="text-gray-6 text-lg" />
                                    <h4 class="ant-list-item-meta-title">
                                        <span class="font-regular">2FA</span>
                                    </h4>
                                </div>
                            </a-anchor-link>
                            <a-anchor-link href="#delete-account">
                                <div slot="title" class="ant-list-item-meta">
                                    <a-icon type="delete" theme="filled" class="text-gray-6 text-lg" />
                                    <h4 class="ant-list-item-meta-title">
                                        <span class="font-regular">Delete Account</span>
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
                            <a-col :span="24" :md="12" class="col-info">
                                <a-avatar :size="74" shape="square" src="images/face-1.jpg" />
                                <div class="avatar-info">
                                    <h4 class="font-semibold m-0">{{username}}</h4>
                                </div>
                            </a-col>
                        </a-row>
                    </template>
                </a-card>

                <!-- Basic Info card -->
                <a-card :bordered="false" id="basic-info" class="header-solid mb-24">
                    <template #title>
                        <h5 class="mb-0 font-semibold">Basic Info</h5>
                    </template>
                    <a-col :span="24" :md="24" class="mb-24">
                        <CardProfileInformation
                            :id="id"
                            :username="username"
                            :age="age"
                            :email="email"
                            :name="name"
                            :password="password"
                            :phoneNumber="phoneNumber"
                            :sex="sex"
                        ></CardProfileInformation>
                    </a-col>
                </a-card>
                <!-- / Basic Info card -->

                <!-- Change Password card -->
                <a-card :bordered="false" id="change-password" class="header-solid mb-24">
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
                <!-- / Change Password card -->

                <!-- Two-factor authentication card -->
                <a-card :bordered="false" id="2fa" class="header-solid mb-24">
                    <template #title>
                        <h5 class="mb-0 font-semibold">Two-factor authentication</h5>
                    </template>
                    <a-tag slot="extra" color="success" class="ant-tag-success px-10 py-5 font-bold">ENABLED</a-tag>
                    <a-form
                        :hideRequiredMark="true"
                    >
                        <a-row type="flex" align="middle">
                            <a-col>
                                <h6 class="font-regular mb-0">Email</h6>
                            </a-col>
                            <a-col class="ml-auto">
                                <span class="mr-15">841359795@qq.com</span>
                                <a-button size="small" class="font-bold px-25">EDIT</a-button>
                            </a-col>
                        </a-row>
                        <hr class="gradient-line">
                        <a-row type="flex" align="middle">
                            <a-col>
                                <h6 class="font-regular mb-0">Phone number</h6>
                            </a-col>
                            <a-col class="ml-auto">
                                <span class="mr-15">No Phone Number</span>
                                <a-button size="small" class="font-bold px-25">ADD</a-button>
                            </a-col>
                        </a-row>
                        <hr class="gradient-line">
                    </a-form>
                </a-card>
                <!-- / Two-factor authentication card -->

                <!-- Delete Account card -->
                <a-card :bordered="false" id="delete-account" class="header-solid mb-24">
                    <template #title>
                        <h5 class="font-semibold">Delete Account</h5>
                        <p class="font-regular">Once you delete your account, there is no going back. Please be certain.</p>
                    </template>
                    <a-form
                        id="components-form-demo-normal-login"
                        class="login-form list-settings-sessions"
                        :hideRequiredMark="true"
                    >
                        <a-row type="flex" align="middle">
                            <a-col style="min-width: 40px;" class="text-center">
                                <a-switch></a-switch>
                            </a-col>
                            <a-col class="pl-15">
                                <p class="mb-0 font-semibold">Confirm</p>
                                <small class="text-dark">I want to delete my account.</small>
                            </a-col>
                            <a-col :span="24" :md="12" class="ml-auto" style="display: flex; align-items: center; justify-content: flex-end">
                                <a-button>
                                    DEACTIVATE
                                </a-button>
                                <a-button type="danger" class="ml-10">
                                    DELETE ACCOUNT
                                </a-button>
                            </a-col>
                        </a-row>
                    </a-form>
                </a-card>
                <!-- / Delete Account card -->

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
            id: 1,
            username: '',
            age: 0,
            email: '',
            name: '',
            password: 0,
            phoneNumber: '',
            sex: '',
            orders: []
        }
    },
    beforeMount() {
        getUserProfile().then(res => {
            console.log(res.data)
            this.id = res.data.data.id
            this.username = res.data.data.username
            this.age = res.data.data.age
            this.email = res.data.data.email
            this.name = res.data.data.name
            this.phoneNumber = res.data.data.phoneNumber
            if (res.data.data.sex === 1) {
                this.sex = 'Male'
            } else {
                this.sex = 'Female'
            }
            // refresh
            this.$forceUpdate()
        })
    },
    methods: {
        handleSubmit(e) {
            e.preventDefault()
            this.form.validateFields((err, values) => {
                if (!err) {
                    console.log('Received values of form: ', values)
                    updateUserProfile(values).then(res => {
                        console.log(res.data)
                        this.$message.success('Profile updated successfully.')
                    })
                }
            })
        },
        fake() {
            localStorage.removeItem('token')
            this.$router.push('/home')
            // refresh the page
            window.location.reload()
            this.$message.success('Password updated successfully. Please login again.')
        }
    }
})

</script>

<style>
</style>
