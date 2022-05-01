<script>
import requestApi from "@/apis/requestApi";
import userApi from "@/apis/userApi";
import useUserStore from '@/store/userStore';

export default {
  data() {
    return {
      requestList: [],
      userInfo: {}
    };
  },
  methods: {
    async getAll() { 
      const res = await requestApi.getAllApprovedRequests();
      this.requestList = res.data;
    },
    async signUpRequest(requestId) {
      const res = await userApi.assignSuperFrog(requestId, this.userInfo.id);
    },
  },
  mounted() {
    const userStore = useUserStore();
    this.userInfo = userStore.userInfo;
    this.getAll()
  },
};
</script>

<template>
    <div class="container col py-3" id="app">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Requests</h4>
            </div>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Request ID</th>
                    <th scope="col">Event Name</th>
                    <th scope="col">Event Type</th>
                    <th scope="col">Customer</th>
                    <th scope="col">Date</th>
                    <th scope="col">Start Time</th>
                    <th scope="col">End Time</th>
                    <th scope="col">Location</th>
                    <th scope="col">Price</th>
                    <th scope="col">Status</th> 
                    <th scope="col">Actions</th> 
                </tr>
            </thead>
            <tbody>
              <tr v-for="request in requestList" :key="request.id">
                <td>{{request.id}}</td>
                <td>{{request.eventName}}</td>
                <td>{{request.eventType}}</td>
                <td>{{request.customer}}</td>
                <td>{{request.date}}</td>
                <td>{{request.startTime}}</td>
                <td>{{request.endTime}}</td>
                <td>{{request.location}}</td>
                <td>{{request.price}}</td>
                <td>
                  <span class="badge bg-secondary" v-if="request.status=='Pending'">{{request.status}}</span>
                  <span class="badge bg-warning" v-if="request.status=='Approved'">{{request.status}}</span>
                  <span class="badge bg-success" v-if="request.status=='Assigned'">{{request.status}}</span>
                  <span class="badge bg-danger" v-if="request.status=='Rejected'">{{request.status}}</span>
                </td>
                <td>
                  <button 
                  v-if="request.status=='Approved'" 
                  type="button" 
                  class="btn btn-success btn-sm me-2"
                  @click="signUpRequest(request.id)">Sign up</button>
                </td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
</style>
