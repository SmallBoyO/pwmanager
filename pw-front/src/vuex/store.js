import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

// 应用初始状态
const state = {
    count: 10,
  	correntUser:{
  		islogin:false,
  		username:'',
  		name:'',
  	},
  	menu:[]
}

// 定义所需的 mutations
const mutations = {
	login(state,data){
		state.correntUser.islogin=true;
		state.correntUser.username=data.username;
		state.correntUser.name=data.name;
	},
  setMenu(state,data){
    if(data!=null){
      state.menu=data.menu;
    }else{
      state.menu=null;
    }
  }
}
// 创建 store 实例
export default new Vuex.Store({
    state,
    mutations
})
