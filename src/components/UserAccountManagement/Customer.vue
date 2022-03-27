<script setup>
import CustomerSideBar from "../Sidebars/CustomerSideBar.vue";
import CustomerTable from "../Tables/CustomerTable.vue";

defineProps({
  msg: String,
});
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <CustomerSideBar />
      <CustomerTable />
    </div>
  </div>
</template>

<style scoped>
.dashboard {
  display: grid;
  grid-template-columns: 1fr 5fr;
}
</style>
