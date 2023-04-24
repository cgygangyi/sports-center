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
                                </div>
                                <div class="col-action">
                                    <a-button type="link" size="small">
                                        <svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-danger" fill-rule="evenodd" clip-rule="evenodd" d="M9 2C8.62123 2 8.27497 2.214 8.10557 2.55279L7.38197 4H4C3.44772 4 3 4.44772 3 5C3 5.55228 3.44772 6 4 6L4 16C4 17.1046 4.89543 18 6 18H14C15.1046 18 16 17.1046 16 16V6C16.5523 6 17 5.55228 17 5C17 4.44772 16.5523 4 16 4H12.618L11.8944 2.55279C11.725 2.214 11.3788 2 11 2H9ZM7 8C7 7.44772 7.44772 7 8 7C8.55228 7 9 7.44772 9 8V14C9 14.5523 8.55228 15 8 15C7.44772 15 7 14.5523 7 14V8ZM12 7C11.4477 7 11 7.44772 11 8V14C11 14.5523 11.4477 15 12 15C12.5523 15 13 14.5523 13 14V8C13 7.44772 12.5523 7 12 7Z" fill="#111827"/>
                                        </svg>
                                        <span class="text-danger">CANCEL</span>
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
import '@fullcalendar/core/vdom' // solves problem with Vite
import FullCalendar from '@fullcalendar/vue'
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from '@fullcalendar/interaction'
import CardNextEvents from "../components/Cards/CardNextEvents"
import {getUserProfile} from "@/api/user";
import {getUserOrders} from "@/api/order";

// Next event's list.
const eventsData = [
    {
        id: "1",
        title: "Cyber Week",
        code: "27 March 2021, at 12:30 PM",
        iconClass: "text-danger",
        icon: "calendar",
        iconBgColor: "rgba(234,6,6,.03)",
    },
    {
        id: "2",
        title: "Meeting with Marry",
        code: "24 March 2021, at 10:00 PM",
        iconClass: "text-primary",
        icon: "bell",
        iconBgColor: "rgba(121,40,202,.03)",
    },
    {
        id: "3",
        title: "Book Deposit Hall",
        code: "25 March 2021, at 9:30 AM",
        iconClass: "text-success",
        icon: "book",
        iconBgColor: "rgba(23,173,55,.03)",
    },
    {
        id: "4",
        title: "Shipment Deal UK",
        code: "25 March 2021, at 2:00 PM",
        iconClass: "text-warning",
        icon: "car",
        iconBgColor: "rgba(245,57,57,.03)",
    },
    {
        id: "5",
        title: "Verify Dashboard Color Palette",
        code: "26 March 2021, at 9:00 AM",
        iconClass: "text-primary",
        icon: "windows",
        iconBgColor: "rgba(33,82,255,.03)",
    },
] ;

// Chart data.
const chartData = {
    labels: ["Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
    datasets: [{
        label: "Visitors",
        tension: 0.5,
        borderWidth: 0,
        pointRadius: 0,
        borderColor: "#fff",
        borderWidth: 2,
        data: [50, 45, 60, 60, 80, 65, 90, 80, 100],
        maxBarThickness: 6,
        fill: true
    }],
} ;

export default {
    components: {
        FullCalendar,
        CardNextEvents,
    },
    data() {
        return {
            orders: [],

            // Next event's list.
            eventsData,

            // Chart data.
            chartData,

            // Calendar options.
            calendarOptions: {
                plugins: [ dayGridPlugin, interactionPlugin ],
                initialView: 'dayGridMonth',
                contentHeight: 'auto',
                initialView: "dayGridMonth",
                headerToolbar: {
                    start: 'title', // will normally be on the left. if RTL, will be on the right
                    center: '',
                    end: 'today prev,next' // will normally be on the right. if RTL, will be on the left
                },
                selectable: true,
                editable: true,
                initialDate: '2023-04-01',
                events: [{
                    title: 'Call with Dave',
                    start: '2023-04-02',
                    end: '2023-04-02',
                    className: 'bg-danger'
                },

                    {
                        title: 'Lunch meeting',
                        start: '2023-04-03',
                        end: '2023-04-03',
                        className: 'bg-warning text-dark'
                    },

                    {
                        title: 'All day conference',
                        start: '2023-04-11',
                        end: '2023-04-11',
                        className: 'bg-success'
                    },

                    {
                        title: 'Meeting with Mary',
                        start: '2023-04-29',
                        end: '2023-04-29',
                        className: 'bg-primary'
                    },
                ],
                views: {
                    month: {
                        titleFormat: {
                            month: "long",
                            year: "numeric"
                        }
                    },
                    agendaWeek: {
                        titleFormat: {
                            month: "long",
                            year: "numeric",
                            day: "numeric"
                        }
                    },
                    agendaDay: {
                        titleFormat: {
                            month: "short",
                            year: "numeric",
                            day: "numeric"
                        }
                    }
                },
            }

        }
    },
    beforeMount() {
        getUserOrders().then(res => {
            console.log(res)
            this.orders = res.data.data;
            console.log(this.orders);
            this.$forceUpdate();
        })
    },
}

</script>

<style lang="scss">
</style>
