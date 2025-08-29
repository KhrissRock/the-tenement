<template>
  <header class="br-header">
    <div class="br-header__logo">
      <a href="/">
        <img src="@/assets/govbr-logo.svg" alt="Governo Federal">
      </a>
    </div>

    <div class="br-header__content">
      <nav class="br-menu">
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="/sobre">Sobre</a></li>
          <li><a href="/servicos">Serviços</a></li>
        </ul>
      </nav>

      <div class="br-header__actions">
        <button class="br-button" type="button" @click="goToLogin">
          <i class="fas fa-user"></i>
          Entrar
        </button>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: 'Header',
  methods: {
    goToLogin() {
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
.br-header {
  background: #1351B4;
  color: white;
}
</style>