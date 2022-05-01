<script>
import SuperFrogSideBar from "../Sidebars/SuperFrogSideBar.vue";
import useUserStore from "@/store/userStore";
export default {
  components: { SuperFrogSideBar },
  data() {
    return {
      userInfo: {},
    };
  },
  mounted() {
    const userStore = useUserStore();
    this.userInfo = userStore.userInfo;
  },
  methods: {
    async userUpdate(values) {
      this.userInfo = values
    },
  },
};
</script>

<template>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <SuperFrogSideBar :userInfo="userInfo"/>
      <router-view v-slot="{ Component, route }">
        <component
          :is="Component"
          view-prop="value"
          @user-update="userUpdate($event)"
        />
      </router-view>
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
