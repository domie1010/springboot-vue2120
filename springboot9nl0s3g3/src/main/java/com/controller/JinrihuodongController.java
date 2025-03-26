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

import com.entity.JinrihuodongEntity;
import com.entity.view.JinrihuodongView;

import com.service.JinrihuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 今日活动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
@RestController
@RequestMapping("/jinrihuodong")
public class JinrihuodongController {
    @Autowired
    private JinrihuodongService jinrihuodongService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JinrihuodongEntity jinrihuodong,
		HttpServletRequest request){
        EntityWrapper<JinrihuodongEntity> ew = new EntityWrapper<JinrihuodongEntity>();

		PageUtils page = jinrihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinrihuodong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JinrihuodongEntity jinrihuodong, 
		HttpServletRequest request){
        EntityWrapper<JinrihuodongEntity> ew = new EntityWrapper<JinrihuodongEntity>();

		PageUtils page = jinrihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinrihuodong), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JinrihuodongEntity jinrihuodong){
       	EntityWrapper<JinrihuodongEntity> ew = new EntityWrapper<JinrihuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jinrihuodong, "jinrihuodong")); 
        return R.ok().put("data", jinrihuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JinrihuodongEntity jinrihuodong){
        EntityWrapper< JinrihuodongEntity> ew = new EntityWrapper< JinrihuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jinrihuodong, "jinrihuodong")); 
		JinrihuodongView jinrihuodongView =  jinrihuodongService.selectView(ew);
		return R.ok("查询今日活动成功").put("data", jinrihuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JinrihuodongEntity jinrihuodong = jinrihuodongService.selectById(id);
        return R.ok().put("data", jinrihuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JinrihuodongEntity jinrihuodong = jinrihuodongService.selectById(id);
        return R.ok().put("data", jinrihuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JinrihuodongEntity jinrihuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jinrihuodong);
        jinrihuodongService.insert(jinrihuodong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JinrihuodongEntity jinrihuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jinrihuodong);
        jinrihuodongService.insert(jinrihuodong);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JinrihuodongEntity jinrihuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jinrihuodong);
        jinrihuodongService.updateById(jinrihuodong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jinrihuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
