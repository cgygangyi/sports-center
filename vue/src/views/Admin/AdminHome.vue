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

        <!-- Charts -->
        <a-row :gutter="24" type="flex" align="stretch">
            <a-col :span="24" :lg="10" class="mb-24">

                <!-- Active Users Card -->
                <CardBarChart></CardBarChart>
                <!-- Active Users Card -->

            </a-col>
            <a-col :span="24" :lg="14" class="mb-24">

                <!-- Sales Overview Card -->
                <CardLineChart></CardLineChart>
                <!-- / Sales Overview Card -->

            </a-col>
        </a-row>
        <!-- / Charts -->

        <a-card :bordered="false">
        </a-card>
        <a-row :gutter="2">
            <a-col :span="12">
                <div id="g2-Pie" style="width: 100%"></div>
            </a-col>
            <a-col :span="12">
                <div id="g2-Column" style="width: 100%"></div>
            </a-col>
        </a-row>

    </div>
</template>

<script>
import { Line, Area, Column, Pie } from '@antv/g2plot'

// Bar chart for "Active Users" card.
import CardBarChart from '../../components/Cards/CardBarChart.vue'

// Line chart for "Sales Overview" card.
import CardLineChart from '../../components/Cards/CardLineChart.vue'

// Counter Widgets
import WidgetCounter from '../../components/Widgets/WidgetCounter.vue'

const data = [
    { type: 'Basketball', value: 7 },
    { type: 'Badminton', value: 5 },
    { type: 'tennis', value: 8 },
    { type: 'table tennis', value: 5 },
    { type: 'volleyball', value: 6 }
]

// Counter Widgets stats
const stats = [
    {
        title: 'Today’s Users',
        value: 56,
        suffix: '+15%',
        icon: `
						<svg width="22" height="22" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path d="M9 6C9 7.65685 7.65685 9 6 9C4.34315 9 3 7.65685 3 6C3 4.34315 4.34315 3 6 3C7.65685 3 9 4.34315 9 6Z" fill="#111827"/>
							<path d="M17 6C17 7.65685 15.6569 9 14 9C12.3431 9 11 7.65685 11 6C11 4.34315 12.3431 3 14 3C15.6569 3 17 4.34315 17 6Z" fill="#111827"/>
							<path d="M12.9291 17C12.9758 16.6734 13 16.3395 13 16C13 14.3648 12.4393 12.8606 11.4998 11.6691C12.2352 11.2435 13.0892 11 14 11C16.7614 11 19 13.2386 19 16V17H12.9291Z" fill="#111827"/>
							<path d="M6 11C8.76142 11 11 13.2386 11 16V17H1V16C1 13.2386 3.23858 11 6 11Z" fill="#111827"/>
						</svg>`
    },
    {
        title: 'New Clients',
        value: 12,
        prefix: '+',
        status: 'danger',
        suffix: '-20%',
        icon: `
						<svg width="22" height="22" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd" clip-rule="evenodd" d="M3.17157 5.17157C4.73367 3.60948 7.26633 3.60948 8.82843 5.17157L10 6.34315L11.1716 5.17157C12.7337 3.60948 15.2663 3.60948 16.8284 5.17157C18.3905 6.73367 18.3905 9.26633 16.8284 10.8284L10 17.6569L3.17157 10.8284C1.60948 9.26633 1.60948 6.73367 3.17157 5.17157Z" fill="#111827"/>
						</svg>`
    }
]

// "Projects" table list of columns and their properties.
const tableColumns = [
    {
        title: 'COMPANIES',
        dataIndex: 'company',
        scopedSlots: { customRender: 'company' },
        width: 300
    },
    {
        title: 'MEMBERS',
        dataIndex: 'members',
        scopedSlots: { customRender: 'members' }
    },
    {
        title: 'BUDGET',
        dataIndex: 'budget',
        class: 'font-bold text-muted text-sm'
    },
    {
        title: 'COMPLETION',
        scopedSlots: { customRender: 'completion' },
        dataIndex: 'completion'
    }
]

// "Projects" table list of rows and their properties.
const tableData = [
    {
        key: '1',
        company: {
            name: 'Soft UI Shopify Version',
            logo: 'images/logos/logo-shopify.svg'
        },
        members: ['images/face-1.jpg', 'images/face-4.jpg', 'images/face-2.jpg', 'images/face-3.jpg'],
        budget: '$14,000',
        completion: 60
    },
    {
        key: '2',
        company: {
            name: 'Progress Track',
            logo: 'images/logos/logo-atlassian.svg'
        },
        members: ['images/face-4.jpg', 'images/face-3.jpg'],
        budget: '$3,000',
        completion: 10
    },
    {
        key: '3',
        company: {
            name: 'Fix Platform Errors',
            logo: 'images/logos/logo-slack.svg'
        },
        members: ['images/face-1.jpg', 'images/face-2.jpg', 'images/face-3.jpg'],
        budget: 'Not Set',
        completion: {
            label: '100',
            status: 'success',
            value: 100
        }
    },
    {
        key: '4',
        company: {
            name: 'Launch new Mobile App',
            logo: 'images/logos/logo-spotify.svg'
        },
        members: ['images/face-1.jpg', 'images/face-2.jpg'],
        budget: '$20,600',
        completion: {
            label: '100',
            status: 'success',
            value: 100
        }
    },
    {
        key: '5',
        company: {
            name: 'Add the New Landing Page',
            logo: 'images/logos/logo-jira.svg'
        },
        members: ['images/face-1.jpg', 'images/face-4.jpg', 'images/face-2.jpg', 'images/face-3.jpg'],
        budget: '$4,000',
        completion: 80
    },
    {
        key: '6',
        company: {
            name: 'Redesign Online Store',
            logo: 'images/logos/logo-invision.svg'
        },
        members: ['images/face-1.jpg', 'images/face-4.jpg', 'images/face-3.jpg'],
        budget: '$2,000',
        completion: {
            label: 'Cancelled',
            status: 'exception',
            value: 100
        }
    }
]

export default ({
    components: {
        CardBarChart,
        CardLineChart,
        WidgetCounter
    },
    data() {
        return {

            // Associating table data with its corresponding property.
            tableData,

            // Associating table columns with its corresponding property.
            tableColumns,

            // Counter Widgets Stats
            stats,
            data
        }
    },
    mounted() {
        fetch('https://gw.alipayobjects.com/os/bmw-prod/e00d52f4-2fa6-47ee-a0d7-105dd95bde20.json')
            .then((res) => res.json())
            .then((data) => {
                const linePlot = new Line('container', {
                    data,
                    xField: 'year',
                    yField: 'gdp',
                    seriesField: 'name',
                    yAxis: {
                        label: {
                            formatter: (v) => `${(v / 10e8).toFixed(1)} B`
                        }
                    },
                    legend: {
                        position: 'top'
                    },
                    smooth: true,
                    // @TODO 后续会换一种动画方式
                    animation: {
                        appear: {
                            animation: 'path-in',
                            duration: 5000
                        }
                    }
                })
                linePlot.render()
            })
        fetch('https://gw.alipayobjects.com/os/bmw-prod/1d565782-dde4-4bb6-8946-ea6a38ccf184.json')
            .then((res) => res.json())
            .then((data) => {
                const area = new Area('g2-Area', {
                    data,
                    xField: 'Date',
                    yField: 'scales',
                    xAxis: {
                        tickCount: 5
                    },
                    animation: false,
                    slider: {
                        start: 0.1,
                        end: 0.9,
                        trendCfg: {
                            isArea: true
                        }
                    }
                })
                area.render()
            })
        fetch('https://gw.alipayobjects.com/os/antfincdn/8elHX%26irfq/stack-column-data.json')
            .then((data) => data.json())
            .then((data) => {
                const stackedColumnPlot = new Column('g2-Column', {
                    data,
                    isStack: true,
                    xField: 'year',
                    yField: 'value',
                    seriesField: 'type',
                    label: {
                        // 可手动配置 label 数据标签位置
                        position: 'middle' // 'top', 'bottom', 'middle'
                    },
                    interactions: [{ type: 'active-region', enable: false }],
                    columnBackground: {
                        style: {
                            fill: 'rgba(0,0,0,0.1)'
                        }
                    }
                })
                stackedColumnPlot.render()
            })

        const piePlot = new Pie('g2-Pie', {
            appendPadding: 10,
            data,
            angleField: 'value',
            colorField: 'type',
            radius: 1,
            innerRadius: 0.6,
            label: {
                type: 'inner',
                offset: '-50%',
                content: '{value}',
                style: {
                    textAlign: 'center',
                    fontSize: 14
                }
            },
            interactions: [{ type: 'element-selected' }, { type: 'element-active' }],
            statistic: {
                title: false,
                content: {
                    style: {
                        whiteSpace: 'pre-wrap',
                        overflow: 'hidden',
                        textOverflow: 'ellipsis'
                    },
                    content: 'venues distribution'
                }
            }
        })
        piePlot.render()
    }
})

</script>

<style>
</style>
