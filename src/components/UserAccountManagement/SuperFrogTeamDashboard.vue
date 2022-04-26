<script setup>
import SuperFrogTeamSideBar from "../Sidebars/SuperFrogTeamSideBar.vue"
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <SuperFrogTeamSideBar />
      <router-view></router-view>
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
