<script setup>
import SuperFrogTeamSideBar from "../../Sidebars/SuperFrogTeamSideBar.vue"
import SuperFrogTeamTable from "../../Tables/SuperFrogTeamTable.vue"

defineProps({
  msg: String
})
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <SuperFrogTeamSideBar />
      <SuperFrogTeamTable />
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
