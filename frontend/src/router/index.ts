import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue' // 首页
import LoginView from '../views/LoginView.vue' // 登录页
import DiscoverView from '@/views/DiscoverView.vue' // 发现页
import MyOrdersView from '@/views/MyOrdersView.vue' // 订单页
import ProfileView from '@/views/ProfileView.vue' // 我的页
import RegisterView from '@/views/RegisterView.vue' // 注册页
import BusinessListView from '@/views/BusinessListView.vue'; // 商家列表页
import BusinessInfoView from '@/views/BusinessInfoView.vue'; // 商家详情页
import OrderView from '@/views/OrderView.vue'; // 订单页
import UserAddressView from '@/views/UserAddressView.vue'; // 用户地址页
import UserAddressEditView from '@/views/UserAddressEditView.vue'; // 编辑地址页
import PaymentView from '@/views/PaymentView.vue'; // 支付页

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      // 首页
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      // 发现页
      path: '/discover',
      name: 'discover',
      component: DiscoverView
    },
    {
      // 订单列表页
      path: '/myorder',
      name: 'myorder',
      component: MyOrdersView
    },
    {
      // 我的页
      path: '/profile',
      name: 'profile',
      component: ProfileView
    },
    {
      // 登录页
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      // 注册页
      path: '/register',
      name: 'register',
      component: RegisterView
    },
    {
      // 商家列表页
      path: '/businessList/:type',
      name: 'businessList',
      component: BusinessListView
    },
    {
      // 商家详情页
      path: '/businessInfo/:id',
      name: 'businessInfo',
      component: BusinessInfoView
    },
    {
      // 确认订单页
      path: '/order/',
      name: 'order',
      component: OrderView
    },
    {
      // 用户地址页
      path: '/useraddress',
      name: 'userAddress',
      component: UserAddressView
    },
    {
      // 编辑地址页
      path: '/editaddress/:id',
      name: 'editAddress',
      component: UserAddressEditView
    },
    {
      // 支付页
      path: '/payment/:id',
      name: 'payment',
      component: PaymentView
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
