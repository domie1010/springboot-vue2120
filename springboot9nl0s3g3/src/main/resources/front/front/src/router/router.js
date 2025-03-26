import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import shangpinfenleiList from '../pages/shangpinfenlei/list'
import shangpinfenleiDetail from '../pages/shangpinfenlei/detail'
import shangpinfenleiAdd from '../pages/shangpinfenlei/add'
import shangpinxinxiList from '../pages/shangpinxinxi/list'
import shangpinxinxiDetail from '../pages/shangpinxinxi/detail'
import shangpinxinxiAdd from '../pages/shangpinxinxi/add'
import jifenshangpinList from '../pages/jifenshangpin/list'
import jifenshangpinDetail from '../pages/jifenshangpin/detail'
import jifenshangpinAdd from '../pages/jifenshangpin/add'
import choujianghuodongList from '../pages/choujianghuodong/list'
import choujianghuodongDetail from '../pages/choujianghuodong/detail'
import choujianghuodongAdd from '../pages/choujianghuodong/add'
import choujiangjiluList from '../pages/choujiangjilu/list'
import choujiangjiluDetail from '../pages/choujiangjilu/detail'
import choujiangjiluAdd from '../pages/choujiangjilu/add'
import jinrihuodongList from '../pages/jinrihuodong/list'
import jinrihuodongDetail from '../pages/jinrihuodong/detail'
import jinrihuodongAdd from '../pages/jinrihuodong/add'
import couponList from '../pages/coupon/list'
import couponDetail from '../pages/coupon/detail'
import couponAdd from '../pages/coupon/add'
import mycouponList from '../pages/mycoupon/list'
import mycouponDetail from '../pages/mycoupon/detail'
import mycouponAdd from '../pages/mycoupon/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discussshangpinxinxiList from '../pages/discussshangpinxinxi/list'
import discussshangpinxinxiDetail from '../pages/discussshangpinxinxi/detail'
import discussshangpinxinxiAdd from '../pages/discussshangpinxinxi/add'
import discussjifenshangpinList from '../pages/discussjifenshangpin/list'
import discussjifenshangpinDetail from '../pages/discussjifenshangpin/detail'
import discussjifenshangpinAdd from '../pages/discussjifenshangpin/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'shangpinfenlei',
					component: shangpinfenleiList
				},
				{
					path: 'shangpinfenleiDetail',
					component: shangpinfenleiDetail
				},
				{
					path: 'shangpinfenleiAdd',
					component: shangpinfenleiAdd
				},
				{
					path: 'shangpinxinxi',
					component: shangpinxinxiList
				},
				{
					path: 'shangpinxinxiDetail',
					component: shangpinxinxiDetail
				},
				{
					path: 'shangpinxinxiAdd',
					component: shangpinxinxiAdd
				},
				{
					path: 'jifenshangpin',
					component: jifenshangpinList
				},
				{
					path: 'jifenshangpinDetail',
					component: jifenshangpinDetail
				},
				{
					path: 'jifenshangpinAdd',
					component: jifenshangpinAdd
				},
				{
					path: 'choujianghuodong',
					component: choujianghuodongList
				},
				{
					path: 'choujianghuodongDetail',
					component: choujianghuodongDetail
				},
				{
					path: 'choujianghuodongAdd',
					component: choujianghuodongAdd
				},
				{
					path: 'choujiangjilu',
					component: choujiangjiluList
				},
				{
					path: 'choujiangjiluDetail',
					component: choujiangjiluDetail
				},
				{
					path: 'choujiangjiluAdd',
					component: choujiangjiluAdd
				},
				{
					path: 'jinrihuodong',
					component: jinrihuodongList
				},
				{
					path: 'jinrihuodongDetail',
					component: jinrihuodongDetail
				},
				{
					path: 'jinrihuodongAdd',
					component: jinrihuodongAdd
				},
				{
					path: 'coupon',
					component: couponList
				},
				{
					path: 'couponDetail',
					component: couponDetail
				},
				{
					path: 'couponAdd',
					component: couponAdd
				},
				{
					path: 'mycoupon',
					component: mycouponList
				},
				{
					path: 'mycouponDetail',
					component: mycouponDetail
				},
				{
					path: 'mycouponAdd',
					component: mycouponAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discussshangpinxinxi',
					component: discussshangpinxinxiList
				},
				{
					path: 'discussshangpinxinxiDetail',
					component: discussshangpinxinxiDetail
				},
				{
					path: 'discussshangpinxinxiAdd',
					component: discussshangpinxinxiAdd
				},
				{
					path: 'discussjifenshangpin',
					component: discussjifenshangpinList
				},
				{
					path: 'discussjifenshangpinDetail',
					component: discussjifenshangpinDetail
				},
				{
					path: 'discussjifenshangpinAdd',
					component: discussjifenshangpinAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
