<script setup>
    let requestList = [
        {
          id: 0,
          name: 'Grad Party',
          type: 'Private',
          date: '03/28/2022',
          startTime: '10:00 AM',
          endTime: '11:00 AM',
          location: '2855 W Bowie St',
          price: '$100',
          status: 'Pending',
        },
        {
          id: 1,
          name: 'Wedding',
          type: 'Private',
          date: '03/29/2022',
          startTime: '7:00 PM',
          endTime: '8:00 AM',
          location: '2808 Stanley Ave',
          price: '$100',
          status: 'Approved',
        },
        {
          id: 2,
          name: 'Book Reading',
          type: 'Public School',
          date: '03/30/2022',
          startTime: '2:00 PM',
          endTime: '4:00 PM',
          location: '4300 Campus Dr',
          price: '$200',
          status: 'Confirmed',
        },
        {
          id: 3,
          name: 'Bachelor Party',
          type: 'Private',
          date: '03/28/2022',
          startTime: '10:00 PM',
          endTime: '11:00 PM',
          location: '2901 Stadium Dr',
          price: '$100',
          status: 'Rejected',
        },
    ]
</script>

<template>
    <div class="container col py-3" id="app">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Requests</h4>
            </div>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Request ID</th>
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
                <td>{{request.id}}</td>
                <td>{{request.name}}</td>
                <td>{{request.type}}</td>
                <td>{{request.date}}</td>
                <td>{{request.startTime}}</td>
                <td>{{request.endTime}}</td>
                <td>{{request.location}}</td>
                <td>{{request.price}}</td>
                <td>
                  <span class="badge bg-secondary" v-if="request.status=='Pending'">{{request.status}}</span>
                  <span class="badge bg-success" v-if="request.status=='Approved'">{{request.status}}</span>
                  <span class="badge bg-success" v-if="request.status=='Confirmed'">{{request.status}}</span>
                  <span class="badge bg-danger" v-if="request.status=='Rejected'">{{request.status}}</span>
                </td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
</style>
