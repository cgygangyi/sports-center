<template>
    <div>
        <a-card :bordered="false" class="header-solid h-full mb-24" :bodyStyle="{paddingTop: '14px'}">
            <a-row type="flex" :gutter="[24,24]" align="stretch">
                <a-col :span="24" :md="12" :xl="6" v-for="(project, index) in projects" :key="index">
                    <VenueCard
                        :id="project.id"
                        :name="project.name"
                        :address="project.address"
                        :cover="project.cover"
                        :price="project.price"
                        class="mb-15"
                    ></VenueCard>
                </a-col>
            </a-row>
        </a-card>
    </div>
</template>

<script>
import VenueCard from "../components/Cards/VenueCard";

import {getAllVenues} from '../api/venue';

export default ({
    components: {
        VenueCard,
    },
    data() {
        return {
            a:'',
            visible: false,
            projects:[],
        }
    },

    beforeCreate() {
        getAllVenues().then((response) => {
            console.log(response)
            let img = ['images/venue-1.jpeg', 'images/venue-2.jpeg', 'images/venue-3.jpeg', "images/venue-4.jpeg", "images/venue-5.jpeg"];
            this.projects = response.data;
            for (let i = 0; i < this.projects.length; i++) {
                let index = parseInt(Math.random() * img.length);
                this.projects[i].cover = img[index];
            }
            for (let i = 0; i < 5; i++) {
                this.projects[i].cover = img[2];
            }
            for (let i = 5; i < 9; i++) {
                this.projects[i].cover = img[0];
            }
            for (let i = 9; i < 16; i++) {
                this.projects[i].cover = img[3];
            }
        });
    },

})



</script>

<style lang="scss">
</style>
