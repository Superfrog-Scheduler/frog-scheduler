<script>
import v from "@/plugins/validation";
import { Form, Field, ErrorMessage } from "vee-validate";
import { Modal } from "bootstrap";
import requestApi from "@/apis/requestApi";

export default {
  components: { Modal, Form, Field, ErrorMessage, v },
  emits: ["sort"],
  methods: {
    async sort(values) {
      console.log(values);
      let s = values.start.split("-");
      let start = s[1] + "-" + s[2] + "-" + s[0];
      let e = values.end.split("-");
      let end = e[1] + "-" + e[2] + "-" + e[0];
      const res = await requestApi.getAllByDates(start, end)
      this.$emit('sort', res.data)
    },
  },
};
</script>

<template>
  <div
    class="modal fade"
    id="sort-modal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <Form
      @submit="sort"
      :validation-schema="validationSchema"
      v-slot:default="{ errors }"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">
              Sort Requests by Dates
            </h5>
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
                <label for="event-type-input" class="form-label date"
                  >Start Date</label
                >
                <Field
                  name="start"
                  as="input"
                  type="date"
                  class="form-control"
                  label="Start"
                  placeholder="Input start date"
                ></Field>
                <ErrorMessage name="start" as="div"></ErrorMessage>
              </div>
              <div class="mb-3">
                <label for="event-type-input" class="form-label date"
                  >End Date</label
                >
                <Field
                  name="end"
                  as="input"
                  type="date"
                  class="form-control"
                  label="Start"
                  placeholder="Input start date"
                ></Field>
                <ErrorMessage name="end" as="div"></ErrorMessage>
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
            <button
              type="submit"
              class="btn btn-primary"
              data-bs-dismiss="modal"
            >
              Save
            </button>
          </div>
        </div>
      </div>
    </Form>
  </div>
</template>

<style></style>
