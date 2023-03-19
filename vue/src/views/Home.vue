<template>
    <div>
        <!-- Counter Widgets -->
        <a-row :gutter="24">
            <a-col :span="24" :lg="12" :xl="6" class="mb-24" v-for="(stat, index) in stats" :key="index">
                <!-- Widget 1 Card -->
                <WidgetCounter
                    :title="stat.title"
                    :value="stat.value"
                    :prefix="stat.prefix"
                    :suffix="stat.suffix"
                    :icon="stat.icon"
                    :status="stat.status"
                ></WidgetCounter>
                <!-- / Widget 1 Card -->
            </a-col>
        </a-row>
        <!-- / Counter Widgets -->

        <!-- Cards -->
        <a-row :gutter="24" type="flex" align="stretch">
            <a-col :span="24" :xl="12" class="mb-24">

                <!-- Information Card 1 -->
                <CardInfo
                :data="venueData"
                ></CardInfo>
                <!-- / Information Card 1 -->

            </a-col>
            <a-col :span="24" :xl="12" class="mb-24">

                <!-- Information Card 2 -->
                <CardInfo2></CardInfo2>
                <!-- / Information Card 2 -->

            </a-col>
        </a-row>
        <!-- / Cards -->

    </div>
</template>

<script>
// Counter Widgets
import WidgetCounter from '../components/Widgets/WidgetCounter' ;

// Information card 1.
import CardInfo from '../components/Cards/CardInfo' ;

// Information card 2.
import CardInfo2 from '../components/Cards/CardInfo2' ;

// Counter Widgets stats
const stats = [
    {
        title: "Real-time attendance",
        value: 3200,
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
        CardInfo,
        CardInfo2,
    },
    data() {
        return {
            stats
        }
    },
})

</script>

<style lang="scss">
</style>
