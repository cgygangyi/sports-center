<template>
    <div>

        <a-card :bordered="false" class="card-product header-solid mb-24">
            <template #title>
                <h6>Item Details</h6>
            </template>

            <a-row type="flex" :gutter="[24]">
                <a-col :span="24" :lg="12" :xl="10" class="col-gallery">
                    <img class="gallery-img shadow-3 img-contain" :src="this.itemData.image">
                </a-col>

                <a-col :span="24" :lg="12" :xl="{ span: 12, offset: 2 }" class="col-info">

                    <h3>{{ this.itemData.itemName }}</h3>

                    <h5 class="mb-0 mt-20 font-semibold">Price: {{ this.itemData.price }} CNY</h5>

                    <h6 class="mt-20 font-semibold"><small>Description:</small></h6>

                    <li><p class="mb-5 text-lg text-muted">{{ this.itemData.info }}</p></li>

                    <a-row :gutter="[24]">
                        <a-col :span="8">
                            <a-button type="primary" block @click="showModal">BOOK</a-button>
                            <a-modal
                                title="Booking"
                                :visible="visible"
                                :confirm-loading="confirmLoading"
                                @ok="handleOk"
                                @cancel="handleCancel"
                            >
                                <p>{{ ModalText }}</p>
                                <TimePicker :data="ModalData"></TimePicker>
                            </a-modal>
                        </a-col>
                    </a-row>

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
                            <a-comment :author="item.username">
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

export default ({
    query: {
        id: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            itemData: {},
            description: [],
            ModalText: 'Please click to select a time slot(just one for each choose)',
            ModalData: [],
            visible: false,
            confirmLoading: false,
            comments: [],
            moment

        }
    },
    beforeMount() {
        console.log(this.$route.query.id)
        getItemInfo(this.$route.query.id).then(res => {
            this.itemData = res.data.data
            console.log(this.itemData)
        })
    },

    methods: {
        showModal() {
        },
        handleOk(e) {
        },
        handleCancel(e) {
            console.log('Clicked cancel button')
            this.visible = false
        }
    }
})

</script>

<style>
</style>
