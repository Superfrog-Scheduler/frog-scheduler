<script setup>
defineProps({
  msg: String,
});
</script>

<template>
  <p>
    <router-link to="/director/requests">Go to SpiritDirector</router-link>
    <br/>
    <router-link to="/team/requests">Go to SuperFrogTeam</router-link>
    <br/>
    <router-link to="/customer/requests">Go to Customer</router-link>
    <br/>
  </p>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
