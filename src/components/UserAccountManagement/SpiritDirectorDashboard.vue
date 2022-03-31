<script setup>
import SpiritDirectorSideBar from "../Sidebars/SpiritDirectorSideBar.vue"
import SpiritDirectorRequestsTable from "../Tables/SpiritDirectorRequestsTable.vue"
import SpiritDirectorTeamTable from "../Tables/SpiritDirectorTeamTable.vue"
defineProps({
  msg: String
})
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <SpiritDirectorSideBar />
      <SpiritDirectorRequestsTable />
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
