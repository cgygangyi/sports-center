<!--<template>-->
<!--    <div>-->
<!--        <a-row :gutter="24" type="flex">-->
<!--            <a-col :span="24" class="mb-24">-->
<!--                <AdminTable-->
<!--                    :data="stateData"-->
<!--                    :columns="stateColumns"-->
<!--                    title="State table"-->
<!--                ></AdminTable>-->
<!--            </a-col>-->
<!--        </a-row>-->
<!--    </div>-->
<!--</template>-->

<!--<script>-->

<!--import AdminTable from '../../components/Cards/AdminTable.vue'-->

<!--import { getAllStates } from '../../api/venueState'-->

<!--const stateColumns = [-->
<!--    {-->
<!--        title: 'ID',-->
<!--        dataIndex: 'id'-->
<!--    },-->
<!--    {-->
<!--        title: 'Venue Id',-->
<!--        dataIndex: 'venueId'-->
<!--    },-->
<!--    {-->
<!--        title: 'Open',-->
<!--        dataIndex: 'open'-->
<!--    },-->
<!--    {-->
<!--        title: 'Free',-->
<!--        dataIndex: 'free'-->
<!--    },-->
<!--    {-->
<!--        title: 'Begin',-->
<!--        dataIndex: 'begin'-->
<!--    },-->
<!--    {-->
<!--        title: 'End',-->
<!--        dataIndex: 'end'-->
<!--    },-->
<!--    {-->
<!--        title: '',-->
<!--        scopedSlots: { customRender: 'editBtn' },-->
<!--        width: 50-->
<!--    }-->
<!--]-->

<!--export default ({-->
<!--    components: {-->
<!--        AdminTable-->
<!--    },-->
<!--    data() {-->
<!--        return {-->
<!--            stateData: [],-->

<!--            stateColumns: stateColumns-->
<!--        }-->
<!--    },-->

<!--    beforeCreate() {-->
<!--        getAllStates().then((response) => {-->
<!--            this.stateData = response.data-->
<!--            console.log(this.stateData)-->
<!--        })-->
<!--    }-->
<!--})-->

<!--</script>-->

<!--<style>-->
<!--</style>-->
<template>
    <div>
        <a-row :gutter="24" type="flex">
            <a-col :span="24" class="mb-24">
                <AdminTable
                    :data="this.venueData"
                    :columns="venueColumns"
                    title="Venues's state table"
                ></AdminTable>
            </a-col>
        </a-row>
    </div>
</template>

<script>

import AdminTable from '@/components/Cards/AdminTable.vue'

import { getAllVenues } from '@/api/venue'

const venueColumns = [
    {
        title: 'ID',
        dataIndex: 'id'
    },
    {
        title: 'Name',
        dataIndex: 'name'
    },
    // {
    //     title: 'ADDRESS',
    //     dataIndex: 'address'
    // },
    // {
    //     title: 'Price',
    //     dataIndex: 'price'
    // },
    {
        title: 'Change state for this venue',
        scopedSlots: { customRender: 'changeStateBtn' }
    }
]

export default ({
    components: {
        AdminTable
    },
    data() {
        return {
            venueData: [],

            venueColumns: venueColumns
        }
    },

    beforeCreate() {
        getAllVenues().then((response) => {
            this.venueData = response.data
            console.log(this.venueData)
        })
    }
})

</script>

<style>
</style>
