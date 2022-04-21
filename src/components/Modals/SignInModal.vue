<script>
import { ref } from "vue";
import v from "@/plugins/validation";
import { Form, Field, ErrorMessage } from "vee-validate";
import { Modal } from "bootstrap";
import utils from "@/utils";
import router from "@/router";

export default {
  props: ["show"],
  components: { Modal, Form, Field, ErrorMessage, v },
  data() {
    return {
      validationSchema: v.yup.object({
        account: v.yup.string().required().email().label("Account name"),
        password: v.yup.string().required().min(3).label("Password"),
      }),
    };
  },
  methods: {
    async login(values) {
      utils.userLoginUtils.login(values);
    },
    toDashboard: () => {
      // router.push({ name: 'director' })
    },
    clearInputFields: () => {
      let email = ref("");
      let password = ref("");
      email.value = "";
      password.value = "";
    },
  },
  mounted() {
    var myModal = new Modal(document.getElementById("sign-in-modal"));
    if (this.show) myModal.show();
  },
};
</script>

<template>
  <div
    class="modal fade"
    id="sign-in-modal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <Form
      @submit="login"
      :validation-schema="validationSchema"
      v-slot:default="{ errors }"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Sign In</h5>
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
            <button type="submit" class="btn btn-primary" data-bs-dismiss="modal" @click="toDashboard">Submit</button>
          </div>
        </div>
      </div>
    </Form>
  </div>
</template>

<style></style>
