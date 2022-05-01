<script>
import requestApi from "@/apis/requestApi";

export default {
  data() {
    return {
      requestList: []
    };
  },
  methods: {
    async getAll() {
      const res = await requestApi.getAllRequests();
      this.requestList = res.data;
    },
    async completeRequest(request) {
      request.status = "Completed";
      const res = await requestApi.updateRequest(request);
    },
  },
  mounted() {
    this.getAll()
  },
};
</script>

<template>
    <div class="container col py-3" id="app">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Appearances</h4>
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
                <td>{{request.customer.firstname}} {{request.customer.lastname}}</td>
                <td>{{request.date}}</td>
                <td>{{request.startTime}}</td>
                <td>{{request.endTime}}</td>
                <td>{{request.location}}</td>
                <td v-if="request.price!=0">{{ request.price }}</td>
                <td v-else> TBD </td>
                <td>
                  <span class="badge bg-danger" v-if="request.status=='Assigned'">Assigned to Me</span>
                  <span class="badge bg-success" v-if="request.status=='Completed'">Completed</span>
                </td>
                <td>
                  <button 
                  v-if="request.status=='Assigned'" 
                  type="button" 
                  class="btn btn-success btn-sm me-2"
                  @click="completeRequest(request)">Mark Complete</button>
                </td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
</style>
