<script setup>
import SpiritDirectorSideBar from "../Sidebars/SpiritDirectorSideBar.vue"
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <SpiritDirectorSideBar />
      <router-view></router-view>
    </div>
  </div>
</template>

<style scoped>

</style>
