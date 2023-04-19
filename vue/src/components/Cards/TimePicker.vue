<template>
    <div>
        <a-row :gutter="[8,8]">
            <a-col :span="5"></a-col>
            <a-col :span="4":id="100">1</a-col>
            <a-col :span="4":id="110">2</a-col>
            <a-col :span="4":id="120">3</a-col>
            <a-col :span="4":id="130">4</a-col>
        </a-row>
        <a-row v-for="(index,i) in list" bordered title="Custom Size" :gutter="[8,8]">
            <a-col :span="5">
                {{ index+9-3*i+':00 - ' + (index+10-3*i)+':00' }}
            </a-col>
            <a-col :span="4" :id="index" @click="isClick(index)">&nbsp;&nbsp;&nbsp;</a-col>
            <a-col :span="4" :id="index+1" @click="isClick(index+1)">&nbsp;&nbsp;&nbsp;</a-col>
            <a-col :span="4" :id="index+2" @click="isClick(index+2)">&nbsp;&nbsp;&nbsp;</a-col>
            <a-col :span="4" :id="index+3" @click="isClick(index+3)">&nbsp;&nbsp;&nbsp;</a-col>
        </a-row>
    </div>

</template>

<script>




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
            book_date:['','1','1','1'],
        }

    },
    beforeCreate() {
        this.chosen = -1;
    },
    mounted() {
      for (var i = 0; i < 40; i++) {
        let change = document.getElementById(i);
        console.log(this.data[i].id);
        if (this.data[i].open === 0 || this.data[i].free === 0) {
          change.style.backgroundColor = 'white';
        } else {
          console.log(change)
          change.style.backgroundColor = 'red';
        }
      }
      for (var i = 0; i < 4; i++){
        var t= i*10;
        var dataString=this.data[t].begin;
        dataString=dataString[6]+dataString[7]+dataString[8]+dataString[9];
        dataString=dataString.replace('-','.')
        let change = document.getElementById(t+100);
        change.innerHTML=dataString;
      }
      console.log(this.book_date)
      console.log(this.data)
    },
    methods: {
        isClick(id) {
            console.log(this.chosen)
            if (this.data[id].open !== 0 && this.data[id].free !== 0) {
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
    a-col {
        background-color: gray;
    }
</style>
