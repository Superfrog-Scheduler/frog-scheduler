import { createApp } from "vue";
import App from "./App.vue";
import router, { setupRouter } from "@/router";
import { setupPlugins } from './plugins';
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap";
import "bootstrap-datepicker";

// createApp(App).use(router).mount("#app");
async function bootstrap() {
    const app = createApp(App);
    setupPlugins(app); // since router will use Pinia, we must set up Pinia first
    setupRouter(app);
  
    await router.isReady(); // wait till router is ready before mounting
    app.mount('#app');
  }
  
  bootstrap();