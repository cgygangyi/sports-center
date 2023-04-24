<template>
    <div>

        <a-card :bordered="false" class="card-product header-solid mb-24">
            <template #title>
                <h6>Product Details</h6>
            </template>

            <a-row type="flex" :gutter="[24]">
                <a-col :span="24" :lg="12" :xl="10" class="col-gallery">
                    <img class="gallery-img shadow-3 img-contain" src="https://images.unsplash.com/photo-1616627781431-23b776aad6b2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;ixlib=rb-1.2.1&amp;auto=format&amp;fit=crop&amp;w=1884&amp;q=80" alt="chair">
                </a-col>

                <a-col :span="24" :lg="12" :xl="{ span: 12, offset: 2 }" class="col-info">

                    <h3>Minimal Bar Stool</h3>

                    <div class="rating">
                        <a-icon type="star" theme="filled" />
                        <a-icon type="star" theme="filled" />
                        <a-icon type="star" theme="filled" />
                        <a-icon type="star" theme="filled" />
                        <a-icon type="star" />
                    </div>

                    <h6 class="mb-0 mt-20 font-semibold">Price</h6>
                    <h5 class="font-semibold">$1,419</h5>

                    <h6 class="mt-20 font-semibold"><small>Description:</small></h6>

                    <ul>
                        <li><p class="mb-5 text-lg text-muted">The most beautiful curves of this swivel stool adds an elegant touch to any environment</p></li>
                        <li><p class="mb-5 text-lg text-muted">Memory swivel seat returns to original seat position</p></li>
                        <li><p class="mb-5 text-lg text-muted">Comfortable integrated layered chair seat cushion design</p></li>
                        <li><p class="mb-5 text-lg text-muted">Fully assembled! No assembly required</p></li>
                    </ul>

                    <a-row :gutter="[24]">
                        <a-col :span="8">
                            <a-button type="primary" block>BOOK</a-button>
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
                            <a-comment :author="item.author" :avatar="item.avatar">
                                <template slot="actions">
                                    <span v-for="action in item.actions">{{ action }}</span>
                                </template>
                                <p slot="content">
                                    {{ item.content }}
                                </p>
                                <a-tooltip slot="datetime" :title="item.datetime.format('YYYY-MM-DD HH:mm:ss')">
                                    <span>{{ item.datetime.fromNow() }}</span>
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
import moment from 'moment';
export default ({
    data() {
        return {
            comments: [
                {
                    actions: ['Reply to'],
                    author: 'Han Solo',
                    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
                    content:
                        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
                    datetime: moment().subtract(1, 'days'),
                },
                {
                    actions: ['Reply to'],
                    author: 'Han Solo',
                    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
                    content:
                        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
                    datetime: moment().subtract(2, 'days'),
                },
            ],
            moment,

        }
    },
})

</script>

<style lang="scss">
</style>
