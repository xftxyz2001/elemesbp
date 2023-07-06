import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue' // 首页
import LoginView from '../views/LoginView.vue' // 登录页
import DiscoverView from '@/views/DiscoverView.vue' // 发现页
import OrderView from '@/views/OrderView.vue' // 订单页
import ProfileView from '@/views/ProfileView.vue' // 我的页
import RegisterView from '@/views/RegisterView.vue' // 注册页
import BusinessListView from '@/views/BusinessListView.vue'; // 商家列表页

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/discover',
      name: 'discover',
      component: DiscoverView
    },
    {
      path: '/order',
      name: 'order',
      component: OrderView
    },
    {
      path: '/profile',
      name: 'profile',
      component: ProfileView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/register',
      name: 'register',
      component: RegisterView
    },
    {
      path: '/businessList/:type',
      name: 'businessList',
      component: BusinessListView
    }
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
