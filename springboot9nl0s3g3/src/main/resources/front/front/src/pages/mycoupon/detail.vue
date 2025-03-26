<template>
<div>
	<div :style='{"padding":"0","margin":"20px auto","borderColor":"#eee","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20240301/3bd53b03e3db41a8a75b2dad0cd5dacf.png) repeat-x left top / auto 8px","borderWidth":"0px","width":"80%","borderStyle":"solid","order":"3"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'☰'" :style='{"padding":"0 150px 0 120px","color":"#fff","background":"#f7c420","display":"inline-block","width":"auto","lineHeight":"50px","fontSize":"16px","justifyContent":"flex-start"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" :to="'/index/mycoupon?centerType=' + (centerType?'1':'0')"><a>{{item.name}}</a></el-breadcrumb-item>
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
                    </div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>优惠券id</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.couponid}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>名称</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.name}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>券编号</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.couponnumber}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>满额</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.fullamount}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>优惠额</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.discountamount}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>生效时间</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.startime}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>过期时间</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.endtime}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>优惠券类型</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.type}}</div>
				</div>
				<div class="item" :style='{"padding":"2px 10px","margin":"0 0 10px 0","borderColor":"#28890b10","borderRadius":"4px","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","whiteSpace":"nowrap","color":"#888","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>备注</div>
					<div  :style='{"padding":"8px 10px 0","wordBreak":"break-all","color":"#000","flex":"1","fontSize":"14px","lineHeight":"24px","height":"auto"}'>{{detail.remark}}</div>
				</div>
				<div class="btn" :style='{"width":"100%","padding":"0","flexWrap":"wrap","display":"flex"}'>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 20px 0","outline":"none","color":"#fff","borderRadius":"6px","background":"#f7c420","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('mycoupon','修改')" @click="editClick">修改</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 10px 0","color":"#333","borderRadius":"6px","background":"#ffecaf","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('mycoupon','删除')" @click="delClick">删除</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 10px 0","color":"#333","borderRadius":"6px","background":"#ffecaf","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('mycoupon','私聊')&&detail.id!=mid" @click="chatClick">联系TA</el-button>
				</div>
			</div>
		</div>
		
			<el-carousel v-if="detailBanner.length" :style='{"width":"100%","margin":"0","background":"#fff","height":"100%"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="480px" :autoplay="true" :interval="3000" :loop="true">
				<el-carousel-item :style='{"borderRadius":"10px","width":"100%","height":"100%"}' v-for="item in detailBanner" :key="item.id">
					<img :style='{"objectFit":"contain","width":"100%","height":"100%"}' :preview-src-list="[item]" v-if="item.substr(0,4)=='http'" :src="item" class="image">
					<img :style='{"objectFit":"contain","width":"100%","height":"100%"}' :preview-src-list="[baseUrl + item]" v-else :src="baseUrl + item" class="image">
				</el-carousel-item>
			</el-carousel>


		

		
		<el-tabs class="detail" :style='{"boxShadow":"none","margin":"20px auto 40px","borderColor":"#d8d8d8","background":"url(http://codegen.caihongy.cn/20240303/d773402b21c748ddbf4a9b7e093f7797.png) repeat-x center top / auto 10px","borderWidth":"0","display":"block","width":"100%","borderStyle":"solid","order":"8"}' v-model="activeName" type="border-card">
		</el-tabs>
	</div>
</div>
</template>

<script>
  import axios from 'axios'
  import Swiper from "swiper";
  
  export default {
    //数据集合
    data() {
      return {
        tablename: 'mycoupon',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '我的优惠券'
          }
        ],
        title: '',
        detailBanner: [],
		userid: localStorage.getItem('frontUserid'),
		id: 0,
        detail: {},
        activeName: 'first',
        total: 1,
        pageSize: 5,
        totalPage: 1,
        buynumber: 1,
		centerType: false,
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
				this.$forceUpdate();

				if(localStorage.getItem('frontToken')){
				}

            }
          });
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
			this.$router.push({path: '/index/mycoupon', query: params});
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
			this.$router.push(`/index/mycouponAdd?type=edit&&id=${this.detail.id}`);
		},
		// 删除
		async delClick(){
			await this.$confirm('是否删除此我的优惠券？')
			  .then(_ => {
			    this.$http.post('mycoupon/delete', [this.detail.id]).then(async res => {
					if (res.data.code == 0) {
						this.$message({
							type: 'success',
							message: '删除成功!',
							duration: 1500,
							onClose: () => {
								history.back()
							}
						});
					}
			    });
			  }).catch(_ => {});
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
</style>
