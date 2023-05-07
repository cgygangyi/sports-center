<template>
    <div>
        <a-card :bordered="false" class="header-solid h-full mb-24" :bodyStyle="{paddingTop: '14px'}">
            <a-row type="flex" :gutter="[24,24]" align="stretch">
                <a-col :span="24" :md="12" :xl="6" v-for="(project, index) in projects" :key="index">
                    <VenueCard
                        :id="project.id"
                        :name="project.name"
                        :address="project.address"
                        :cover="project.image"
                        :price="project.price"
                        class="mb-15"
                    ></VenueCard>
                </a-col>
            </a-row>
        </a-card>
    </div>
</template>

<script>
import VenueCard from '../components/Cards/VenueCard'

import { getAllVenues } from '../api/venue'

export default ({
    components: {
        VenueCard
    },
    data() {
        return {
            a: '',
            visible: false,
            projects: []
        }
    },
    activated () {
        window.location.reload()
    },
    beforeCreate() {
        getAllVenues().then((response) => {
            console.log(response)
            this.projects = response.data.data
        })
    },
    mounted () {
        getAllVenues().then((response) => {
            console.log(response)
            this.projects = response.data.data
        })
    }

})

</script>

<style>
</style>
