package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MycouponEntity;
import com.entity.view.MycouponView;

import com.service.MycouponService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 我的优惠券
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
@RestController
@RequestMapping("/mycoupon")
public class MycouponController {
    @Autowired
    private MycouponService mycouponService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MycouponEntity mycoupon,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            mycoupon.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<MycouponEntity> ew = new EntityWrapper<MycouponEntity>();

		PageUtils page = mycouponService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mycoupon), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MycouponEntity mycoupon, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		mycoupon.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<MycouponEntity> ew = new EntityWrapper<MycouponEntity>();

		PageUtils page = mycouponService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mycoupon), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MycouponEntity mycoupon){
       	EntityWrapper<MycouponEntity> ew = new EntityWrapper<MycouponEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mycoupon, "mycoupon")); 
        return R.ok().put("data", mycouponService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MycouponEntity mycoupon){
        EntityWrapper< MycouponEntity> ew = new EntityWrapper< MycouponEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mycoupon, "mycoupon")); 
		MycouponView mycouponView =  mycouponService.selectView(ew);
		return R.ok("查询我的优惠券成功").put("data", mycouponView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MycouponEntity mycoupon = mycouponService.selectById(id);
        return R.ok().put("data", mycoupon);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MycouponEntity mycoupon = mycouponService.selectById(id);
        return R.ok().put("data", mycoupon);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MycouponEntity mycoupon, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mycoupon);
    	mycoupon.setUserid((Long)request.getSession().getAttribute("userId"));
        mycouponService.insert(mycoupon);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MycouponEntity mycoupon, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mycoupon);
    	mycoupon.setUserid((Long)request.getSession().getAttribute("userId"));
        mycouponService.insert(mycoupon);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        MycouponEntity mycoupon = mycouponService.selectOne(new EntityWrapper<MycouponEntity>().eq("", username));
        return R.ok().put("data", mycoupon);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody MycouponEntity mycoupon, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mycoupon);
        mycouponService.updateById(mycoupon);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mycouponService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MycouponEntity mycoupon, HttpServletRequest request,String pre){
        EntityWrapper<MycouponEntity> ew = new EntityWrapper<MycouponEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = mycouponService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mycoupon), params), params));
        return R.ok().put("data", page);
    }










}
