import { createWebHistory, createRouter } from "vue-router"
import Home from "../components/Home.vue"
import SuperFrogTeamDashboard from "../components/UserAccountManagement/SuperFrogTeamDashboard.vue";
import CustomerDashboard from "../components/UserAccountManagement/CustomerDashboard.vue";
import SpiritDirectorDashboard from "../components/UserAccountManagement/SpiritDirectorDashboard.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: Home,
  },
  {
    path: "/team/requests",
    name: "SuperFrogTeamDashboard",
    component: SuperFrogTeamDashboard,
  },
  {
    path: "/customer/requests",
    name: "CustomerDashboard",
    component: CustomerDashboard,
  },
  {
    path: "/director/requests",
    name: "SpiritDirectorDashboard",
    component: SpiritDirectorDashboard,
  }
]

const router = createRouter({ 
  history: createWebHistory(),
  routes
 })

export default router