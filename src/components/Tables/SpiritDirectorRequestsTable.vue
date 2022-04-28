<script>
import EditRequestModal from "../Modals/EditRequestModal.vue";
import AssignRequestModal from "../Modals/AssignRequestModal.vue";
import downloadApi from "@/apis/downloadApi";


export default {
  components: { EditRequestModal, AssignRequestModal },
  data() {
    return {
      requestList: [
        {
          id: 1,
          name: "Grad Party",
          type: "Private",
          customer: "Wingyang Bei",
          date: "03/28/2022",
          startTime: "10:00 AM",
          endTime: "11:00 AM",
          location: "2855 W Bowie St",
          price: "$100",
          status: "Pending",
        },
        {
          id: 2,
          name: "Wedding",
          type: "Private",
          customer: "Tony Sanchez",
          date: "03/29/2022",
          startTime: "7:00 PM",
          endTime: "8:00 AM",
          location: "2808 Stanley Ave",
          price: "$100",
          status: "Approved",
        },
        {
          id: 3,
          name: "Book Reading",
          type: "Public School",
          customer: "Sherrie Jackson",
          date: "03/30/2022",
          startTime: "2:00 PM",
          endTime: "4:00 PM",
          location: "4300 Campus Dr",
          price: "$200",
          status: "Assigned",
        },
        {
          id: 4,
          name: "Bachelor Party",
          type: "Private",
          customer: "Michael Schumer",
          date: "03/28/2022",
          startTime: "10:00 PM",
          endTime: "11:00 PM",
          location: "2901 Stadium Dr",
          price: "$100",
          status: "Rejected",
        },
            {
      id: 5,
      name: 'Birthday Party',
      type: 'Private',
      customer: 'Joe Biden',
      date: '02/27/2022',
      startTime: '3:00 PM',
      endTime: '4:00 PM',
      location: '1600 Pennsylvania Ave',
      price: '$100',
      status: 'Completed',
    }
      ],
    };
  },
  methods: {
    download() {
      downloadApi.exportData();
    },
  },
};
</script>

<template>
  <div class="container col py-3" id="app">
    <div class="card">
      <div class="card-body d-flex justify-content-between">
        <div><!-- empty div so content-between looks good --></div>
        <h4 class="card-title">Requests</h4>
        <button
          type="button"
          class="btn btn-light btn-sm btn-outline-dark"
          @click="download"
        >
          Download as Excel
        </button>
      </div>
      <EditRequestModal id="edit-request-modal" />
      <AssignRequestModal id="assign-request-modal" />
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
          <td>{{ request.name }}</td>
          <td>{{ request.type }}</td>
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
              class="badge bg-success"
              v-if="request.status == 'Approved'"
              >{{ request.status }}</span
            >
            <span
              class="badge bg-success"
              v-if="request.status == 'Assigned'"
              >{{ request.status }}</span
            >
            <span class="badge bg-danger" v-if="request.status == 'Rejected'">{{
              request.status
            }}</span>
          </td>
          <td v-if="request.status != 'Rejected'">
            <button
              type="button"
              class="btn btn-light btn-sm btn-outline-dark"
              data-bs-toggle="modal"
              data-bs-target="#edit-request-modal"
            >
              Edit
            </button>
          </td>
          <td v-else colspan="3" style="color: gray">–</td>
          <td v-if="request.status == 'Pending'">
            <button type="button" class="btn btn-success btn-sm me-2">
              Approve
            </button>
            <button type="button" class="btn btn-danger btn-sm">Reject</button>
          </td>
          <td v-if="request.status == 'Approved'">
            <button
              type="button"
              class="btn btn-success btn-sm col-12"
              data-bs-toggle="modal"
              data-bs-target="#assign-request-modal"
            >
              Assign
            </button>
          </td>
          <td v-if="request.status == 'Assigned'">
            <button type="button" class="btn btn-danger btn-sm col-12">
              Remove
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>
