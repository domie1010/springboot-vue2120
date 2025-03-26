<template>
<div class="home-preview" :style='{"padding":"0 10%","margin":"0px auto","flexWrap":"wrap","flexDirection":"row","background":"#f6f6f6","display":"flex","width":"100%","justifyContent":"center"}'>



		<!-- 关于我们 -->
		<div id="about" class="animate__animated" :style='{"minHeight":"500px","padding":"30px","margin":"40px 20px 40px 0","alignItems":"flex-start","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20240301/24b80a403de34629ad8eb5261533a714.png) no-repeat center top / 100% 12px,#fff","flexDirection":"column","display":"flex","width":"calc(40% - 20px)","position":"relative","height":"auto","order":"6"}'>
		  <div :style='{"padding":"0","margin":"0","color":"#f7c420","textAlign":"left","background":"none","width":"100%","fontSize":"30px","lineHeight":"60px","fontWeight":"600"}'>{{aboutUsDetail.title}}</div>
		  <div :style='{"margin":"0 0 30px","color":"#888","textAlign":"left","display":"none","width":"100%","lineHeight":"1.5","fontSize":"16px"}'>{{aboutUsDetail.subtitle}}</div>
		  <div :style='{"padding":"0","margin":"20px 0 0","flexWrap":"wrap","display":"flex","width":"100%","height":"160px","order":"5"}'>
		    <img :style='{"width":"100%","margin":"0","objectFit":"cover","borderRadius":"8px","display":"block","height":"100%"}' :src="baseUrl + aboutUsDetail.picture1">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture2">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture3">
		  </div>
		  <div :style='{"padding":"0","margin":"10px 0 0","color":"#333","background":"none","width":"100%","fontSize":"14px","lineHeight":"24px","height":"auto"}' v-html="aboutUsDetail.content"></div>
		  <div :style='{"width":"315px","position":"absolute","top":"180px","background":"url(http://codegen.caihongy.cn/20231006/3fb7e07853594c3c9097d2bbe08a28bd.png) no-repeat","display":"none","height":"30px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"border":"0px solid #1d8001","cursor":"pointer","margin":"0","top":"40px","textAlign":"center","background":"none","display":"block","width":"auto","lineHeight":"36px","position":"absolute","right":"30px"}' @click="toDetail('aboutusDetail',aboutUsDetail)">
		    <span :style='{"color":"#333","fontSize":"15px"}'>查看更多</span>
		    <span class="icon iconfont icon-jiantou18" :style='{"color":"#666","fontSize":"14px"}'></span>
		  </div>
		</div>
		<!-- 关于我们 -->

		<!-- 系统简介 -->
		<div id="system" class="animate__animated" :style='{"padding":"30px 30px 0","margin":"40px 0 40px 20px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20240301/24b80a403de34629ad8eb5261533a714.png) no-repeat center top / 100% 12px,#fff","display":"block","width":"calc(40% - 20px)","position":"relative","height":"auto","order":"2"}'>
		  <div :style='{"padding":"0","margin":"0","color":"#f7c420","textAlign":"left","background":"none","width":"100%","fontSize":"30px","fontWeight":"600","height":"60px"}'>{{systemIntroductionDetail.title}}</div>
		  <div :style='{"margin":"0 0 30px","color":"#888","textAlign":"right","display":"none","width":"100%","lineHeight":"1.5","fontSize":"16px"}'>{{systemIntroductionDetail.subtitle}}</div>
		  <div :style='{"width":"100%","flexWrap":"wrap","display":"block","height":"auto","order":"2"}'>
		    <img :style='{"width":"100%","margin":"0","objectFit":"cover","borderRadius":"8px","display":"block","height":"210px"}' :src="baseUrl + systemIntroductionDetail.picture1">
		    <img :style='{"width":"43%","margin":"0","objectFit":"contain","display":"none","height":"80%"}' :src="baseUrl + systemIntroductionDetail.picture2">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + systemIntroductionDetail.picture3">
		  </div>
		  <div :style='{"padding":"0px","margin":"20px 0 0","overflow":"hidden","color":"#333","background":"#fff","width":"100%","lineHeight":"24px","fontSize":"14px","height":"312px","order":"1"}' v-html="systemIntroductionDetail.content"></div>
		  <div :style='{"transform":"rotate(180deg)","top":"0","background":"url(http://codegen.caihongy.cn/20230920/8a35b5134ee644b8a9a87ea99a0f1490.png) no-repeat","display":"none","width":"200px","position":"absolute","right":"52%","height":"100%"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"border":"0px solid #1d8001","cursor":"pointer","margin":"0","textAlign":"right","display":"flex","right":"30px","justifyContent":"center","top":"30px","background":"none","width":"auto","lineHeight":"40px","position":"absolute","order":"8","height":"40px"}' @click="toDetail('systemintroDetail',systemIntroductionDetail)">
		    <span :style='{"padding":"0 6px 0 0","margin":"0","color":"#333","background":"none","display":"inline-block","width":"auto","fontSize":"15px","lineHeight":"40px","height":"40px"}'>查看更多</span>
		    <span class="icon iconfont icon-jiantou18" :style='{"padding":"0px","margin":"0","color":"#333","background":"none","display":"inline-block","fontSize":"14px","lineHeight":"40px","height":"40px"}'></span>
		  </div>
		</div>
		<!-- 系统简介 -->
		
	<!-- 新闻资讯 -->
	<div id="animate_newsnews" class="news animate__animated" :style='{"width":"100%","padding":"0","margin":"20px auto","position":"relative","background":"url(),#f6f6f6","order":"3"}'>
		<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
			<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		</div>
		
		<div class="title" :style='{"width":"100%","padding":"0 20px","margin":"0px auto","lineHeight":"60px","textAlign":"left","background":"#F7C420"}'>
			<span :style='{"color":"#000","fontSize":"22px","fontWeight":"600"}'>公告信息</span>
		</div>
		
			
			
			
			
			
			
			
			
			
			
		




		<div class="list list15 index-pv1" :style='{"padding":"0","margin":"20px 0 0","color":"#666","background":"none","width":"100%","fontSize":"14px","height":"auto"}'>
			<div class="tab" :style='{"width":"100%","margin":"0 0 30px","justifyContent":"center","display":"flex","height":"auto"}'>
				<div class="item" :class="newsIndex15 == 0 ? 'active' : ''" @click="newsIndexClick15(0)">
					<div :style='{"color":"inherit","fontSize":"14px"}'>全部</div>
				</div>
				<template v-for="(item,index) in newsCategoryList15">
				<div v-if="index < 6" class="item" :class="newsIndex15 == index + 1 ? 'active' : ''" @click="newsIndexClick15(index+1)">
					<!-- <img :style='{"width":"34px","margin":"0 5px 0 0","objectFit":"cover","display":"block","height":"34px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg"> -->
					<div :style='{"color":"inherit","fontSize":"14px"}'>{{item.typename}}</div>
				</div>
				</template>
				<div class="more" @click="moreBtn('news')">
				  <div :style='{"color":"inherit","fontSize":"14px"}'>更多</div>
				  <span class="icon iconfont icon-jiantou25" :style='{"color":"inherit","margin":"0 0 0 2px","fontSize":"14px"}'></span>
				</div>
			</div>
		  <div v-if="newsList.length" class="content" :style='{"width":"100%","justifyContent":"space-between","display":"flex","height":"auto"}'>
		    <div @click="toDetail('newsDetail', newsList[0])" class="left list-item animation-box" :style='{"cursor":"pointer","borderColor":"#000","margin":"0 40px 20px 0","borderRadius":"8px","background":"#fff","borderWidth":"0px 0px 6px","width":"25%","position":"relative","borderStyle":"solid","height":"auto"}'>
		      <img :style='{"width":"100%","objectFit":"cover","borderRadius":" 8px 8px 0 0","display":"block","height":"170px"}' :src="baseUrl + newsList[0].picture">
		      <div :style='{"padding":"0 10px","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"40px","fontSize":"16px","textOverflow":"ellipsis","fontWeight":"600"}' class="name">{{newsList[0].title}}</div>
		      <div :style='{"padding":"0 10px","margin":"0 0 5px","overflow":"hidden","color":"#666","background":"#fff","lineHeight":"24px","fontSize":"inherit","textIndent":"2em","height":"72px"}' class="desc">{{newsList[0].introduction}}</div>
		      <div :style='{"width":"100%","padding":"0 10px","margin":"5px 0 0","textAlign":"left"}'>
		        <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"24px","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"24px","fontSize":"inherit"}'>{{newsList[0].addtime}}</span>
		      </div>
		      <div :style='{"padding":"10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{newsList[0].name}}</span>
		      </div>
		      <div :style='{"padding":"10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{newsList[0].thumbsupnum}}</span>
		      </div>
		      <div :style='{"padding":"10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{newsList[0].storeupnum}}</span>
		      </div>
		      <div :style='{"padding":"10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{newsList[0].clicknum}}</span>
		      </div>
		    </div>
		    <div v-if="newsList.length > 1" class="right" :style='{"alignItems":"flex-start","flexWrap":"wrap","background":"none","flex":"1","display":"flex","width":"75%","justifyContent":"space-between","height":"auto"}'>
			  <template v-for="(item,index) in newsList">
		      <div v-if="index > 0" @click="toDetail('newsDetail', item)" class="list-item animation-box">
		        <div class="date">
		          <div class="day">{{item.addtime.split(" ")[0].split("-")[2]}}</div>
		          <div class="year">{{item.addtime.split(" ")[0].split("-")[0] + '-' + item.addtime.split(" ")[0].split("-")[1]}}</div>
		        </div>
		        <div :style='{"padding":"20px 0","alignItems":"center","flexWrap":"wrap","flex":"1","display":"flex"}' class="info">
		          <div class="name">{{item.title}}</div>
		          <div class="desc">{{item.introduction}}</div>
		          <div class="publisher" :style='{"padding":"0 10px","display":"inline-block"}'>
		            <span class="icon iconfont icon-geren16"></span>
		            <span class="text">{{item.name}}</span>
		          </div>
		          <div class="like" :style='{"padding":"0 10px","display":"inline-block"}'>
		            <span class="icon iconfont icon-zan10"></span>
		            <span class="text">{{item.thumbsupnum}}</span>
		          </div>
		          <div class="collect" :style='{"padding":"0 10px","display":"inline-block"}'>
		            <span class="icon iconfont icon-shoucang10"></span>
		            <span class="text">{{item.storeupnum}}</span>
		          </div>
		          <div class="view" :style='{"padding":"0 10px","display":"inline-block"}'>
		            <span class="icon iconfont icon-chakan2"></span>
		            <span class="text">{{item.clicknum}}</span>
		          </div>
		        </div>
		      </div>
			  </template>
		    </div>
		  </div>
		</div>







		<div @click="moreBtn('news')" :style='{"border":"0px solid #1d8001","cursor":"pointer","margin":"0 auto","top":"12px","textAlign":"center","background":"none","display":"block","width":"130px","lineHeight":"36px","position":"absolute","right":"0"}'>
			<span :style='{"color":"#000","fontSize":"16px"}'>查看更多</span>
			<i :style='{"color":"#000","fontSize":"16px"}' class="icon iconfont icon-jiantou18"></i>
		</div>
		
		</div>
	<!-- 新闻资讯 -->


<!-- 商品推荐 -->
<div id="animate_recommendshangpinxinxi" class="recommend animate__animated" :style='{"padding":"20px 0 0","margin":"40px 0 0","borderColor":"#f7c420","background":"#f6f6f6","borderWidth":"12px 0 0","width":"60%","position":"relative","borderStyle":"solid","order":"5"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"100%","margin":"0","lineHeight":"40px","textAlign":"left","background":"none"}'>
		<span :style='{"padding":"0","fontSize":"30px","color":"#f7c420","fontWeight":"600","display":"block"}'>商品信息推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	







		<div v-if="shangpinxinxiRecommend.length" :style='{"padding":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="list list17 index-pv1">
		  <div v-for="item,index in shangpinxinxiRecommend" :key="index"  @click="toDetail('shangpinxinxiDetail', item)" :style='{"cursor":"pointer","margin":"20px 0 0","overflow":"hidden","background":"none","width":"32%","position":"relative","height":"353px"}' class="item">
				<img class="image" v-if="preHttp(item.shangpintupian)" :src="item.shangpintupian.split(',')[0]" alt="" />
				<img class="image" v-else :src="baseUrl + (item.shangpintupian?item.shangpintupian.split(',')[0]:'')" alt="" />
			<div class="content">
		      <div :style='{"lineHeight":"24px","fontSize":"14px","color":"#fff","display":"none"}'>{{item.shangpinjieshao}}</div>

		      <div class="info">
				<div :style='{"overflow":"hidden","whiteSpace":"hidden","color":"#fff","textAlign":"left","width":"100%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis"}' class="name ">{{item.shangpinmingcheng}}</div>
				<div :style='{"overflow":"hidden","whiteSpace":"hidden","color":"#fff","textAlign":"left","width":"100%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis"}' class="name ">上架时间:{{item.shangjiashijian}}</div>
				<div :style='{"overflow":"hidden","whiteSpace":"hidden","color":"#fff","textAlign":"left","width":"100%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis"}' class="name ">库存:{{item.alllimittimes}}</div>
				<div :style='{"width":"100%","padding":"0","margin":"0 10px 0 0","display":"inline-block"}'>
		          <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"inherit"}'>{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0","margin":"0 10px 0 0","display":"inline-block"}'>
		          <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"inherit"}'>{{item.thumbsupnum}}</span>
		        </div>
		        <div :style='{"padding":"0","margin":"0 10px 0 0","display":"inline-block"}'>
		          <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"inherit"}'>{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0","margin":"0 10px 0 0","display":"inline-block"}'>
		          <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"inherit"}'>{{item.clicknum}}</span>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
	
	<div @click="moreBtn('shangpinxinxi')" :style='{"border":"0px solid #fff","cursor":"pointer","margin":"0","top":"20px","textAlign":"center","background":"none","display":"block","width":"auto","lineHeight":"36px","position":"absolute","right":"30px"}'>
		<span :style='{"color":"#333","fontSize":"15px"}'>查看更多</span>
		<i :style='{"color":"#666","fontSize":"14px"}' class="icon iconfont icon-jiantou18"></i>
	</div>
	
</div>
<!-- 商品推荐 -->


<!-- 特价商品 -->
<div id="animate_listjifenshangpin" class="lists animate__animated" :style='{"padding":"0","margin":"40px 0 20px","background":"#f6f6f6","flex":"1","width":"60%","position":"relative","order":"1"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"padding":"10px  0 0","margin":"0","borderColor":"#f7c420","textAlign":"left","background":"none","borderWidth":"12px 0 0","width":"100%","lineHeight":"48px","borderStyle":"solid"}'>
	  <span :style='{"padding":"0","fontSize":"30px","color":"#f7c420","fontWeight":"600","display":"block","font":"\"宋体\""}'>积分商品展示</span>
	</div>
	
	
	
	
	
	
	
	
	
	


	<div v-if="jifenshangpinList.length" class="list list11 index-pv1" :style='{"padding":"0","margin":"20px 0 0","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
	  <div class="list" :style='{"alignItems":"flex-start","flexWrap":"wrap","flex":"1","background":"none","display":"flex","justifyContent":"space-between","height":"auto"}'>
	    <div :style='{"cursor":"pointer","margin":"0 0 20px","overflow":"hidden","borderRadius":"8px","background":"#fff","width":"31%","position":"relative","height":"auto"}' class="item list-item animation-box" v-for="item,index in jifenshangpinList" :key="index" @click="toDetail('jifenshangpinDetail', item)">
			<img :name="item.id" :style='{"width":"100%","margin":"0 0 5px","objectFit":"cover","borderRadius":"8px 8px 0 0","display":"block","height":"230px"}' v-if="preHttp(item.shangpintupian)" :src="item.shangpintupian.split(',')[0]" alt="" />
			<img :name="item.id" :style='{"width":"100%","margin":"0 0 5px","objectFit":"cover","borderRadius":"8px 8px 0 0","display":"block","height":"230px"}' v-else :src="baseUrl + (item.shangpintupian?item.shangpintupian.split(',')[0]:'')" alt="" />
			<div class="line1" :style='{"padding":"0 10px","borderColor":"#ddd","whiteSpace":"nowrap","color":"#333","textAlign":"center","overflow":"hidden","borderWidth":"0 0 0px","width":"100%","lineHeight":"24px","fontSize":"16px","textOverflow":"ellipsis","borderStyle":"solid","height":"40px"}'>{{item.shangpinmingcheng}}</div>
	    </div>
	  </div>
	</div>




	
	
	<div @click="moreBtn('jifenshangpin')" :style='{"border":"0px solid #1d8001","cursor":"pointer","margin":"0","top":"30px","textAlign":"center","background":"none","display":"block","width":"auto","lineHeight":"36px","position":"absolute","right":"0"}'>
		<span :style='{"color":"#333","fontSize":"15px"}'>查看更多</span>
		<i :style='{"color":"#333","fontSize":"14px","display":"inline-block"}' class="icon iconfont icon-jiantou18"></i>
	</div>
	

</div>
<!-- 特价商品 -->
	
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        aboutUsDetail: {},
        systemIntroductionDetail: {},
        newsList: [],
        shangpinxinxiRecommend: [],

        jifenshangpinList: [],


		newsIndex15: 0,
		newsCategoryList15: [],


      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getNewsList();
		this.getNewsCategory()
		this.getAboutUs();
		this.getSystemIntroduction();
		this.getList();
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {
			setTimeout(()=>{
			},750)
		},
		newsIndexClick15(index) {
			this.newsIndex15 = index
			this.getNewsList()
		},
		getNewsCategory() {
			this.$http.get('newstype/list', {}).then(res => {
				if (res.data.code == 0) {
					this.newsCategoryList15 = res.data.data
				}
			});
		},

		listIndexClick11(index, name) {
			this['listIndex11' + name] = index[this['listColumn11' + name]]
			this.getList()
		},

		handleScroll() {
			let arr = [
				{id:'search',css:'animate__'},
				{id:'about',css:'animate__'},
				{id:'system',css:'animate__'},
				{id:'animate_recommendshangpinxinxi',css:'animate__'},
				{id:'animate_listjifenshangpin',css:'animate__'},
				{id:'animate_newsnews',css:'animate__'},
				{id:'msgs',css:'animate__'},
				{id:'friendly',css:'animate__'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      getAboutUs() {
          this.$http.get('aboutus/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.aboutUsDetail = res.data.data;
            }
          })
      },
      getSystemIntroduction() {
          this.$http.get('systemintro/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.systemIntroductionDetail = res.data.data;
            }
          })
      },
		getNewsList() {
			let data = {
				page: 1,
				limit: 7,
                sort: 'addtime',
				order: 'desc'
			}
			if(this.newsIndex15!=0) {
				data['typename'] = this.newsCategoryList15[this.newsIndex15 - 1].typename
			}
			this.$http.get('news/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
			let autoSortUrl = "";
			let data = {}
          autoSortUrl = "shangpinxinxi/autoSort";
          if(localStorage.getItem('frontToken')) {
              autoSortUrl = "shangpinxinxi/autoSort2";
          }
			data = {
				page: 1,
				limit: 6,
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.shangpinxinxiRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
			data = {
				page: 1,
				limit: 6,
			}
			this.$http.get('jifenshangpin/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.jifenshangpinList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select /deep/ .el-input__inner {
			border: 0px solid #ddd;
			border-radius: 0px;
			padding: 0 30px 0 10px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .3);
			color: #333;
			width: 180px;
			font-size: 14px;
			height: 32px;
		}
		
		.search .input /deep/ .el-input__inner {
			border: 0px solid #ddd;
			border-radius: 2px;
			padding: 0 10px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .3);
			outline: none;
			color: #333;
			width: 280px;
			font-size: 14px;
			height: 32px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: #0c5f62;
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: #0c5f62;
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(0.96) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
	


	.home-preview .news .list15 .tab .item {
				cursor: pointer;
				border-radius: 8px;
				padding: 0 20px;
				margin: 0 10px;
				color: #333;
				background: #fff;
				display: flex;
				width: auto;
				font-size: 16px;
				line-height: 60px;
				align-items: center;
			}
	
	.home-preview .news .list15 .tab .item:hover {
				background: #f7c420;
			}
	
	.home-preview .news .list15 .tab .item.active {
				background: #f7c420;
			}
	
	.home-preview .news .list15 .tab .more {
				cursor: pointer;
				border-radius: 6px;
				padding: 5px 10px;
				margin: 0 10px;
				color: #fff;
				background: #333;
				display: none;
				line-height: 44px;
				align-items: center;
			}
	
	.home-preview .news .list15 .tab .more:hover {
				background: red;
			}
	
	.home-preview .news .list15 .content .right .list-item  {
				border: 0px solid #ddd;
				cursor: pointer;
				border-radius: 8px;
				padding: 0;
				box-shadow: 1px 2px 9px #eee;
				margin: 0 0 20px;
				overflow: hidden;
				background: #fff;
				display: flex;
				width: 32%;
				justify-content: space-between;
				height: 180px;
			}
	.home-preview .news .list15 .content .right .list-item:hover  {
				box-shadow: 1px 2px 4px #999;
			}
	
	.home-preview .news .list15 .content .right .list-item .date  {
				border-radius: 8px 0 0 8px;
				padding: 0 16px;
				flex-direction: column;
				background: #f7c420;
				display: flex;
				width: auto;
				border-color: #ddd;
				border-width: 0 0px 0 0;
				justify-content: center;
				align-items: center;
				border-style: solid;
				height: 100%;
			}
	.home-preview .news .list15 .content .right .list-item:hover .date {
				border-color: #fff;
			}
	.home-preview .news .list15 .content .right .list-item .date .day  {
				color: #000;
				font-weight: 600;
				width: auto;
				font-size: 32px;
				border-color: #F5BB00;
				border-width: 0 0 0px;
				line-height: 40px;
				border-style: solid;
			}
	.home-preview .news .list15 .content .right .list-item:hover .date .day {
				color: #fff;
				border-color: #fff;
			}
	.home-preview .news .list15 .content .right .list-item .date .year  {
				color: #333;
				width: auto;
				font-size: inherit;
				line-height: 40px;
			}
	.home-preview .news .list15 .content .right .list-item:hover .date .year {
				color: #fff;
			}
	
	.home-preview .news .list15 .content .right .list-item .info .name  {
				padding: 0 10px;
				margin: 0 0 10px;
				overflow: hidden;
				color: #333;
				white-space: nowrap;
				width: 100%;
				font-size: 16px;
				line-height: 1.5;
				text-overflow: ellipsis;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .name {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .desc  {
				padding: 0 10px;
				margin: 0 0 10px;
				overflow: hidden;
				color: #666;
				text-indent: 2em;
				width: 100%;
				font-size: inherit;
				line-height: 24px;
				height: 72px;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .desc {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .publisher .icon {
				margin: 0 2px 0 0;
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .publisher .icon {
			}
	.home-preview .news .list15 .content .right .list-item .info .publisher .text {
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .publisher .text {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .like .icon {
				margin: 0 2px 0 0;
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .like .icon {
			}
	.home-preview .news .list15 .content .right .list-item .info .like .text {
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .like .text {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .collect .icon {
				margin: 0 2px 0 0;
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .collect .icon {
			}
	.home-preview .news .list15 .content .right .list-item .info .collect .text {
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .collect .text {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .view .icon {
				margin: 0 2px 0 0;
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .view .icon {
			}
	.home-preview .news .list15 .content .right .list-item .info .view .text {
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .view .text {
			}






	.home-preview .recommend .list17 .item .image {
				border-radius: 8px;
				object-fit: cover;
				display: block;
				width: 100%;
				transition: 0.3s;
				height: 100%;
			}

	.home-preview .recommend .list17 .item:hover .image {
				transform: scale(1);
			}
	
	.home-preview .recommend .list17 .item .content {
				border-radius: 8px;
				padding: 10px;
				left: 0;
				bottom: -100%;
				background: rgba(0,0,0,.5);
				display: flex;
				width: 100%;
				position: absolute;
				transition: 0s;
				height: 60%;
			}
	
	.home-preview .recommend .list17 .item:hover .content {
				bottom: 0;
			}


</style>
