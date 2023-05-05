<template>
	<div>
        <div class="mx-auto mt-50" style="max-width: 800px;">

            <div class="mb-24">
                <a-card :bordered="false" class="header-solid" :bodyStyle="{paddingTop: 0 }" :headStyle="{paddingBottom: '0' }">
                    <template #title>
                        <h5 class="mb-0">Sign up</h5>
                    </template>
                    <a-form
                        :form="form"
                        @submit="handleSubmit"
                    >
                        <a-row :gutter="[24]">
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Username" :colon="false">
                                    <a-input
                                        v-decorator="[
                                            'username',
                                            { rules: [{ required: true, message: 'Please input your username!' },
                                                        { max: 20, message: 'Max length of username is 20'},
                                                        { min: 4, message: 'Min length of username is 4'}] },
                                        ]"
                                        placeholder="Username"
                                    >
                                    </a-input>
                                </a-form-item>
                            </a-col>
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Email Address" :colon="false">
                                    <a-input
                                        v-decorator="[
                                            'email',
                                            { rules: [{ required: true, message: 'Please input your email!' }] },
                                        ]"
                                        placeholder="Email"
                                    >
                                    </a-input>
                                </a-form-item>
                            </a-col>
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Password" :colon="false">
                                    <a-input
                                        v-decorator="[
                                            'password',
                                            { rules: [{ required: true, message: 'Please input your Password!' }] },
                                        ]"
                                        type="password"
                                        placeholder="******"
                                    >
                                    </a-input>
                                </a-form-item>
                            </a-col>
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Repeat Password" :colon="false">
                                    <a-input
                                        v-decorator="[
                                            'Confirm password',
                                            { rules: [{ required: true, message: 'Please input your Password!' }] },
                                        ]"
                                        type="password"
                                        placeholder="******"
                                    >
                                    </a-input>
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
                                        v-decorator="['age',{ rules: [{ required: true, message: 'Please input your age!' }] },]"
                                        type="number"
                                        placeholder="Age"
                                    >
                                    </a-input>
                                </a-form-item>
                            </a-col>
                            <a-col :span="12">
                                <a-form-item class="mb-10" label="Gender" :colon="false">
                                    <a-select
                                        v-decorator="['sex',{ rules: [{ required: true, message: 'Please input your gender!' }] },]"
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
                                <a-button type="primary" html-type="submit" class="px-25">SIGN UP</a-button>
                            </a-col>
                        </a-row>
                    </a-form>
                </a-card>
            </div>

        </div>
	</div>

</template>

<script>

import { userRegister } from '@/api/user'

export default ({
    data() {
        return {
        }
    },
    beforeCreate() {
        this.form = this.$form.createForm(this, { name: 'normal_login' })
    },
    methods: {
        handleSubmit(e) {
            e.preventDefault()
            this.form.validateFields((err, values) => {
                if (!err) {
                    userRegister(values).then(res => {
                        console.log(res)
                        if (res.data === -1) {
                            this.$message.error('username already exists')
                        } else {
                            this.$message.success('sign up successfully')
                            this.$router.push({ path: '/login' })
                        }
                    })
                    console.log('Received values of form: ', values)
                }
            })
        }
    }
})

</script>

<style>
</style>
