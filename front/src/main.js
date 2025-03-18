import { createApp } from 'vue'
import './style.css'
import './assets/styles/base.css'
import './assets/styles/color.css'
import './assets/icon/fonticon/iconfont.js'
import App from './App.vue'
import {router} from "./route/config.js";
const app=createApp(App);
app.use(router);
app.mount('#app');
