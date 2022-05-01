import axios from "axios";
import useUserStore from '@/store/userStore';
import utils from '@/utils';

const info = async (token, id) => {
  console.log("token", token, id);
  const instance = axios.create({
    baseURL: "http://localhost:8080",
    // timeout: 1000,
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
  var session_url = "http://localhost:8080/users";
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
      roles: roles
    })
    .then((r) => {
      console.log(r);
      // return r.data;
    })

    .catch(function (error) {
      console.log(error.response.data);
    });
};

const login = async (loginInfo) => {
  var session_url = "http://localhost:8080/auth/login";
  var uname = loginInfo.account;
  var pass = loginInfo.password;
  console.log("login", uname, pass);

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
      console.log(r);
      return r.data;
    })

    .catch(function (error) {
      console.log("Error on Authentication");
    });
};

const updateUserInfo = async (updatedInfo) => {
  const userStore = useUserStore();
  let id = userStore.id
  var session_url = `http://localhost:8080/users/${id}`;
  var uname = updatedInfo.account;
  var fname = updatedInfo.fname;
  var lname = updatedInfo.lname;
  var phone = updatedInfo.tel;
  var roles = updatedInfo.roles;

  await axios.put(session_url,
      {
        username: uname,
        firstname: fname,
        lastname: lname,
        phone: phone,
        roles: roles
      },
    )
}

const getAllSuperFrogs = async () => {
  let token = utils.cacheUtils.get('login_token')?.token
  const instance = axios.create({
    baseURL: "http://localhost:8080",
    timeout: 1000,
    headers: { Authorization: "Bearer " +  token},
  });
  return await instance
    .get("/users/superfrogs")
    .then((res) => {
      console.log(res.data);
      return res.data;
    })
    .catch((error) => {
      console.error(error.response.data);
    });
}

const getAllCustomers = async () => {
  let token = utils.cacheUtils.get('login_token')?.token
  const instance = axios.create({
    baseURL: "http://localhost:8080",
    timeout: 1000,
    headers: { Authorization: "Bearer " +  token},
  });
  return await instance
    .get("/users/customers")
    .then((res) => {
      console.log(res.data);
      return res.data;
    })
    .catch((error) => {
      console.error(error.response.data);
    });
}

const assignSuperFrog = async (requestId, userId) => {
  var session_url = `http://localhost:8080/users/${userId}/${requestId}`;

  const res = await axios.put(session_url);
}

const removeAssignment = async (requestId) => {
  var session_url = `http://localhost:8080/users/remove/${requestId}`;
  const res = await axios.put(session_url);
  console.log(res);
}

export default {
  info,
  login,
  register,
  updateUserInfo,
  getAllSuperFrogs,
  getAllCustomers,
  assignSuperFrog,
  removeAssignment
};
