<template>
  <div :style='{"width":"100%","padding":"30px 10% 40px","margin":"0px auto","position":"relative","background":"none"}'>
    <div class="section-title" :style='{"padding":"30px 0 0","margin":"40px auto","color":"#000","textAlign":"center","background":"url(http://codegen.caihongy.cn/20240303/4a00266e357e47d5856d30e525467334.png) no-repeat center center / 100% 100%","width":"100%","fontSize":"24px","fontWeight":"600","height":"92px"}'>确认{{totalPrice>0?'下单':'预订'}}</div>
    <el-descriptions v-if="seat!=1" title="选择收货地址"></el-descriptions>
    <el-table v-if="seat!=1"
      :data="addressList"
      style="width: 100%;padding: 0 10px;">
      <el-table-column
        label="选择"
        width="55">
        <template slot-scope="scope">
          <el-radio
            v-model="radio"
            :label="scope.$index"
            @change.native="getCurrentRow(scope.$index)">
            &nbsp;</el-radio>
        </template>
      </el-table-column>
      <el-table-column
        label="收件人"
        prop="name">
      </el-table-column>
      <el-table-column
        label="联系方式"
        prop="phone">
      </el-table-column>
      <el-table-column
        label="地址"
        prop="address">
      </el-table-column>
    </el-table>
	<div style="width:100%;display:flex;align-items:center;justify-content:center;margin:10px 0">
		<el-button type="success" @click="addAddress">添加收货地址</el-button>
	</div>
    <el-descriptions title="清单列表"></el-descriptions>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        label="商品名称">
        <template slot-scope="scope">
          <div class="shangpin">
            <el-image
              style="width: 100px; height: 100px;flex: 1"
              :src="baseUrl + scope.row.picture"
              fit="fill"></el-image>
            <span style="margin-left: 10px;flex: 1">{{ scope.row.goodname }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column v-if="totalPrice>0"
        label="价格">
        <template slot-scope="scope">
          <span v-if="type == 2">{{ scope.row.price }} 积分</span>
          <span v-else><span :style='{"fontSize":"12px"}'>￥</span>{{ scope.row.price }}</span>
        </template>
      </el-table-column>
      <el-table-column v-if="seat==1"
        label="座位">
        <template slot-scope="scope">
          <span>{{ scope.row.activeSeat }}</span>
        </template>
      </el-table-column>
      <el-table-column v-if="seat!=1"
        label="数量">
        <template slot-scope="scope">
          <span>{{ scope.row.buynumber }}</span>
        </template>
      </el-table-column>
      <el-table-column v-if="totalPrice>0"
        label="总价">
        <template slot-scope="scope">
          <span v-if="type == 2">{{ scope.row.price * scope.row.buynumber }} 积分</span>
          <span v-else><span :style='{"fontSize":"12px"}'>￥</span>{{ changePrice(scope.row) }}</span>
        </template>
      </el-table-column>
    </el-table>
	<div style="width: 100%;padding: 12px;box-sizing: border-box;display: flex;align-items: center;" v-if="type!=2">
	    <span style="width: 80px; font-size: 14px;">优惠券：</span>
		<el-button v-if="!nowCoupon.id" @click="changeCoupon">选择优惠券</el-button>
		<el-button v-if="nowCoupon.id" type="success" @click="changeCoupon">满{{nowCoupon.fullamount}}减{{nowCoupon.discountamount}}</el-button>
	</div>
    <div style="width: 100%;padding: 12px;box-sizing: border-box;display: flex;align-items: center;">
        <span style="width: 80px; font-size: 14px;">备注：</span><el-input type="textarea" v-model="remark" placeholder="备注" style="width: calc(100% - 80px);"></el-input>
    </div>
    <div class="buy" v-if="seat!=1 && tableData.length > 0">
      <template v-if="type == 2">
        <span style="color: red;margin-right: 10px;font-weight: 700;">总价：{{totalPrice}} 积分</span>
        <el-button type="warning" @click="jfClick">兑换</el-button>
      </template>
      <template v-else>
        <span style="color: red;margin-right: 10px;font-weight: 700;">总价：<span :style='{"fontSize":"12px"}'>￥</span>{{totalPrice}}</span>
        <el-button type="success" @click="payClick">支付</el-button>
      </template>
    </div>
    <div class="buy" v-if="seat==1 && tableData.length > 0">
      <template v-if="type == 2">
        <span style="color: red;margin-right: 10px;font-weight: 700;">总价：{{totalPrice}} 积分</span>
        <el-button type="success" @click="xzJfClick">兑换</el-button>
      </template>
      <template v-else>
        <span style="color: red;margin-right: 10px;font-weight: 700;" v-if="totalPrice>0">总价：<span :style='{"fontSize":"12px"}'>￥</span>{{totalPrice}}</span>
        <el-button type="success" @click="xzPayClick">{{totalPrice>0?'支付':'预订'}}</el-button>
      </template>
    </div>
		<el-dialog
		  title="优惠券"
		  :visible.sync="couponVisible"
		  width="85%">
		  <div class="coupon_list">
		  	<div class="coupon" v-for="(item,index) in couponList" :key="index" :class="!changeStatus(item)?'coupons':''">
		  		<div class="coupon_left">
		  			<div class="name">{{item.name}}</div>
		  			<div class="name">满{{item.fullamount}}减{{item.discountamount}}</div>
		  			<div class="date">{{item.startime}}-{{item.endtime}}</div>
					<div class="date">{{item.remark}}</div>
		  		</div>
		  		<div class="coupon_right">
		  			<div class="price">￥<span class="num">{{item.discountamount}}</span></div>
		  			<div class="btn" @click="takeCoupon(item)" v-if="item.status=='可使用'">
		  				{{changeStatus(item)?'立即使用':'不满条件'}}</div>
		  		</div>
		  		<img v-if="item.status=='已过期'" class="no-coupon" src="@/assets/no-coupon.png" alt="">
		  		<img v-if="item.status=='已使用'" class="no-coupon" src="@/assets/finish-coupon.png" alt="">
		  	</div>
		  	<div class="noList" v-if="!couponList.length">
		  		暂无优惠券
		  	</div>
		  	<div v-if="nowCoupon.id">
		  		<el-button @click="clearCoupon" size='mini'>不使用优惠券</el-button>
		  	</div>
		  </div>
		</el-dialog>
  </div>
</template>

<script>
import config from '@/config/config'
export default {
    data() {
		return {
			baseUrl: config.baseUrl,
			userTableName: localStorage.getItem('UserTableName'),
			addressList: [],
			tableData: [],
			currentRow: null,
			radio: -1,
			order: {
				address: "",
				buynumber: 0,
				consignee: '',
				discountprice: 0,
				discounttotal: 0,
				goodid: 0,
				goodname: "",
				orderid: "",
				picture: "",
				price: 0,
				status: "未支付",
				tablename: "",
				tel: "",
				total: 0,
				type: 1,
				userid: localStorage.getItem('frontUserid')
			},
			user: {},
			type: 0,
			seat: 0,
			buynumber: 0,
			remark:'',
			couponVisible:false,
			nowCoupon:{
				
			},
			couponList: [],
			orderIdList: {},
		}
    },
    created() {
		if(this.$route.query.type != undefined) {
			this.type = this.$route.query.type;
		}
		if(this.$route.query.seat != undefined) {
			this.seat = this.$route.query.seat;
		}
		if(this.$route.query.tablename != undefined) {
			this.order.tablename = this.$route.query.tablename;
		}
		this.getSession();
		this.getAddrList();
		// 获取商品购买的清单列表
		var orderGoods = localStorage.getItem('orderGoods')
		// 转换成json类型，localstorage保存的是string数据
		this.tableData = JSON.parse(orderGoods);
		this.type = this.$route.query.type;
    },
    methods: {
		changePrice(row){
			let price = row.price * row.buynumber
			let discountamount = 0
			let totalPrice = 0
			this.tableData.forEach(item => {
				totalPrice += item.price * item.buynumber;
			})
			if(this.nowCoupon.id){
				discountamount = Number(((Number(price.toFixed(2)) / Number(totalPrice.toFixed(2))) * this.nowCoupon.discountamount).toFixed(2))
			}
			price = price - discountamount
			row.total = (price).toFixed(2)
			return (price).toFixed(2)
		},
		clearCoupon(){
			this.nowCoupon = {}
			this.$forceUpdate()
		},
		changeStatus(row) {
			let total = JSON.parse(JSON.stringify(this.totalPrice))
			if(this.nowCoupon.id){
				total = Number(total) + Number(this.nowCoupon.discountamount)
			}
			
			if (row.fullamount <= total) {
				if (row.status=='可使用') {
					return true
				}
			}
			return false
		},
		takeCoupon(row){
			if (!this.changeStatus(row)) {
				return false
			}
			this.nowCoupon = row
			this.couponVisible = false
		},
		changeCoupon(){
			this.couponVisible = true
			this.getMyList()
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
		getSession() {
			if(!this.userTableName){
				this.$router.push('/login');
				return false
			}
			this.$http.get(`${this.userTableName}/session`, {emulateJSON: true}).then(res => {
				if (res.data.code == 0) {
					this.user = res.data.data;
				}
			});
		},
		getCurrentRow(index) {
			this.radio = index;　
		},
		getAddrList() {
			this.$http.get('address/list', {params: {userid: localStorage.getItem('frontUserid')}}).then(res => {
				if (res.data.code == 0) {
					this.addressList = res.data.data.list;
					this.addressList.forEach((item, index) => {
						if (item.isdefault == '是') {
							this.radio = index;
						}
					});
				}
			});
		},
		addAddress(){
			this.$router.push('/index/shop-address/addOrUpdate');
		},
		getCartList() {
			this.$http.get('cart/list', {params: {page: 1, limit: 1000, userid: localStorage.getItem('frontUserid')}}).then(res => {
				if (res.data.code == 0) {
					this.tableData = res.data.data.list;
					if (this.$route.query.id != undefined || this.$route.query.type != undefined) {
						this.tableData = [];
						this.buynumber = this.$route.query.buynumber;
						let detailObj = JSON.parse(this.$route.query.detailObj);
						this.order.tablename = this.$route.query.tablename;
						if (this.$route.query.type == 1) {
							this.tableData.push({
								buynumber: this.buynumber,
								goodid: detailObj.id,
								picture: this.$route.query.picture,
								goodname: this.$route.query.goodname,
								goodtype: this.$route.query.goodtype,
								tablename: this.$route.query.tablename,
								userid: localStorage.getItem('frontUserid'),
								price: this.$route.query.price
							});
						}
						if (this.$route.query.type == 2) {
							this.tableData.push({
								buynumber: this.buynumber,
								goodid: detailObj.id,
								picture: this.$route.query.picture,
								goodname: this.$route.query.goodname,
								tablename: this.$route.query.tablename,
								userid: localStorage.getItem('frontUserid'),
								jf: detailObj.jf
							});
						}
					}
				}
			});
		},
		handleChange(value, index, goodid) {
			this.$http.get(`${this.order.tablename}/detail/${goodid}`).then(res => {
				if (res.data.code == 0 && value > res.data.data.onelimittimes) {
					this.tableData[index].buynumber = --value;
					this.$message.error(`每人单次只能购买${res.data.data.onelimittimes}件`);
				}
			});
		},
        // 正常下单，生成订单，减少余额，添加积分，减少库存，修改状态已支付
         payClick() {
			let that = this
            if (this.radio == -1) {
				this.$message({
					message: '请选择收货地址',
					type: 'error',
					duration: 1500
				});
				return;
            }
			var orderno = this.createOrder() + 1
            // 生成订单
            for(let index in this.tableData){
				let item = this.tableData[index]
				setTimeout(()=>{
					
                // 获取商品详情信息
                 this.$http.get(`${item.tablename}/info/${item.goodid}`).then( res => {
                    // 订单编号
                    this.orderIdList['orderId' + Number(index)] = String(this.createOrder())
                    let data = res.data.data;
                    data.alllimittimes = data.alllimittimes - item.buynumber;
                    // 更新库存信息
                     this.$http.post(`${item.tablename}/update`, data).then( res => {
                        // 添加订单信息
                        let order = {
                            orderid: this.orderIdList['orderId' + Number(index)],
                            tablename: item.tablename,
                            userid: this.user.id,
                            goodid: item.goodid,
                            goodname: item.goodname,
                            goodtype: item.goodtype,
                            picture: item.picture,
                            buynumber: item.buynumber,
                            discountprice: item.price,
                            price: item.price,
                            total: Number(item.total),
                            discounttotal: Number(item.total),
                            type: this.type?Number(this.type):1,
                            //total: this.totalPrice,
                            address: this.addressList[this.radio].address,
                            tel: this.addressList[this.radio].phone,
                            consignee: this.addressList[this.radio].name,
                            remark: this.remark,
                            status: '未支付',
							sfsh: '',
							role: this.userTableName,
							orderno: orderno,
                        }
						if (this.nowCoupon.id) {
							order.couponnumber = this.nowCoupon.couponnumber
							order.discountamount = this.nowCoupon.discountamount
							this.nowCoupon.status = '已使用'
							this.$http.post(`mycoupon/update`, this.nowCoupon)
						}
						this.$http.post('orders/add', order).then( res => {
                            // 减少余额，更新订单状态
                            // 判断余额是否充足
                            if (Number(this.user.money) < Number(item.total)) {
                                this.$message({
                                    message: '余额不足，请先充值',
                                    type: 'error',
                                    duration: 1500,
								onClose(){
									that.$router.push('/index/center')
								}
                                });
                                return
                            }
                            // 如果该商品存在积分
                            if (data.jf) {
                                this.user.jf = Number((Number(this.user.jf) + Number(item.total)).toFixed(2))
                            }
                            this.user.money = Number((Number(this.user.money) - Number(item.total)).toFixed(2))
                            // 更新用户余额
                            this.$http.post(`${this.userTableName}/update`, this.user).then(res => {
								localStorage.setItem('sessionForm',JSON.stringify(this.user))
                                order.status = '已支付'
                                var params = {
                                    orderid: this.orderIdList['orderId' + Number(index)],
                                    page: 1,
                                    limit: 1,
                                }
                                this.$http.get('orders/list', {params: params}).then(res => {
                                    order.id = res.data.data.list[0].id;
                                    this.$http.post(`orders/update`, order).then(res => {
                                        // 删除购物车数据(如果是购物车下单)
                                        if (item.id) {
                                            this.$http.post('cart/delete', [item.id]).then(res => {});
                                        }
                                        this.$message({
											message: '购买成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
                                                this.$router.push('/index/shop-order/order');
											}
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
				},500)
            }
        },
        // 积分兑换，生成订单，减少用户积分，减少库存
        jfClick() {
            if (this.radio == -1) {
				this.$message({
					message: '请选择收货地址',
					type: 'error',
					duration: 1500
				});
				return;
            }

            // 生成订单
            for(let index in this.tableData){
				let item = this.tableData[index]
				setTimeout(()=>{
					
                // 订单编号
                this.orderIdList['orderId' + Number(index)] = String(this.createOrder())
                 this.$http.get(`${item.tablename}/info/${item.goodid}`).then( res => {
                    let data = res.data.data;
                    // 减少库存
                    data.alllimittimes = data.alllimittimes - item.buynumber;
                    // 更新库存信息
                     this.$http.post(`${item.tablename}/update`, data).then( res => {
                        // 判断积分是否充足
                        if (this.user.jf < this.totalPrice) {
                            this.$message({
                                message: '积分不足，兑换失败',
                                type: 'error',
                                duration: 1500
                            });
                            return
                        }
                        // 添加订单信息
                        let order = {
                            orderid: this.orderIdList['orderId' + Number(index)],
                            tablename: item.tablename,
                            userid: this.user.id,
                            goodid: item.goodid,
                            goodname: item.goodname,
                            goodtype: item.goodtype,
                            picture: item.picture,
                            buynumber: item.buynumber,
                            discountprice: item.price,
                            price: item.price,
                            total: Number((item.price * item.buynumber).toFixed(2)),
                            discounttotal: Number((item.price * item.buynumber).toFixed(2)),
                            type: 2,
                            total: this.totalPrice,
                            address: this.addressList[this.radio].address,
                            tel: this.addressList[this.radio].phone,
                            consignee: this.addressList[this.radio].name,
                            status: '已支付',
							sfsh: '',
							role: this.userTableName,
                        }
                         this.$http.post('orders/add', order).then( res => {
                            this.user.jf = Number((Number(this.user.jf) - Number(item.price * item.buynumber)).toFixed(2))
                            // 更新用户余额
                             this.$http.post(`${this.userTableName}/update`, this.user).then( res => {
								localStorage.setItem('sessionForm',JSON.stringify(this.user))
                                this.$message({
                                    message: '兑换成功',
                                    type: 'success',
                                    duration: 1500,
                                    onClose: () => {
                                        this.$router.push('/index/shop-order/order');
                                    }
                                });
                            });
                        });
                    });
                });
				},500)
            };
        },
		createOrder() {
			let order = '';
			let now = new Date();
			order += now.getFullYear();
			order += now.getMonth() + 1;
			order += now.getDate();
			order += now.getHours();
			order += now.getMinutes();
			order += now.getSeconds();
			order += now.getMilliseconds();

			return order;
		}
    },
    computed: {
		totalPrice() {
			let totalPrice = 0;
			this.tableData.forEach(item => {
				totalPrice += item.price * item.buynumber;
			});
			if(this.nowCoupon.id){
				totalPrice = totalPrice - this.nowCoupon.discountamount
			}
			if(totalPrice<0){
				totalPrice = 0
			}
			return totalPrice.toFixed(2);
		},
		totalJifen() {
			let totalJifen = 0;
			this.tableData.forEach(item => {
				totalJifen += parseInt(item.jf * this.buynumber);
			});

			return totalJifen;
		}
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .section {
    width: 900px;
    margin: 0 auto;
  }

  .shangpin {
    display: flex;
  }
  .buy {
    text-align: right;
    padding-right: 82px;
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
