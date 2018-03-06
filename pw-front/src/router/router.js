import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '../page/login.vue'
import home from '../page/home.vue'
import manage from '../page/manage.vue'
Vue.use(VueRouter)

const routes = [{
        path: '',
        component: login,
        name: '',
        hidden: true
    },{
        path: '/login',
        component: login,
        name: '',
        hidden: true
    },{
		path: '/home',
        component: home,
        name: '系统管理',
        children:[{
        path:'manage',
        name:'密码管理',
        component:manage,
      }
		]
	}];
const router = new VueRouter({
    routes:routes
})
router.beforeEach((to, from, next) => {
	next();
});
export default router;
