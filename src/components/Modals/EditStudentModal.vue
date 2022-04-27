<script setup>
import { ref } from "vue";

defineProps({
  modalID: String,
});

let name = ref("");
let email = ref("");
let phone = ref("");

function clearInputFields() {
  name.value = "";
  email.value = "";
  phone.value = "";
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
          <h5 class="modal-title" id="staticBackdropLabel">Edit Student Info</h5>
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
              <label for="student-name-input" class="form-label"
                >First Name</label
              >
              <Field
                name="fname"
                as="input"
                type="text"
                class="form-control"
                label="First name"
              ></Field>
            </div>
            <div class="mb-3">
              <label for="last-name-input" class="form-label"
                >Last Name</label
              >
              <Field
                name="lname"
                as="input"
                type="text"
                class="form-control"
                label="Last name"
              ></Field>

            <div class="mb-3">
              <label for="email-input" class="form-label"
                >Email</label
              >
              <Field
                name="account"
                as="input"
                type="text"
                class="form-control"
                label="Account name"
                placeholder="Input your account email"
              ></Field>
            </div>
            <div class="mb-3">
              <label for="phone-input" class="form-label">Phone</label>
              <Field
                name="tel"
                as="input"
                type="text"
                class="form-control"
                label="Phone number"
                placeholder="Input your phone number"
              ></Field>
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
          <button type="button" class="btn btn-primary">Save</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style></style>
