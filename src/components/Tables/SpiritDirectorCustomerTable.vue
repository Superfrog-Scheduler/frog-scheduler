<script>
import EditUserModal from "../Modals/EditUserModal.vue";
import userApi from "@/apis/userApi";

export default {
  components: { EditUserModal },
  data() {
    return {
      customerList: [],
      customerInfo: {}
    };
  },
  methods: {
    async getAll() {
      const res = await userApi.getAllCustomers();
      this.customerList = res.data;
    },
    async deactivateCustomer(customer) {
      customer.enabled = false;
      const res = await userApi.deactivateUser(customer.id);
    },
    async reactivateCustomer(customer) {
      customer.enabled = true;
      const res = await userApi.reactivateUser(customer.id);
    },
    async editUser(customer) {
      this.customerInfo = customer;
    },
    async editUserSuccess(customer) {
      console.log("customer", customer)
      await userApi.updateUserInfo(customer);
      this.getAll();
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
      <div class="card-body">
        <h4 class="card-title">Customers</h4>
      </div>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Name</th>
          <th scope="col">Email</th>
          <th scope="col">Phone</th>
          <th scope="col">Status</th>
          <th scope="col" colspan="2">Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="customer in customerList" :key="customer.id">
          <td>{{ customer.id }}</td>
          <td>{{ customer.firstname }} {{ customer.lastname }}</td>
          <td>{{ customer.username }}</td>
          <td>{{ customer.phone }}</td>
          <td>
            <span class="badge bg-success" v-if="customer.enabled">Active</span>
            <span class="badge bg-danger" v-else>Inactive</span>
          </td>
          <td>
            <button
              type="button"
              class="btn btn-light btn-sm btn-outline-dark"
              data-bs-toggle="modal"
              data-bs-target="#edit-user-modal"
              @click="editUser(customer)"
            >
              Edit
            </button>
            <EditUserModal
              id="edit-user-modal"
              :userInfo="customerInfo"
              @user-update="editUserSuccess($event)"
            />
          </td>
          <td>
            <button
              v-if="customer.enabled"
              @click="deactivateCustomer(customer)"
              type="button"
              class="btn btn-danger btn-sm me-2"
            >
              Deactivate
            </button>
            <button
              v-else
              type="button"
              @click="reactivateCustomer(customer)"
              class="btn btn-success btn-sm"
            >
              Reactivate
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>
