<template>
    <div>
        <a-row :gutter="24" type="flex">
            <a-col :span="24" class="mb-24">
                <AdminTable
                    :data="this.venueData"
                    :columns="venueColumns"
                    title="Venues table"
                ></AdminTable>
            </a-col>
        </a-row>
    </div>
</template>

<script>

import AdminTable from '../../components/Cards/AdminTable.vue'

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
    {
        title: 'ADDRESS',
        dataIndex: 'address'
    },
    {
        title: 'Price',
        dataIndex: 'price'
    },
    {
        title: '',
        scopedSlots: { customRender: 'editBtn' },
        width: 50
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
