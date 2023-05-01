<template>
    <div>

        <a-card :bordered="false" class="card-product header-solid mb-24">
            <template #title>
                <h6>Product Details</h6>
            </template>

            <a-row type="flex" :gutter="[24]">
                <a-col :span="24" :lg="12" :xl="10" class="col-gallery">
                    <img class="gallery-img shadow-3 img-contain" src="images/venue-3.jpeg" alt="chair">
                </a-col>

                <a-col :span="24" :lg="12" :xl="{ span: 12, offset: 2 }" class="col-info">

                    <h3>{{ this.venueData.name }}</h3>

                    <div class="rating">
                        <a-icon type="star" theme="filled" />
                        <a-icon type="star" theme="filled" />
                        <a-icon type="star" theme="filled" />
                        <a-icon type="star" theme="filled" />
                        <a-icon type="star" />
                    </div>

                    <h5 class="mb-0 mt-20 font-semibold">Price: {{ this.venueData.price }} (CNY/hour)</h5>
                    <h5 class="mb-0 mt-20 font-semibold">address: {{ this.venueData.address }}</h5>

                    <h6 class="mt-20 font-semibold"><small>Description:</small></h6>

                    <ul v-for="des in description" :key="des">
                        <li><p class="mb-5 text-lg text-muted">{{ des }}</p></li>
                    </ul>

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
                        <a-list-item slot="renderItem" slot-scope="item, index">
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

export default ({
    components: {
    },
    query: {
        id: {
            type: String,
            required: true,
        },
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

        }
    },
    beforeMount() {
        this.getItemData();
        this.getComments();
    },

    methods: {
        showModal() {
            if (localStorage.getItem("token") === null || localStorage.getItem("token") === '') {
                this.$message.warning("Please login first!")
                return
            }
            this.ModalText = 'Please click to select a time slot(just one for each choose)';
            getVenueTime(this.$route.query.id).then((response) => {
                console.log(response);
                if (response.data === '') {
                    this.$message.warning("Please login first!")
                }
                else {
                    this.ModalData = response.data;
                    this.visible = true;
                }
                console.log(this.ModalData);
            }).catch((error) => {
                console.log(error);
            });
        },
        handleOk(e) {
            let id = sessionStorage.getItem("chosen");
            bookVenue(id).then((response) => {
                console.log(response);
                if (response.data === '') {
                    this.$message.warning("Please login first!")
                }
                else {
                    this.ModalText = 'Booking......';
                    this.confirmLoading = true;
                    setTimeout(() => {
                        this.visible = false;
                        this.confirmLoading = false;
                        this.$message.success("Successfully booked!")
                    }, 1000);
                }
            }).catch((error) => {
                console.log(error);
            });


        },
        handleCancel(e) {
            console.log('Clicked cancel button');
            this.visible = false;
        },
    }
})

</script>

<style lang="scss">
</style>
