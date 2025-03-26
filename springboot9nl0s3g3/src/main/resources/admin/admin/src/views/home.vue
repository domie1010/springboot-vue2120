<template>
<div class="content" :style='{"minHeight":"100vh","padding":"10px 30px 30px","alignItems":"flex-start","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20240124/033cd0c06a2446d197fe6a33984ccd19.png) no-repeat center top / cover","display":"flex"}'>
	<!-- notice -->
	<!-- title -->
	<div class="text" :style='{"padding":"50px 0","margin":"10px 0","color":"rgb(51, 51, 51)","borderRadius":"5px","textAlign":"center","background":"#fff","width":"100%","fontSize":"26px","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
	

	<!-- 日历 -->
	<div class="calendar" :style='{"boxShadow":"0 0px 0px rgba(0,0,0,.1)","margin":"10px 0 10px 10px","borderRadius":"5px","background":"#fff","width":"calc(40% - 10px)","height":"auto","order":"1"}'>
	  <div :style='{"width":"100%","padding":"10px","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"auto"}'>
	    <div @click="pyear" :style='{"cursor":"pointer","padding":"0 0","alignItems":"center","color":"#8A8A8A","borderRadius":"4px","background":"transparent","display":"flex","width":"auto","fontSize":"14px","justifyContent":"center","height":"30px"}'><span class="icon iconfont icon-fanhui" :style='{"margin":"0 2px","fontSize":"16px","color":"#fff","display":"none"}'></span>上一年</div>
	    <div @click="pmonth" :style='{"cursor":"pointer","padding":"0","alignItems":"center","color":"#8A8A8A","borderRadius":"0","background":"transparent","display":"flex","width":"auto","fontSize":"14px","justifyContent":"center","height":"30px"}'><span class="icon iconfont icon-fanhui" :style='{"margin":"0 2px","fontSize":"16px","color":"#fff","display":"none"}'></span>上一月</div>
	    <div :style='{"padding":"0 10px","alignItems":"center","justifyContent":"center","display":"flex"}'>
	      <div :style='{"color":"#333","margin":"0 2px","fontSize":"16px"}'>{{this.year}}年</div>
	      <div :style='{"color":"#333","margin":"0 2px","fontSize":"16px"}'>{{this.month}}月</div>
	    </div>
	    <div @click="nmonth" :style='{"cursor":"pointer","padding":"0","alignItems":"center","color":"#8A8A8A","borderRadius":"0","background":"transparent","display":"flex","width":"auto","fontSize":"14px","justifyContent":"center","height":"30px"}'>下一月<span class="icon iconfont icon-jinru" :style='{"margin":"0 2px","fontSize":"16px","color":"#fff","display":"none"}'></span></div>
	    <div @click="nyear" :style='{"cursor":"pointer","padding":"0 ","alignItems":"center","color":"#8A8A8A","borderRadius":"0","background":"transparent","display":"flex","width":"auto","fontSize":"14px","justifyContent":"center","height":"30px"}'>下一年<span class="icon iconfont icon-jinru" :style='{"color":"#fff","margin":"0 2px","fontSize":"16px"}'></span></div>
	  </div>
	  <table :style='{"width":"100%","padding":"0 0 10px","heith":"auto","borderRadius":"12px","background":"#fff"}' v-if="this.weeks.length">
	    <thead :style='{"width":"100%","heith":"auto"}'>
	      <tr :style='{"width":"100%","heith":"auto","alignItems":"center","justifyContent":"center","display":"flex"}'>
	        <th :style='{"alignItems":"center","color":"#666","flex":1,"display":"flex","lineHeight":"40px","fontSize":"14px","justifyContent":"center"}' v-for="item,index in this.heads" :key="index">{{item}}</th>
	      </tr>
	    </thead>
	    <tbody :style='{"width":"100%","heith":"auto"}'>
	      <tr :style='{"width":"100%","heith":"auto","alignItems":"center","justifyContent":"center","display":"flex"}' v-for="week,index in this.weeks" :key="index">
	        <td :style='{"cursor":"pointer","padding":"6px 15px","flex":1,"display":"flex","height":"48px"}' v-for="day,key in week.days" :key="key" :class="{other: day.isOther, festival: day.isFestival, today: day.isToday, rest: day.isRest}">
	          <div class="text">
	            <div class="new">{{day.day}}</div>
	            <div class="old">{{day.text}}</div>
	          </div>
	        </td>
	      </tr>
	    </tbody>
	  </table>
	</div>
	
	<!-- echarts -->
</div>
</template>
<script>
//0
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
			// 日历
			year: 2023,
			month: 6,
			heads: ['一', '二', '三', '四', '五', '六', '日'],
			weeks: [],
			now: Solar.fromDate(new Date()),
		};
	},
	mounted(){
		this.init();
	},
	methods:{
		init(){
			if(this.$storage.get('Token')){
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code != 0) {
				router.push({ name: 'login' })
				}
			});
			}else{
				router.push({ name: 'login' })
			}
			this.$nextTick(() => {
				// --- 日历 ---
				this.year = this.now.getYear()
				this.month = this.now.getMonth()
				this.weeks = this.render(this.year, this.month);
			})
		},
		// 日历
		nyear() {
			this.year = this.year + 1
			this.weeks = this.render(this.year, this.month)
		},
		pyear() {
			this.year = this.year - 1
			this.weeks = this.render(this.year, this.month)
		},
		nmonth() {
			this.month = this.month + 1
			if (this.month > 12) {
				this.month = 1
				this.year = this.year + 1
			}
			this.weeks = this.render(this.year, this.month)
		},
		pmonth() {
			this.month = this.month - 1
			if (this.month < 1) {
				this.month = 12
				this.year = this.year - 1
			}
			this.weeks = this.render(this.year, this.month)
		},
		// 日历
		render(year, month, weekStart = 1) {
			let months = SolarMonth.fromYm(year, month)
			let weeks = []
		
			months.getWeeks(weekStart).forEach(w => {
				let week = {
					index: 0,
					days: []
				}
				week.index = w.getIndexInYear()
				let days = []
				w.getDays().forEach(d => {
					days.push(this.buildDay(d, month))
				})
				week.days = days
				weeks.push(week)
			})
			return weeks
		},
		buildDay(d, month) {
			let lunar = d.getLunar()
			let day = {
				day: 0,
				text: '',
				isFestival: false,
				isToday: false,
				isOther: false,
				isHoliday: false,
				isRest: false
			}
			day.day = d.getDay()
			let text = lunar.getDayInChinese()
			if (1 === d.getDay()) {
				text = lunar.getMonthInChinese() + '月'
			}
			// let otherFestivals = d.getOtherFestivals()
			// if (otherFestivals.length > 0) {
			// 	text = otherFestivals[0]
			// 	day.isFestival = true
			// }
			// otherFestivals = lunar.getOtherFestivals()
			// if (otherFestivals.length > 0) {
			// 	text = otherFestivals[0]
			// 	day.isFestival = true
			// }
			let festivals = d.getFestivals()
			if (festivals.length > 0) {
				text = festivals[0]
				day.isFestival = true
			}
			festivals = lunar.getFestivals()
			if (festivals.length > 0) {
				text = festivals[0]
				day.isFestival = true
			}
			let jq = lunar.getJieQi()
			if (jq) {
				text = jq
				day.isFestival = true
			}
			day.text = text
			if (d.toYmd() === this.now.toYmd()) {
				day.isToday = true
			}
			if (d.getMonth() !== month) {
				day.isOther = true
			}
			let h = HolidayUtil.getHoliday(d.getYear(), d.getMonth(), d.getDay())
			if (h) {
				day.isHoliday = true
				day.isRest = !h.isWork()
			}
			return day
		},
		// 日历
  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
	
	// 日历
	.calendar td .text {
				border-radius: 12px;
				flex-direction: column;
				background: #fff;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td .text:hover {
				background: rgba(78,110,242,.1);
			}
	.calendar td .text .new {
				color: #000;
				font-size: 18px;
				line-height: 1.4;
			}
	.calendar td .text .old {
				color: #666;
				display: none;
				font-size: 16px;
				line-height: 1.4;
			}
	.calendar td.festival .text {
				border-radius: 12px;
				flex-direction: column;
				background: transparent;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td.festival .text:hover {
				background: rgba(78,110,242,.1);
			}
	.calendar td.festival .text .new {
				color: #000;
				font-size: 18px;
				line-height: 1.4;
			}
	.calendar td.festival .text .old {
				color: #666;
				display: none;
				font-size: 16px;
				line-height: 1.4;
			}
	.calendar td.other .text {
				border-radius: 12px;
				flex-direction: column;
				background: #fff;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				opacity: 0.3;
				height: 100%;
			}
	.calendar td.other .text:hover {
				background: rgba(78,110,242,.1);
			}
	.calendar td.other .text .new {
				color: #000;
				font-size: 18px;
				line-height: 1.4;
			}
	.calendar td.other .text .old {
				color: #666;
				display: none;
				font-size: 16px;
				line-height: 1.4;
			}
	.calendar td.today .text {
				border-radius: 12px;
				flex-direction: column;
				color: #fff;
				background: rgb(64, 158, 255);
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td.today .text:hover {
				background: rgba(64, 158, 255,.5);
			}
	.calendar td.today .text .new {
				color: inherit;
				font-size: 18px;
				line-height: 1.4;
			}
	.calendar td.today .text .old {
				color: inherit;
				display: none;
				font-size: 16px;
				line-height: 1.4;
			}
	
	// echarts1
	.type1 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0px 0;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type1 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	// echarts2
	.type2 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 10px 0 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type2 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type2 .echarts2 {
				border-radius: 5px;
				padding: 20px;
				margin: 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type2 .echarts2:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	// echarts3
	.type3 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type3 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type3 .echarts2 {
				border-radius: 5px;
				padding: 20px;
				margin: 10px 10px 0 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type3 .echarts2:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type3 .echarts3 {
				border-radius: 5px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type3 .echarts3:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	// echarts4
	.type4 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type4 .echarts2 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts2:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type4 .echarts3 {
				border-radius: 5px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts3:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type4 .echarts4 {
				border-radius: 5px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts4:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	// echarts5
	.type5 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0 10px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type5 .echarts2 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0 10px;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts2:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type5 .echarts3 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0 10px;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts3:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type5 .echarts4 {
				border-radius: 5px;
				padding: 20px;
				margin: 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts4:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type5 .echarts5 {
				border-radius: 5px;
				padding: 20px;
				margin: 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts5:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	
	.echarts-flag-2 {
	  display: flex;
	  flex-wrap: wrap;
	  justify-content: space-between;
	  padding: 10px 20px;
	  background: rebeccapurple;
	
	  &>div {
	    width: 32%;
	    height: 300px;
	    margin: 10px 0;
	    background: rgba(255,255,255,.1);
	    border-radius: 8px;
	    padding: 10px 20px;
	  }
	}
</style>
