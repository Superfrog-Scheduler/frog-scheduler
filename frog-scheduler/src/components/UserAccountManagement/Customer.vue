<script setup>
import UserSideBar from "../Sidebars/UserSideBar.vue"

defineProps({
  msg: String
})
</script>

<template>
  <UserSideBar />

</template>

<style scoped>
a {
  color: #42b983;
}
</style>
