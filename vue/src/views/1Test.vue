<template>
    <a-form
        id="components-form-demo-validate-other"
        :form="form"
        v-bind="formItemLayout"
        @submit="handleSubmit"
    >

        <a-row :gutter="[24]">
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
                <a-form-item class="mb-10" label="Address" :colon="false">
                    <a-input
                        v-decorator="[
                                            'address',
                                            { rules: [{ required: true, message: 'Please input the address!' }] },
                                        ]"
                        placeholder="Address"
                    >
                    </a-input>
                </a-form-item>
            </a-col>
            <a-col :span="12">
                <a-form-item class="mb-10" label="Type" :colon="false">
                    <a-input
                        v-decorator="['type',
                                            { rules: [{ required: true, message: 'Please input your name!' }] },
                                        ]"
                        placeholder="Type"
                    >
                    </a-input>
                </a-form-item>
            </a-col>
            <a-col :span="12">
                <a-form-item class="mb-10" label="Price" :colon="false">
                    <a-input
                        v-decorator="['price']"
                        type="number"
                        placeholder="Price"
                    >
                    </a-input>
                </a-form-item>
            </a-col>
        </a-row>

        <a-form-item label="Upload">
            <a-upload
                v-decorator="[
          'upload',
          {
            valuePropName: 'fileList',
            getValueFromEvent: normFile,
          },
        ]"
                name="logo"
                action="/upload.do"
                list-type="picture"
            >
                <a-button> <a-icon type="upload" /> Click to upload </a-button>
            </a-upload>
        </a-form-item>
        <a-form-item :wrapper-col="{ span: 12, offset: 6 }">
            <a-button type="primary" html-type="submit">
                Submit
            </a-button>
        </a-form-item>
    </a-form>
</template>

<script>
import { addNewVenue } from '@/api/venue'

export default {
    data: () => ({
        formItemLayout: {
            labelCol: { span: 6 },
            wrapperCol: { span: 14 }
        }
    }),
    beforeCreate() {
        this.form = this.$form.createForm(this, { name: 'validate_other' })
    },
    methods: {
        handleSubmit(e) {
            e.preventDefault()
            this.form.validateFields((err, values) => {
                if (!err) {
                    values.upload = values.upload[0].thumbUrl
                    // delete data:image/png;base64, at the beginning of the string
                    values.upload = values.upload.slice(22)
                    console.log('Received values of form: ', values)
                    addNewVenue(values).then(() => {
                        this.$message.success('Venue added successfully')
                    })
                }
            })
        },
        normFile(e) {
            console.log('Upload event:', e)
            if (Array.isArray(e)) {
                return e
            }
            return e && e.fileList
        }
    }
}
</script>
<style>
#components-form-demo-validate-other .dropbox {
    height: 180px;
    line-height: 1.5;
}
</style>
