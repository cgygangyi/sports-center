<template>

	<!-- Profile Information Card -->
	<a-card :bordered="false" class="header-solid h-full card-profile-information" :bodyStyle="{paddingTop: 0, paddingBottom: '16px' }" :headStyle="{paddingRight: 0,}">

        <a-button type="link" slot="extra" @click="showModal">
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
                initialValues='name= Edit to change your profile'
            >
                <a-form-item class="mb-10">
                    <a-input
                        v-decorator="[
                            'email',
                            { rules: [{ required: true, message: 'Please input your email!' }] },
                            ]"
                        placeholder="Email"
                        :value="email"
                    >
                    </a-input>
                </a-form-item>
                <a-form-item class="mb-10">
                    <a-input
                        v-decorator="[
                            'name',
                            { rules: [{ required: true, message: 'Please input your name!' }] },
                            ]"
                        placeholder="Name"
                        :value="name"
                    >
                    </a-input>
                </a-form-item>
                <a-form-item class="mb-10">
                    <a-input
                        v-decorator="[
                            'phoneNumber',
                            { rules: [{ required: true, message: 'Please input your phoneNumber!' }] },
                            ]"
                        placeholder="phone number"
                        :value="phoneNumber"
                    >
                    </a-input>
                </a-form-item>
                <a-form-item class="mb-10">
                    <a-input
                        v-decorator="['age']"
                        type="number"
                        placeholder="Age"
                        :value="age"
                    >
                    </a-input>
                </a-form-item>
                <a-form-item class="mb-10">
                    <a-select
                        v-decorator="['sex']"
                        placeholder="Select a option and change input text above"
                        @change="handleSelectChange"
                        :value="sex"
                    >
                        <a-select-option value="Male">
                            Male
                        </a-select-option>
                        <a-select-option value="Female">
                            Female
                        </a-select-option>
                    </a-select>
                </a-form-item>
            </a-form>
        </a-modal>

		<a-descriptions :title="username" :column="1">
			<a-descriptions-item label="Full Name">
				{{ name }}
			</a-descriptions-item>
			<a-descriptions-item label="Mobile">
				{{ phoneNumber }}
			</a-descriptions-item>
			<a-descriptions-item label="Email">
				{{ email }}
			</a-descriptions-item>
			<a-descriptions-item label="Age" id="age">
				{{ age }}
			</a-descriptions-item>
            <a-descriptions-item label="Gender">
                {{ sex }}
            </a-descriptions-item>
		</a-descriptions>

        <hr class="my-25">

        <p class="text-dark">
            Perhaps they will understand Maupassant's words that life may not be as good as you think, but it will not be as bad as you think. "People are more fragile and strong than you can imagine. Sometimes, a fragile sentence can bring tears to your face, and sometimes you find yourself biting your teeth and walking a long way.".
        </p>
	</a-card>
	<!-- / Profile Information Card -->

</template>

<script>

import { editUserProfile } from '@/api/user'

export default ({
    props: {
        id: {
            type: Number,
            default: 0
        },
        username: {
            type: String,
            default: ''
        },
        email: {
            type: String,
            default: ''
        },
        password: {
            type: String,
            default: ''
        },
        name: {
            type: String,
            default: ''
        },
        age: {
            type: Number,
            default: 0
        },
        phoneNumber: {
            type: String,
            default: ''
        },
        sex: {
            type: String,
            default: ''
        }
    },
    data() {
        return {
            ModalText: 'Content of the modal',
            visible: false,
            confirmLoading: false
        }
    },
    beforeCreate() {
        this.form = this.$form.createForm(this, { name: 'profile' })
        this.form.setFieldsValue({ email: this.email })
    },
    methods: {
        showModal() {
            this.visible = true
        },
        handleOk() {
            this.ModalText = 'The modal will be closed after two seconds'
            this.confirmLoading = true
            const values = this.form.getFieldsValue()
            editUserProfile(values).then(res => {
                console.log(res)
            })
            setTimeout(() => {
                this.visible = false
                this.confirmLoading = false
                // eslint-disable-next-line vue/no-mutating-props
                this.age = 20
            }, 500)
        },
        handleCancel(e) {
            console.log('Clicked cancel button')
            this.visible = false
        }
    }

})

</script>
