<script setup>


defineProps({
  msg: String,
});
</script>

<template>
  <h1>{{ msg }}</h1>

  <p>
    <router-link to="/director">Go to SpiritDirector</router-link>
    <br/>
    <router-link to="/team">Go to SuperFrogTeam</router-link>
    <br/>
    <router-link to="/customer">Go to Customer</router-link>
    <br/>
  </p>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
