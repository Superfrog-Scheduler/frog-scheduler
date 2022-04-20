<script setup>
import CustomerSideBar from "../Sidebars/CustomerSideBar.vue"
import CustomerTable from "../Tables/CustomerTable.vue"
import CustomerProfile from "../Tables/CustomerProfile.vue"
import { useRouter } from 'vue-router';

export default {
  components: {useRouter, CustomerSideBar, CustomerTable, CustomerProfile },
  data() {
    return {
      currentPath: useRouter().currentRoute.value
    }
  },
  computed: {
    currentView() {
      return this.currentPath.name
    }
  },
  mounted() {
    window.addEventListener('hashchange', () => {
      this.currentPath = window.location.hash
    })
  }
}
</script>

<template>
  <div class="container-fluid">
    <div class = "row flex-nowrap">
      <CustomerSideBar/>
      <CustomerTable/>
     <component :is="currentView" />
    </div>
  </div>
</template>

<style scoped>
</style>
