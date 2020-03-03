<template>
  <div>
  <table id="tableData" style="border:1px solid #dddddd">
    <thead>
      <tr>
        <th v-for="value in tableHead" :key="value">{{value}}</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="entry in electricData" :key="entry">
        <th v-for="(key, index) in entry" :key="key">
          {{entry[index]}}
        </th>
      </tr>
    </tbody>
  </table>
  <button v-on:click="downExcel">엑셀</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      tableHead: ['일시', '전기소비량(kWh)', '단가', '전기요금(원)'],
      electricData: [],
      address: 'http://localhost:8080/'
    }
  },
  methods: {
    getData: async function () {
      await axios.get(this.address)
        .then(response => {
          for (const data of response.data) {
            let temp = [data.hour, data.consumption, data.unitPrice, data.cost]
            this.electricData.push(temp)
          }
        })
    },
    downExcel: function () {
      axios.get(this.address + 'excel')
    }
  },
  mounted() {
    this.getData()
  }
}
</script>

<style scoped>
</style>
