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