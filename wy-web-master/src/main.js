import Vue from 'vue';
import iView from 'iview';
import router from './router';
import VueRouter from 'vue-router';
import store from './store/store';
import App from './app.vue';
import 'iview/dist/styles/iview.css';
import axios from './axios';
import VueAxios from 'vue-axios';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';    // 默认主题
import "babel-polyfill";
import WtDataTable from './components/dataTable.js';  //自定义组件

Vue.use(WtDataTable);
Vue.use(ElementUI, { size: 'small' });

Vue.use(VueAxios,axios);

Vue.use(iView);

new Vue({
    el: '#app',
    router: router,
    store: store,
    render: h => h(App)
});