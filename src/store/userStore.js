import { defineStore } from 'pinia';
import userApi from '@/apis/userApi';

export default defineStore('user', {
  state: () => {
    return {
      userInfo: {},
    };
  },
  actions: {
    async getUserInfo(instance, id) {
      const res = await userApi.info(instance, id);
      console.log("res", res)
      this.userInfo = res.data;
    },
  },
});
