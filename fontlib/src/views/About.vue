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