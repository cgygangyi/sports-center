<template>
    <div>

        <a-card :bordered="false" class="card-product header-solid mb-24">
            <template #title>
                <h6>Item Details</h6>
            </template>

            <a-row type="flex" :gutter="[24]">
                <a-col :span="24" :lg="12" :xl="10" class="col-gallery">
                    <img class="gallery-img shadow-3 img-contain" :src="this.itemData.image" height="100%">
                </a-col>

                <a-col :span="24" :lg="12" :xl="{ span: 12, offset: 2 }" class="col-info">

                    <h3>{{ this.itemData.itemName }}</h3>

                    <h5 class="mb-0 mt-20 font-semibold">Price: {{ this.itemData.price }} CNY</h5>

                    <h6 class="mt-20 font-semibold"><small>Description:</small></h6>

                    <li><p class="mb-5 text-lg text-muted">{{ this.itemData.info }}</p></li>
                    <a-form
                    :form="form"
                    @submit="handleSubmit"
                    :hideRequiredMark="true"
                    >
                        <a-row :gutter="[24]">
                            <a-col :span="24">
                                <a-form-item class="mb-10" label="Quantity" :colon="false">
                                    <a-input-number id="count" :defaultValue="1" :min="1" :max="10" />
                                </a-form-item>
                            </a-col>
                            <a-col :span="8">
                                <a-button type="primary" @click="showModal">
                                    PURCHASE
                                </a-button>
                                <a-modal v-model="visible" title="Please select a paying method" @ok="handleOk">
                                    <a-tabs default-active-key="1" @change="callback">
                                        <a-tab-pane key="1" tab="Card">
                                            <a-select default-value="" style="width: 80%" @change="handleChange">
                                                <a-select-option value="jack">
                                                    Jack
                                                </a-select-option>
                                                <a-select-option value="lucy">
                                                    Lucy
                                                </a-select-option>
                                                <a-select-option value="disabled" disabled>
                                                    Disabled
                                                </a-select-option>
                                                <a-select-option value="Yiminghe">
                                                    yiminghe
                                                </a-select-option>
                                            </a-select>
                                        </a-tab-pane>
                                        <a-tab-pane key="2" tab="Cash" force-render>
                                            Content of Tab Pane 2
                                        </a-tab-pane>
                                    </a-tabs>
                                </a-modal>
                            </a-col>
                        </a-row>
                    </a-form>

                </a-col>

            </a-row>
            <a-row type="flex" :gutter="[24]" class="mt-50">
                <a-col :span="24">
                    <a-list
                        class="comment-list"
                        :header="`${comments.length} replies`"
                        item-layout="horizontal"
                        :data-source="comments"
                    >
                        <a-list-item slot="renderItem" slot-scope="item">
                            <a-comment :author="item.username" :avatar="item.image">
                                <p slot="content">
                                    {{ item.info }}
                                </p>
                                <a-tooltip slot="datetime">
                                    <span>{{ item.commentTime }}</span>
                                </a-tooltip>
                            </a-comment>
                        </a-list-item>
                    </a-list>

                </a-col>
            </a-row>

        </a-card>

    </div>
</template>

<script>
import moment from 'moment'
import { getItemInfo } from '@/api/item'
import { getItemCommentById } from '@/api/itemComment'
import { makeItemOrder } from '@/api/order'

export default ({
    query: {
        id: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            visible: false,
            form: this.$form.createForm(this),
            itemData: {},
            description: [],
            comments: [],
            moment

        }
    },
    beforeMount() {
        getItemInfo(this.$route.query.id).then(res => {
            this.itemData = res.data.data
            console.log(this.itemData)
        })
        getItemCommentById(this.$route.query.id).then(res => {
            this.comments = res.data.data
            console.log(this.comments)
        })
    },

    methods: {
        showModal() {
            this.visible = true
        },
        handleOk(e) {
            console.log(e)
            this.form.validateFields((err, values) => {
                if (!err) {
                    // add count into valuse, in json format
                    values.number = document.getElementById('count').value
                    console.log('Received values of form: ', values)
                    makeItemOrder(this.itemData.id, values).then(res => {
                        console.log(res)
                        this.$message.success('Order Success')
                    })
                } else {
                    console.log(err)
                }
            })
            this.visible = false
        },
        handleSubmit (e) {
            e.preventDefault()
        }
    }
})

</script>

<style>
</style>
