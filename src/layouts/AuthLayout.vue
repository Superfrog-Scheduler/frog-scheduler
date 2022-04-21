<template>
  <!-- auth layout -->
  <Home :show="show" />
</template>

<script>
import Home from "../components/Home.vue";

export default {
  components: { Home },
  data() {
    return {
      show: true
    };
  },
};
</script>

<style scoped></style>
