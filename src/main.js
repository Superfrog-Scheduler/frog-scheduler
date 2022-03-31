import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap";
import "bootstrap-datepicker";

createApp(App).use(router).mount("#app");
