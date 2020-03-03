<template>
  <div>
    <highcharts :options="chartOptions"></highcharts>
  </div>
</template>

<script>
import axios from 'axios'
import { Chart } from 'highcharts-vue'
import Highcharts from 'highcharts'
import exportingInit from 'highcharts/modules/exporting'
import exportingData from 'highcharts/modules/export-data'

exportingInit(Highcharts)
exportingData(Highcharts)
export default {
  components: {
    highcharts: Chart
  },
  data () {
    return {
      chartOptions: {
        chart: {
          zoomType: 'xy'
        },
        title: {
          text: '전기소비량과 전기요금'
        },
        subtitle: {
          text: 'from https://jsfiddle.net/gh/get/library/pure/highcharts/highcharts/tree/master/samples/highcharts/demo/line-basic/'
        },
        xAxis: [{
          categories: [],
          crosshair: true
        }],
        yAxis: [{ // Primary yAxis
          labels: {
            format: '{value}°kWh',
            style: {
              color: Highcharts.getOptions().colors[1]
            }
          },
          title: {
            text: '전기소비량(kWh)',
            style: {
              color: Highcharts.getOptions().colors[1]
            }
          }
        }, { // Secondary yAxis
          title: {
            text: '전기요금',
            style: {
              color: Highcharts.getOptions().colors[0]
            }
          },
          labels: {
            format: '{value} 원',
            style: {
              color: Highcharts.getOptions().colors[0]
            }
          },
          opposite: true
        }],
        tooltip: {
          shared: true
        },
        legend: {
          layout: 'vertical',
          align: 'left',
          x: 120,
          verticalAlign: 'top',
          y: 100,
          floating: true,
          backgroundColor: Highcharts.defaultOptions.legend.backgroundColor || // theme
            'rgba(255,255,255,0.25)'
        },
        series: [{
          name: '전기요금',
          type: 'column',
          yAxis: 1,
          data: [],
          tooltip: {
            valueSuffix: ' 원'
          }
        }, {
          name: '전기소비량',
          type: 'spline',
          data: [],
          tooltip: {
            valueSuffix: ' kWh'
          }
        }]
      },
      address: 'http://localhost:8080'
    }
  },
  methods: {
    getData: function () {
      axios.get(this.address)
        .then(response => {
          for (const data of response.data) {
            this.chartOptions.series[0].data.push(data.cost)
            this.chartOptions.series[1].data.push(data.consumption)
            this.chartOptions.xAxis[0].categories.push(data.hour)
          }
        })
    }
  },
  created () {
    this.getData()
  }
}
// options 속성이나 콜백에 created: () => console.log(this.a) 이나 vm.$watch('a', newValue => this.myMethod()) 와 같은 화살표 함수 사용을 지양하기 바랍니다.
// `화살표 함수들은 부모 컨텍스트에 바인딩되기 때문에, this 컨텍스트가 호출하는 Vue 인스턴스에서 사용할 경우
// Uncaught TypeError: Cannot read property of undefined 또는 Uncaught TypeError: this.myMethod is not a function와 같은 오류가 발생하게 됩니다.`
// 모든 화면이 렌더링된 후 실행합니다.
</script>

<style>
.highcharts-figure, .highcharts-data-table table {
  min-width: 310px;
  max-width: 800px;
  margin: 1em auto;
}

#container {
  height: 400px;
}

.highcharts-data-table table {
  font-family: Verdana, sans-serif;
  border-collapse: collapse;
  border: 1px solid #EBEBEB;
  margin: 10px auto;
  text-align: center;
  width: 100%;
  max-width: 500px;
}
.highcharts-data-table caption {
  padding: 1em 0;
  font-size: 1.2em;
  color: #555;
}
.highcharts-data-table th {
  font-weight: 600;
  padding: 0.5em;
}
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
  padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
  background: #f8f8f8;
}
.highcharts-data-table tr:hover {
  background: #f1f7ff;
}
</style>
