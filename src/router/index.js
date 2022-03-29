import { createWebHistory, createRouter } from "vue-router"
import Home from "../components/Home.vue"
import SuperFrogTeam from "../components/UserAccountManagement/SuperFrogTeam/SuperFrogTeamRequestsView.vue";
import Customer from "../components/UserAccountManagement/Customer/CustomerRequestsView.vue";
import SpiritDirector from "../components/UserAccountManagement/SpiritDirector/SpiritDirectorRequestsView.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/team",
    name: "SuperFrogTeam",
    component: SuperFrogTeam,
  },
  {
    path: "/customer",
    name: "Customer",
    component: Customer,
  },
  {
    path: "/director",
    name: "SpiritDirector",
    component: SpiritDirector,
  },
]

const router = createRouter({ 
  history: createWebHistory(),
  routes
 })

export default router