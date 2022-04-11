<script>
import SpiritDirectorSideBar from "../Sidebars/SpiritDirectorSideBar.vue"
import SpiritDirectorRequestsTable from "../Tables/SpiritDirectorRequestsTable.vue"
import SpiritDirectorTeamTable from "../Tables/SpiritDirectorTeamTable.vue"
import SpiritDirectorCustomerTable from "../Tables/SpiritDirectorCustomerTable.vue"
import { useRouter } from 'vue-router';

export default {
  components: {useRouter, SpiritDirectorSideBar, SpiritDirectorRequestsTable, SpiritDirectorTeamTable, SpiritDirectorCustomerTable },
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
    <div class="row flex-nowrap">
      <SpiritDirectorSideBar />
      <component :is="currentView" />
    </div>
  </div>
</template>

<style scoped>

</style>
