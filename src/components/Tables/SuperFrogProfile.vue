<script>
import EditUserModal from "../Modals/EditUserModal.vue";
import useUserStore from "@/store/userStore";
import userApi from "@/apis/userApi";
import utils from '@/utils';

export default {
  components: { EditUserModal },
  data() {
    return {
      userInfo: {},
      id: -1
    };
  },
  mounted() {
    const userStore = useUserStore();
    this.userInfo = userStore.userInfo;
    this.id = userStore.id;
  },
  emits: ['user-update'],
  methods: {
    async userUpdate(values) {
      values["roles"] = "team";
      console.log("updtae", values);
      userApi.updateUserInfo(values);
      let token = utils.cacheUtils.get('login_token')?.token
      const res = await userApi.info(token, this.id)
      this.userInfo = res.data;
      this.$emit('user-update', this.userInfo)
    },
  },
};
</script>

<template>
  <div class="container col py-3" id="app">
    <div class="card">
      <div class="card-body d-flex justify-content-between">
        <div><!-- empty div so content-between looks good --></div>
        <h4 class="card-title">Profile</h4>

        <EditUserModal
          id="edit-user-modal"
          roles="team"
          :userInfo="userInfo"
          @user-update="userUpdate($event)"
        />
        <button
          type="button"
          class="btn btn-light btn-sm btn-outline-dark"
          data-bs-toggle="modal"
          data-bs-target="#edit-user-modal"
        >
          Edit
        </button>
      </div>
    </div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Student Name</th>
          <th scope="col">E-Mail</th>
          <th scope="col">Phone Number</th>
        </tr>
      </thead>
      <tbody>
        <td>{{ userInfo.firstname }} {{ userInfo.lastname }}</td>
        <td>{{ userInfo.username }}</td>
        <td>{{ userInfo.phone }}</td>
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>
