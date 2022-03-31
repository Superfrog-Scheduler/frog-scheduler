<script setup>
    let studentList = [
        {
          id: 0,
          name: 'Yilika Loufoua',
          email: 'y.loufoua@tcu.edu',
          phone: '817-990-3244',
          classification: 'Senior',
          requestsTaken: 3,
        },
        {
          id: 1,
          name: 'Quynh Dong',
          email: 'q.dong@tcu.edu',
          phone: '817-234-9843',
          classification: 'Sophomore',
          requestsTaken: 1,
        },
        {
          id: 2,
          name: 'Chase Lennartson',
          email: 'c.lennartson@tcu.edu',
          phone: '817-039-2935',
          classification: 'Junior',
          requestsTaken: 2,
        },
        {
          id: 3,
          name: 'Lucas Karwal',
          email: 'l.karwal@tcu.edu',
          phone: '682-323-5236',
          classification: 'Senior',
          requestsTaken: 5,
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
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Classification</th>
                    <th scope="col">Requests Taken</th>
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
              </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
</style>