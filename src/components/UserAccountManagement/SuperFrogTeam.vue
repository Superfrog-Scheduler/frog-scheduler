<script setup>
import SuperFrogTeamSideBar from "../Sidebars/SuperFrogTeamSideBar.vue"

defineProps({
  msg: String
})
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <SuperFrogTeamSideBar />
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
