<template>
    <div>
        <a-button class="editable-add-btn" @click="handleAdd">
            Add
        </a-button>
        <a-table bordered :data-source="dataSource" :columns="columns">
            <template slot="operation" slot-scope="text, record">
                <a @click="print(text,record)">Delete</a>
            </template>
        </a-table>
    </div>
</template>
<script>
export default {
    components: {
    },
    data() {
        return {
            dataSource: [
                {
                    key: '0',
                    name: 'Edward King 0',
                    age: '32',
                    address: 'London, Park Lane no. 0'
                },
                {
                    key: '1',
                    name: 'Edward King 1',
                    age: '32',
                    address: 'London, Park Lane no. 1'
                }
            ],
            count: 2,
            columns: [
                {
                    title: 'name',
                    dataIndex: 'name',
                    width: '30%',
                    scopedSlots: { customRender: 'name' }
                },
                {
                    title: 'age',
                    dataIndex: 'age'
                },
                {
                    title: 'address',
                    dataIndex: 'address'
                },
                {
                    title: 'operation',
                    dataIndex: 'operation',
                    scopedSlots: { customRender: 'operation' }
                }
            ]
        }
    },
    methods: {
        print(text, record) {
            console.log(text, record)
        }
    }
}
</script>
<style>
</style>
