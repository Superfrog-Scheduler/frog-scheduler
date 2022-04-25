<script setup>
import EditCustomerModal from "../Modals/EditCustomerModal.vue";
    let customerList = [
        {
          id: 1,
          name: 'Michael Schumer',
          email: 'm.schumer@gmail.com',
          phone: '817-685-9382',
          isActive: true
        },
        {
          id: 2,
          name: 'Wingyang Bei',
          email: 'w.bei@gmail.com',
          phone: '817-123-4321',
          isActive: true
        },
        {
          id: 3,
          name: 'Tony Sanchez',
          email: 't.sanchez@gmail.com',
          phone: '817-126-3463',
          isActive: false
        },
        {
          id: 4,
          name: 'Sherrie Jackson',
          email: 's.jackson@gmail.com',
          phone: '817-647-3574',
          isActive: true
        }
    ]
</script>

<template>
    <div class="container col py-3" id="app">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Customers</h4>
            </div>
        </div>
        <EditCustomerModal id="edit-customer-modal" />
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
                <td>{{customer.id}}</td>
                <td>{{customer.name}}</td>
                <td>{{customer.email}}</td>
                <td>{{customer.phone}}</td>
                <td>
                  <span class="badge bg-success" v-if="customer.isActive">Active</span>
                  <span class="badge bg-danger" v-else>Inactive</span>
                </td>
                <td>
                  <button 
                    type="button" 
                    class="btn btn-light btn-sm btn-outline-dark" 
                    data-bs-toggle="modal" 
                    data-bs-target="#edit-customer-modal">Edit</button>
                </td>
                <td>
                  <button v-if="customer.isActive" type="button" class="btn btn-danger btn-sm me-2">Deactivate</button>
                  <button v-else type="button" class="btn btn-success btn-sm">Reactivate</button>
                </td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
</style>