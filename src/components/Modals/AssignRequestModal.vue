<script setup>
  // TODO: GET student list
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
  <div
    class="modal fade"
    :id="modalID"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">Assign Super Frog</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <table class="table">
              <thead>
                  <tr>
                      <th scope="col">Name</th>
                      <th scope="col">Classification</th>
                      <th scope="col">Requests Taken</th>
                  </tr>
              </thead>
              <tbody>
                <tr v-for="student in studentList" :key="student.id">
                  <td>{{student.name}}</td>
                  <td>{{student.classification}}</td>
                  <td>{{student.requestsTaken}}</td>
                  <td>
                    <button type="button" class="btn btn-success btn-sm" data-bs-dismiss="modal">Select</button>
                  </td>
                </tr>
              </tbody>
          </table>
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
            @click="clearInputFields">Cancel
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
.datepicker {
  width: 25%;
}

.table-condensed {
  width: 100%;
  text-align: center;
}
</style>
