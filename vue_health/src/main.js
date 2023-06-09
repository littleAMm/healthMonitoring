import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from '../src/router'


Vue.config.productionTip = false
Vue.use(ElementUI)
new Vue({
  router,
  render: h => h(App),
  data(){
    return{
      username:'',
      id:1
    }
  }
}).$mount('#app')
