<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"flex-end","background":"url(http://codegen.caihongy.cn/20231023/53250f7f1f2540f7a640c243c9d668aa.png)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
      <el-form :style='{"padding":"20px 20px 20px","boxShadow":"0 0px 0px rgba(64, 158, 255, .8)","margin":"0","borderRadius":"10px","flexWrap":"wrap","background":"transparent","display":"flex","width":"30%","position":"relative","height":"49vh"}'>
        <div v-if="true" :style='{"margin":"0 0 200px 0","color":"#fff","top":"33%","textAlign":"center","left":"0","width":"100%","lineHeight":"44px","fontSize":"48px","position":"fixed","textShadow":"none"}' class="title-container">基于springboot的商场多功能折扣系统登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 auto 10px","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>用户名：</div>
          <input :style='{"border":"4px solid #9B9B9B","padding":"0 30px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","outline":"0px solid #efefef","color":"#000","borderRadius":"10px","width":"100%","fontSize":"16px","height":"60px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 auto 10px","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
          <input :style='{"border":"4px solid #9B9B9B","padding":"0 30px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","outline":"0px solid #efefef","color":"#000","borderRadius":"10px","width":"100%","fontSize":"16px","height":"60px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>

        <div :style='{"width":"100%","margin":"20px auto 40px"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>

		
        <div :style='{"width":"100%","padding":"0","margin":"0 auto","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
          <el-button v-if="loginType==1" :style='{"border":"1px solid #0E9BD3","cursor":"pointer","padding":"0 0","margin":"0 10px","color":"#0E9BD3","borderRadius":"0","background":"transparent","borderWidth":"0 0 4px","width":"auto","fontSize":"30px","fontWeight":"bold","height":"44px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
		verifyCheck2: false,
		flag: false,
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
      },
      menus: [],
      roles: [],
      tableName: "",
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {

  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
		this.$router.push({path:'/register',query:{pageFlag:'register'}})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}
		
		this.loginPost()
    },
	loginPost() {
		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/" });
			} else {
				this.$message.error(data.msg);
			}
		});
	},
  }
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20231023/53250f7f1f2540f7a640c243c9d668aa.png);
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 4px solid #9B9B9B;
		border-radius: 10px;
		padding: 0 30px;
		box-shadow: 0 0 0px rgba(64, 158, 255, .5);
		outline: 0px solid #efefef;
		color: #000;
		width: 100%;
		font-size: 16px;
		height: 60px;
	  }
  
  .list-item.select /deep/ .el-select .el-input__inner {
		border: 1px solid rgba(64, 158, 255, 1);
		padding: 0 10px;
		box-shadow: 0 0 6px rgba(64, 158, 255, .5);
		outline: 1px solid #efefef;
		color: rgba(64, 158, 255, 1);
		width: 288px;
		font-size: 14px;
		outline-offset: 4px;
		height: 44px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border: 0px solid rgba(64, 158, 255, 1);
  	  	padding: 0 10px;
  	  	outline: none;
  	  	color: #000;
  	  	width: calc(100% - 80px);
  	  	font-size: 16px;
  	  	height: 100%;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #9B9B9B;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: #00ACEE;
        border-color: #00ACEE;
      }
  .list-type /deep/ .el-radio__label {
		color: #9B9B9B;
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: #00ACEE;
        font-size: 14px;
      }
}

</style>
