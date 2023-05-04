<template>

    <div>
        <a-card :bordered="false" class="header-solid h-full mb-24" :bodyStyle="{paddingTop: '14px'}">
            <a-tabs class="tabs-sliding" default-active-key="1">
                <a-tab-pane key="1" tab="Venues">
                    <a-list
                        class="comment-list"
                        :header="`${venueComments.length} replies`"
                        item-layout="horizontal"
                        :data-source="venueComments"
                    >
                        <a-list-item slot="renderItem" slot-scope="item">
                            <p>{{ item.venueName }}</p>
                            <a-comment :author="item.username" :avatar="item.image">
                                <p slot="content">
                                    {{ item.info }}
                                </p>
                                <a-tooltip slot="datetime">
                                    <span>{{ item.commentTime }}</span>
                                </a-tooltip>
                                <a-button type="link" size="small" @click="deleteVenueComment(item.id)">
                                    <svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path class="fill-danger" fill-rule="evenodd" clip-rule="evenodd" d="M9 2C8.62123 2 8.27497 2.214 8.10557 2.55279L7.38197 4H4C3.44772 4 3 4.44772 3 5C3 5.55228 3.44772 6 4 6L4 16C4 17.1046 4.89543 18 6 18H14C15.1046 18 16 17.1046 16 16V6C16.5523 6 17 5.55228 17 5C17 4.44772 16.5523 4 16 4H12.618L11.8944 2.55279C11.725 2.214 11.3788 2 11 2H9ZM7 8C7 7.44772 7.44772 7 8 7C8.55228 7 9 7.44772 9 8V14C9 14.5523 8.55228 15 8 15C7.44772 15 7 14.5523 7 14V8ZM12 7C11.4477 7 11 7.44772 11 8V14C11 14.5523 11.4477 15 12 15C12.5523 15 13 14.5523 13 14V8C13 7.44772 12.5523 7 12 7Z" fill="#111827"/>
                                    </svg>
                                    <span class="text-danger">DELETE</span>
                                </a-button>
                            </a-comment>
                        </a-list-item>
                    </a-list>
                </a-tab-pane>
                <a-tab-pane key="2" tab="Items">
                    <a-list
                        class="comment-list"
                        :header="`${itemComments.length} replies`"
                        item-layout="horizontal"
                        :data-source="itemComments"
                    >
                        <a-list-item slot="renderItem" slot-scope="item">
                            <img :src="item.itemImage" alt="">
                            <p>{{ item.itemName }}</p>
                            <a-comment :author="item.username" :avatar="item.image">
                                <p slot="content">
                                    {{ item.info }}
                                </p>
                                <a-tooltip slot="datetime">
                                    <span>{{ item.commentTime }}</span>
                                </a-tooltip>
                                <a-button type="link" size="small" @click="deleteItemComment(item.id)">
                                    <svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path class="fill-danger" fill-rule="evenodd" clip-rule="evenodd" d="M9 2C8.62123 2 8.27497 2.214 8.10557 2.55279L7.38197 4H4C3.44772 4 3 4.44772 3 5C3 5.55228 3.44772 6 4 6L4 16C4 17.1046 4.89543 18 6 18H14C15.1046 18 16 17.1046 16 16V6C16.5523 6 17 5.55228 17 5C17 4.44772 16.5523 4 16 4H12.618L11.8944 2.55279C11.725 2.214 11.3788 2 11 2H9ZM7 8C7 7.44772 7.44772 7 8 7C8.55228 7 9 7.44772 9 8V14C9 14.5523 8.55228 15 8 15C7.44772 15 7 14.5523 7 14V8ZM12 7C11.4477 7 11 7.44772 11 8V14C11 14.5523 11.4477 15 12 15C12.5523 15 13 14.5523 13 14V8C13 7.44772 12.5523 7 12 7Z" fill="#111827"/>
                                    </svg>
                                    <span class="text-danger">DELETE</span>
                                </a-button>
                            </a-comment>
                        </a-list-item>
                    </a-list>
                </a-tab-pane>
            </a-tabs>
        </a-card>
    </div>

</template>

<script>
import { getUserItemComment, deleteItemComment } from '@/api/itemComment'
import { getUserVenueComment, deleteVenueComment } from '@/api/venueComment'

export default {
    data() {
        return {
            venueComments: [],
            itemComments: []
        }
    },
    beforeMount() {
        getUserItemComment().then(res => {
            this.itemComments = res.data.data
            console.log(this.itemComments)
        })
        getUserVenueComment().then(res => {
            this.venueComments = res.data.data
            console.log(this.venueComments)
        })
    },
    methods: {
        deleteVenueComment(id) {
            console.log(id)
            deleteVenueComment(id).then(res => {
                this.$message.success('Delete successfully')
                this.venueComments = this.venueComments.filter(item => item.id !== id)
            })
        },
        deleteItemComment(id) {
            deleteItemComment(id).then(res => {
                this.$message.success('Delete successfully')
                this.itemComments = this.itemComments.filter(item => item.id !== id)
            })
        }
    }
}

</script>

<style>
</style>
