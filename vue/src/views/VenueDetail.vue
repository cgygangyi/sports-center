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
                    <a-tag class=" font-bold" color="green">IN STOCK</a-tag>

                    <h6 class="mt-20 font-semibold"><small>Description:</small></h6>

                    <ul>
                        <li><p class="mb-5 text-lg text-muted">The most beautiful curves of this swivel stool adds an elegant touch to any environment</p></li>
                        <li><p class="mb-5 text-lg text-muted">Memory swivel seat returns to original seat position</p></li>
                        <li><p class="mb-5 text-lg text-muted">Comfortable integrated layered chair seat cushion design</p></li>
                        <li><p class="mb-5 text-lg text-muted">Fully assembled! No assembly required</p></li>
                    </ul>

                    <a-row :gutter="[24]">
                        <a-col :span="8">
                            <a-button type="primary" block>ADD TO CART</a-button>
                        </a-col>
                    </a-row>

                </a-col>

            </a-row>
            <a-row type="flex" :gutter="[24]" class="mt-50">
                <a-col :span="24">
                    <h6>Reviews</h6>
                    <a-table :columns="columns" :data-source="data" :pagination="false">

                        <template slot="product" slot-scope="product">
                            <h6 class="m-0">
                                <a-avatar :size="48" shape="square" :src="product.img" class="mr-10"></a-avatar>
                                {{ product.name }}
                            </h6>
                        </template>

                        <template slot="review" slot-scope="review">
                            <div class="rating">
                                <a-icon type="star" v-for="n in review" :key="n" theme="filled" />
                                <a-icon type="star" v-for="n in (5 - review)" :key="6 - n" />
                            </div>
                        </template>

                        <template slot="availability" slot-scope="availability">
                            <a-progress :percent="availability.value ? availability.value : availability" :show-info="false" :status="availability.status ? availability.status : 'normal'" />
                        </template>

                    </a-table>

                </a-col>
            </a-row>

        </a-card>

    </div>
</template>

<script>

export default ({
    data() {
        return {

            // Add To Cart form object
            form: this.$form.createForm(this, { name: 'editProduct' }),

            // Table columns
            columns: [
                {
                    title: 'PRODUCT',
                    dataIndex: 'product',
                    scopedSlots: { customRender: 'product' },
                },
                {
                    title: 'PRICE',
                    dataIndex: 'price',
                    width: 100,
                },
                {
                    title: 'REVIEW',
                    dataIndex: 'review',
                    scopedSlots: { customRender: 'review' },
                },
                {
                    title: 'AVAILABILITY',
                    scopedSlots: { customRender: 'availability' },
                    dataIndex: 'availability',
                },
                {
                    title: 'ID',
                    dataIndex: 'id',
                    width: 100,
                },
            ],

            // Table rows
            data: [
                {
                    key: '1',
                    product: {
                        name: 'Christopher Knight Home',
                        img: 'https://raw.githubusercontent.com/creativetimofficial/public-assets/master/soft-ui-design-system/assets/img/ecommerce/black-chair.jpg',
                    },
                    price: '$89.53',
                    review: 4,
                    availability: 80,
                    id: '230019',
                },
                {
                    key: '2',
                    product: {
                        name: 'Bar Height Swivel Barstool',
                        img: 'https://raw.githubusercontent.com/creativetimofficial/public-assets/master/soft-ui-design-system/assets/img/ecommerce/chair-pink.jpg',
                    },
                    price: '$99.99',
                    review: 5,
                    availability: 90,
                    id: '87120',
                },
                {
                    key: '3',
                    product: {
                        name: 'Signature Design by Ashley',
                        img: 'https://raw.githubusercontent.com/creativetimofficial/public-assets/master/soft-ui-design-system/assets/img/ecommerce/chair-steel.jpg',
                    },
                    price: '$129.00',
                    review: 4,
                    availability: {
                        value: 60,
                        status: 'exception',
                    },
                    id: '412301',
                },
                {
                    key: '4',
                    product: {
                        name: 'Modern Square',
                        img: 'https://raw.githubusercontent.com/creativetimofficial/public-assets/master/soft-ui-design-system/assets/img/ecommerce/chair-wood.jpg',
                    },
                    price: '$59.99',
                    review: 4,
                    availability: {
                        value: 40,
                        status: 'exception',
                    },
                    id: '001992',
                },
            ],

        }
    },
})

</script>

<style lang="scss">
</style>
