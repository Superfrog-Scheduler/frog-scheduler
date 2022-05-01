<script>
import EditUserModal from "../Modals/EditUserModal.vue";
import NewFrogModal from "../Modals/NewFrogModal.vue";
import userApi from "@/apis/userApi";

export default {
  components: { EditUserModal, NewFrogModal },
  data() {
    return {
      studentList: [],
      studentInfo: {},
    };
  },
  methods: {
    async getAll() {
      const res = await userApi.getAllSuperFrogs();
      this.studentList = res.data;
    },
    async editUser(student) {
      this.studentInfo = student;
    },
    async editUserSuccess(student) {
      await userApi.updateUserInfo(student);
      this.getAll();
    },
    async deactivateStudent(student) {
      student.enabled = false;
      await userApi.deactivateUser(student.id);
    },
    async reactivateStudent(student) {
      student.enabled = true;
      await userApi.reactivateUser(student.id);
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
        <div><!-- empty div so content-between looks good --></div>
        <h4 class="card-title">SuperFrog Team</h4>

        <NewFrogModal id="add-frog-modal" />
        <button
          type="button"
          class="btn btn-primary mx-4"
          data-bs-toggle="modal"
          data-bs-target="#add-frog-modal"
        >
          Add Superfrog
        </button>
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
        <tr v-for="student in studentList" :key="student.id">
          <td>{{ student.id }}</td>
          <td>{{ student.firstname }} {{ student.lastname }}</td>
          <td>{{ student.username }}</td>
          <td>{{ student.phone }}</td>
          <td>
            <span class="badge bg-success" v-if="student.enabled">Active</span>
            <span class="badge bg-danger" v-else>Inactive</span>
          </td>
          <td>
            <button
              type="button"
              class="btn btn-light btn-sm btn-outline-dark"
              data-bs-toggle="modal"
              data-bs-target="#edit-student-modal"
              @click="editUser(student)"
            >
              Edit
            </button>
            <EditUserModal id="edit-student-modal" :userInfo="studentInfo" @user-update="editUserSuccess($event)"/>
          </td>
          <td>
            <button
              v-if="student.enabled"
              type="button"
              class="btn btn-danger btn-sm me-2"
              @click="deactivateStudent(student)"
            >
              Deactivate
            </button>
            <button 
            v-else type="button" 
            class="btn btn-success btn-sm"
            @click="reactivateStudent(student)">
              Reactivate
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>
