import Vue from 'vue'
import HighchartsVue from 'highcharts-vue'

import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: function (h) { return h(App) }
}).$mount('#app')

Vue.use(HighchartsVue)
