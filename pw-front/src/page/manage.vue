<template>
  <div>
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
  			<el-form :inline="true">
  					<el-form-item>
  							<el-input v-model="searchData.name" placeholder="账号名"></el-input>
  					</el-form-item>
  					<el-form-item>
  							<el-input v-model="searchData.loginaccount" placeholder="登录账号"></el-input>
  					</el-form-item>
  					<el-button @click="search">搜索</el-button>
  					<el-button  @click="addAccount">添加角色</el-button>
  			</el-form>
  	</el-col>
    <el-table
  		:data="listdata"
  		stripe
  		style="width: 100%" height="700">
      <el-table-column
  			prop="name"
  			label="账号名">
  		</el-table-column>
  		<el-table-column
  			prop="loginaccount"
  			label="登录账号"
  			width="180">
  		</el-table-column>
  		<el-table-column
  			prop="password"
  			label="密码"
  			width="180">
  		</el-table-column>
  		<el-table-column
  			prop="phone"
  			label="电话">
  		</el-table-column>
  		<el-table-column label="操作">
  				<template scope="scope">
  						<el-button size="small" @click="editAccount(scope.$index, scope.row)">
  						编辑
  						</el-button>
  				</template>
  		</el-table-column>
  	</el-table>
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
  								 :current-page="searchData.correntPage" :page-sizes="[10, 20, 50, 100, 200]" :page-size="searchData.pageSize"
  								 layout="total, sizes, prev, pager, next, jumper" :total="searchData.total">
  	</el-pagination>
    <el-dialog title="添加账号" size='tiny' :visible.sync="addAccountVisible">
  			<el-form :inline="false" ref="addAccountForm" :model="addData" label-width="80px">
  					<el-form-item label="登录账号" prop="loginaccount">
  							<el-input placeholder="登录账号" v-model="addData.loginaccount"></el-input>
  					</el-form-item>
            <el-form-item label="密码" prop="password">
  							<el-input placeholder="密码" v-model="addData.password"></el-input>
  					</el-form-item>
  					<el-form-item label="邮箱" prop="email">
  							<el-input placeholder="邮箱" v-model="addData.email"></el-input>
  					</el-form-item>
            <el-form-item label="电话" prop="phone">
  							<el-input placeholder="电话" v-model="addData.phone"></el-input>
  					</el-form-item>
            <el-form-item label="域名" prop="domain">
  							<el-input placeholder="域名" v-model="addData.domain"></el-input>
  					</el-form-item>
            <el-form-item label="账号名" prop="name">
  							<el-input placeholder="账号名" v-model="addData.name"></el-input>
  					</el-form-item>
  					<el-form-item>
  							<el-button size="small" type="danger" @click="submitAdd('addAccountForm')">添加</el-button>
  					</el-form-item>
  			</el-form>
  	</el-dialog>
    <el-dialog title="更新账号" size='tiny' :visible.sync="editAccountVisible">
  			<el-form :inline="false" ref="updateAccountForm" :model="editData" label-width="80px">
  					<el-form-item label="登录账号" prop="loginaccount">
  							<el-input placeholder="登录账号" v-model="editData.loginaccount"></el-input>
  					</el-form-item>
            <el-form-item label="密码" prop="password">
  							<el-input placeholder="密码" v-model="addData.password"></el-input>
  					</el-form-item>
  					<el-form-item label="邮箱" prop="email">
  							<el-input placeholder="邮箱" v-model="editData.email"></el-input>
  					</el-form-item>
            <el-form-item label="电话" prop="phone">
  							<el-input placeholder="电话" v-model="editData.phone"></el-input>
  					</el-form-item>
            <el-form-item label="域名" prop="domain">
  							<el-input placeholder="域名" v-model="editData.domain"></el-input>
  					</el-form-item>
            <el-form-item label="账号名" prop="name">
  							<el-input placeholder="账号名" v-model="editData.name"></el-input>
  					</el-form-item>
  					<el-form-item>
  							<el-button size="small" type="danger" @click="submitUpdate('updateAccountForm')">修改</el-button>
  					</el-form-item>
  			</el-form>
  	</el-dialog>
  </div>
</template>
<script type="text/ecmascript-6">
	import	{getAccountByPage,addAccount,updateAccount} from '../api/manage.js'
	import qs from 'qs';
	export default {
		data() {
			return {
        searchData:{
          correntPage:1,
          pageSize:10,
          total:10
        },
        addData:{
          loginaccount:'',
          password:'',
          email:'',
          phone:'',
          domain:'',
          name:''
        },
        editData:{
          id:-1,
          loginaccount:'',
          password:'',
          email:'',
          phone:'',
          domain:'',
          name:''
        },
        listdata:[],
        addAccountVisible:false,
        editAccountVisible:false
			}
		},
		methods:{
      editAccount(index, row){
        this.editData.id = row.id
        this.editData.loginaccount = row.loginaccount
        this.editData.email = row.email
        this.editData.phone = row.phone
        this.editData.domain = row.domain
        this.editData.name = row.name
        this.editAccountVisible = true
        console.log(index, row);
      },
      addAccount(){
        this.addAccountVisible = true
      },
      submitAdd(form){
        addAccount(this.addData).then(data=>{
          console.log(data);
          if(data.ret === 1){
            this.addAccountVisible = false
            this.$refs['addAccountForm'].resetFields();
            this.$alert("添加成功")
            this.search()
          }
        })
      },
      submitUpdate(){
        updateAccount(this.editData).then(data=>{
            if(data.ret === 1){
              this.editAccountVisible = false
              this.$refs['updateAccountForm'].resetFields();
              this.$alert("修改成功")
              this.search()
            }
        })
      },
      search(){
        getAccountByPage(this.searchData).then(data=>{
          console.log(data);
          this.listdata=data.page.result;
          this.searchData.correntPage = data.page.correntPage;
          this.searchData.pageSize = data.page.pageSize;
          this.searchData.total = data.page.total;
        })
      },
      handleSizeChange(val) {
          this.searchData.pageSize = val;
          console.log(`每页 ${val} 条`);
          this.search();
          console.log(this.searchData.pageSize);
      },
      handleCurrentChange(val) {
          this.searchData.correntPage = val;
          this.search();
          console.log(`当前页: ${val}`);
          console.log(this.searchData.correntPage);
      }
		},
		created(){
      this.search();
		},
    handleEdit(index,row){

    }
	}
</script>
