<template>
  <DefaultLayout>
    <div class="home-layout">
      <section class="br-hero">
        <div class="br-container">
          <slot name="hero"></slot>
        </div>
      </section>

      <section class="br-container main-content">
        <slot></slot>
      </section>
    </div>
  </DefaultLayout>
</template>

<script>
import DefaultLayout from './DefaultLayout.vue'

export default {
  name: 'HomeLayout',
  components: {
    DefaultLayout
  }
}
</script>

<style scoped>
.home-layout {
  background: linear-gradient(135deg, #1351B4 0%, #0C3266 100%);
  color: white;
}

.main-content {
  padding: 3rem 0;
  background: white;
  color: #1351B4;
}
</style>