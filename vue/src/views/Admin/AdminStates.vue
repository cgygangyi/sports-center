<!--
	This is the tables page, it uses the dashboard layout in:
	"./layouts/Dashboard.vue" .
 -->

<template>
    <div>
        <a-row :gutter="24" type="flex">
            <a-col :span="24" class="mb-24">
                <CardVenueTable
                    :data="stateData"
                    :columns="stateColumns"
                    title="State table"
                ></CardVenueTable>
            </a-col>
        </a-row>
    </div>
</template>

<script>

import CardVenueTable from '../../components/Cards/CardVenueTable.vue' ;

import {getAllStates} from "@/api/venueState";

const stateColumns = [
    {
        title: 'ID',
        dataIndex: 'id',
    },
    {
        title: 'Venue Id',
        dataIndex: 'venueId',
    },
    {
        title: 'Open',
        dataIndex: 'open',
    },
    {
        title: 'Free',
        dataIndex: 'free',
    },
    {
        title: 'Begin',
        dataIndex: 'begin',
    },
    {
        title: 'End',
        dataIndex: 'end',
    },
    {
        title: '',
        scopedSlots: { customRender: 'editBtn' },
        width: 50,
    },
];

export default ({
    components: {
        CardVenueTable,
    },
    data() {
        return {
            stateData: [],

            stateColumns: stateColumns,
        }
    },

    beforeCreate() {
        getAllStates().then((response) => {
            this.stateData = response.data;
            console.log(this.stateData)
        });
    },
})

</script>

<style lang="scss">
</style>
