<template>
    <div>
        <a-card>
            <a-row>
                <a-col>
                    <button>{{ day0 }}</button>
                </a-col>
                <a-col>
                    <button>{{ day1 }}</button>
                </a-col>
                <a-col>
                    <button>{{ day2 }}</button>
                </a-col>
                <a-col>
                    <button>{{ day3 }}</button>
                </a-col>
            </a-row>
            <TimePicker :data="ModalData"></TimePicker>
        </a-card>
    </div>
</template>

<script>

import { getAllStatesByDay, getDay } from '@/api/venueState'
import TimePicker from '@/components/Cards/TimePicker.vue'

export default ({
    components: {
        TimePicker
    },
    beforeMount() {
        for (let i = 0; i < 4; i++) {
            getDay(i).then((response) => {
                if (i === 0) {
                    this.day0 = response.data.data
                } else if (i === 1) {
                    this.day1 = response.data.data
                } else if (i === 2) {
                    this.day2 = response.data.data
                } else {
                    this.day3 = response.data.data
                }
            }).catch((error) => {
                console.log(error)
            })
        }
        getAllStatesByDay(0).then((response) => {
            this.ModalData = response.data.data
            console.log(this.ModalData)
        }).catch((error) => {
            console.log(error)
        })
    },
    data() {
        return {
            day0: '',
            day1: '',
            day2: '',
            day3: '',
            numberVenues: 0,
            ModalData: []
        }
    }
})

</script>

<style>
</style>
