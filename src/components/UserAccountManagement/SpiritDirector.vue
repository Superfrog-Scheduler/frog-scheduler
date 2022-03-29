<script setup>
import SpiritDirectorSideBar from "../Sidebars/SpiritDirectorSideBar.vue"
import SpiritDirector from "../Tables/SpiritDirectorRequestsTable.vue"
defineProps({
  msg: String
})
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <SpiritDirectorSideBar />
      <SpiritDirector />
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
