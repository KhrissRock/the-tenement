<template>
  <LoginLayout>
    <h2 class="br-heading medium text-center">Acessar Sistema</h2>

    <form @submit.prevent="handleLogin" class="login-form">
      <div class="br-input">
        <label for="cpf">CPF</label>
        <input
            id="cpf"
            v-model="form.cpf"
            type="text"
            placeholder="000.000.000-00"
            required
        >
      </div>

      <div class="br-input">
        <label for="password">Senha</label>
        <input
            id="password"
            v-model="form.password"
            type="password"
            placeholder="Digite sua senha"
            required
        >
      </div>

      <button
          type="submit"
          class="br-button primary block"
          :disabled="loading"
      >
        <span v-if="loading">Carregando...</span>
        <span v-else>Entrar</span>
      </button>

      <div class="login-links">
        <a href="/recuperar-senha">Esqueci minha senha</a>
        <a href="/cadastro">Criar conta</a>
      </div>
    </form>
  </LoginLayout>
</template>

<script>
import LoginLayout from '@/layouts/LoginLayout.vue'

export default {
  name: 'Login',
  components: {
    LoginLayout
  },
  data() {
    return {
      form: {
        cpf: '',
        password: ''
      },
      loading: false
    }
  },
  methods: {
    async handleLogin() {
      this.loading = true
      try {
        // Simulação de login
        await new Promise(resolve => setTimeout(resolve, 1000))
        console.log('Login realizado:', this.form)
        this.$router.push('/dashboard')
      } catch (error) {
        console.error('Erro no login:', error)
      } finally {
        this.loading = false
      }
    }
  }
}
</script>

<style scoped>
.login-form {
  margin-top: 2rem;
}

.br-input {
  margin-bottom: 1.5rem;
}

.block {
  width: 100%;
  margin-bottom: 1rem;
}

.login-links {
  display: flex;
  justify-content: space-between;
  margin-top: 1rem;
}

.login-links a {
  color: #1351B4;
  text-decoration: none;
}

.login-links a:hover {
  text-decoration: underline;
}

.text-center {
  text-align: center;
}
</style>