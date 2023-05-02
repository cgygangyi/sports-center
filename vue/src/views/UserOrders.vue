<template>

    <div>
        <a-row :gutter="24" type="flex">

            <!-- Calendar column -->
            <a-col :span="24" :lg="24" class="mb-24">
                <a-card class="card-calendar">
                    <FullCalendar :options="calendarOptions" />
                </a-card>
            </a-col>
            <!-- / Calendar column -->
            <a-col :span="24" :md="16" class="mb-24">
                <a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0, paddingBottom: '16px' }">
                    <h6 class="font-semibold my-20">Appointment Information</h6>
                    <a-row :gutter="[24, 24]" v-for="order in this.orders" :key="order">
                        <a-col :span="24">
                            <a-card :bordered="false" class="card-billing-info">
                                <div class="col-info">
                                    <a-descriptions :column="1">
                                        <a-descriptions-item label="ID">
                                            {{ order.id }}
                                        </a-descriptions-item>
                                        <a-descriptions-item label="Begin Time">
                                            {{ order.begin }}
                                        </a-descriptions-item>
                                        <a-descriptions-item label="End Time">
                                            {{ order.end }}
                                        </a-descriptions-item>
                                        <a-descriptions-item label="Venue Name">
                                            {{ order.name }}
                                        </a-descriptions-item>
                                        <a-descriptions-item label="Address">
                                            {{ order.address }}
                                        </a-descriptions-item>
                                    </a-descriptions>
                                        <a-collapse v-model="activeKey">
                                            <a-collapse-panel key="1" header="Comment">
                                                <a-list
                                                    v-if="comments.length"
                                                    :data-source="comments"
                                                    :header="`${comments.length} ${comments.length > 1 ? 'replies' : 'reply'}`"
                                                    item-layout="horizontal"
                                                >
                                                    {/* eslint-disable-next-line vue/no-unused-vars */}
                                                    <a-list-item slot="renderItem" slot-scope="item">
                                                        <a-comment
                                                            :content="item.content"
                                                            :datetime="item.datetime"
                                                        />
                                                    </a-list-item>
                                                </a-list>
                                                <a-comment>
                                                    <div slot="content">
                                                        <a-form-item>
                                                            <a-textarea :rows="3" :value="value" @change="handleChange" />
                                                        </a-form-item>
                                                        <a-form-item>
                                                            <a-button html-type="submit" :loading="submitting" type="white" @click="handleSubmit(order.id)">
                                                                Add Comment
                                                            </a-button>
                                                        </a-form-item>
                                                    </div>
                                                </a-comment>
                                            </a-collapse-panel>
                                        </a-collapse>

                                </div>
                                <div class="col-action">
                                    <a-button type="link" size="small">
                                        <svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-danger" fill-rule="evenodd" clip-rule="evenodd" d="M9 2C8.62123 2 8.27497 2.214 8.10557 2.55279L7.38197 4H4C3.44772 4 3 4.44772 3 5C3 5.55228 3.44772 6 4 6L4 16C4 17.1046 4.89543 18 6 18H14C15.1046 18 16 17.1046 16 16V6C16.5523 6 17 5.55228 17 5C17 4.44772 16.5523 4 16 4H12.618L11.8944 2.55279C11.725 2.214 11.3788 2 11 2H9ZM7 8C7 7.44772 7.44772 7 8 7C8.55228 7 9 7.44772 9 8V14C9 14.5523 8.55228 15 8 15C7.44772 15 7 14.5523 7 14V8ZM12 7C11.4477 7 11 7.44772 11 8V14C11 14.5523 11.4477 15 12 15C12.5523 15 13 14.5523 13 14V8C13 7.44772 12.5523 7 12 7Z" fill="#111827"/>
                                        </svg>
                                        <span class="text-danger">DELETE</span>
                                    </a-button>
                                </div>
                            </a-card>
                        </a-col>
                    </a-row>
                </a-card>
            </a-col>
            <!-- Events Column -->
            <a-col :span="24" :md="8">

                <!-- Next Event card -->
                <CardNextEvents
                    :data="eventsData" class="mb-24"
                ></CardNextEvents>
                <!-- / Next Event card -->
            </a-col>

        </a-row>
    </div>

</template>

<script>
import moment from 'moment'
import '@fullcalendar/core/vdom' // solves problem with Vite
import FullCalendar from '@fullcalendar/vue'
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from '@fullcalendar/interaction'
import CardNextEvents from '../components/Cards/CardNextEvents'
import { getUserOrders } from '@/api/order'

// Next event's list.
const eventsData = [
    {
        id: '1',
        title: 'No.1 Basketball venue',
        code: '29 April 2023, at 13:00',
        iconClass: 'text-primary',
        icon: 'calendar',
        iconBgColor: 'rgba(234,6,6,.03)'
    }
]

// Chart data.
const chartData = {
    labels: ['Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
    datasets: [{
        label: 'Visitors',
        tension: 0.5,
        pointRadius: 0,
        borderColor: '#fff',
        borderWidth: 2,
        data: [50, 45, 60, 60, 80, 65, 90, 80, 100],
        maxBarThickness: 6,
        fill: true
    }]
}

export default {
    components: {
        FullCalendar,
        CardNextEvents
    },
    data() {
        return {
            comments: [],
            submitting: false,
            value: '',
            moment,
            activeKey: ['1'],
            orders: [],

            // Next event's list.
            eventsData,

            // Chart data.
            chartData,

            // Calendar options.
            calendarOptions: {
                plugins: [dayGridPlugin, interactionPlugin],
                contentHeight: 'auto',
                initialView: 'dayGridMonth',
                headerToolbar: {
                    start: 'title', // will normally be on the left. if RTL, will be on the right
                    center: '',
                    end: 'today prev,next' // will normally be on the right. if RTL, will be on the left
                },
                selectable: true,
                editable: true,
                initialDate: '2023-04-01',
                events: [],
                views: {
                    month: {
                        titleFormat: {
                            month: 'long',
                            year: 'numeric'
                        }
                    },
                    agendaWeek: {
                        titleFormat: {
                            month: 'long',
                            year: 'numeric',
                            day: 'numeric'
                        }
                    },
                    agendaDay: {
                        titleFormat: {
                            month: 'short',
                            year: 'numeric',
                            day: 'numeric'
                        }
                    }
                }
            }

        }
    },
    watch: {
        activeKey(key) {
            console.log(key)
        }
    },
    beforeMount() {
        getUserOrders().then(res => {
            console.log(res)
            this.orders = res.data.data
            console.log(this.orders)
            // add elements to this.calendarOptions.events
            for (let i = 0; i < this.orders.length; i++) {
                this.calendarOptions.events.push({
                    title: this.orders[i].name,
                    start: this.orders[i].begin,
                    end: this.orders[i].end,
                    className: 'bg-warning text-dark'
                })
            }
            this.$forceUpdate()
        })
    },
    methods: {
        handleSubmit(id) {
            if (!this.value) {
                return
            }
            this.submitting = true

            setTimeout(() => {
                this.submitting = false
                this.comments = [
                    {
                        content: this.value,
                        datetime: moment().fromNow()
                    },
                    ...this.comments
                ]
                this.value = ''
            }, 1000)
        },
        handleChange(e) {
            this.value = e.target.value
        }
    }
}

</script>

<style>
</style>
