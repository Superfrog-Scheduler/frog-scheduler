import { createWebHistory, createRouter } from "vue-router"
import Home from "../components/Home.vue"
import SuperFrogTeamRequestsView from "../components/UserAccountManagement/SuperFrogTeam/SuperFrogTeamRequestsView.vue";
import CustomerRequestsView from "../components/UserAccountManagement/Customer/CustomerRequestsView.vue";
import SpiritDirectorRequestsTable from "../components/Tables/SpiritDirectorRequestsTable.vue";
import SpiritDirectorTeamTable from "../components/Tables/SpiritDirectorTeamTable.vue";
import SpiritDirectorCustomerTable from "../components/Tables/SpiritDirectorCustomerTable.vue";
import SpiritDirectorDashboard from "../components/UserAccountManagement/SpiritDirectorDashboard.vue";

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
    path: "/director",
    name: "SpiritDirectorDashboard",
    component: SpiritDirectorDashboard,
    redirect: { name: "SpiritDirectorRequestsTable" },
    children: [
      {
        path: "requests",
        name: "SpiritDirectorRequestsTable",
        component: SpiritDirectorRequestsTable,
      },
      {
        path: "team",
        name: "SpiritDirectorTeamTable",
        component: SpiritDirectorTeamTable,
      },
      {
        path: "customers",
        name: "SpiritDirectorCustomerTable",
        component: SpiritDirectorCustomerTable,
      },
    ],
  },  
]

const router = createRouter({ 
  history: createWebHistory(),
  routes
 })

export default router