<script>
import v from "@/plugins/validation";
import { Form, Field, ErrorMessage } from "vee-validate";
import { Modal } from "bootstrap";
import requestApi from "@/apis/requestApi";
import useUserStore from '@/store/userStore';

export default {
  components: { Modal, Form, Field, ErrorMessage, v, },
  data() {
    return {
      validationSchema: v.yup.object({
        eventName: v.yup.string().required().label("Event Name"),
        eventType: v.yup.string().required().label("Event Type"),
        date: v.yup.string().required().label("Event Date"),
        startTime: v.yup.string().required().label("Start Time"),
        endTime: v.yup.string().required().label("End Time"),
        location: v.yup.string().required().label("Location"),
      })
    };
  },
  emits: ["new-request"],
  methods: {
    async makeRequest(values) {
      const userStore = useUserStore();
      const userInfo = userStore.userInfo;
      values["customer"] = userInfo
      let d = values.date.split("-")
      values["date"] = d[1] + "-" + d[2] + "-" + d[0]
      await requestApi.makeRequest(values);
      var message = new Modal(document.getElementById("messageModal"));
      message.show();
      this.$emit('new-request')
    }
  }
};
</script>

<template>
  <div
    class="modal fade"
    id="add-request-modal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
      <Form
      @submit="makeRequest"
      :validation-schema="validationSchema"
      v-slot:default="{ errors }"
    >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">Make New Request</h5>
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
              <label for="eventName-input" class="form-label">Event Name</label>
              <Field
                  name="eventName"
                  as="input"
                  type="text"
                  class="form-control"
                  label="Event Name"
                  placeholder="Input event name"
                ></Field>
                <ErrorMessage name="eventName" as="div"></ErrorMessage>
            </div>
            <div class="mb-3">
              <label for="eventType-input" class="form-label">Event Type</label>
             <Field
                  name="eventType"
                  as="input"
                  type="text"
                  class="form-control"
                  label="Event Type"
                  placeholder="Input event type"
                ></Field>
                <ErrorMessage name="eventType" as="div"></ErrorMessage>
            </div>
            <div class="mb-3">
              <label for="date-input" class="form-label">Event Date</label>
             <Field
                  id="date-input"
                  name="date"
                  as="input"
                  type="date"
                  class="form-control"
                  label="Event date"
                  placeholder="Input event date"
                ></Field>
                <ErrorMessage name="date" as="div"></ErrorMessage>
            </div>
            <div class="mb-3">
              <label for="start-time-input" class="form-label">Start Time</label>
             <Field
                  id="start-time-input"
                  name="startTime"
                  as="input"
                  type="text"
                  class="form-control"
                  label="Start time"
                  placeholder="Input start time"
                ></Field>
                <ErrorMessage name="startTime" as="div"></ErrorMessage>
            </div>
            <div class="mb-3">
              <label for="end-time-input" class="form-label">End Time</label>
             <Field
                  id="end-time-input"
                  name="endTime"
                  as="input"
                  type="text"
                  class="form-control"
                  label="End time"
                  placeholder="Input end time"
                ></Field>
                <ErrorMessage name="endTime" as="div"></ErrorMessage>
            </div>
            <div class="mb-3">
              <label for="location-input" class="form-label">Event Location</label>
             <Field
                  name="location"
                  as="input"
                  type="text"
                  class="form-control"
                  label="Event location"
                  placeholder="Input event location"
                ></Field>
                <ErrorMessage name="location" as="div"></ErrorMessage>
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
          <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Submit</button>
        </div>
      </div>
    </div>
    </Form>
  </div>
  <!-- Modal -->
  <div
    class="modal fade"
    id="messageModal"
    tabindex="-1"
    role="dialog"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Message</h5>
        </div>
        <div class="modal-body">
          Submit new request successfully!
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
          >
            Close
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
