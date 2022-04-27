<script>
import v from "@/plugins/validation";
import { Form, Field, ErrorMessage } from "vee-validate";
import { Modal } from "bootstrap";
import userApi from "@/apis/userApi";

export default {
  components: { Modal, Form, Field, ErrorMessage, v },
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
        password: v.yup.string().required().min(3).label("Password"),
        passwordConfirmation: v.yup.string().when("password", {
          is: (val) => (val && val.length > 0 ? true : false),
          then: v.yup
            .string()
            .oneOf(
              [v.yup.ref("password")],
              "Both password need to be the same"
            ),
        }),
      }),
    };
  },
  methods: {
    async register(values) {
      
      values["roles"] = "team"
      console.log(values);
      userApi.register(values);
      var message = new Modal(document.getElementById("messageModal"));
      message.show();
    },
  },
};
</script>

<template>
  <div
    class="modal fade"
    id="add-frog-modal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
      <Form
      @submit="register"
      :validation-schema="validationSchema"
      v-slot:default="{ errors }"
    >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">Add Superfrog</h5>
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
              <label for="password-input" class="form-label">Password</label>
              <Field
                  name="password"
                  as="input"
                  type="password"
                  class="form-control"
                  :validate-on-input="true"
                  label="Password"
                  placeholder="Input password"
                ></Field>
                <ErrorMessage name="password" as="div"></ErrorMessage>
            </div>
            <div class="mb-3">
              <label for="cf-password-input" class="form-label"
                >Confirm Password</label
              >
              <Field
                  name="passwordConfirmation"
                  as="input"
                  type="password"
                  class="form-control"
                  :validate-on-input="true"
                  label="Password Confirmation"
                  placeholder="Re-confirm password"
                ></Field>
                <div v-if="errors.passwordConfirmation" class="bing-error">
                  Passwords must match
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
          Register new frog successfully!
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
