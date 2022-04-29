import axios from "axios";
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
  var eventName = newRequestInfo.eventName;
  var eventType = newRequestInfo.eventType;
  var date = newRequestInfo.date;
  var startTime = newRequestInfo.startTime;
  var endTime = newRequestInfo.endTime;
  var location = newRequestInfo.location;
  var price = newRequestInfo.price;
  var customer = newRequestInfo.customer;

  return await axios
    .post(session_url, {
      eventName: eventName,
      eventType: eventType,
      date: date,
      startTime: startTime,
      endTime: endTime,
      location: location,
      price: price,
      customer: customer  
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
  let id = updatedInfo.id
  var session_url = `http://localhost:8080/requests/${id}`;
  var eventName = updatedInfo.eventName;
  var eventType = updatedInfo.eventType;
  var date = updatedInfo.date;
  var startTime = updatedInfo.startTime;
  var endTime = updatedInfo.endTime;
  var location = updatedInfo.location;
  var price = updatedInfo.price;
  var customer = updatedInfo.customer;
  var status = updatedInfo.status;
  console.log("update");
  console.log(session_url);
  console.log(updatedInfo);

  await axios.put(session_url,
    {
      id: id,
      eventName: eventName,
      eventType: eventType,
      date: date,
      startTime: startTime,
      endTime: endTime,
      location: location,
      price: price,
      customer: customer,
      status: status
    })
    .then((r) => {
      console.log(r);
      // return r.data;
    })

    .catch(function (error) {
      console.log(error);
    });
}

const getAllRequests = async () => {
  let token = utils.cacheUtils.get('login_token')?.token
  console.log(token);
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
