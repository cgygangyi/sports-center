<template>
    <div>
        <a-row>
            <a-col :span="4"></a-col>
            <a-col :span="4">3.28</a-col>
            <a-col :span="4">3.29</a-col>
            <a-col :span="4">3.30</a-col>
            <a-col :span="4">3.31</a-col>
        </a-row>
        <a-row v-for="(index,i) in list" bordered title="Custom Size">
            <a-col :span="4">
                {{ index }}
            </a-col>
            <a-col :span="4" :id="index" @click="isClick(index)" style="border: 0;">&nbsp;&nbsp;&nbsp;</a-col>
            <a-col :span="4" :id="index+1" @click="isClick(index+1)">&nbsp;&nbsp;&nbsp;</a-col>
            <a-col :span="4" :id="index+2" @click="isClick(index+2)">&nbsp;&nbsp;&nbsp;</a-col>
            <a-col :span="4" :id="index+3" @click="isClick(index+3)">&nbsp;&nbsp;&nbsp;</a-col>
        </a-row>
    </div>

</template>

<script>

window.onload=function () {

}

export default {
    components: {
    },
    props: {
        data: {
            type: Array,
            default: []
        }
    },
    data() {
        return {
            list: [0, 4, 8, 12, 16, 20, 24, 28, 32, 36],
            chosen: -1,
        }
    },
    beforeCreate() {
        this.chosen = -1;
    },
    updated() {
        for (var i = 0; i < 40; i++) {
            let change = document.getElementById(i);
            console.log(this.data[i].id);
            if (this.data[i].open === 0 || this.data[i].free === 0) {
                change.style.backgroundColor = 'red';
            } else {
                console.log(change)
                change.style.backgroundColor = 'white';
            }
        }
    },
    methods: {
        isClick(id) {
            console.log(this.chosen)
            if (this.data[id].open != 0 && this.data[id].free != 0) {
                if (this.chosen === -1) {
                    this.chosen = id;
                    let change = document.getElementById(id);
                    change.style.backgroundColor = 'green';
                } else if (this.chosen === id) {
                    this.chosen = -1;
                    let change = document.getElementById(id);
                    change.style.backgroundColor = 'white';
                }
            }
        }
    }
}
</script>

<style>
    a-row {
        border: solid 1px black;
    }
</style>
