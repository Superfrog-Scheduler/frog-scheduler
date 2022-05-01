<script>
import router from "@/router";
import utils from "@/utils";
export default {
  methods: {
    redirect: (num) => {
      switch (num) {
        case 1:
          router.push("/director/requests");
          break;
        case 2:
          router.push("/director/team");
          break;
        case 3:
          router.push("/director/customers");
          break;
        case 4:
          utils.userLoginUtils.logout();
          break;
      }
    },
  },
};
</script>

<template>
  <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
    <div
      class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100"
    >
      <div class="pb-4">
        <img
          src="https://miro.medium.com/max/720/1*W35QUSvGpcLuxPo3SRTH4w.png"
          alt="hugenerd"
          width="155"
          height="155"
          class="d-flex rounded-circle"
        />
        <span class="d-flex fs-5 d-none d-sm-inline">Spirit Director</span>
      </div>
      <ul
        class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
        id="menu"
      >
        <li class="nav-item">
          <i class="fs-4 bi-house"></i>
          <span
            class="ms-1 d-none d-sm-inline text-success link"
            @click="redirect(1)"
            >Request Management
          </span>
        </li>
        <li>
          <i class="fs-4 bi-table"></i>
          <span
            class="ms-1 d-none d-sm-inline text-success link"
            @click="redirect(2)"
            >Team Management
          </span>
        </li>
        <li>
          <i class="fs-4 bi-table"></i>
          <span
            class="ms-1 d-none d-sm-inline text-success link"
            @click="redirect(3)"
            >Customer Management
          </span>
        </li>
        <li>
          <i class="fs-4 bi-table"></i>
          <span
            class="ms-1 d-none d-sm-inline text-success link"
            @click="redirect(4)"
            >Log Out
          </span>
        </li>
      </ul>
      <hr />
    </div>
  </div>
</template>

<style scoped>
a {
  color: #42b983;
}

.link {
  cursor: pointer;
}
</style>
