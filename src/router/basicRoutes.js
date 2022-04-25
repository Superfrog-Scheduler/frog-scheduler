const basicRoutes = [
  {
    path: "/",
    name: "mainLayout",
    meta: {
      requiresAuth: false,
    },
    component: () => import("@/layouts/MainLayout.vue"),
    redirect: { name: "home" },
    children: [
      {
        path: "home",
        name: "home",
        meta: {
          title: "Home",
          requiresAuth: false,
        },
        component: () => import("@/components/Home.vue"),
      },
      {
        path: "/director",
        name: "director",
        meta: {
          title: "Director",
          requiresAuth: true,
          role: "director",
        },
        component: () =>
        import("@/components/UserAccountManagement/SpiritDirectorDashboard.vue"),
        redirect: { name: "SpiritDirectorRequestsTable" },
        children: [
          {
            path: "requests",
            name: "SpiritDirectorRequestsTable",
            meta: {
              requiresAuth: true
            },
            component: () => import("@/components/Tables/SpiritDirectorRequestsTable.vue"),
          },
          {
            path: "team",
            name: "SpiritDirectorTeamTable",
            meta: {
              requiresAuth: true
            },
            component: () => import("@/components/Tables/SpiritDirectorTeamTable.vue"),
          },
          {
            path: "customers",
            name: "SpiritDirectorCustomerTable",
            meta: {
              requiresAuth: true
            },
            component: () => import("@/components/Tables/SpiritDirectorCustomerTable.vue"),
          },
        ],
      },
      {
        path: "customer",
        name: "customer",
        meta: {
          title: "Customer",
          requiresAuth: true,
          role: "customer",
        },
        component: () =>
          import("@/components/UserAccountManagement/CustomerDashboard.vue"),
        redirect: { name: "CustomerTable" },
        children: [
          {
            path: "requests",
            name: "CustomerTable",
            meta: {
              requiresAuth: true
            },
            component: () => import("@/components/Tables/CustomerTable.vue"),
          },
          {
            path: "profile",
            name: "CustomerProfile",
            meta: {
              requiresAuth: true
            },
            component: () => import("@/components/Tables/CustomerProfile.vue"),
          },
        ],
      },
      {
        path: "team",
        name: "team",
        meta: {
          title: "Team",
          requiresAuth: true,
          role: "team",
        },
        component: () =>
          import("@/components/UserAccountManagement/SuperFrogTeamDashboard.vue"),
        redirect: { name: "SuperFrogTeamTable" },
        children: [
          {
            path: "requests",
            name: "SuperFrogTeamTable",
            meta: {
              requiresAuth: true
            },
            component: () => import("@/components/Tables/SuperFrogTeamTable.vue"),
          },
          {
            path: "profile",
            name: "SuperFrogTeamProfile",
            meta: {
              requiresAuth: true
            },
            component: () => import("@/components/Tables/SuperFrogTeamProfile.vue"),
          },
        ],
      },
    ],
  },
  {
    path: "/auth",
    meta: {
      requiresAuth: false,
    },
    component: () => import("@/layouts/AuthLayout.vue"),
    children: [
      {
        path: "login",
        name: "auth.login",
        component: () => import("@/layouts/AuthLayout.vue"),
        meta: {
          visitorOnly: true,
          requiresAuth: false,
        },
      },
    ],
  },
];

export default basicRoutes;
