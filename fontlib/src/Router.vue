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