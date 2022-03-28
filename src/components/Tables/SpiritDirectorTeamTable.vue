<script setup>
    let superfrogStudentList = [
        {
          id: 0,
          name: 'Yilika Loufoua',
          appearances: 2
        },
        {
          id: 1,
          name: 'Quinh Dong',
          appearances: 1
        },
        {
          id: 2,
          name: 'Chase Lennartson',
          appearances: 3
        },
        {
          id: 3,
          name: 'Lucas Karwal',
          appearances: 0
        },
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
                    <th scope="col">Student ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">appearances</th> 
                </tr>
            </thead>
            <tbody>
              <tr v-for="student in superfrogStudentList" :key="student.id">
                <td>{{student.id}}</td>
                <td>{{student.name}}</td>
                <td>{{student.appearances}}</td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
</style>