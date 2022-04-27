<script setup>
let requestList = [
    {
      id: 3,
      name: 'Book Reading',
      type: 'Public School',
      customer: 'Sherrie Jackson',
      date: '03/30/2022',
      startTime: '2:00 PM',
      endTime: '4:00 PM',
      location: '4300 Campus Dr',
      price: '$200',
      status: 'Assigned',
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
    },
  ]
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
                <td>{{request.name}}</td>
                <td>{{request.type}}</td>
                <td>{{request.customer}}</td>
                <td>{{request.date}}</td>
                <td>{{request.startTime}}</td>
                <td>{{request.endTime}}</td>
                <td>{{request.location}}</td>
                <td>{{request.price}}</td>
                <td>
                  <span class="badge bg-danger" v-if="request.status=='Assigned'">Assigned to Me</span>
                  <span class="badge bg-success" v-if="request.status=='Completed'">Completed</span>
                </td>
                <td>
                  <button v-if="request.status=='Assigned'" type="button" class="btn btn-success btn-sm me-2">Mark Complete</button>
                </td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
</style>
