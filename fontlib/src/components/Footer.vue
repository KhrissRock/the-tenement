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