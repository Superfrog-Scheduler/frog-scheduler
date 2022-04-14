<script setup>
import { ref } from "vue";

defineProps({
  modalID: String,
});

let email = ref("");
let password = ref("");

function clearInputFields() {
  email.value = "";
  password.value = "";
}
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
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">Sign In</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <form>
            <div class="mb-3">
              <label for="email-input" class="form-label date">Email</label>
              <input
                type="email"
                class="form-control"
                id="email-input"
                v-model="email"
              />
            </div>
            <div class="mb-3">
              <label for="password-input" class="form-label"
                >Password</label
              >
              <input
                type="password"
                class="form-control"
                id="password-input"
                v-model="password"
              />
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
            @click="clearInputFields"
          >
            Cancel
          </button>
          <button type="button" class="btn btn-primary">Submit</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
</style>
