<script setup>
import SuperFrogSideBar from "../Sidebars/SuperFrogSideBar.vue"
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <SuperFrogSideBar />
      <router-view></router-view>
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
