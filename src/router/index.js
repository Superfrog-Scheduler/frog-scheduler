import { createWebHistory, createRouter } from "vue-router"
import basicRoutes from './basicRoutes';
import setupGuard from './guard';
import useUserStore from '@/store/userStore';
// import autoloadDynamicRoutes from './loadDynamicRoutes';
import utils from '@/utils';

const router = createRouter({ 
  history: createWebHistory(),
  routes: [...basicRoutes]
 })

 export async function setupRouter(app) {
   console.log("index")
  let token = utils.cacheUtils.get('login_token')?.token
  if (token) {
    // get user info and save it to Pinia, then we can have access to user's permission list in different components
    const userStore = useUserStore();
    await userStore.getUserInfo(token);

    const userRole = userStore.userInfo?.role;

    // autoloadDynamicRoutes(router); // add more route records to the router, e.g., /users and /orders
  }
  setupGuard(router); // set up router guard
  app.use(router);
}

export default router