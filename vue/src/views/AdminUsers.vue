<!--
	This is the tables page, it uses the dashboard layout in:
	"./layouts/Dashboard.vue" .
 -->

<template>
    <div>
        <a-row :gutter="24" type="flex">
            <a-col :span="24" class="mb-24">
                <CardVenueTable
                    :data="this.userData"
                    :columns="userColumns"
                    title="Users Table"
                ></CardVenueTable>
            </a-col>
        </a-row>
    </div>
</template>

<script>

import CardVenueTable from '../components/Cards/CardVenueTable' ;

import {getAllUsers} from "@/api/user";

const userColumns = [
    {
        title: 'ID',
        dataIndex: 'id',
    },
    {
        title: 'Username',
        dataIndex: 'username',
    },
    {
        title: 'Email',
        dataIndex: 'email',
    },
    {
        title: 'Name',
        dataIndex: 'name',
    },
    {
        title: 'Phone Number',
        dataIndex: 'phoneNumber',
    },
    {
        title: 'Age',
        dataIndex: 'age',
    },
    {
        title: 'Sex',
        dataIndex: 'sex',
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
            userData: [],

            userColumns: userColumns,
        }
    },

    beforeCreate() {
        getAllUsers().then((response) => {
            this.userData = response.data;
            console.log(this.userData)
        });
    },
})

</script>

<style lang="scss">
</style>
