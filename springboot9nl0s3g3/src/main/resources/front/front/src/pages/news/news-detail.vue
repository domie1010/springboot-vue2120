<template>
	<div :style='{"padding":"0 10%","margin":"10px auto","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative","justifyContent":"space-between"}'>
	<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 10px 20px 0","color":"#fff","borderRadius":"6px","background":"#000","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' type="warning" size="mini" @click="backClick" class="el-icon-back">返回</el-button>
	<div :style='{"width":"100%","overflow":"hidden","flexWrap":"wrap","background":"none","justifyContent":"space-between","display":"flex"}'>
		<div :style='{"margin":"10px 0 0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230921/eb4b56c7d55142c4b9339e032022bfb5.png) repeat-x center bottom","display":"none","width":"calc(100% - 0px)","lineHeight":"56px","height":"66px"}'>
			<div :style='{"margin":"0 auto","color":"#333","textAlign":"center","background":"none","display":"inline-block","width":"auto","fontSize":"20px","fontWeight":"500"}'>公告信息</div>
		</div>
		<div :style='{"minHeight":"260px","padding":"20px 20px 60px","background":"#fff","flex":"1","width":"calc(100% - 230px)","position":"relative","order":"1"}'>
			<div  :style='{"padding":"0 0 10px","margin":"0 0 10px","borderColor":"#f7c420","color":"#000","textAlign":"left","borderWidth":"0 0 4px","width":"100%","lineHeight":"24px","fontSize":"16px","borderStyle":"solid","fontWeight":"600"}'>{{detail.title}}</div>
			
			<div :style='{"margin":"40px 0 10px","alignItems":"center","color":"#999","background":"none","display":"flex","width":"100%","fontSize":"14px","justifyContent":"flex-end"}'>
			  <div :style='{"padding":"0","margin":"0 10px 0 0","position":"absolute","left":"20px","bottom":"20px"}'>
			    <span class="icon iconfont icon-shijian22" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit","display":"none"}'></span>
			    <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>发布时间：{{detail.addtime}}</span>
			  </div>
			  <div :style='{"padding":"0","margin":"0 10px 0 0"}'>
			    <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
			    <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{detail.name}}</span>
			  </div>
			  <div :style='{"padding":"0","margin":"0 10px 0 0"}'>
			    <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
			    <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{detail.thumbsupnum}}</span>
			  </div>
			  <div :style='{"padding":"0","margin":"0 10px 0 0"}'>
			    <span class="icon iconfont icon-cai01" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
			    <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{detail.storeupnum}}</span>
			  </div>
			  <div :style='{"padding":"0","margin":"0 10px 0 0"}'>
			    <span class="icon iconfont icon-liulan13" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
			    <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{detail.clicknum}}</span>
			  </div>
			</div>
			<div class="operate" :style='{"padding":"0","alignItems":"center","color":"#666","display":"flex","width":"100%","fontSize":"14px","justifyContent":"flex-end"}'>
				<div @click="zanClick" :style='{"padding":"0 15px","alignItems":"center","justifyContent":"center","display":"flex"}'>
					<span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"inherit","color":"inherit"}'></span>
					<span :style='{"color":"inherit","lineHeight":"40px","fontSize":"inherit"}'>{{zanType?'取消赞':'点赞'}}</span>
				</div>
				<div @click="collectClick" :style='{"padding":"0 15px","alignItems":"center","justifyContent":"center","display":"flex"}'>
					<span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"inherit","color":"inherit"}'></span>
					<span :style='{"color":"inherit","lineHeight":"40px","fontSize":"inherit"}'>{{collectType?'取消收藏':'收藏'}}</span>
				</div>
			</div>
			
			<div :style='{"margin":"20px 0 0","color":"#666","width":"100%","fontSize":"14px","lineHeight":"1.5","textIndent":"2em","height":"auto"}' class="content-detail" v-html="detail.content"></div>
		</div>
		<!-- option -->
		<div :style='{"padding":"0","margin":"20px 0 0","display":"flex","width":"calc(100% - 280px)","justifyContent":"center","height":"auto","order":"10"}'>
		  <div :style='{"border":"0px solid #1e3c4f60","padding":"0 10px","margin":"0 30px 0 0","color":"#333","borderRadius":"8px","background":"#f7c420","fontSize":"14px","lineHeight":"36px","height":"36px"}' @click="prepDetailClick">上一篇：prev</div>
		  <div :style='{"border":"0px solid #1e3c4f60","padding":"0 10px","color":"#333","borderRadius":"8px","background":"#ffe9a1","fontSize":"14px","lineHeight":"36px","height":"36px"}' @click="nextDetailClick">下一篇：next</div>
		</div>

		<!-- 热门文章 -->
		<div class="hot" :style='{"padding":"0","margin":"0px 0 0 30px","borderRadius":"8px","background":"#fff","width":"250px","height":"auto","order":"2"}'>
		  <div :style='{"padding":"20px 0 0","borderColor":"#f7c420","color":"#00172e","borderRadius":"4px","textAlign":"center","background":"none","borderWidth":"8px 0 0","width":"100%","lineHeight":"24px","fontSize":"22px","borderStyle":"solid","fontWeight":"600"}'>热门消息</div>
		  <div :style='{"width":"100%","padding":"0 10px 10px","margin":"0","background":"#fff","height":"auto"}'>
		    <div v-for="item in hotList" :key="item.id" :style='{"cursor":"pointer","width":"100%","padding":"0","margin":"0 0 20px","background":"#fff","height":"auto"}' @click="toDetail(item.id)">
		      <img :style='{"margin":"0 0 5px","objectFit":"cover","borderRadius":"4px","display":"block","width":"100%","float":"left","height":"150px"}' :src="baseUrl + item.picture" alt="">
		      <div :style='{"padding":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis","float":"right","height":"24px"}'>{{ item.title }}</div>
		      <div :style='{"padding":"0","margin":"0 0 5px","color":"#999","textAlign":"right","width":"100%","lineHeight":"24px","fontSize":"14px","float":"right"}'>{{item.addtime}}</div>
		    </div>
		  </div>
		</div>
		<!-- 推荐文章 -->
		<div class="news" :style='{"width":"100%","margin":"20px 0 0","textAlign":"center","background":"none","height":"auto","order":"11"}'>
		  <div :style='{"padding":"20px 20px 0px","color":"#000","textAlign":"left","background":"url(http://codegen.caihongy.cn/20240303/fbc8c854c36a4fec9c653496921a9e49.png) no-repeat left top / 100% 10px","display":"inline-block","width":"100%","lineHeight":"44px","fontSize":"22px","minWidth":"200px","fontWeight":"600"}'>推荐文章</div>
		  <div :style='{"padding":"0 20px","margin":"10px 0 0","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		    <div v-for="item in recommendList" :key="item.id" :style='{"border":"1px solid #eee","width":"23%","padding":"10px","borderRadius":"8px","background":"#fff","height":"auto"}' @click="toDetail(item.id)">
		      <img :style='{"width":"30%","objectFit":"cover","borderRadius":"4px","float":"left","display":"block","height":"120px"}' :src="baseUrl + item.picture" alt="">
		      <div :style='{"padding":"0 10px","overflow":"hidden","whiteSpace":"nowrap","color":"#000","textAlign":"left","width":"70%","lineHeight":"40px","fontSize":"14px","textOverflow":"ellipsis","float":"right"}'>{{ item.title }}</div>
		      <div :style='{"padding":"0 10px","color":"#999","textAlign":"left","width":"70%","lineHeight":"24px","fontSize":"14px","float":"right"}'>{{item.addtime}}</div>
		    </div>
		  </div>
		</div>
	</div>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				id: 0,
				detail: {},
				zanType: false,
				zanForm: {},
				collectType:false,
				collectForm: {},
				baseUrl:'',
				hotList: [],
				recommendList: [],
				categoryList: [],
				currentIndex: 0,
				allList: []
			}
		},
		created() {
			this.id = this.$route.query.id
			this.baseUrl = this.$config.baseUrl;
			this.getCategoryList()
			this.getDetail()
			this.getNewsList()
			this.getHotList()
			this.getRecommendList()
		},
		watch:{
			$route(newValue) {
				this.id = this.$route.query.id
			    this.getDetail()
			}
		},
		methods: {
			  backClick() {
				  history.back()
			  },
			getNewsList() {
				let params = {page:1, limit: 100,sort:'addtime',order:'desc'};
				this.$http.get('news/list', {params: params}).then(res => {
					if (res.data.code == 0) {
						for(let x in res.data.data.list){
							if(res.data.data.list[x].id == this.id){
								this.currentIndex = Number(x)
								break
							}
						}
						this.allList = res.data.data.list
					}
				});
			},
			// 上一篇
			prepDetailClick(){
				if(this.currentIndex == 0){
					this.$message.error('已经是第一篇了')
					return false
				}
				this.currentIndex--
				this.$router.push({path: '/index/newsDetail', query: {id: this.allList[this.currentIndex].id}});
			},
			// 下一篇
			nextDetailClick(){
				if(this.currentIndex == this.allList.length - 1){
					this.$message.error('已经是最后一篇了')
					return false
				}
				this.currentIndex++
				this.$router.push({path: '/index/newsDetail', query: {id: this.allList[this.currentIndex].id}});
			},
			getCategoryList(){
				this.$http.get('newstype/list', {}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data;
					}
				});
			},
			// 获取热门列表
			getHotList(){
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get('news/autoSort', {params: params}).then(res => {
					if (res.data.code == 0) {
						this.hotList = res.data.data.list;
					}
				});
			},
			// 获取推荐列表
			getRecommendList(){
				let url = 'news/autoSort'
				if(localStorage.getItem('frontToken')){
					url = 'news/autoSort2'
				}
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get(url, {params: params}).then(res => {
					if (res.data.code == 0) {
						this.recommendList = res.data.data.list;
					}
				});
			},
			// 跳转详情
			toDetail(id){
				this.$router.push({path: '/index/newsDetail', query: {id: id}});
			},
			getDetail(){
				this.$http.get(`news/detail/${this.id}`,{}).then(res=>{
					if(res.data&&res.data.code==0){
						this.detail = res.data.data
						window.scrollTo(0, 100)
						this.getZan()
						this.getCollect()
					}
				})
			},
			getZan() {
				this.$http.get('storeup/list', {
					params: {
						page: 1,
						limit: 1,
						type: 21,
						userid: localStorage.getItem('frontUserid'),
						tablename: 'news',
						refid: this.id
					}
				}).then(res=>{
					if(res.data&&res.data.code==0){
						if(res.data.data.list.length){
							this.zanType = true
							this.zanForm = res.data.data.list[0]
						}else{
							this.zanType = false
						}
					}
				})
			},
			getCollect(){
				this.$http.get('storeup/list', {
					params: {
						page: 1,
						limit: 1,
						type: 1,
						userid: localStorage.getItem('frontUserid'),
						tablename: 'news',
						refid: this.id
					}
				}).then(res=>{
					if(res.data&&res.data.code==0){
						if(res.data.data.list.length){
							this.collectType = true
							this.collectForm = res.data.data.list[0]
						}else{
							this.collectType = false
						}
					}
				})
			},
			zanClick() {
				if(this.zanType){
					this.$http.post('storeup/delete', [this.zanForm.id]).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('取消成功')
							this.detail.thumbsupnum--
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getZan()
						}
					})
				}else{
					let data = {
						name: this.detail.title,
						picture: this.detail.picture,
						refid: this.detail.id,
						type: 21,
						tablename: 'news',
						userid: localStorage.getItem('frontUserid')
					}
					this.$http.post('storeup/add', data).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('点赞成功')
							this.detail.thumbsupnum++
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getZan()
						}
					})
				}
			},
			collectClick(){
				if(this.collectType){
					this.$http.post('storeup/delete', [this.collectForm.id]).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('取消成功')
							this.detail.storeupnum--
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getCollect()
						}
					})
				}else{
					let data = {
						name: this.detail.title,
						picture: this.detail.picture,
						refid: this.detail.id,
						type: 1,
						tablename: 'news',
						userid: localStorage.getItem('frontUserid')
					}
					this.$http.post('storeup/add', data).then(res => {
						if (res.data && res.data.code == 0) {
							this.detail.storeupnum++
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.$message.success('收藏成功')
							this.getCollect()
						}
					})
				}
			},
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.section {
		width: 900px;
		margin: 0 auto;
	}
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	.section-content {
		margin-top: 30px;
	}
	.content-title {
		text-align: center;
		font-size: 22px;
		font-weight: bold;
	}
	.content-sub-title {
		text-align: center;
		margin-top: 20px;
		color: #888888;
		font-size: 14px;
	}
	.operate{
		display: flex;
		align-items: center;
		justify-content: space-between;
		padding: 0 40px;
	}
</style>