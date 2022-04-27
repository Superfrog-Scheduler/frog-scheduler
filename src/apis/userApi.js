import axios from "axios";

const info = async (token, id) => {
  console.log("token", token, id);
  const instance = axios.create({
    baseURL: "http://localhost:8080",
    timeout: 1000,
    headers: { Authorization: "Bearer " + token },
  });
  return await instance
    .get(`/users/${id}`)
    .then((res) => {
      console.log(res.data);
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
export default { info, login, register };
