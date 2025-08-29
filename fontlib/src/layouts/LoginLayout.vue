<template>
  <div class="login-layout">
    <div class="br-header compact">
      <div class="br-header__logo">
        <a href="/">
          <img src="@/assets/govbr-logo.svg" alt="Governo Federal">
        </a>
      </div>
    </div>

    <main class="login-content">
      <div class="br-container">
        <div class="login-card">
          <slot></slot>
        </div>
      </div>
    </main>

    <Footer />
  </div>
</template>

<script>
import Footer from '@/components/Footer.vue'

export default {
  name: 'LoginLayout',
  components: {
    Footer
  }
}
</script>

<style scoped>
.login-layout {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.login-content {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #f8f8f8;
  padding: 2rem 0;
}

.login-card {
  background: white;
  padding: 3rem;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  max-width: 400px;
  width: 100%;
}
</style>