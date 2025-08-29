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