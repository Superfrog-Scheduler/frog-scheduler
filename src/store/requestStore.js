import { defineStore } from 'pinia';
import requestApi from '@/apis/requestApi';

export default defineStore('request', {
  state: () => {
    return {
      requestInfo: {},
      id: 0,
    };
  },
  actions: {
    async getrequestInfo(token) {
      const res = await requestApi.info(token, this.id);
      
      this.requestInfo = res.data;
    },
  },
});
