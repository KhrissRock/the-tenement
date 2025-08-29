<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
@import '@govbr-ds/core/dist/core.min.css';

body {
  margin: 0;
  padding: 0;
  font-family: 'Rawline', sans-serif;
}
</style>