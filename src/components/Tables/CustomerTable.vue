<script>
import requestApi from "@/apis/requestApi";
import NewRequestModal from "../Modals/NewRequestModal.vue";
import useUserStore from '@/store/userStore';
export default {
  components: { NewRequestModal },
  data() {
    return {
      requestList: [],
      userInfo: {}
    };
  },
  methods: {
    async getMyRequests() {
      const res = await requestApi.getAllRequestsByCustomer(this.userInfo.id);
      this.requestList = res.data;
      console.log(this.requestList);
    },
    async newRequest() {
      this.getMyRequests()
    }
  },
  mounted() {
    const userStore = useUserStore();
    this.userInfo = userStore.userInfo;
    this.getMyRequests()
  },
};
</script>

<template>
  <div class="container col py-3" id="app">
    <div class="card">
      <div class="card-body d-flex justify-content-between">
        <div><!-- empty div so content-between looks good --></div>
        <h4 class="card-title">Requests</h4>
        <NewRequestModal id="add-request-modal" @new-request="newRequest($event)"/>
        <button
          type="button"
          class="btn btn-primary mx-4"
          data-bs-toggle="modal"
          data-bs-target="#add-request-modal"
        >
          New Request
        </button>
      </div>
    </div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Event Name</th>
          <th scope="col">Event Type</th>
          <th scope="col">Date</th>
          <th scope="col">Start Time</th>
          <th scope="col">End Time</th>
          <th scope="col">Location</th>
          <th scope="col">Price</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="request in requestList" :key="request.id">
          <td>{{ request.eventName }}</td>
          <td>{{ request.eventType }}</td>
          <td>{{ request.date }}</td>
          <td>{{ request.startTime }}</td>
          <td>{{ request.endTime }}</td>
          <td>{{ request.location }}</td>
          <td>{{ request.price }}</td>
          <td>
            <span
              class="badge bg-secondary"
              v-if="request.status == 'Pending'"
              >{{ request.status }}</span
            >
            <span
              class="badge bg-success"
              v-if="request.status == 'Approved'"
              >{{ request.status }}</span
            >
            <span
              class="badge bg-success"
              v-if="request.status == 'Confirmed'"
              >{{ request.status }}</span
            >
            <span class="badge bg-danger" v-if="request.status == 'Rejected'">{{
              request.status
            }}</span>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>