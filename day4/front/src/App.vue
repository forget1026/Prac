<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <highchart />
    <Table />
  </div>
</template>

<script>
import highchart from './components/HighChart'
import Table from './components/Table'

export default {
  name: 'App',
  components: {
    highchart,
    Table
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
