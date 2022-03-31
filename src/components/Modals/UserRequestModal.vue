<script setup>
defineProps({
  modalID: String,
});
</script>

<!-- 
TODO: 
- clear input fields when canceled is pressed
- add time picker
- fix spacing between months and years after clicking on them
- add event type drop down menu if there are predefined types
- is price input by user as an offer or calculated based on time?
- maybe add address selector?
-->

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
          <h5 class="modal-title" id="staticBackdropLabel">New Request</h5>
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
              <input type="text" class="form-control" id="event-name-input" />
            </div>
            <div class="mb-3">
              <label for="event-type-input" class="form-label"
                >Event Type</label
              >
              <input type="text" class="form-control" id="date-input" />
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
              />
            </div>
            <div class="mb-3">
              <label for="start-time-input" class="form-label"
                >Start Time</label
              >
              <input type="text" class="form-control" id="start-time-input" />
            </div>
            <div class="mb-3">
              <label for="end-time-input" class="form-label">End Time</label>
              <input type="text" class="form-control" id="end-time-input" />
            </div>
            <div class="mb-3">
              <label for="location-input" class="form-label">Location</label>
              <input type="text" class="form-control" id="location-input" />
            </div>
            <div class="mb-3">
              <label for="price-input" class="form-label">Price</label>
              <input type="text" class="form-control" id="price-input" />
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
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
.datepicker {
  width: 25%;
}

.table-condensed {
  width: 100%;
  text-align: center;
}
</style>
