import './assets/main.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';
import axios from 'axios';

import App from './App.vue';
import router from './router';
import 'font-awesome/css/font-awesome.min.css';

axios.defaults.baseURL = 'http://localhost:8080';
axios.defaults.withCredentials = true;

const app = createApp(App);
router.beforeEach(function (to, from, next) {
  console.log(to.path);
  //除了首页，商家列表，商家信息，注册，登录之外都得判断是否登录
  if (
    !(
      to.path == '/' ||
      to.path.startsWith('/businessList') ||
      to.path == '/businessInfo' ||
      to.path == '/login' ||
      to.path == '/register'
    )
  ) {
    axios.get('/user/info').then((res) => {
      const r = res.data;
      if (r.code == 100) {
        router.push({ name: 'login' });
      }
    });
  }
  next();
});

app.use(createPinia());
app.use(router);
app.mount('#app');
