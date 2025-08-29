import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// Import do Design System do Governo
import '@govbr-ds/core/dist/core.min.css'

const app = createApp(App)
app.use(router)
app.mount('#app')