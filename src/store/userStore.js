import { defineStore } from 'pinia';
import userApi from '@/apis/userApi';

export default defineStore('user', {
  state: () => {
    return {
      userInfo: {},
      id: 0,
    };
  },
  actions: {
    async getUserInfo(token) {
      const res = await userApi.info(token, this.id);
      
      this.userInfo = res.data;
      console.log("user", this.userInfo)
    },
  },
});
