import { createWebHistory, createRouter } from "vue-router"
import Home from "../components/Home.vue"
import SuperFrogTeamRequestsView from "../components/UserAccountManagement/SuperFrogTeam/SuperFrogTeamRequestsView.vue";
import CustomerRequestsView from "../components/UserAccountManagement/Customer/CustomerRequestsView.vue";
import SpiritDirectorRequestsView from "../components/UserAccountManagement/SpiritDirector/SpiritDirectorRequestsView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: Home,
  },
  {
    path: "/team/requests",
    name: "SuperFrogTeamRequestsView",
    component: SuperFrogTeamRequestsView,
  },
  {
    path: "/customer/requests",
    name: "CustomerRequestsView",
    component: CustomerRequestsView,
  },
  {
    path: "/director/requests",
    name: "SpiritDirectorRequestsView",
    component: SpiritDirectorRequestsView,
  }
]

const router = createRouter({ 
  history: createWebHistory(),
  routes
 })

export default router