<script>
import CustomerSideBar from "../Sidebars/CustomerSideBar.vue"
import useUserStore from "@/store/userStore";
export default {
  components: { CustomerSideBar },
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
    <div class = "row flex-nowrap">
      <CustomerSideBar :userInfo="userInfo"/>
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
</style>
