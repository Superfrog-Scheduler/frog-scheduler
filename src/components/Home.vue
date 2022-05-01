<script>
import router from "../router";
import SignInModal from "./Modals/SignInModal.vue";
import SignUpModal from "./Modals/SignUpModal.vue";

export default {
  components: { SignInModal, SignUpModal },
  props: ["show"],
};
</script>

<template>
  <section class="colored-section" id="title">
    <div class="container-fluid">
      <!-- Nav Bar -->

      <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand" href="">Super Frog Scheduler</a>

        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarTogglerDemo02"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#pricingModal" >Pricing</a>
            </li>
            <div class="modal fade" id="pricingModal" tabindex="-1" aria-labelledby="pricingModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="pricingModalLabel">Pricing</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <p>Prices are based on a 1 hour appearance – Additional fees may apply if more than one hour.</p>
                    <p>SuperFrog appearance Flat Fee - $100/hr</p>
                  </div>
                </div>
              </div>
            </div>
            <li class="nav-item">
              <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#rangeModal" >Range</a>
            </li>
            <div class="modal fade" id="rangeModal" tabindex="-1" aria-labelledby="rangeModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="rangeModalLabel">Range</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <p>We only service requests that are within 100 mile radius from Amon G. Carter Stadium.</p>
                  </div>
                </div>
              </div>
            </div>
          </ul>
        </div>
      </nav>

      <!-- Title -->

      <div class="row">
        <SignInModal id="sign-in-modal" :show="show" />
        <SignUpModal id="sign-up-modal" />

        <div class="col-lg-6 row-item">
          <h1 class="big-heading" id="header">
            Have Super Frog at your event.
          </h1>
          <button
            type="button"
            class="btn btn-dark btn-lg sign-button"
            data-bs-toggle="modal"
            data-bs-target="#sign-in-modal"
            
          >
            Sign In
          </button>
          <button
            type="button"
            class="btn btn-outline-light btn-lg sign-button"
            data-bs-toggle="modal"
            data-bs-target="#sign-up-modal"
          >
            Sign Up
          </button>
        </div>

        <div class="col-lg-6 row-item">
          <img
            class="title-image rounded"
            src="../../images/superfrog.jpg"
            alt="superfrog"
          />
        </div>
      </div>
    </div>
  </section>
</template>

<style scoped>
a {
  color: #42b983;
}

body {
  font-family: "Montserrat";
  text-align: center;
}

h1,
h2,
h3,
h4,
h5,
h6 {
  font-family: "Montserrat-Bold";
}

p {
  color: #8f8f8f;
}

/* Headings */

.big-heading {
  font-family: "Montserrat-Black";
  font-size: 3.5rem;
  line-height: 1.5;
}

/* Containers */

.container-fluid {
  padding: 7% 15%;
}

.row-item {
  height: 100%;
}

/* Sections */

.colored-section {
  background-color: #ff4c68;
  height: 100vh;
}

/* Navigation Bar */

.navbar {
  padding: 0 0 4.5rem;
}

.navbar-brand {
  font-family: "Ubuntu";
  font-size: 2.5rem;
  font-weight: bold;
}

.nav-item {
  padding: 0 18px;
}

.nav-link {
  font-size: 1.2rem;
  font-family: "Montserrat-Light";
}

.navbar-collapse {
  display: flex;
  justify-content: flex-end;
}

/* Buttons */

.sign-button {
  margin: 5% 3% 5% 0;
}

/* Title Section */

#title {
  background-color: #4d1979;
  text-align: left;
}

#title .container-fluid {
  padding: 3% 10%;
}

#header {
  color: white;
}

/* Title Image */

.title-image {
  width: 500px;
}

@media (max-width: 1028px) {
  #title {
    text-align: center;
  }

  .title-image {
    position: static;
    transform: rotate(0);
  }
}
</style>
