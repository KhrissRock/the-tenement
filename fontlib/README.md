Aplicação Vue.js usando o Design System do Governo Federal brasileiro. Aqui está a estrutura completa:

## 1. Estrutura do Projeto

```
src/
├── components/
│   ├── Header.vue
│   ├── Footer.vue
│   └── Loading.vue
├── layouts/
│   ├── DefaultLayout.vue
│   ├── HomeLayout.vue
│   ├── LoginLayout.vue
│   └── ExternalLayout.vue
├── views/
│   ├── Home.vue
│   ├── Login.vue
│   ├── About.vue
│   └── Services.vue
├── App.vue
└── main.js
```

## 2. Configuração Principal (main.js)

```javascript
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// Import do Design System do Governo
import '@govbr-ds/core/dist/core.min.css'

const app = createApp(App)
app.use(router)
app.mount('#app')
```

## 3. Componente App.vue

```vue
<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
@import '@govbr-ds/core/dist/core.min.css';

body {
  margin: 0;
  padding: 0;
  font-family: 'Rawline', sans-serif;
}
</style>
```

## 4. Layouts

### DefaultLayout.vue (Layout Base)
```vue
<template>
  <div class="template-default">
    <Header />
    <main class="template-default-content">
      <slot></slot>
    </main>
    <Footer />
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'

export default {
  name: 'DefaultLayout',
  components: {
    Header,
    Footer
  }
}
</script>

<style scoped>
.template-default {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.template-default-content {
  flex: 1;
}
</style>
```

### HomeLayout.vue (Layout para Home)
```vue
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
```

### LoginLayout.vue (Layout para Login)
```vue
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
```

### ExternalLayout.vue (Layout para Conteúdo Externo)
```vue
<template>
  <DefaultLayout>
    <div class="external-layout">
      <div class="br-container">
        <div class="external-content">
          <slot></slot>
        </div>
      </div>
    </div>
  </DefaultLayout>
</template>

<script>
import DefaultLayout from './DefaultLayout.vue'

export default {
  name: 'ExternalLayout',
  components: {
    DefaultLayout
  }
}
</script>

<style scoped>
.external-layout {
  padding: 2rem 0;
}

.external-content {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
</style>
```

## 5. Componentes

### Header.vue
```vue
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
```

### Footer.vue
```vue
<template>
  <footer class="br-footer">
    <div class="br-container">
      <div class="br-footer__content">
        <div class="br-footer__info">
          <p>© 2024 Governo Federal. Todos os direitos reservados.</p>
        </div>
        
        <div class="br-footer__links">
          <a href="/privacidade">Política de Privacidade</a>
          <a href="/termos">Termos de Uso</a>
          <a href="/acessibilidade">Acessibilidade</a>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'Footer'
}
</script>

<style scoped>
.br-footer {
  background: #0C3266;
  color: white;
  padding: 2rem 0;
}

.br-footer__content {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.br-footer__links a {
  color: white;
  margin-left: 1.5rem;
  text-decoration: none;
}

.br-footer__links a:hover {
  text-decoration: underline;
}
</style>
```

## 6. Views (Páginas)

### Home.vue
```vue
<template>
  <HomeLayout>
    <template #hero>
      <div class="hero-content">
        <h1 class="br-heading large">Bem-vindo ao Portal</h1>
        <p class="br-paragraph">Serviços digitais do Governo Federal</p>
        <button class="br-button primary" @click="exploreServices">
          Explorar Serviços
        </button>
      </div>
    </template>
    
    <div class="services-grid">
      <div class="br-card">
        <div class="br-card__content">
          <h3 class="br-heading small">Serviço 1</h3>
          <p>Descrição do serviço disponível</p>
        </div>
      </div>
      
      <div class="br-card">
        <div class="br-card__content">
          <h3 class="br-heading small">Serviço 2</h3>
          <p>Descrição do serviço disponível</p>
        </div>
      </div>
    </div>
  </HomeLayout>
</template>

<script>
import HomeLayout from '@/layouts/HomeLayout.vue'

export default {
  name: 'Home',
  components: {
    HomeLayout
  },
  methods: {
    exploreServices() {
      this.$router.push('/servicos')
    }
  }
}
</script>

<style scoped>
.hero-content {
  text-align: center;
  padding: 4rem 0;
}

.services-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 2rem;
  margin-top: 2rem;
}
</style>
```

### Login.vue
```vue
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
```

### About.vue (usando ExternalLayout)
```vue
<template>
  <ExternalLayout>
    <h1 class="br-heading large">Sobre o Sistema</h1>
    
    <div class="br-text">
      <p>Este é um sistema desenvolvido utilizando o Design System do Governo Federal brasileiro.</p>
      
      <h2 class="br-heading medium">Características</h2>
      <ul class="br-list">
        <li>Design acessível</li>
        <li>Padrões governamentais</li>
        <li>Interface responsiva</li>
        <li>Conformidade com as diretrizes</li>
      </ul>
    </div>
  </ExternalLayout>
</template>

<script>
import ExternalLayout from '@/layouts/ExternalLayout.vue'

export default {
  name: 'About',
  components: {
    ExternalLayout
  }
}
</script>

<style scoped>
.br-text {
  margin-top: 2rem;
}

.br-list {
  margin: 1rem 0;
}
</style>
```

## 7. Router Configuration

```javascript
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/Home.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/Login.vue')
  },
  {
    path: '/sobre',
    name: 'About',
    component: () => import('@/views/About.vue')
  },
  {
    path: '/servicos',
    name: 'Services',
    component: () => import('@/views/Services.vue')
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
```

## 8. Package.json (dependências)

```json
{
  "dependencies": {
    "vue": "^3.3.0",
    "vue-router": "^4.2.0",
    "@govbr-ds/core": "^1.8.0"
  },
  "devDependencies": {
    "@vitejs/plugin-vue": "^4.2.3",
    "vite": "^4.3.0"
  }
}
```

Este exemplo demonstra:

1. **Três layouts diferentes** para diferentes tipos de páginas
2. **Uso do Design System do Governo** através das classes CSS
3. **Componentes reutilizáveis** (Header, Footer)
4. **Roteamento** entre diferentes páginas
5. **Estilização consistente** com as diretrizes governamentais

Para usar, instale as dependências e certifique-se de incluir o CSS do Design System do Governo no seu projeto.