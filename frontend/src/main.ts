import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import axios from 'axios'

import App from './App.vue'
import router from './router'

import 'font-awesome/css/font-awesome.min.css'

axios.defaults.baseURL = 'http://localhost:8080'
axios.defaults.withCredentials = true
// axios.defaults.headers.common['Authorization'] = 'Bearer ' + localStorage.getItem('token')

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.mount('#app')
