import axios from "axios";
import useUserStore from "@/store/userStore";
import utils from "@/utils";

const info = async (token, id) => {
  const instance = axios.create({
    // baseURL: "http://localhost:8080",
    baseURL: "https://boiling-wave-73184.herokuapp.com/",
    headers: { Authorization: "Bearer " + token },
  });
  return await instance
    .get(`/users/${id}`)
    .then((res) => {
      return res.data;
    })
    .catch((error) => {
      console.error(error.response.data);
    });
};

const register = async (registerInfo) => {
  // var session_url = "http://localhost:8080/users";
  var session_url = "https://boiling-wave-73184.herokuapp.com/users";
  var uname = registerInfo.account;
  var pass = registerInfo.password;
  var fname = registerInfo.fname;
  var lname = registerInfo.lname;
  var phone = registerInfo.tel;
  var roles = registerInfo.roles;
  return await axios
    .post(session_url, {
      username: uname,
      password: pass,
      firstname: fname,
      lastname: lname,
      phone: phone,
      roles: roles,
    })
    .then((r) => {
      // return r.data;
    })

    .catch(function (error) {
      console.log(error.response.data);
    });
};

const login = async (loginInfo) => {
  // var session_url = "http://localhost:8080/auth/login";
  var session_url = "https://boiling-wave-73184.herokuapp.com/auth/login";
  var uname = loginInfo.account;
  var pass = loginInfo.password;

  return await axios
    .post(
      session_url,
      {},
      {
        auth: {
          username: uname,
          password: pass,
        },
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
        },
      }
    )
    .then((r) => {
      return r.data;
    })

    .catch(function (error) {
      console.log("Error on Authentication");
      return "Login Fail"
    });
};

const updateUserInfo = async (updatedInfo) => {
  let id = updatedInfo.id;
  // var session_url = `http://localhost:8080/users/${id}`;
  var session_url = `https://boiling-wave-73184.herokuapp.com/users/${id}`;
  var uname = updatedInfo.account;
  var fname = updatedInfo.fname;
  var lname = updatedInfo.lname;
  var phone = updatedInfo.tel;
  var roles = updatedInfo.roles;

  await axios.put(session_url, {
    username: uname,
    firstname: fname,
    lastname: lname,
    phone: phone,
    roles: roles,
  });
};

const reactivateUser = async (userId) => {
  console.log("reactivateUser");
  // var session_url = `http://localhost:8080/users/activate/${userId}`;
  var session_url = `https://boiling-wave-73184.herokuapp.com/users/activate/${userId}`;

  await axios.put(session_url);
};

const deactivateUser = async (userId) => {
  console.log("deactivateUser");
  // var session_url = `http://localhost:8080/users/${userId}`;
  var session_url = `https://boiling-wave-73184.herokuapp.com/users/${userId}`;
  await axios.delete(session_url);
};

const getAllSuperFrogs = async () => {
  let token = utils.cacheUtils.get("login_token")?.token;
  const instance = axios.create({
    // baseURL: "http://localhost:8080",
    baseURL: "https://boiling-wave-73184.herokuapp.com/",
    timeout: 1000,
    headers: { Authorization: "Bearer " + token },
  });
  return await instance
    .get("/users/superfrogs")
    .then((res) => {
      return res.data;
    })
    .catch((error) => {
      console.error(error.response.data);
    });
};

const getAllCustomers = async () => {
  let token = utils.cacheUtils.get("login_token")?.token;
  const instance = axios.create({
    // baseURL: "http://localhost:8080",
    baseURL: "https://boiling-wave-73184.herokuapp.com/",
    timeout: 1000,
    headers: { Authorization: "Bearer " + token },
  });
  return await instance
    .get("/users/customers")
    .then((res) => {
      return res.data;
    })
    .catch((error) => {
      console.error(error.response.data);
    });
};

const assignSuperFrog = async (requestId, userId) => {
  // var session_url = `http://localhost:8080/users/${userId}/${requestId}`;
  var session_url = `https://boiling-wave-73184.herokuapp.com/users/${userId}/${requestId}`;
  const res = await axios.put(session_url);
};

const removeAssignment = async (requestId) => {
  let token = utils.cacheUtils.get("login_token")?.token;
  const instance = axios.create({
    // baseURL: "http://localhost:8080",
    baseURL: "https://boiling-wave-73184.herokuapp.com/",
    timeout: 1000,
    headers: { Authorization: "Bearer " + token },
  });
  return await instance
    .put(`/users/remove/${requestId.id}`)
    .then((res) => {
      return res.data;
    })
    .catch((error) => {
      console.error(error.response.data);
    });
};
export default {
  info,
  login,
  register,
  updateUserInfo,
  getAllSuperFrogs,
  getAllCustomers,
  assignSuperFrog,
  removeAssignment,
  reactivateUser,
  deactivateUser
};
