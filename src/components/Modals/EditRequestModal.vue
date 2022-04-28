<script setup>
import { ref } from "vue";

defineProps({
  modalID: String,
});

let eventName = ref("");
let eventType = ref("");
let date = ref("");
let startTime = ref("");
let endTime = ref("");
let location = ref("");
let price = ref("");

function clearInputFields() {
  eventName.value = "";
  eventType.value = "";
  date.value = "";
  startTime.value = "";
  endTime.value = "";
  location.value = "";
  price.value = "";
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
          <h5 class="modal-title" id="staticBackdropLabel">Edit Request</h5>
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
              <label for="event-name-input" class="form-label"
                >Event Name</label
              >
              <input
                type="text"
                class="form-control"
                id="event-name-input"
                v-model="eventName"
              />
            </div>
            <div class="mb-3">
              <label for="event-type-input" class="form-label"
                >Event Type</label
              >
              <input
                type="text"
                class="form-control"
                id="event-type-input"
                v-model="eventType"
              />
            </div>
            <div class="mb-3">
              <label for="event-type-input" class="form-label date">Date</label>
              <input
                type="text"
                data-provide="datepicker"
                class="form-control"
                id="date-input"
                autocomplete="off"
                data-date-autoclose="true"
                data-date-assume-nearby-year="true"
                v-model="date"
                @blur="updateDate"
                @focus="updateDate"
              />
            </div>
            <div class="mb-3">
              <label for="start-time-input" class="form-label"
                >Start Time</label
              >
              <input
                type="text"
                class="form-control"
                id="start-time-input"
                v-model="startTime"
              />
            </div>
            <div class="mb-3">
              <label for="end-time-input" class="form-label">End Time</label>
              <input
                type="text"
                class="form-control"
                id="end-time-input"
                v-model="endTime"
              />
            </div>
            <div class="mb-3">
              <label for="location-input" class="form-label">Location</label>
              <input
                type="text"
                class="form-control"
                id="location-input"
                v-model="location"
              />
            </div>
            <div class="mb-3">
              <label for="price-input" class="form-label">Price</label>
              <input
                type="text"
                class="form-control"
                id="price-input"
                v-model="price"
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

<style>
.datepicker {
  width: 25%;
}

.table-condensed {
  width: 100%;
  text-align: center;
}
</style>
