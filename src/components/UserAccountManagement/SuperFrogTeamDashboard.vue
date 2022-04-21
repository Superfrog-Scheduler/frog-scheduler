<script>
import SuperFrogTeamSideBar from "../Sidebars/SuperFrogTeamSideBar.vue"
import SuperFrogTeamTable from "../Tables/SuperFrogTeamTable.vue"
import SuperFrogTeamProfile from "../Tables/SuperFrogTeamProfile.vue"
import { useRouter } from 'vue-router';

export default {
  components: {useRouter, SuperFrogTeamSideBar, SuperFrogTeamTable , SuperFrogTeamProfile },
  data() {
    return {
      currentPath: useRouter().currentRoute.value
    }
  },
  computed: {
    currentView() {
      console.log(this.currentPath.name)
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
      <SuperFrogTeamSideBar />
      <component :is="currentView" />
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
