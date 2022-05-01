<script>
import { ref } from "vue";
import v from "@/plugins/validation";
import { Form, Field, ErrorMessage } from "vee-validate";
import { Modal } from "bootstrap";
import userApi from '@/apis/userApi';

export default {
  props: ["show"],
  components: { Modal, Form, Field, ErrorMessage, v },
  data() {
    return {
      validationSchema: v.yup.object({
        fname: v.yup.string().required().label("First name"),
        lname: v.yup.string().required().label("Last name"),
        account: v.yup.string().required().email().label("Account name"),
        tel: v.yup.string().required().length(10).matches(/^[0-9]+$/, "Must be only digits").label("Phone number"),
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
      userApi.register(values)
      var message = new Modal(document.getElementById("messageModal"))
      message.show()
    },
    clearInputFields: () => {
      let firstName = ref("");
      let lastName = ref("");
      let email = ref("");
      let phone = ref("");
      let password = ref("");
      let confimrPassword = ref("");
      firstName.value = "";
      lastName.value = "";
      email.value = "";
      phone.value = "";
      password.value = "";
      confimrPassword.value = "";
    },
  },
  mounted() {
    var myModal = new Modal(document.getElementById("sign-up-modal"));
    if (this.show) myModal.show();
  },
};
</script>

<template>
  <div
    class="modal fade"
    id="sign-up-modal"
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
                <Field
                  name="fname"
                  as="input"
                  type="text"
                  class="form-control"
                  label="First name"
                  placeholder="Input your first name"
                ></Field>
                <ErrorMessage name="fname" as="div"></ErrorMessage>
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
                  placeholder="Input your last name"
                ></Field>
                <ErrorMessage name="lname" as="div"></ErrorMessage>
              </div>
              <div class="mb-3">
                <label for="email-input" class="form-label date">Email</label>
                <Field
                  name="account"
                  as="input"
                  type="text"
                  class="form-control"
                  label="Account name"
                  placeholder="Input your account email"
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
                  placeholder="Input your phone number"
                ></Field>
                <ErrorMessage name="tel" as="div"></ErrorMessage>
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
                  placeholder="Input your password"
                ></Field>
                <ErrorMessage name="password" as="div"></ErrorMessage>
              </div>
              <div class="mb-3">
                <label for="confirm-password-input" class="form-label"
                  >Confirm Password</label
                >
                <Field
                  name="passwordConfirmation"
                  as="input"
                  type="password"
                  class="form-control"
                  :validate-on-input="true"
                  label="Password Confirmation"
                  placeholder="Re-confirm your password"
                ></Field>
                <div v-if="errors.passwordConfirmation" class="bing-error">
                  Passwords must match
                </div>
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
            <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Submit</button>
          </div>
        </div>
      </div>
    </Form>
  </div>

<!-- Modal -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Message</h5>
      </div>
      <div class="modal-body">
        Register new account successfully! Now you can login!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</template>

<style></style>
