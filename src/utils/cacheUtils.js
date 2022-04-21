export default {
    set(key, data, expire) {
      let cachedValue = { data };
      if (expire) {
        cachedValue.expire = new Date().getTime() + expire * 1000;
      }
      localStorage.setItem(key, JSON.stringify(cachedValue));
    },
    get(key) {
      const cachedValueString = localStorage.getItem(key);
      if (cachedValueString) {
        // if token exists
        const cachedValue = JSON.parse(cachedValueString);
        const expire = cachedValue.expire;
  
        // console.log(cachedValue);
        if (expire && expire < new Date().getTime()) {
          localStorage.removeItem(key);
          return null;
        } else {
          return cachedValue.data; // return data
        }
      }
      return null;
    },
    remove(key) {
      localStorage.removeItem(key);
    },
  };
  