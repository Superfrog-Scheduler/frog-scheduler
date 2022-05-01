<script>
import v from "@/plugins/validation";
import { Form, Field, ErrorMessage } from "vee-validate";
import { Modal } from "bootstrap";


export default {
  components: { Modal, Form, Field, ErrorMessage, v },
  props: ['roles'],
  data() {
    return {
      validationSchema: v.yup.object({
        fname: v.yup.string().required().label("First name"),
        lname: v.yup.string().required().label("Last name"),
        account: v.yup.string().required().email().label("Account name"),
        tel: v.yup
          .string()
          .required()
          .length(10)
          .matches(/^[0-9]+$/, "Must be only digits")
          .label("Phone number"),
      }),
    };
  },
  emits: ['user-update'],
  methods: {
    async update(values) {
      this.$emit('user-update', values)
    },

  },
};
</script>

<template>
  <div
    class="modal fade"
    id="edit-user-modal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <Form
      @submit="update"
      :validation-schema="validationSchema"
      v-slot:default="{ errors }"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Edit User Info</h5>
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
              <label for="fname-input" class="form-label">First Name</label>
              <Field
                  name="fname"
                  as="input"
                  type="text"
                  class="form-control"
                  label="First name"
                  placeholder="Input first name"
                ></Field>
                <ErrorMessage name="fname" as="div"></ErrorMessage>
            </div>
            <div class="mb-3">
              <label for="lname-input" class="form-label">Last Name</label>
             <Field
                  name="lname"
                  as="input"
                  type="text"
                  class="form-control"
                  label="Last name"
                  placeholder="Input last name"
                ></Field>
                <ErrorMessage name="lname" as="div"></ErrorMessage>
            </div>
              <div class="mb-3">
              <label for="email-input" class="form-label">Email</label>
              <Field
                  name="account"
                  as="input"
                  type="text"
                  class="form-control"
                  label="Account name"
                  placeholder="Input account email"
                ></Field>
                <div v-if="errors.account" class="bing-error">
                  Account name must be a valid email address
                </div>
            </div>
              <div class="mb-3">
              <label for="phone-input" class="form-label">Phone</label>
              <Field
                  name="tel"
                  as="input"
                  type="text"
                  class="form-control"
                  label="Phone number"
                  placeholder="Input phone number"
                ></Field>
                <ErrorMessage name="tel" as="div"></ErrorMessage>
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
            <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Save</button>
          </div>
        </div>
      </div>
    </Form>
  </div>
</template>

<style></style>
