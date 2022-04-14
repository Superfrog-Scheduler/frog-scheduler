<script setup>
import { ref } from "vue";

defineProps({
  modalID: String,
});

let firstName = ref("");
let lastName = ref("");
let email = ref("");
let phone = ref("");
let password = ref("");
let confimrPassword = ref("");

function clearInputFields() {
  firstName.value = "";
  lastName.value = "";
  email.value = "";
  phone.value = "";
  password.value = "";
  confimrPassword.value = "";
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
         <h5 class="modal-title" id="staticBackdropLabel">Sign Up</h5>
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
              <label for="first-name-input" class="form-label"
                >First Name</label
              >
              <input
                type="text"
                class="form-control"
                id="first-name-input"
                v-model="firstName"
              />
            </div>
            <div class="mb-3">
              <label for="last-name-input" class="form-label"
                >Last Name</label
              >
              <input
                type="text"
                class="form-control"
                id="first-name-input"
                v-model="lastName"
              />
            </div>
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
              <label for="phone-input" class="form-label"
                >Phone</label
              >
              <input
                type="tel"
                class="form-control"
                id="phone-input"
                v-model="phone"
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
            <div class="mb-3">
              <label for="confirm-password-input" class="form-label"
                >Confirm Password</label
              >
              <input
                type="password"
                class="form-control"
                id="confirm-password-input"
                v-model="confirmPassword"
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
