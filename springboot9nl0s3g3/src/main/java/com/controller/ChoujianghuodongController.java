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

import com.entity.ChoujianghuodongEntity;
import com.entity.view.ChoujianghuodongView;

import com.service.ChoujianghuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 抽奖活动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
@RestController
@RequestMapping("/choujianghuodong")
public class ChoujianghuodongController {
    @Autowired
    private ChoujianghuodongService choujianghuodongService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChoujianghuodongEntity choujianghuodong,
		HttpServletRequest request){
        EntityWrapper<ChoujianghuodongEntity> ew = new EntityWrapper<ChoujianghuodongEntity>();

		PageUtils page = choujianghuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, choujianghuodong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChoujianghuodongEntity choujianghuodong, 
		HttpServletRequest request){
        EntityWrapper<ChoujianghuodongEntity> ew = new EntityWrapper<ChoujianghuodongEntity>();

		PageUtils page = choujianghuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, choujianghuodong), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChoujianghuodongEntity choujianghuodong){
       	EntityWrapper<ChoujianghuodongEntity> ew = new EntityWrapper<ChoujianghuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( choujianghuodong, "choujianghuodong")); 
        return R.ok().put("data", choujianghuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChoujianghuodongEntity choujianghuodong){
        EntityWrapper< ChoujianghuodongEntity> ew = new EntityWrapper< ChoujianghuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( choujianghuodong, "choujianghuodong")); 
		ChoujianghuodongView choujianghuodongView =  choujianghuodongService.selectView(ew);
		return R.ok("查询抽奖活动成功").put("data", choujianghuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChoujianghuodongEntity choujianghuodong = choujianghuodongService.selectById(id);
        return R.ok().put("data", choujianghuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChoujianghuodongEntity choujianghuodong = choujianghuodongService.selectById(id);
        return R.ok().put("data", choujianghuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChoujianghuodongEntity choujianghuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(choujianghuodong);
        choujianghuodongService.insert(choujianghuodong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChoujianghuodongEntity choujianghuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(choujianghuodong);
        choujianghuodongService.insert(choujianghuodong);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChoujianghuodongEntity choujianghuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(choujianghuodong);
        choujianghuodongService.updateById(choujianghuodong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        choujianghuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
