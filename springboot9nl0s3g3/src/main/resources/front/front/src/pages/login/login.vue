<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20240225/947418f72d214efd8bedab3cbfea25cc.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"flex-start"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"80px 40px 0","boxShadow":"0px 26px 26px -30px #999","margin":"0 0 0 80px","alignItems":"center","flexDirection":"column","display":"flex","justifyContent":"center","minHeight":"88vh","borderRadius":"30px","flexWrap":"wrap","background":"#fff","width":"800px","position":"relative","height":"auto"}' :rules="rules">
			<div v-if="false" :style='{"width":"100%","margin":"0 0 10px 0","lineHeight":"44px","fontSize":"18px","color":"#333","textAlign":"center"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"margin":"0 auto","color":"#000","textAlign":"center","letterSpacing":"2px","top":"0","borderRadius":"30px 30px 0 0","left":"0","background":"#f5c720","width":"100%","lineHeight":"100px","fontSize":"24px","position":"absolute","fontWeight":"600"}'>基于springboot的商场多功能折扣系统登录</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"75%","margin":"0 auto 40px"}' prop="username">
				<div v-if="true" :style='{"color":"#333","textAlign":"right","left":"-120px","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px","position":"absolute"}'>账号：</div>
				<input :style='{"padding":"0 10px","borderColor":"#333","color":"#666","borderRadius":"4px","borderWidth":"1px","width":"100%","fontSize":"14px","borderStyle":"solid","height":"50px"}' v-model="loginForm.username" placeholder="请输入账号">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"75%","margin":"0 auto 40px"}' prop="password">
				<div v-if="true" :style='{"color":"#333","textAlign":"right","left":"-120px","background":"none","display":"inline-block","width":"120px","lineHeight":"36px","fontSize":"14px","position":"absolute"}'>密码：</div>
				<input :style='{"padding":"0 10px","borderColor":"#333","color":"#666","borderRadius":"4px","borderWidth":"1px","width":"100%","fontSize":"14px","borderStyle":"solid","height":"50px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>

			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"75%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>

			
			<el-form-item class="list-btn" :style='{"width":"75%","margin":"30px auto","order":"10"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px","color":"#000","borderRadius":"8px","background":"#f7c420","width":"150px","letterSpacing":"4px","fontSize":"18px","height":"50px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 0px","margin":"0 10px","color":"#fff","borderRadius":"8px","textAlign":"center","background":"#000","width":"150px","fontSize":"14px","height":"50px"}' @click="resetForm('loginForm')">重置</el-button>
			</el-form-item>
			<div :style='{"width":"75%","margin":"0 auto","flexWrap":"wrap","background":"#fff","display":"flex","order":"10"}'>
			<router-link :style='{"cursor":"pointer","border":"1px solid #ffffff50","padding":"10px","margin":"0 20px 20px 0","color":"#000","borderRadius":"4px","background":"#fff5cd","width":"auto","fontSize":"16px"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			<router-link :style='{"cursor":"pointer","margin":"0px 0 0","color":"#f5c720","textAlign":"right","background":"none","display":"block","width":"100%","fontSize":"14px","textDecoration":"none"}' :to="{path: '/register', query: {pageFlag:'security1'}}">忘记密码?</router-link>
			</div>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
</div>
</template>

<script>
import menu from '@/config/menu'
export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账号', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}],
			flag: false,
			verifyCheck2: false,
		}
	},
  components: {
  },
	created() {
		this.roleMenus = menu.list()
		for(let item in this.roleMenus) {
		    if(this.roleMenus[item].hasFrontLogin=='是') {
		        this.roles.push(this.roleMenus[item]);
		    }
		}
		
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }

		this.loginPost(formName)
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
	  loginPost(formName) {
		this.$refs[formName].validate((valid) => {
		  if (valid) {
		    this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
		      if (res.data.code === 0) {
		        localStorage.setItem('frontToken', res.data.token);
		        localStorage.setItem('UserTableName', this.loginForm.tableName);
		        localStorage.setItem('username', this.loginForm.username);
		        // localStorage.setItem('adminName', this.loginForm.username);
		        localStorage.setItem('frontSessionTable', this.loginForm.tableName);
		        localStorage.setItem('frontRole', this.role);
		        localStorage.setItem('keyPath', 0);
		        this.$router.push('/');
		        this.$message({
		          message: '登录成功',
		          type: 'success',
		          duration: 1500,
		        });
		      } else {
		        this.$message.error(res.data.msg);
		      }
		    });
		  } else {
		    return false;
		  }
		});
	  },
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20240225/947418f72d214efd8bedab3cbfea25cc.jpg);
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-form-item__content {
			display: flex;
			width: 100%;
		}

		.list-code /deep/ .el-form-item__content {
			display: flex;
			width: 100%;
			justify-content: space-between;
		}

		.list-type /deep/ .el-form-item__content {
			padding: 0px;
			margin: 20px 0 0;
			display: flex;
		}

		.list-btn /deep/ .el-form-item__content {
			display: block;
			justify-content: center;
			flex-wrap: wrap;
			text-align: center;
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border-radius: 4px;
			padding: 0 10px;
			color: #666;
			width: 100%;
			font-size: 14px;
			border-color: #333;
			border-width: 1px;
			border-style: solid;
			height: 50px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border-radius: 4px;
			padding: 0 10px;
			color: #666;
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 110px);
			font-size: 14px;
			border-color: #333;
			border-width: 1px;
			border-style: solid;
			height: 50px;
		}

		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			border: 4px double #fff;
			border-radius: 2px;
			padding: 4px;
			background: #f5c720;
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #f5c720;
			font-size: 14px;
		}
	}

</style>
