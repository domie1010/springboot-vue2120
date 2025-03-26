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

import com.entity.ChoujiangjiluEntity;
import com.entity.view.ChoujiangjiluView;

import com.service.ChoujiangjiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 抽奖记录
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
@RestController
@RequestMapping("/choujiangjilu")
public class ChoujiangjiluController {
    @Autowired
    private ChoujiangjiluService choujiangjiluService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChoujiangjiluEntity choujiangjilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			choujiangjilu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChoujiangjiluEntity> ew = new EntityWrapper<ChoujiangjiluEntity>();

		PageUtils page = choujiangjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, choujiangjilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChoujiangjiluEntity choujiangjilu, 
		HttpServletRequest request){
        EntityWrapper<ChoujiangjiluEntity> ew = new EntityWrapper<ChoujiangjiluEntity>();

		PageUtils page = choujiangjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, choujiangjilu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChoujiangjiluEntity choujiangjilu){
       	EntityWrapper<ChoujiangjiluEntity> ew = new EntityWrapper<ChoujiangjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( choujiangjilu, "choujiangjilu")); 
        return R.ok().put("data", choujiangjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChoujiangjiluEntity choujiangjilu){
        EntityWrapper< ChoujiangjiluEntity> ew = new EntityWrapper< ChoujiangjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( choujiangjilu, "choujiangjilu")); 
		ChoujiangjiluView choujiangjiluView =  choujiangjiluService.selectView(ew);
		return R.ok("查询抽奖记录成功").put("data", choujiangjiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChoujiangjiluEntity choujiangjilu = choujiangjiluService.selectById(id);
        return R.ok().put("data", choujiangjilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChoujiangjiluEntity choujiangjilu = choujiangjiluService.selectById(id);
        return R.ok().put("data", choujiangjilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChoujiangjiluEntity choujiangjilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(choujiangjilu);
        choujiangjiluService.insert(choujiangjilu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChoujiangjiluEntity choujiangjilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(choujiangjilu);
        choujiangjiluService.insert(choujiangjilu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChoujiangjiluEntity choujiangjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(choujiangjilu);
        choujiangjiluService.updateById(choujiangjilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        choujiangjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
