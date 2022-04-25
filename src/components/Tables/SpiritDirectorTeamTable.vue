<script setup>
import EditStudentModal from "../Modals/EditStudentModal.vue";
    let studentList = [
        {
          id: 1,
          name: 'Yilika Loufoua',
          email: 'y.loufoua@tcu.edu',
          phone: '817-990-3244',
          classification: 'Senior',
          requestsTaken: 3,
          isActive: true
        },
        {
          id: 2,
          name: 'Quynh Dong',
          email: 'q.dong@tcu.edu',
          phone: '817-234-9843',
          classification: 'Sophomore',
          requestsTaken: 1,
          isActive: true
        },
        {
          id: 3,
          name: 'Chase Lennartson',
          email: 'c.lennartson@tcu.edu',
          phone: '817-039-2935',
          classification: 'Junior',
          requestsTaken: 2,
          isActive: true
        },
        {
          id: 4,
          name: 'Lucas Karwal',
          email: 'l.karwal@tcu.edu',
          phone: '682-323-5236',
          classification: 'Senior',
          requestsTaken: 5,
          isActive: false
        }
    ]
</script>

<template>
    <div class="container col py-3" id="app">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">SuperFrog Team</h4>
            </div>
        </div>
        <EditStudentModal id="edit-student-modal" />
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Classification</th>
                    <th scope="col">Requests Taken</th>
                    <th scope="col">Status</th>
                    <th scope="col" colspan="2">Actions</th> 
                </tr>
            </thead>
            <tbody>
              <tr v-for="student in studentList" :key="student.id">
                <td>{{student.id}}</td>
                <td>{{student.name}}</td>
                <td>{{student.email}}</td>
                <td>{{student.phone}}</td>
                <td>{{student.classification}}</td>
                <td>{{student.requestsTaken}}</td>
                <td>
                  <span class="badge bg-success" v-if="student.isActive">Active</span>
                  <span class="badge bg-danger" v-else>Inactive</span>
                </td>
                <td>
                  <button 
                    type="button" 
                    class="btn btn-light btn-sm btn-outline-dark" 
                    data-bs-toggle="modal" 
                    data-bs-target="#edit-student-modal">Edit</button>
                </td>
                <td>
                  <button v-if="student.isActive" type="button" class="btn btn-danger btn-sm me-2">Deactivate</button>
                  <button v-else type="button" class="btn btn-success btn-sm">Reactivate</button>
                </td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
</style>