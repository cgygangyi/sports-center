<template>
    <div>
      <table class="calendar-table">
        <thead>
          <tr >
              <th :colspan="4"></th>
              <th :colspan="4" :id="100">1</th>
              <th :colspan="4" :id="110">2</th>
              <th :colspan="4" :id="120">3</th>
              <th :colspan="4" :id="130">4</th>
          </tr>
        </thead>
          <tr v-for="(index,i) in list" :key="i">
              <th :colspan="4">{{ index+9-3*i+':00 - ' + (index+10-3*i)+':00' }}</th>
              <th :colspan="4" :id="index" @click="isClick(index)">&nbsp;&nbsp;&nbsp;</th>
              <th :colspan="4" :id="index+1" @click="isClick(index+1)">&nbsp;&nbsp;&nbsp;</th>
              <th :colspan="4" :id="index+2" @click="isClick(index+2)">&nbsp;&nbsp;&nbsp;</th>
              <th :colspan="4" :id="index+3" @click="isClick(index+3)">&nbsp;&nbsp;&nbsp;</th>
          </tr>
      </table>
    </div>
</template>

<script>

export default {
    components: {
    },
    props: {
        data: {
            type: Array,
            // eslint-disable-next-line vue/require-valid-default-prop
            default: []
        }
    },
    data() {
        return {
            list: [0, 4, 8, 12, 16, 20, 24, 28, 32, 36],
            chosen: -1,
            book_date: ['', '1', '1', '1']
        }
    },
    beforeCreate() {
        this.chosen = -1
    },
    mounted() {
        for (let i = 0; i < 40; i++) {
            const change = document.getElementById(i)
            console.log(this.data[i].id)
            if (this.data[i].open === 0) {
                change.style.backgroundColor = 'grey'
            } else if (this.data[i].free === 0) {
                change.style.backgroundColor = 'red'
            } else {
                console.log(change)
                change.style.backgroundColor = 'white'
            }
        }
        for (let j = 0; j < 4; j++) {
            const t = j * 10
            let dataString = this.data[t].begin
            if (dataString[5] === '0') {
                dataString = dataString[0] + dataString[1] + dataString[2] + dataString[3] +
              dataString[4] + dataString[6] + dataString[7] + dataString[8] + dataString[9]
            } else {
                dataString = dataString[0] + dataString[1] + dataString[2] + dataString[3] + dataString[4] +
              dataString[5] + dataString[6] + dataString[7] + dataString[8] + dataString[9]
            }

            dataString = dataString.replace('-', '.')
            dataString = dataString.replace('-', '.')
            const change = document.getElementById(t + 100)
            change.innerHTML = dataString
        }
        console.log(this.book_date)
        console.log(this.data)
    },
    methods: {
        isClick(id) {
            if (this.data[id].open !== 0 && this.data[id].free !== 0) {
                if (this.chosen === -1) {
                    this.chosen = id
                    const change = document.getElementById(id)
                    change.style.backgroundColor = 'green'
                } else if (this.chosen === id) {
                    this.chosen = -1
                    const change = document.getElementById(id)
                    change.style.backgroundColor = 'white'
                }
                sessionStorage.setItem('chosen', this.data[id].id)
            }
        }

    }
}
</script>

<style>
    a-col {
      border-collapse: collapse;
      border: 1px solid #dee4f5;
      background-color: gray;
    }
    .calendar-table {
      border-collapse: collapse;
    }
    .calendar-table th {
      vertical-align: inherit;
      font-weight: bold;
    }
    .calendar-table tr {
      height: 30px;
      width: 20px;
    }
    .calendar-table tr, td, th {
      user-select: none;
      border: 1px solid #dee4f5;
      text-align: center;
      min-width: 30px;
      line-height: 1.8em;
      transition: background 0.2s ease;
    }

</style>
