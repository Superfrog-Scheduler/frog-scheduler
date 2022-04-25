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
          <h5 class="modal-title" id="staticBackdropLabel">Edit Customer Info</h5>
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
              <label for="customer-name-input" class="form-label"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                id="customer-name-input"
                v-model="name"
              />
            </div>
            <div class="mb-3">
              <label for="customer-type-input" class="form-label"
                >Email</label
              >
              <input
                type="text"
                class="form-control"
                id="customer-type-input"
                v-model="email"
              />
            </div>
            <div class="mb-3">
              <label for="phone-input" class="form-label">Phone</label>
              <input
                type="text"
                class="form-control"
                id="phone-input"
                v-model="phone"
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
          <button type="button" class="btn btn-primary">Save</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style></style>
