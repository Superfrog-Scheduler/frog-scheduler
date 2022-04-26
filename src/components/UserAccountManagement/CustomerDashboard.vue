<script setup>
import CustomerSideBar from "../Sidebars/CustomerSideBar.vue"
</script>

<template>
  <div class="container-fluid">
    <div class = "row flex-nowrap">
      <CustomerSideBar/>
      <router-view></router-view>
    </div>
  </div>
</template>

<style scoped>
</style>
