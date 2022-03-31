<script setup>
defineProps({
  msg: String,
});
</script>

<template>
  <!-- <p>
    <router-link to="/director/requests">Go to SpiritDirector</router-link>
    <br/>
    <router-link to="/team/requests">Go to SuperFrogTeam</router-link>
    <br/>
    <router-link to="/customer/requests">Go to Customer</router-link>
    <br/>
  </p> -->
    <section class="colored-section" id="title">

    <div class="container-fluid">

      <!-- Nav Bar -->

      <nav class="navbar navbar-expand-lg navbar-dark">

        <a class="navbar-brand" href="">Super Frog Scheduler</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">

          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="#">Request</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#pricing">Pricing</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Range</a>
            </li>
          </ul>

        </div>
      </nav>


      <!-- Title -->

      <div class="row">

        <div class="col-lg-6 row-item">
          <h1 class="big-heading">Have Super Frog at your event.</h1>
          <button type="button" class="btn btn-dark btn-lg sign-button"><i class="fab fa-apple"></i> Sign In</button>
          <button type="button" class="btn btn-outline-light btn-lg sign-button"><i class="fab fa-google-play"></i> Sign Up</button>
          <div class="temp">
              <router-link to="/director/requests">Go to SpiritDirector</router-link>
              <br/>
              <router-link to="/team/requests">Go to SuperFrogTeam</router-link>
              <br/>
              <router-link to="/customer/requests">Go to Customer</router-link>
              <br/>
              </div>
        </div>

        <div class="col-lg-6 row-item">
          <img class="title-image rounded" src="../../images/superfrog.jpg" alt="superfrog">
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

h1, h2, h3, h4, h5, h6 {
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

.container-fluid{
  padding: 7% 15%;
}

.row-item {
  height: 100%;
}

/* Sections */

.colored-section {
  background-color: #ff4c68;
  color: #fff;
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

.navbar-collapse{
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
  color: #fff;
  text-align: left;
}

#title .container-fluid {
  padding: 3% 10%;
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
