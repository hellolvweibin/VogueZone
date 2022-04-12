// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import VueRouter from "vue-router";
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'



//导入element-ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';


Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.use(mavonEditor);

// Vue.use(Vuetify)


// 设置反向代理，前端请求默认发送到 http://localhost:8091/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8091/api'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.config.productionTip = false

/* eslint-disable no-new */


new Vue({
  el: '#app',
  router,
  render: h => h(App),
  components: {App},
  template: '<App/>'
})
