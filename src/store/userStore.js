import { defineStore } from 'pinia';
import userApi from '@/apis/userApi';

export default defineStore('user', {
  state: () => {
    return {
      userInfo: {},
    };
  },
  actions: {
    async getUserInfo() {
      const res = await userApi.info();
      this.userInfo = res.result;
    },
  },
});
