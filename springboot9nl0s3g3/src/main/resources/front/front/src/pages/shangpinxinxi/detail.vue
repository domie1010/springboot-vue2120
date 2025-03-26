<template>
<div>
	<div :style='{"padding":"0","margin":"20px auto","borderColor":"#eee","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20240301/3bd53b03e3db41a8a75b2dad0cd5dacf.png) repeat-x left top / auto 8px","borderWidth":"0px","width":"80%","borderStyle":"solid","order":"3"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'☰'" :style='{"padding":"0 150px 0 120px","color":"#fff","background":"#f7c420","display":"inline-block","width":"auto","lineHeight":"50px","fontSize":"16px","justifyContent":"flex-start"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" :to="'/index/shangpinxinxi?centerType=' + (centerType?'1':'0')"><a>{{item.name}}</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div :style='{"padding":"0","margin":"20px auto","borderColor":"#eee","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20240301/3bd53b03e3db41a8a75b2dad0cd5dacf.png) repeat-x left top / auto 8px","borderWidth":"0px","width":"80%","borderStyle":"solid","order":"3"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="detail-preview" :style='{"padding":"0 10%","margin":"40px auto","alignItems":"flex-start","flexWrap":"wrap","display":"flex","width":"100%","position":"relative","justifyContent":"space-between"}'>
		<div class="attr" :style='{"padding":"10px 0 0","margin":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative","justifyContent":"space-between","order":"3"}'>

			<div class="info" :style='{"width":"100%","padding":"0px","margin":"0","background":"none","flex":"1","order":"2"}'>
				<div class="item" :style='{"padding":"0 40px 0 20px","margin":"0 0 10px 0","overflow":"hidden","alignItems":"center","borderRadius":"4px","background":"#fff","display":"flex","lineHeight":"auto","justifyContent":"space-between","height":"50px"}'>
					<div :style='{"padding":"0px","overflow":"hidden","color":"#000","display":"block","width":"calc(100% - 300px)","fontSize":"16px","fontWeight":"600"}'>
                    {{detail.shangpinmingcheng}}
                    </div>
					<div @click="storeup(1)" v-show="!isStoreup" :style='{"border":"0px solid #ffffff50","cursor":"pointer","padding":"0 16px","lineHeight":"40px","borderRadius":"30px","background":"#f5c820"}'><i v-if="true" :style='{"color":"#000","fontSize":"16px"}' class="el-icon-star-off"></i><span :style='{"color":"#000","fontSize":"14px"}'>点我收藏({{detail.storeupnum}})</span></div>
					<div @click="storeup(-1)" v-show="isStoreup" :style='{"border":"0px solid #ffffff50","cursor":"pointer","padding":"0 16px","lineHeight":"40px","borderRadius":"30px","background":"#f5c820"}'><i v-if="true" :style='{"color":"#000","fontSize":"16px"}' class="el-icon-star-on"></i><span :style='{"color":"#000","fontSize":"14px"}'>取消收藏({{detail.storeupnum}})</span></div>
				</div>
				<div class="item" :style='{"padding":"0 40px 0 20px","margin":"0 0 10px 0","overflow":"hidden","alignItems":"center","borderRadius":"4px","background":"#fff","display":"flex","lineHeight":"auto","justifyContent":"space-between","height":"50px"}'>
					<div :style='{"padding":"0px","overflow":"hidden","color":"#000","display":"block","width":"calc(100% - 300px)","fontSize":"16px","fontWeight":"600"}'>
                    </div>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 20px 0","outline":"none","color":"#fff","borderRadius":"6px","background":"#f7c420","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' type="warning" size="small" @click="couponClick">优惠券</el-button>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}' v-if="detail.price">
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>价格</div>
					<div style="font-weight: bold;" :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'><span :style='{"fontSize":"12px"}'>￥</span>{{detail.price}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}' v-if="detail.jf">
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>积分</div>
					<div style="color: red;font-weight: bold;" :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.jf}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>单限</div>
					<div :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.onelimittimes}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>库存</div>
					<div :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.alllimittimes}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>商品类型</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.shangpinleixing}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>规格</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.guige}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>品牌</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.pinpai}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>上架时间</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.shangjiashijian}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>点击次数</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.clicknum}}</div>
				</div>
				<div class="btn" :style='{"width":"100%","padding":"0","flexWrap":"wrap","display":"flex"}'>
					<el-input-number :style='{"width":"140px","margin":"0 10px 20px 0","lineHeight":"36px","position":"relative","display":"flex"}' v-if="detail.alllimittimes" :min=1 v-model="buynumber"></el-input-number>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 10px 20px 0","color":"#fff","borderRadius":"6px","background":"#000","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="detail.alllimittimes" type="warning" size="small" @click="addCart">添加到购物车</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 20px 0","outline":"none","color":"#fff","borderRadius":"6px","background":"#f7c420","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="detail.alllimittimes" type="warning" size="small" @click="buyNow">立即购买</el-button>

					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 10px 0","color":"#000","borderRadius":"6px","background":"#ffecaf","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="detail.alllimittimes" type="warning" size="small" @click="jfTap">积分兑换</el-button>
				</div>
				<div class="btn" :style='{"width":"100%","padding":"0","flexWrap":"wrap","display":"flex"}'>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 20px 0","outline":"none","color":"#fff","borderRadius":"6px","background":"#f7c420","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('shangpinxinxi','修改')" @click="editClick">修改</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 10px 0","color":"#333","borderRadius":"6px","background":"#ffecaf","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('shangpinxinxi','删除')" @click="delClick">删除</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 10px 0","color":"#333","borderRadius":"6px","background":"#ffecaf","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('shangpinxinxi','私聊')&&detail.id!=mid" @click="chatClick">联系TA</el-button>
				</div>
			</div>
		</div>
		
			<el-carousel v-if="detailBanner.length" :style='{"width":"100%","margin":"0","background":"#fff","height":"100%"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="480px" :autoplay="true" :interval="3000" :loop="true">
				<el-carousel-item :style='{"borderRadius":"10px","width":"100%","height":"100%"}' v-for="item in detailBanner" :key="item.id">
					<img :style='{"objectFit":"contain","width":"100%","height":"100%"}' :preview-src-list="[item]" v-if="item.substr(0,4)=='http'" :src="item" class="image">
					<img :style='{"objectFit":"contain","width":"100%","height":"100%"}' :preview-src-list="[baseUrl + item]" v-else :src="baseUrl + item" class="image">
				</el-carousel-item>
			</el-carousel>

			<div class="zancai" :style='{"border":"0","padding":"0","margin":"0","background":"#fff","display":"flex","width":"100%","justifyContent":"center","order":"2"}'>
				<div :style='{"cursor":"pointer","padding":"12px 0","margin":"0 0px","borderColor":"#ddd","alignItems":"center","background":"none","borderWidth":"0 0 0px","display":"flex","width":"20%","borderStyle":"solid","justifyContent":"center"}' v-if="!isThumbsupnum && !isCrazilynum" class="zan" @click="thumbsupOrCrazily(21)">
					<i :style='{"color":"#333","margin":"0 3px","fontSize":"16px"}' class="iconfont icon-dianzan"></i>
					<span :style='{"color":"#333","margin":"0 3px","fontSize":"14px"}'>赞一下({{detail.thumbsupnum}})</span>
				</div>
				<div :style='{"cursor":"pointer","padding":"12px 0","margin":"0 0px","borderColor":"#ddd","alignItems":"center","background":"none","borderWidth":"0 0 0px","display":"flex","width":"20%","borderStyle":"solid","justifyContent":"center"}' v-if="!isThumbsupnum && !isCrazilynum" class="cai" @click="thumbsupOrCrazily(22)">
					<i :style='{"color":"#333","margin":"0 3px","fontSize":"16px"}' class="iconfont icon-iconfontzan"></i>
					<span :style='{"color":"#333","margin":"0 3px","fontSize":"14px"}'>踩一下({{detail.crazilynum}})</span>
				</div>
				<div :style='{"cursor":"pointer","padding":"12px 0","margin":"0 0px","borderColor":"#ddd","alignItems":"center","background":"none","borderWidth":"0 0 0px","display":"flex","width":"20%","borderStyle":"solid","justifyContent":"center"}' v-if="isThumbsupnum" class="zan" @click="cancelThumbsupOrCrazily(21)">
					<i :style='{"color":"#333","margin":"0 3px","fontSize":"16px"}' class="iconfont icon-dianzan"></i>
					<span :style='{"color":"#333","margin":"0 3px","fontSize":"14px"}'>取消赞({{detail.thumbsupnum}})</span>
				</div>
				<div :style='{"cursor":"pointer","padding":"12px 0","margin":"0 0px","borderColor":"#ddd","alignItems":"center","background":"none","borderWidth":"0 0 0px","display":"flex","width":"20%","borderStyle":"solid","justifyContent":"center"}' v-if="isCrazilynum" class="cai" @click="cancelThumbsupOrCrazily(22)">
					<i :style='{"color":"#333","margin":"0 3px","fontSize":"16px"}' class="iconfont icon-iconfontzan"></i>
					<span :style='{"color":"#333","margin":"0 3px","fontSize":"14px"}'>取消踩({{detail.crazilynum}})</span>
				</div>
			</div>

		

		
		<el-tabs class="detail" :style='{"boxShadow":"none","margin":"20px auto 40px","borderColor":"#d8d8d8","background":"url(http://codegen.caihongy.cn/20240303/d773402b21c748ddbf4a9b7e093f7797.png) repeat-x center top / auto 10px","borderWidth":"0","display":"block","width":"100%","borderStyle":"solid","order":"8"}' v-model="activeName" type="border-card">
			<el-tab-pane label="商品介绍" name="first">
				<div v-html="detail.shangpinjieshao"></div>
			</el-tab-pane>
			<el-tab-pane label="评论" name="second">
				<el-form class="add comment" :style='{"padding":"15px","margin":"0 0 20px"}' :model="form" :rules="rules" ref="form">
					<el-form-item class="item" :style='{"width":"100%","display":"flex","height":"auto"}' label="评论" prop="content">
						<editor
						    :style='{"minHeight":"200px","border":"0","color":"#333","borderRadius":"4px","background":"#fff","width":"100%","lineHeight":"32px","fontSize":"14px"}'
						    v-model="form.content" 
						    class="editor" 
						    action="file/upload">
						</editor>
					</el-form-item>
					<el-form-item class="btn" :style='{"width":"100%","padding":"0 0 0 80px","margin":"10px 0 0","height":"auto"}'>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#000","borderRadius":"6px","background":"#f5c820","width":"110px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="submitForm('form')">立即提交</el-button>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"6px","background":"#000","width":"110px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="resetForm('form')">重置</el-button>
					</el-form-item>
				</el-form>
				
				<div v-if="infoList.length" :style='{"padding":"0"}' class="comment">
					<div :style='{"padding":"10px 20px","margin":"0 0 20px","borderColor":"#d7d7d7","borderRadius":"8px","flexWrap":"wrap","borderWidth":"0px","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-for="item in infoList" :key="item.id" @mouseenter="discussEnter(item.id)"
						@mouseleave="discussLeave">
						<div class="user" :style='{"width":"150px","alignItems":"center","flexWrap":"wrap","flexDirection":"column","display":"flex","height":"auto"}'>
							<el-image v-if="item.avatarurl" :style='{"width":"80px","margin":"0 0 5px","borderRadius":"4px","objectFit":"cover","height":"80px"}' :size="50" :src="baseUrl + item.avatarurl"></el-image>
							<el-image v-if="!item.avatarurl" :style='{"width":"80px","margin":"0 0 5px","borderRadius":"4px","objectFit":"cover","height":"80px"}' :size="50" :src="require('@/assets/touxiang.png')"></el-image>
							<div :style='{"color":"#333","fontSize":"14px"}' class="name">{{item.nickname}}</div>
						</div>
						<div :style='{"padding":"0px","margin":"10px 0px 0px","color":"#333","borderRadius":"4px","background":"none","wordWrap":"break-word","width":"calc(100% - 150px)","lineHeight":"30px","fontSize":"14px"}' class="content-block-ask">
							<div v-html="item.content"></div>
							<div class="btn" :style='{"width":"100%","margin":"0","alignItems":"center","justifyContent":"flex-start","display":"flex","height":"40px"}'>
							  <!-- <el-button :style='{"border":"0px solid #1e3c4f","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","color":"#fff","borderRadius":"20px","background":"#f5c820","width":"auto","lineHeight":"32px","fontSize":"14px","height":"32px"}'>回复</el-button> -->
							  <el-button v-if="showIndex==item.id&&userid==item.userid" @click="discussDel(item.id)" :style='{"border":"0px solid #1e3c4f","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","color":"#fff","borderRadius":"20px","background":"#9e9e9e","width":"auto","lineHeight":"32px","fontSize":"14px","height":"32px"}'>删除</el-button>
							</div>
						</div>
						<div :style='{"padding":"0px","margin":"10px 0px 0px","color":"#333","borderRadius":"4px","background":"none","wordWrap":"break-word","width":"calc(100% - 150px)","lineHeight":"30px","fontSize":"14px"}' class="content-block-reply" v-if="item.reply">
							回复：<span v-html="item.reply"></span>
						</div>
					</div>
				</div>
				
				<el-pagination
				  background
				  id="pagination" class="pagination"
				  :pager-count="7"
				  :page-size="pageSize"
				  prev-text="上一页"
				  next-text="下一页"
				  :hide-on-single-page="false"
				  :layout='["prev","pager","next"].join()'
				  :total="total"
				  :style='{"padding":"5px 10%","margin":"20px auto","color":"#333","textAlign":"center","width":"100%","clear":"both","lineHeight":"40px","fontWeight":"500","height":"40px","order":"50"}'
				  @current-change="curChange"
				  @prev-click="prevClick"
				  @next-click="nextClick"
				></el-pagination>
			</el-tab-pane>
		</el-tabs>
	</div>
	<div class="share_view" :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","bottom":"20%","background":"#fff","width":"48px","position":"fixed","right":"0","zIndex":"11"}'>
	</div>
	<el-dialog title="优惠券" :visible.sync="couponVisible" width="85%">
		<div class="coupon_list">
			<div class="coupon" v-for="(item,index) in couponList" :key="index">
				<div class="coupon_left">
					<div class="name">{{item.name}}</div>
					<div class="name">满{{item.fullamount}}减{{item.discountamount}}</div>
					<div class="date">{{item.startime}}-{{item.endtime}}</div>
					<div class="date">{{item.remark}}</div>
				</div>
				<div class="coupon_right">
					<div class="price">￥<span class="num">{{item.discountamount}}</span></div>
					<div class="btn" @click="getCoupon(item)">立即领取</div>
				</div>
			</div>
			<div class="noList" v-if="!couponList.length">
				暂无优惠券
			</div>
		</div>
	</el-dialog>
</div>
</template>

<script>
  import axios from 'axios'
  import Swiper from "swiper";
  
  export default {
    //数据集合
    data() {
      return {
        tablename: 'shangpinxinxi',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '商品信息'
          }
        ],
        title: '',
        detailBanner: [],
		userid: localStorage.getItem('frontUserid'),
		id: 0,
        detail: {},
        activeName: 'second',
        form: {
          content: '',
          userid: localStorage.getItem('frontUserid'),
          nickname: localStorage.getItem('username'),
          avatarurl: '',
        },
		showIndex: -1,
        infoList: [],
        rules: {
          content: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ],
        },
        total: 1,
        pageSize: 5,
        totalPage: 1,
        storeupParams: {
          name: '',
          picture: '',
          refid: 0,
          tablename: 'shangpinxinxi',
          userid: localStorage.getItem('frontUserid')
        },
        isStoreup: false,
        storeupInfo: {},
        isCrazilynum: false,
        isThumbsupnum: false,
        thumbsupOrCrazilyInfo: {},
        buynumber: 1,
        cart: {
			buynumber: 0,
			discountprice: 0,
			goodid: 0,
			goodname: '',
			picture: '',
			price: 0,
			userid: localStorage.getItem('frontUserid')
        },
        isInCart: false,
		centerType: false,
		shareUrl: location.href,
		couponVisible: false,
		couponList: [],
      }
    },
    created() {
		if(this.$route.query.centerType) {
			this.centerType = true
		}
		
        this.init();
    },
	mounted() {
	},
    //方法集合
    methods: {
        init() {
		  this.id = this.$route.query.id
          this.baseUrl = this.$config.baseUrl;
          this.$http.get(this.tablename + '/detail/'  + this.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
				this.title = this.detail.shangpinmingcheng;
				this.detailBanner = this.detail.shangpintupian ? this.detail.shangpintupian.split(",") : [];
				this.$forceUpdate();

				this.getDiscussList(1);
				if(localStorage.getItem('frontToken')){
					this.getStoreupStatus();
					this.getThumbsupOrCrazilyStatus();
					this.getCartList();
				}

            }
          });
        },
      storeup(type) {
        if (type == 1 && !this.isStoreup) {
          this.storeupParams.name = this.title;
          this.storeupParams.picture = this.detailBanner[0];
          this.storeupParams.refid = this.detail.id;
          this.storeupParams.type = type;
          this.$http.post('storeup/add', this.storeupParams).then(res => {
            if (res.data.code == 0) {
              this.isStoreup = true;
			  this.detail.storeupnum++
			  this.$http.post('shangpinxinxi/update', this.detail).then(res => {});
              this.$message({
                type: 'success',
                message: '收藏成功!',
                duration: 1500,
              });
            }
          });
        }
        if (type == -1 && this.isStoreup) {
          this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'shangpinxinxi', userid: localStorage.getItem('frontUserid')}}).then(res => {
            if (res.data.code == 0 && res.data.data.list.length > 0) {
              this.isStoreup = true;
              this.storeupInfo = res.data.data.list[0];
              let delIds = new Array();
              delIds.push(this.storeupInfo.id);
              this.$http.post('storeup/delete', delIds).then(res => {
                if (res.data.code == 0) {
                  this.isStoreup = false;
				  this.detail.storeupnum--
				  this.$http.post('shangpinxinxi/update', this.detail).then(res => {});
                  this.$message({
                    type: 'success',
                    message: '取消成功!',
                    duration: 1500,
                  });
                }
              });
            }
          });
        }
      },
      getStoreupStatus(){
        if(localStorage.getItem("frontToken")) {
            this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'shangpinxinxi', userid: localStorage.getItem('frontUserid')}}).then(res => {
              if (res.data.code == 0 && res.data.data.list.length > 0) {
                this.isStoreup = true;
                this.storeupInfo = res.data.data.list[0];
              }
            });
        }
      },
      thumbsupOrCrazily(type) {
        this.storeupParams.name = this.title;
        this.storeupParams.picture = this.detailBanner[0];
        this.storeupParams.refid = this.detail.id;
        this.storeupParams.type = type;
        this.$http.post('storeup/add', this.storeupParams).then(res => {
          if (res.data.code == 0) {
            this.getThumbsupOrCrazilyStatus();
            this.$message({
              type: 'success',
              message: '操作成功!',
              duration: 1500,
            });
          }
        });

        if (type == 21) this.detail.thumbsupnum = Number(this.detail.thumbsupnum) + 1;
        if (type == 22) this.detail.crazilynum = Number(this.detail.crazilynum) + 1;
        this.$http.post('shangpinxinxi/update', this.detail).then(res => {});
      },
      cancelThumbsupOrCrazily(type) {
        let delIds = new Array();
        delIds.push(this.thumbsupOrCrazilyInfo.id);
        this.$http.post('storeup/delete', delIds).then(res => {
          if (res.data.code == 0) {
            this.isThumbsupnum = false;
            this.isCrazilynum = false;
            this.$message({
              type: 'success',
              message: '取消成功!',
              duration: 1500,
            });
          }
        });

        if (type == 21) this.detail.thumbsupnum -= 1;
        if (type == 22) this.detail.crazilynum -= 1;
        this.$http.post('shangpinxinxi/update', this.detail).then(res => {});
      },
    getThumbsupOrCrazilyStatus() {
        if(localStorage.getItem("frontToken")) {
            this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 21, refid: this.detail.id, tablename: 'shangpinxinxi', userid: localStorage.getItem('frontUserid')}}).then(res => {
              if (res.data.code == 0 && res.data.data.list.length > 0) {
                this.isThumbsupnum = true;
                this.thumbsupOrCrazilyInfo = res.data.data.list[0];
              }
            });

            this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 22, refid: this.detail.id, tablename: 'shangpinxinxi', userid: localStorage.getItem('frontUserid')}}).then(res => {
              if (res.data.code == 0 && res.data.data.list.length > 0) {
                this.isCrazilynum = true;
                this.thumbsupOrCrazilyInfo = res.data.data.list[0];
              }
            });
        }
    },
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
      sizeChange(size){
        this.pageSize = size
        this.getDiscussList(1);
      },
		// 返回按钮
		backClick(){
			let params = {}
			if(this.centerType){
				params.centerType = 1
			}
			this.$router.push({path: '/index/shangpinxinxi', query: params});
		},
		// 下载
		download(file){
			if(!file) {
				this.$message({
				  type: 'error',
				  message: '文件不存在',
				  duration: 1500,
				});
				return;
			}
		  let arr = file.replace(new RegExp('upload/', "g"), "")
		  axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: localStorage.getItem("frontToken")
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  },err=>{
			  axios.get((location.href.split(this.$config.name).length>1 ? location.href.split(this.$config.name)[0] :'') + this.$config.name + '/file/download?fileName=' + arr, {
			  	headers: {
			  		token: localStorage.getItem("frontToken")
			  	},
			  	responseType: "blob"
			  }).then(({
			  	data
			  }) => {
			  	const binaryData = [];
			  	binaryData.push(data);
			  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
			  		type: 'application/pdf;chartset=UTF-8'
			  	}))
			  	const a = document.createElement('a')
			  	a.href = objectUrl
			  	a.download = arr
			  	// a.click()
			  	// 下面这个写法兼容火狐
			  	a.dispatchEvent(new MouseEvent('click', {
			  		bubbles: true,
			  		cancelable: true,
			  		view: window
			  	}))
			  	window.URL.revokeObjectURL(data)
			  })
		  })
      },
      getDiscussList(page) {
        this.$http.get('discussshangpinxinxi/list', {params: {page, limit: this.pageSize, refid: this.detail.id}}).then(res => {
          if (res.data.code == 0) {
            this.infoList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = Number(res.data.data.pageSize);
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
	  discussEnter(index){
		  this.showIndex = index
	  },
	  discussLeave(){
		  this.showIndex = -1
	  },
	  discussDel(id){
		  this.$confirm('是否删除此评论？')
		    .then(_ => {
		      this.$http.post('discussshangpinxinxi/delete',[id]).then(res=>{
				  if(res.data&&res.data.code==0){
					  this.addDiscussNum(1)
					  this.$message({
					    type: 'success',
					    message: '删除成功!',
					    duration: 1500,
						onClose: () => {
							this.getDiscussList(1);
						}
					  });
				  }
			  })
		    }).catch(_ => {});
	  },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get('orders/list', {params: {page: 1, limit: 1, status: '已完成', goodid: this.detail.id, userid: localStorage.getItem('frontUserid')}}).then(res => {
                if (res.data.code == 0 && res.data.data.list.length == 0) {
                  this.$message({
                    type: 'success',
                    message: '请完成订单后再评论!',
                    duration: 1500
                  });
                  return false
                } else {
                    this.form.refid = this.detail.id;
                    this.form.avatarurl = localStorage.getItem('frontHeadportrait')?localStorage.getItem('frontHeadportrait'):'';
                    this.$http.post('discussshangpinxinxi/add', this.form).then(res => {
						if (res.data.code == 0) {
							this.addDiscussNum(2)
							this.form.content = '';
							this.getDiscussList(1);
							this.$message({
								type: 'success',
								message: '评论成功!',
								duration: 1500,
							});
						}
                    });
                }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
	  addDiscussNum(type){
		  if(type==2){
			  this.detail.discussnum++
		  }else if(type==1){
			  if(this.detail.discussnum!=0){
				  this.detail.discussnum--
			  }else{
				  this.detail.discussnum = 0
			  }
		  }
		  this.$http.post('shangpinxinxi/update',this.detail).then(res=>{
			  
		  })
	  },
      getCartList() {
        this.$http.get('cart/list', {params: {userid: localStorage.getItem('frontUserid'), tablename: 'shangpinxinxi', goodid: this.detail.id}}).then(res => {
          if (res.data.code == 0) {
            if (res.data.data.list.length > 0) {
              this.isInCart = true;
            } else {
              this.isInCart = false;
            }
          }
        });
      },
      addCart() {
            // 单次购买限制
            if (this.detail.onelimittimes > 0 && this.detail.onelimittimes < this.buynumber) {
                this.$message.error(`每人单次只能购买${this.detail.onelimittimes}件`);
                return
            }
            // 库存不够
            if (this.detail.alllimittimes <= 0 ) {
                this.$message.error(`商品已售罄`);
                return
            }
            // 库存限制
            if (this.detail.alllimittimes > 0 && this.detail.alllimittimes < this.buynumber) {
                this.$message.error(`库存不足`);
                return
            }
        if (this.isInCart) {
          this.$message.error('该商品已经添加到购物车');
          return;
        }

        this.cart.buynumber = this.buynumber;
        this.cart.goodid = this.detail.id;
        this.cart.goodname = this.title;
        this.cart.tablename = this.tablename;
        this.cart.picture = this.detailBanner[0];
        this.cart.price = this.detail.price;
        this.$http.post('cart/save', this.cart).then(res => {
          if (res.data.code === 0) {
            this.getCartList();
            this.$message({
              message: '添加成功',
              type: 'success',
              duration: 1500,
            });
          } else {
            this.$message.error(res.data.msg);
          }
        });
      },
        //立即购买
        buyNow() {
            // 单次购买限制
            if (this.detail.onelimittimes > 0 && this.detail.onelimittimes < this.buynumber) {
                this.$message.error(`每人单次只能购买${this.detail.onelimittimes}件`);
                return
            }
            // 库存不够
            if (this.detail.alllimittimes <= 0 ) {
                this.$message.error(`商品已售罄`);
                return
            }
            // 库存限制
            if (this.detail.alllimittimes > 0 && this.detail.alllimittimes < this.buynumber) {
                this.$message.error(`库存不足`);
                return
            }
            // 保存到storage中，在确认下单页面中获取要购买的商品
            localStorage.setItem('orderGoods', JSON.stringify([{
                tablename: this.tablename,
                goodid: this.detail.id,
                goodname: this.title,

                picture:this.detailBanner[0],
                buynumber: this.buynumber,
                userid: localStorage.getItem('frontUserid'),
                price: this.detail.price,
                discountprice: this.detail.vipprice ? this.detail.vipprice : 0
            }]));
            // 跳转到确认下单页面
            let query = {
                type: 1,
            }
            this.$router.push({path: '/index/shop-order/orderConfirm', query: query});
        },


        // 积分兑换
        jfTap() {
            // 活动倒计时限制
            // 单次购买限制
            if (this.detail.onelimittimes > 0 && this.detail.onelimittimes < this.buynumber) {
                this.$message.error(`每人单次只能购买${this.detail.onelimittimes}件`);
                return
            }
            // 库存不够
            if (this.detail.alllimittimes <= 0 ) {
                this.$message.error(`商品已售罄`);
                return
            }
            // 库存限制
            if (this.detail.alllimittimes > 0 && this.detail.alllimittimes < this.buynumber) {
                this.$message.error(`库存不足`);
                return
            }
            // 保存到storage中，在确认下单页面中获取要购买的商品
            localStorage.setItem('orderGoods', JSON.stringify([{
                tablename: this.tablename,
                goodid: this.detail.id,
                goodname: this.title,

                picture:this.detailBanner[0],
                buynumber: this.buynumber,
                userid: localStorage.getItem('frontUserid'),
                price: this.detail.jf,
                discountprice: this.detail.jf ? this.detail.jf : 0
            }]));
            // 跳转到确认下单页面,并且携带参数type=2代表是积分兑换
            let query = {
              type: 2,
            }
            this.$router.push({path: '/index/shop-order/orderConfirm', query: query});
        },
		// 权限判断
		btnAuth(tableName,key){
			if(this.centerType){
				return this.isBackAuth(tableName,key)
			}else{
				return this.isAuth(tableName,key)
			}
		},
		// 修改
		editClick(){
			this.$router.push(`/index/shangpinxinxiAdd?type=edit&&id=${this.detail.id}`);
		},
		// 删除
		async delClick(){
			await this.$confirm('是否删除此商品信息？')
			  .then(_ => {
			    this.$http.post('shangpinxinxi/delete', [this.detail.id]).then(async res => {
					if (res.data.code == 0) {
						this.$http.get('storeup/list',{params:{
							page: 1,
							limit: 100,
							refid: this.detail.id,
							tablename: 'shangpinxinxi',
						}}).then(async obj=>{
							if(obj.data&&obj.data.code==0){
								let arr = []
								for(let x in obj.data.data.list){
									arr.push(obj.data.data.list[x].id)
								}
								if(arr.length){
									await this.$http.post('storeup/delete',arr).then(()=>{})
								}
								this.$message({
									type: 'success',
									message: '删除成功!',
									duration: 1500,
									onClose: () => {
										history.back()
									}
								});
							}
						})
					}
			    });
			  }).catch(_ => {});
		},
		// 获取uuid
		getUUID() {
			return new Date().getTime();
		},
		couponClick() {
			this.couponList = []
			this.couponVisible = true
			this.getCouponList()
		},
		getCouponList() {
			this.$http.get('coupon/lists').then(res => {
				if (res.data && res.data.code == 0) {
					for (let x in res.data.data) {
						if (this.changeCoupon(res.data.data[x])) {
							this.couponList.push(res.data.data[x])
						}
					}
				}
			})
		},
		changeCoupon(row) {
			if (!this.isBetweenTime(this.getCurDateTime(), [row.startime, row.endtime])) {
				return false
			}
			return true
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
		getCoupon(item) {
			this.$http.get('mycoupon/page', {
				params: {
					page: 1,
					couponid: item.id
				}
			}).then(res => {
				if (res.data && res.data.code == 0) {
					if (res.data.data.list.length) {
						this.$message.error('已领取该优惠券，请前往使用')
						return false
					}
					let data = {
						userid: localStorage.getItem('frontUserid'),
						couponid: item.id,
					}
					data = Object.assign(data, JSON.parse(JSON.stringify(item)))
					data.couponnumber = this.getUUID()
					delete data.id
					delete data.addtime
					this.$http.post('mycoupon/add', data).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('领取成功！')
						}
					})
				}
			})
		},
    },
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	
	.detail-preview {
	
	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }
	
	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }
	
	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }
	
	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		margin: 0 0 0 -1px;
		display: flex;
		border-color: #DCDFE6;
		border-radius: 0px 0 0 0px;
		background: #000;
		width: 80px;
		justify-content: center;
		border-width: 1px 1px 1px 0;
		align-items: center;
		position: inherit;
		border-style: solid;
		text-align: center;
		height: 36px;
		order: 3;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #fff;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		margin: 0 -1px 0 0;
		display: flex;
		border-color: #ddd;
		border-radius: 0;
		background: #000;
		width: 80px;
		justify-content: center;
		border-width: 1px 0 1px 1px;
		align-items: center;
		position: inherit;
		border-style: solid;
		text-align: center;
		height: 36px;
		order: 0;
	}
	
	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #fff;
		font-size: 14px;
	}
	
	.attr .el-input-number /deep/ .el-input .el-input__inner {
		border: 1px solid #ddd;
		padding: 0;
		margin: 1px 0 0;
		color: #666;
		display: inline-block;
		font-size: 14px;
		line-height: 36px;
		border-radius: 0px;
		outline: none;
		background: #fff;
		width: 100%;
		position: inherit;
		text-align: center;
		height: 36px;
		order: 2;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		margin: 0;
		background: none;
		border-color: #e9e9e9;
		border-width: 0px 0;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		border: 0;
		padding: 0 20px;
		margin: 0 20px 0 0;
		color: #333;
		font-weight: 500;
		display: inline-block;
		font-size: 14px;
		border-color: #e9e9e9;
		line-height: 60px;
		transition: all 0s;
		background: #fff;
		border-width: 0 0px 0 0;
		position: relative;
		border-style: solid;
		list-style: none;
		text-align: center;
		min-width: 120px;
		height: 60px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		color: #fff;
		background: #f7c420;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		border: 0;
		margin: 0 20px 0 0;
		color: #fff;
		background: #f7c420;
		border-color: #e9e9e9;
		border-width: 0 0px 0 0;
		line-height: 60px;
		border-style: solid;
		text-align: center;
		min-width: 120px;
		height: 60px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		width: 80px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 10px;
		color: #000;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
		color: #000;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
		color: #000;
		display: inline-block;
	}
		
	.breadcrumb-preview .el-breadcrumb .item3 /deep/ .el-breadcrumb__inner a {
		color: #000;
		display: inline-block;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0 6px;
		margin: 0 5px;
		color: #666;
		background: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0 6px;
		margin: 0 5px;
		color: #666;
		background: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0 6px;
		margin: 0 5px;
		color: #C0C4CC;
		background: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0 6px;
		margin: 0 5px;
		color: #C0C4CC;
		background: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #fff;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f7c420;
		text-align: center;
		min-width: 30px;
		height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f7c420;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}

	#pagination.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	.share_view{
		position: fixed;
		right:0;
		bottom: 20%;
		background: #fff;
		box-shadow: 0 4px 6px rgba(0,0,0,.1);
		.share{
			width: 40px;
			height: 40px;
			display: flex;
			align-items: center;
			justify-content: center;
			border-bottom: 1px solid #eee;
			cursor: pointer;
		}
		.share:last-of-type{
			border:none;
		}
	}


	.detail-preview .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	
	.detail-preview .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				display: block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
	.coupon_list {
		width: 100%;
		display: flex;
		flex-wrap: wrap;
	
		.coupon {
			width: 31%;
			background: url('../../assets/coupon.png');
			background-repeat: no-repeat;
			background-position: center center;
			background-size: cover;
			padding: 60px 30px;
			display: flex;
			align-items: center;
			margin: 0 1% 20px;
	
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
	
		.noList {
			color: #9e9e9e;
			width: 100%;
			text-align: center;
			padding: 60px 0;
		}
	}
</style>
