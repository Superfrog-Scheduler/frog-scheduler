<script setup>
import CustomerSideBar from "../Sidebars/CustomerSideBar.vue"
import CustomerTable from "../Tables/CustomerTable.vue"

defineProps({
  msg: String
})
</script>

<template>
  <div class="dashboard">
    <CustomerSideBar/>
    <CustomerTable/>
  </div>
</template>

<style scoped>
  .dashboard {
    display: grid;
    grid-template-columns: 1fr 5fr;
  }
</style>
