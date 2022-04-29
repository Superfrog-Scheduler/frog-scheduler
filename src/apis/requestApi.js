import axios from "axios";
import requestStore from '@/store/requestStore';
import utils from '@/utils';

const info = async (token, id) => {
  console.log("token", token, id);
  const instance = axios.create({
    baseURL: "http://localhost:8080",
    timeout: 1000,
    headers: { Authorization: "Bearer " + token },
  });
  return await instance
    .get(`/requests/${id}`)
    .then((res) => {
      console.log(res.data);
      return res.data;
    })
    .catch((error) => {
      console.error(error.response.data);
    });
};

const makeRequest = async (newRequestInfo) => {
  var session_url = "http://localhost:8080/requests";
  var name = newRequestInfo.account;
  var type = newRequestInfo.type;
  var date = newRequestInfo.date;
  var startTime = newRequestInfo.startTime;
  var endTime = newRequestInfo.endTime;
  var location = newRequestInfo.location;
  var price = newRequestInfo.price;
  return await axios
    .post(session_url, {
      name: name,
      type: type,
      date: date,
      startTime: startTime,
      endTime: endTime,
      location: location,
      price: price
    })
    .then((r) => {
      console.log(r);
      // return r.data;
    })

    .catch(function (error) {
      console.log(error);
    });
};

const update = async (updatedInfo) => {
  const requestStore = requestStore();
  let id = requestStore.id
  var session_url = `http://localhost:8080/requests/${id}`;
  var name = updatedInfo.account;
  var type = updatedInfo.type;
  var date = updatedInfo.date;
  var startTime = updatedInfo.startTime;
  var endTime = updatedInfo.endTime;
  var location = updatedInfo.location;
  var price = updatedInfo.price;

  await axios.put(session_url,
    {
      name: name,
      type: type,
      date: date,
      startTime: startTime,
      endTime: endTime,
      location: location,
      price: price  
    })
}

const getAllRequests = async () => {
  let token = utils.cacheUtils.get('login_token')?.token
  const instance = axios.create({
    baseURL: "http://localhost:8080",
    timeout: 1000,
    headers: { Authorization: "Bearer " + token },
  });
  return await instance
    .get("/requests")
    .then((res) => {
      console.log(res.data);
      return res.data;
    })
    .catch((error) => {
      console.error(error.response.data);
    });
}
export default { info, makeRequest, update, getAllRequests };
