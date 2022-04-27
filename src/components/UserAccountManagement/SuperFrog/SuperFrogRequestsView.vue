<script setup>
import SuperFrogSideBar from "../../Sidebars/SuperFrogSideBar.vue"
import SuperFrogTable from "../../Tables/SuperFrogTable.vue"

defineProps({
  msg: String
})
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <SuperFrogSideBar />
      <SuperFrogTable />
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
