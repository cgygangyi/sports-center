<template>
    <div>
        <upload></upload>
        <a-carousel arrows>
            <div
                slot="prevArrow"
                slot-scope="props"
                class="custom-slick-arrow"
                style="left: 10px;zIndex: 1"
            >
                <a-icon type="left-circle" />
            </div>
            <div slot="nextArrow" slot-scope="props" class="custom-slick-arrow" style="right: 10px">
                <a-icon type="right-circle" />
            </div>
            <div><img src="images/carousel-1.jpeg" alt="" width="1400px"></div>
            <div><img src="images/carousel-2.jpeg" alt="" height="1400px"></div>
            <div><img src="images/carousel-3.jpeg" alt="" height="1400px"></div>
        </a-carousel>
        <a-row :gutter="24" style="margin-bottom: 20px; margin-top: 20px">
            <a-col :span="24" :lg="12" :xl="6" class="my-24" v-for="(stat, index) in stats" :key="index">
                <WidgetCounter
                    :title="stat.title"
                    :value="stat.value"
                    :prefix="stat.prefix"
                    :suffix="stat.suffix"
                    :icon="stat.icon"
                    :status="stat.status"
                ></WidgetCounter>
            </a-col>
        </a-row>
        <a-col :span="24" :lg="24" class="mb-24">

            <!-- Orders History Timeline Card -->
            <CardOrderHistory></CardOrderHistory>
            <!-- / Orders History Timeline Card -->

        </a-col>
    </div>
</template>

<script>
import WidgetCounter from '../components/Widgets/WidgetCounter' ;
import CardOrderHistory from '../components/Cards/CardOrderHistory' ;

// Counter Widgets stats
const stats = [
    {
        title: "Real-time attendance",
        value: 4,
        icon: `
						<svg width="22" height="22" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path d="M9 6C9 7.65685 7.65685 9 6 9C4.34315 9 3 7.65685 3 6C3 4.34315 4.34315 3 6 3C7.65685 3 9 4.34315 9 6Z" fill="#111827"/>
							<path d="M17 6C17 7.65685 15.6569 9 14 9C12.3431 9 11 7.65685 11 6C11 4.34315 12.3431 3 14 3C15.6569 3 17 4.34315 17 6Z" fill="#111827"/>
							<path d="M12.9291 17C12.9758 16.6734 13 16.3395 13 16C13 14.3648 12.4393 12.8606 11.4998 11.6691C12.2352 11.2435 13.0892 11 14 11C16.7614 11 19 13.2386 19 16V17H12.9291Z" fill="#111827"/>
							<path d="M6 11C8.76142 11 11 13.2386 11 16V17H1V16C1 13.2386 3.23858 11 6 11Z" fill="#111827"/>
						</svg>`,
    },
] ;


export default ({
    components: {
        WidgetCounter,
        CardOrderHistory,
    },
    data() {
        return {
            stats,
        }
    },

    beforeCreate() {
    },

    beforeMount() {
    },

    methods: {
    },
})



</script>

<style scoped>
/* For demo */
.ant-carousel >>> .slick-slide {
    text-align: center;
    height: 580px;
    line-height: 580px;
    background: #364d79;
    overflow: hidden;
}

.ant-carousel >>> .custom-slick-arrow {
    width: 25px;
    height: 25px;
    font-size: 25px;
    color: #fff;
    background-color: rgba(31, 45, 61, 0.41);
    opacity: 0.3;
}
.ant-carousel >>> .custom-slick-arrow:before {
    display: none;
}
.ant-carousel >>> .custom-slick-arrow:hover {
    opacity: 0.5;
}

.ant-carousel >>> .slick-slide h3 {
    color: #fff;
}
</style>
