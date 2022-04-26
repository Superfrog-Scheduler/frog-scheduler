import utils from '@/utils';
import useUserStore from '@/store/userStore';

function setupGuard(router) {
  router.beforeEach((to, from) => {
    // if the "to" page requires authentication but there is no token stored in localStorage,
    // redirect to the login page
    if (to.meta.requiresAuth && !isLoggedIn(to)) {
      return {
        name: 'auth.login',
      };
    }

    // if a logged in user tries to access the login page, redirect back to where comes from
    if (isVisitorOnly(to)) {
      return from;
    }

    // get user info and save to Pinia
    getUserInfo();
  });
}

function isLoggedIn(route) {
  let token = getToken();
  const status = token ? true : false;

  // if user is not logged in, we need to cache the requested page so that we can redirect to
  // this page after user logs in, this has a better user experience
  if (!status) {
    utils.cacheUtils.set('requested_page_prior_login', route.name);
  }
  return status;
}

// Some views are for visitor only (e.g., login view)
function isVisitorOnly(route) {
  let token = getToken();
  // if logged in and this page is visitor only return true
  return route.meta.visitorOnly && token;
}

function getToken() {
  return utils.cacheUtils.get('login_token')?.token;
}

function getUserInfo() {
  const userStore = useUserStore();
  let token = getToken()
  if (token) {
    userStore.getUserInfo(token);
  }
}

export default setupGuard;
