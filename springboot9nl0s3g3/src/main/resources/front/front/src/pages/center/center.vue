<template>
<div class="center-preview" :style='{"padding":"0 10%","margin":"20px auto 40px","flexWrap":"wrap","background":"none","display":"block","width":"100%","position":"relative","justifyContent":"space-between"}'>
	<div class="title" :style='{"padding":"30px 0 0","margin":"40px auto","color":"#000","textAlign":"center","background":"url(http://codegen.caihongy.cn/20240303/4a00266e357e47d5856d30e525467334.png) no-repeat center center / 100% 100%","width":"100%","fontSize":"24px","fontWeight":"600","height":"92px"}'>{{ title }}</div>
	
	<div class="info" :style='{"padding":"80px 20px 10px 220px","boxShadow":"0 0px 0px rgba(0, 0, 0, 0.3)","margin":"40px 0 0 0","borderColor":"#28890b20","alignItems":"center","textAlign":"left","display":"block","justifyContent":"flex-start","minHeight":"200px","overflow":"hidden","borderRadius":"0px","flexWrap":"wrap","background":"#fff","borderWidth":"0px","width":"calc(100% - 0px)","position":"relative","borderStyle":"solid","height":"auto","order":"2"}'>
		<div :style='{"padding":"8px 20px","borderColor":"#eee","margin":"0","color":"#000","letterSpacing":"0px","minWidth":"250px","borderRadius":"0","top":"20px","left":"20px","borderWidth":"0px","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(247,196,32,1) 100%)","width":"auto","lineHeight":"1.5","fontSize":"16px","position":"absolute","borderStyle":"solid","fontWeight":"600","height":"auto"}'>个人信息</div>
		<div :style='{"width":"auto","borderColor":"#1abc9e20","fontSize":0,"borderStyle":"solid","borderWidth":"0 0 0px 0","height":"auto"}' v-if="userTableName=='yonghu'">
			<el-image :style='{"margin":"10px auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"8px","top":"70px","left":"20px","borderWidth":"0 0 1px 0","display":"block","width":"120px","position":"absolute","borderStyle":"solid","height":"120px"}' :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#ddd","margin":"0 30px 30px 0","borderRadius":"4px","borderWidth":"1px","display":"inline-block","width":"calc(33% - 30px)","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-geren14" :style='{"padding":"0 5px","fontSize":"24px","color":"#f7c420","float":"left","display":"inline-block"}'></span>
			<div :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#666","display":"inline-block"}'>用户账号</div>
			<div :style='{"fontSize":"14px","color":"#999","textAlign":"left","flex":1,"display":"inline-block"}'>{{sessionForm.yonghuzhanghao}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#ddd","margin":"0 30px 30px 0","borderRadius":"4px","borderWidth":"1px","display":"inline-block","width":"calc(33% - 30px)","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-zhangjie7" :style='{"padding":"0 5px","fontSize":"24px","color":"#f7c420","float":"left","display":"inline-block"}'></span>
			<div :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#666","display":"inline-block"}'>用户姓名</div>
			<div :style='{"fontSize":"14px","color":"#999","textAlign":"left","flex":1,"display":"inline-block"}'>{{sessionForm.yonghuxingming}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#ddd","margin":"0 30px 30px 0","borderRadius":"4px","borderWidth":"1px","display":"inline-block","width":"calc(33% - 30px)","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"24px","color":"#f7c420","float":"left","display":"inline-block"}'></span>
			<div :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#666","display":"inline-block"}'>手机号</div>
			<div :style='{"fontSize":"14px","color":"#999","textAlign":"left","flex":1,"display":"inline-block"}'>{{sessionForm.shoujihao}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#ddd","margin":"0 30px 30px 0","borderRadius":"4px","borderWidth":"1px","display":"inline-block","width":"calc(33% - 30px)","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-qita3" :style='{"padding":"0 5px","fontSize":"24px","color":"#f7c420","float":"left","display":"inline-block"}'></span>
			<div :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#666","display":"inline-block"}'>性别</div>
			<div :style='{"fontSize":"14px","color":"#999","textAlign":"left","flex":1,"display":"inline-block"}'>{{sessionForm.xingbie}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#ddd","margin":"0 30px 30px 0","borderRadius":"4px","borderWidth":"1px","display":"inline-block","width":"calc(33% - 30px)","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-touxiang09" :style='{"padding":"0 5px","fontSize":"24px","color":"#f7c420","float":"left","display":"inline-block"}'></span>
			<div :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#666","display":"inline-block"}'>邮箱</div>
			<div :style='{"fontSize":"14px","color":"#999","textAlign":"left","flex":1,"display":"inline-block"}'>{{sessionForm.email}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#ddd","margin":"0 30px 30px 0","borderRadius":"4px","borderWidth":"1px","display":"inline-block","width":"calc(33% - 30px)","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shijian17" :style='{"padding":"0 5px","fontSize":"24px","color":"#f7c420","float":"left","display":"inline-block"}'></span>
			<div :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#666","display":"inline-block"}'>积分</div>
			<div :style='{"fontSize":"14px","color":"#999","textAlign":"left","flex":1,"display":"inline-block"}'>{{sessionForm.jf}}</div>
		</div>
		
	</div>
	
    <el-tabs tab-position="left" :style='{"width":"100%","margin":"40px 0 0","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="100px">
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' v-if="userTableName=='yonghu'" label="用户账号" prop="yonghuzhanghao">
            <el-input v-model="sessionForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' v-if="userTableName=='yonghu'" label="用户姓名" prop="yonghuxingming">
            <el-input v-model="sessionForm.yonghuxingming" placeholder="用户姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' v-if="userTableName=='yonghu'" label="头像" prop="touxiang">
			<file-upload
			tip="点击上传头像"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
			@change="yonghutouxiangHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' v-if="userTableName=='yonghu'" label="手机号" prop="shoujihao">
            <el-input v-model="sessionForm.shoujihao" placeholder="手机号" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' v-if="userTableName=='yonghu'" label="性别" prop="xingbie">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' v-if="userTableName=='yonghu'" label="邮箱" prop="email">
            <el-input v-model="sessionForm.email" placeholder="邮箱" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' v-if="userTableName=='yonghu'" label="积分">
            <el-input v-model="sessionForm.jf" placeholder="积分" readonly></el-input>
          </el-form-item>
          <el-form-item class="balance" :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' v-if="userTableName=='yonghu'" label="余额">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
				<el-input v-model="sessionForm.money" placeholder="余额" readonly></el-input>
				<div @click="dialogFormVisibleMoney = true" :style='{"cursor":"pointer","padding":"0 15px","margin":"0 20px 0 10px","borderColor":"#eee","color":"#000","display":"inline-block","borderRadius":"0px","background":"#f7c420","borderWidth":"0px","width":"auto","lineHeight":"36px","fontSize":"14px","borderStyle":"solid","height":"36px"}'>点我充值</div>
			</div>
		  </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","color":"#000","borderRadius":"4px","background":"#f7c420","width":"110px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"border":"0px solid #ddd","cursor":"pointer","padding":"0","margin":"0","color":"#000","borderRadius":"4px","background":"#e0e0e0","width":"110px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
	  <el-tab-pane label="修改密码">
		<el-form class="center-preview-pv" ref="passwordForm" :model="passwordForm" :rules="passwordRules" label-width="100px">
			<el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' label="原密码" prop="password">
			  <el-input type="password" v-model="passwordForm.password" placeholder="原密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' label="新密码" prop="newpassword">
			  <el-input type="password" v-model="passwordForm.newpassword" placeholder="新密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"none","display":"inline-block"}' label="确认密码" prop="repassword">
			  <el-input type="password" v-model="passwordForm.repassword" placeholder="确认密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}'>
			  <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","color":"#000","borderRadius":"4px","background":"#f7c420","width":"110px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="updatePassword">修改密码</el-button>
			</el-form-item>
		</el-form>
	  </el-tab-pane>
		<el-tab-pane v-for="(item,index) in menuList" :key="index" v-if="hasBack(item.menu)" :label="item.child[0].menu" :name="item.child[0].tableName"></el-tab-pane>
      <el-tab-pane label="我的订单"></el-tab-pane>
      <el-tab-pane label="我的地址" name="MyAddress">
        <router-view></router-view>
      </el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
      <el-tab-pane label="我的优惠券">
		  <div class="coupon_list">
		  	<div class="coupon" v-for="(item,index) in couponList" :key="index" :class="(item.status=='已过期'||item.status=='已使用')?'coupons':''">
		  		<div class="coupon_left">
		  			<div class="name">{{item.name}}</div>
		  			<div class="name">满{{item.fullamount}}减{{item.discountamount}}</div>
		  			<div class="date">{{item.startime}}-{{item.endtime}}</div>
					<div class="date">{{item.couponnumber}}</div>
					<div class="date">{{item.remark}}</div>
		  		</div>
		  		<div class="coupon_right">
		  			<div class="price">￥<span class="num">{{item.discountamount}}</span></div>
					<div class="btn" v-if="item.status=='可使用'">{{item.status}}</div>
		  		</div>
		  		<img v-if="item.status=='已过期'" class="no-coupon" src="@/assets/no-coupon.png" alt="">
		  		<img v-if="item.status=='已使用'" class="no-coupon" src="@/assets/finish-coupon.png" alt="">
		  	</div>
		  	<div class="noList" v-if="!couponList.length">
		  		暂无优惠券
		  	</div>
		  </div>
	  </el-tab-pane>
    </el-tabs>

	<el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
	  <el-form :model="chongzhiForm">
		<el-form-item label="充值金额" label-width="120px">
		  <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
		</el-form-item>
		<el-form-item label-width="120px">
		  <el-radio-group v-model="chongzhiForm.radio">
			<el-radio style="margin-bottom: 30px" label="微信支付">
			  <el-image
				style="width: 60px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/weixin.png')"
				fit="fill"></el-image>
				<span style="display: inline-block;margin-left: 10px">微信支付</span>
			</el-radio>
			<el-radio label="支付宝支付">
			  <el-image
				style="width: 60px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/zhifubao.png')"
				fit="fill"></el-image>
				<span style="display: inline-block;margin-left: 10px">支付宝支付</span>
			</el-radio>
			<el-radio label="中国建设银行支付">
			  <el-image
				style="width: 120px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/jianshe.png')"
				fit="fill"></el-image>
			</el-radio>
			<el-radio label="中国农业银行支付">
			  <el-image
				style="width: 126px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/nongye.png')"
				fit="fill"></el-image>
			</el-radio>
			<el-radio label="中国银行支付">
			  <el-image
				style="width: 140px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/zhongguo.png')"
				fit="fill"></el-image>
			</el-radio>
			<el-radio label="交通银行支付">
			  <el-image
				style="width: 120px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/jiaotong.png')"
				fit="fill"></el-image>
			</el-radio>
		  </el-radio-group>
		</el-form-item>
	  </el-form>
	  <div slot="footer" class="dialog-footer">
		<el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
		<el-button type="primary" @click="chongzhi">确认充值</el-button>
	  </div>
	</el-dialog>
</div>
</template>

<script>
  import config from '@/config/config'
  import menu from '@/config/menu'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
		passwordForm: {},
		passwordRules: {
			password: [
				{
					required: true,
					message: "密码不能为空",
					trigger: "blur"
				}
			],
			newpassword: [
				{
					required: true,
					message: "新密码不能为空",
					trigger: "blur"
				}
			],
			repassword: [
				{
					required: true,
					message: "确认密码不能为空",
					trigger: "blur"
				}
			]
		},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
		menuList: [],
        disabled: false,
        dialogFormVisibleMoney: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('frontToken')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {},
		couponList: [],
      }
    },
    created() {
		let menus = menu.list()
		for(let x in menus){
			if(menus[x].tableName == this.userTableName){
				this.menuList = menus[x].backMenu
			}
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuzhanghao', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuxingming', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'touxiang', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'shoujihao', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'xingbie', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'email', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'jf', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'money', null);
		}

		if ('yonghu' == this.userTableName&&this.rules['yonghuzhanghao']){
			this.rules['yonghuzhanghao'].push({ required: true, message: '请输入用户账号', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['yonghuzhanghao']) {
			this.$set(this.rules, 'yonghuzhanghao', [{ required: true, message: '请输入用户账号', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['mima']){
			this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['mima']) {
			this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['yonghuxingming']){
			this.rules['yonghuxingming'].push({ required: true, message: '请输入用户姓名', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['yonghuxingming']) {
			this.$set(this.rules, 'yonghuxingming', [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'shoujihao', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'email', [{ required: false, validator: this.$validate.isEmail, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'jf', [{ required: false, validator: this.$validate.isNumber, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'money', [{ required: false, validator: this.$validate.isNumber, trigger: 'blur' }]);
		}

      this.init();
      this.sessionForm = JSON.parse(localStorage.getItem('sessionForm'))
    },
    //方法集合
    methods: {
      init() {
        if ('yonghu' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
      },
	  setSession(){
		  localStorage.setItem('sessionForm',JSON.stringify(this.sessionForm))
	  },
      onSubmit(formName) {
		if(`yonghu` == this.userTableName && this.sessionForm.touxiang!=null){
			this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
        this.$refs[formName].validate((valid) => {
			if (valid) {
				this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
					if (res.data.code == 0) {
						this.setSession()
						this.$message({
							message: '更新成功',
							type: 'success',
							duration: 1500
						});
					}
				});
			} else {
				return false;
			}
        });
      },
      yonghutouxiangHandleAvatarSuccess(fileUrls) {
        this.sessionForm.touxiang = fileUrls;
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: '请输入充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: '请输入正确的充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择充值方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
		if(!this.sessionForm.money) {
			this.sessionForm.money = parseFloat(this.chongzhiForm.money)
		}else{
			this.sessionForm.money = parseFloat(this.sessionForm.money) + parseFloat(this.chongzhiForm.money);
		}
        
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
			  this.setSession()
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '修改密码':
            this.passwordForm = {
				password: '',
				newpassword: '',
				repassword: '',
			}
			this.$forceUpdate()
            break;
          case '我的订单':
            tab.$router.push('/index/shop-order/order');
            break;
          case '我的地址':
            tab.$router.push('/index/shop-address/list');
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
		  case '我的优惠券':
			this.getMyList()
		    break;
		  default:
		  	tab.$router.push(`/index/${tab.name}?centerType=1`);
        }

        this.title = event.target.outerText;
      },
	  async updatePassword(){
			this.$refs["passwordForm"].validate(async valid => {
				if (valid) {
					var password = "";
					if (this.sessionForm.mima) {
						password = this.sessionForm.mima;
					} else if (this.sessionForm.password) {
						password = this.sessionForm.password;
					}
					if (this.userTableName == 'yonghu') {
					}
					var nowpassword = ''
					await this.$http.get('encrypt/md5?text=' + this.passwordForm.password,).then(res=>{
						if(res.data&&res.data.code==0){
							nowpassword = res.data.data
						}
					})
					if(nowpassword!=password){
						this.$message.error("原密码错误");
						return;
					}
					if (this.passwordForm.newpassword != this.passwordForm.repassword) {
						this.$message.error("两次密码输入不一致");
						return;
					}
					if (this.passwordForm.newpassword == this.passwordForm.password) {
						this.$message.error("新密码与原密码相同！");
						return;
					}
					this.sessionForm.password = this.passwordForm.newpassword;
					this.sessionForm.mima = this.passwordForm.newpassword;
					this.$http.post(`${this.userTableName}/update`,this.sessionForm).then(({data})=>{
						if (data && data.code === 0) {
							this.$message({
								message: "修改密码成功,下次登录系统生效",
								type: "success",
								duration: 1500,
								onClose: () => {
								}
							});
							this.setSession()
						} else {
							this.$message.error(data.msg);
						}
					});
				}
			})
	  },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      },
	  getMyList() {
	  	this.$http.get('mycoupon/page').then(res => {
	  		if (res.data && res.data.code == 0) {
	  			for (let x in res.data.data.list) {
	  				if (!this.isBetweenTime(this.getCurDateTime(), [res.data.data.list[x].startime, res
	  						.data.data.list[x].endtime
	  					]) && res.data.data.list[x].status != '已使用' && res.data.data.list[x].status !=
	  					'已过期') {
	  					res.data.data.list[x].status = '已过期'
	  					this.$http.post('mycoupon/update', res.data.data.list[x]).then(obj => {})
	  				} else if (this.isBetweenTime(this.getCurDateTime(), [res.data.data.list[x]
	  						.startime, res.data.data.list[x].endtime
	  					]) && res.data.data.list[x].status != '已使用' && res.data.data.list[x].status !=
	  					'可使用') {
	  					res.data.data.list[x].status = '可使用'
	  					this.$http.post('mycoupon/update', res.data.data.list[x]).then(obj => {})
	  				}
	  
	  			}
	  			this.couponList = res.data.data.list
	  		}
	  	})
	  },
	  isBetweenTime(currentDate, timeQuantum) {
	  	let isBetween = true;
	  	let currentTime = new Date(currentDate);
	  	let startTime = new Date(timeQuantum[0]);
	  	let endTime = new Date(timeQuantum[1]);
	  	let t1 = currentTime.getTime() - startTime.getTime();
	  	let t2 = currentTime.getTime() - endTime.getTime();
	  	if (t1 < 0 || t2 > 0) {
	  		isBetween = false;
	  	}
	  	return isBetween;
	  },
	  hasBack(name){
		  switch(name){
			case '订单管理':
				return false
				break;
			case '我的收藏管理':
				return false
				break;
			default:
				return true
		  }
	  }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
		.el-tabs__nav{
			overflow: auto;
		}
		::-webkit-scrollbar {
		  -webkit-appearance: none;
		  width: 6px;
		  height: 6px;
		}
		::-webkit-scrollbar-track {
		  background: rgba(0, 0, 0, 0.1);
		  border-radius: 0;
		}
		::-webkit-scrollbar-thumb {
		  cursor: pointer;
		  border-radius: 5px;
		  background: rgba(0, 0, 0, 0.15);
		  transition: color 0.2s ease;
		}
		::-webkit-scrollbar-thumb:hover {
		  background: rgba(0, 0, 0, 0.3);
		}
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	padding: 0px;
	margin: 0 30px 0 0;
	background: none;
	width: 200px;
	border-color: #28890b20;
	border-width: 0 0 0px;
	position: relative;
	border-style: solid;
	text-align: center;
	height: auto;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	margin: 0 0 20px;
  	color: #333;
  	font-weight: 500;
  	display: block;
  	font-size: 16px;
  	line-height: 60px;
  	border-radius: 20px;
  	background: #fff;
  	width: 100%;
  	position: relative;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	padding: 0 10px;
  	color: #000;
  	background: #f7c420;
  	font-weight: 600;
  	font-size: 16px;
  	line-height: 60px;
  	position: relative;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	padding: 0 10px;
  	margin: 0 0 20px;
  	color: #000;
  	font-weight: 600;
  	display: inline-block;
  	font-size: 16px;
  	line-height: 60px;
  	border-radius: 20px;
  	background: #f7c420;
  	width: 100%;
  	position: relative;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content {
  	padding: 40px 0;
  	margin: 0;
  	background: #fff;
  	flex: 1;
  	width: calc(100% - 230px);
  }
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	width: 100%;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 100px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 100px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border-radius: 0px;
  	padding: 0 12px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	color: #666;
  	background: #fff;
  	width: auto;
  	font-size: 14px;
  	border-color: #ddd;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 400px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border-radius: 0px;
  	padding: 0 12px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	color: #666;
  	background: #fff;
  	width: auto;
  	font-size: 14px;
  	border-color: #ddd;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 400px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border-radius: 0px;
  	padding: 0 10px 0 30px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	color: #666;
  	background: #fff;
  	width: auto;
  	font-size: 14px;
  	border-color: #ddd;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 400px;
  	height: 40px;
  }
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	cursor: pointer;
  	color: #999;
  	font-weight: 600;
  	font-size: 24px;
  	border-color: #ddd;
  	line-height: 80px;
  	border-radius: 0px;
  	background: #fff;
  	width: 120px;
  	border-width: 1px;
  	border-style: solid;
  	text-align: center;
  	height: 80px;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border-radius: 0px;
  	padding: 0 12px;
  	color: #666;
  	background: #fff;
  	display: inline-block;
  	width: auto;
  	font-size: 14px;
  	border-color: #ddd;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 300px;
  	height: 36px;
  }
  .coupon_list {
  	width: 100%;
  	display: flex;
  	flex-wrap: wrap;
  
  	.coupon {
  		width: 49%;
  		margin: 0 1% 20px 0;
  		background: url('../../assets/coupon.png');
  		background-repeat: no-repeat;
  		background-position: center center;
  		background-size: cover;
  		padding: 60px 30px;
  		display: flex;
  		align-items: center;
  
  		position: relative;
  
  		.no-coupon {
  			position: absolute;
  			width: 80px;
  			right: 20px;
  			top: 20px;
  		}
  
  		.coupon_left {
  			flex: 1;
  			color: #000;
  
  			.name {
  				font-size: 22px;
  				line-height: 1.5;
  			}
  
  			.date {
  				font-size: 14px;
  				line-height: 1.5;
  			}
			.date1 {
				font-size: 12px;
				line-height: 1.5;
				color: #FF0800;
			}
  		}
  
  		.coupon_right {
  			display: flex;
  			flex-direction: column;
  			align-items: center;
  
  			.price {
  				color: #FF0800;
  				font-size: 20px;
  				padding: 0 0 10px;
  
  				.num {
  					font-size: 28px;
  				}
  			}
  
  			.btn {
  				width: 100px;
  				height: 30px;
  				line-height: 30px;
  				border-radius: 30px;
  				background: #FF0800;
  				text-align: center;
  				color: #fff;
  				font-size: 18px;
  				cursor: pointer;
  			}
  		}
  	}
  
  	.coupons {
  		filter: grayscale(100%);
  	}
  
  	.noList {
  		color: #9e9e9e;
  		width: 100%;
  		text-align: center;
  		padding: 60px 0;
  	}
  }
</style>
