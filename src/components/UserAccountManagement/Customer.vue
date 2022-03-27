<script setup>
import UserSideBar from "../Sidebars/UserSideBar.vue"
import UserTable from "../Tables/UserTable.vue"

defineProps({
  msg: String
})
</script>

<template>
  <div class="dashboard">
    <UserSideBar/>
    <UserTable/>
  </div>
</template>

<style scoped>
  .dashboard {
    display: grid;
    grid-template-columns: 1fr 5fr;
  }
</style>
