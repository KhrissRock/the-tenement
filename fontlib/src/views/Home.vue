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