<script>
import userApi from "@/apis/userApi";

export default {
  emits: ['assign-superfrog'],
  props: ['selectedRequest'],
  data() {
    return {
      studentList: [],
    };
  },
  methods: {
    async getAll() {
      const res = await userApi.getAllSuperFrogs();
      this.studentList = res.data;
    },
    async assignSuperFrog(studentId) {
      console.log(this.selectedRequest);
      this.$emit('assign-superfrog', this.selectedRequest);
      await userApi.assignSuperFrog(this.selectedRequest.id, studentId);
    }
  },
  mounted() {
    this.getAll()
  },
};
</script>

<template>
  <div
    class="modal fade"
    id="assign-request-modal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">Assign SuperFrog</h5>
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
                  </tr>
              </thead>
              <tbody>
                <tr v-for="student in studentList" :key="student.id">
                  <td>{{student.firstname.concat(" ", student.lastname)}}</td>
                  <td>
                    <button type="button" 
                      @click="assignSuperFrog(student.id)" 
                      class="btn btn-success btn-sm" 
                      data-bs-dismiss="modal">
                      Select</button>
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
