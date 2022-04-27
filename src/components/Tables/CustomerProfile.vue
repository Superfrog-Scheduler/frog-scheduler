<script>
import useUserStore from '@/store/userStore';
export default {
  data() {
    return {
      userInfo: {}
    }
  },
  mounted() {
    const userStore = useUserStore();
    this.userInfo = userStore.userInfo
  }
}
</script>

<template>
  <div class="container col py-3" id="app">
    <div class="card">
      <div class="card-body d-flex justify-content-center">
        <div><!-- empty div so content-between looks good --></div>
        <h4 class="card-title">Profile</h4>
      </div>
    </div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Customer Name</th>
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
