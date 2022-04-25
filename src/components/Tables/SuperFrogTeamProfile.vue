<script setup>
import EditStudentModal from "../Modals/EditStudentModal.vue";

    let profileList = [
        {
          name: 'Bob Smith',
          email: 'b.smith@tcu.edu',
          dateOfBirth: '10/23/1987',
          phone: '817-528-1249',
          address: '2800 S University Dr',
        },
    ]
</script>

<template>
  <div class="container col py-3" id="app">
    <div class="card">
      <div class="card-body d-flex justify-content-center">
        <div><!-- empty div so content-between looks good --></div>
        <h4 class="card-title">Profile</h4>
        <EditStudentModal id="edit-student-modal" />
        <button
          type="button"
          class="btn btn-primary mx-4"
          data-bs-toggle="modal"
          data-bs-target="edit-student-modal"
        >
          Edit Student
        </button>
      </div>
    </div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Customer Name</th>
          <th scope="col">E-Mail</th>
          <th scope="col">Date of Birth</th>
          <th scope="col">Phone Number</th>
          <th scope="col">Address</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="profile in profileList" :key="profile.id">
          <td>{{ profile.name }}</td>
          <td>{{ profile.email }}</td>
          <td>{{ profile.dateOfBirth }}</td>
          <td>{{ profile.phone }}</td>
          <td>{{ profile.address }}</td>
          <td>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
</style>
