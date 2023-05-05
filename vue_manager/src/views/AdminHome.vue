<template>
    <div>

        <!-- Charts page head -->
        <a-row :gutter="24" type="flex" align="stretch">
            <a-col :span="24" :lg="12" class="mb-24">
                <h5 class="font-semibold">Charts</h5>
                <p>
                    Charts on this page use Chart.js - Simple yet flexible JavaScript charting for designers &amp; developers.
                </p>

            </a-col>
        </a-row>
        <!-- / Charts page head -->

        <!-- Charts -->
        <a-row :gutter="24" type="flex" align="stretch">
            <a-col :span="24" :lg="12" class="mb-24">
                <a-card :bordered="false" class="header-solid" :bodyStyle="{padding: '0 40px 40px'}">
                    <template #title>
                        <h6>Doughnut chart</h6>
                    </template>
                    <ChartDoughnut></ChartDoughnut>
                </a-card>
            </a-col>

        </a-row>
        <!-- / Charts -->

    </div>
</template>

<script>
import ChartDoughnut from '../components/Charts/ChartDoughnut'

export default ({
    components: {
        ChartDoughnut
    },
    data() {
        return {
        }
    }
})

</script>

<style lang="scss">
</style>
