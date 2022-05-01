<script>
import EditRequestModal from "../Modals/EditRequestModal.vue";
import AssignRequestModal from "../Modals/AssignRequestModal.vue";
import downloadApi from "@/apis/downloadApi";
import requestApi from "@/apis/requestApi";
import SortModal from "../Modals/SortModal.vue";
import userApi from "@/apis/userApi";

export default {
  components: { EditRequestModal, AssignRequestModal, SortModal },
  data() {
    return {
      requestList: [],
      selectedRequestId: {},
      requestInfo: {},

      selectedRequest: {},
    };
  },
  methods: {
    download() {
      downloadApi.exportData();
    },
    async getAll() {
      const res = await requestApi.getAllRequests();
      this.requestList = res.data;
    },
    async approveRequest(request) {
      request.status = "Approved";
      const res = await requestApi.updateRequest(request);
    },
    async rejectRequest(request) {
      request.status = "Rejected";
      const res = await requestApi.updateRequest(request);
    },
    async sortRequests(values) {
      this.requestList = values;
    },
    async removeAssignment(request) {
      const res = await userApi.removeAssignment(request);
      this.getAll();
    },
    async editRequest(request) {
      console.log(request);
      this.requestInfo = request;
    },
    async editRequestSuccess(request) {
      this.getAll();
      request.status = "Approved";
      const res = await userApi.removeAssignment(request.id);
    },
    async assignSuperFrog(request) {
      request.status = "Assigned";
      const res = await userApi.removeAssignment(request.id);
    },
  },
  mounted() {
    this.getAll();
  },
};
</script>

<template>
  <div class="container col py-3" id="app">
    <div class="card">
      <div class="card-body d-flex justify-content-between">
        <div class="sort">
          <button
            type="button"
            class="btn btn-light btn-sm btn-outline-dark"
            data-bs-toggle="modal"
            data-bs-target="#sort-modal"
          >
            Sort By Date
          </button>
          <button
            type="button"
            class="btn btn-light btn-sm btn-dark"
            @click="getAll"
          >
            Reset
          </button>
        </div>
        <h4 class="card-title">Requests</h4>
        <button
          type="button"
          class="btn btn-light btn-sm btn-outline-dark"
          @click="download"
        >
          Download as Excel
        </button>
      </div>

      <AssignRequestModal
        id="assign-request-modal"
        :selectedRequest="this.selectedRequest"
        @assign-superfrog="assignSuperFrog"
      />

      <SortModal id="sort-modal" @sort="sortRequests($event)" />
    </div>
    <table class="table" id="requests-table">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Event Name</th>
          <th scope="col">Event Type</th>
          <th scope="col">Customer</th>
          <th scope="col">Date</th>
          <th scope="col">Start Time</th>
          <th scope="col">End Time</th>
          <th scope="col">Location</th>
          <th scope="col">Price</th>
          <th scope="col">Status</th>
          <th scope="col" colspan="3">Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="request in requestList" :key="request.id">
          <td>{{ request.id }}</td>
          <td>{{ request.eventName }}</td>
          <td>{{ request.eventType }}</td>
          <td>{{ request.customer }}</td>
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
              class="badge bg-warning"
              v-if="request.status == 'Approved'"
              >{{ request.status }}</span
            >
            <span
              class="badge bg-success"
              v-if="request.status == 'Assigned'"
              >{{ request.status }}</span
            >
            <span
              class="badge bg-success"
              v-if="request.status == 'Completed'"
              >{{ request.status }}</span
            >
            <span class="badge bg-danger" v-if="request.status == 'Rejected'">{{
              request.status
            }}</span>
          </td>
          <td
            v-if="request.status != 'Rejected' && request.status != 'Completed'"
          >
            <button
              type="button"
              class="btn btn-light btn-sm btn-outline-dark"
              data-bs-toggle="modal"
              data-bs-target="#edit-request-modal"
              @click="editRequest(request)"
            >
              Edit
            </button>
            <EditRequestModal
              id="edit-request-modal"
              :requestInfo="requestInfo"
              @edit-request="editRequestSuccess($event)"
            />
          </td>
          <td v-else colspan="3" style="color: gray">–</td>
          <td v-if="request.status == 'Pending'">
            <button
              type="button"
              @click="approveRequest(request)"
              class="btn btn-success btn-sm me-2"
            >
              Approve
            </button>
            <button
              type="button"
              @click="rejectRequest(request)"
              class="btn btn-danger btn-sm"
            >
              Reject
            </button>
          </td>
          <td v-if="request.status == 'Approved'">
            <button
              type="button"
              class="btn btn-success btn-sm col-12"
              data-bs-toggle="modal"
              data-bs-target="#assign-request-modal"
              @click="this.selectedRequest = request"
            >
              Assign
            </button>
          </td>
          <td v-if="request.status == 'Assigned'">
            <button
              type="button"
              class="btn btn-danger btn-sm col-12"
              @click="removeAssignment(request)"
            >
              Remove
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>
