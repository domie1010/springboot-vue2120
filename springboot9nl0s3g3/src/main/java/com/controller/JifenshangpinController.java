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

import com.entity.JifenshangpinEntity;
import com.entity.view.JifenshangpinView;

import com.service.JifenshangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 积分商品
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
@RestController
@RequestMapping("/jifenshangpin")
public class JifenshangpinController {
    @Autowired
    private JifenshangpinService jifenshangpinService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JifenshangpinEntity jifenshangpin,
		HttpServletRequest request){
        EntityWrapper<JifenshangpinEntity> ew = new EntityWrapper<JifenshangpinEntity>();

		PageUtils page = jifenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenshangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JifenshangpinEntity jifenshangpin, 
		HttpServletRequest request){
        EntityWrapper<JifenshangpinEntity> ew = new EntityWrapper<JifenshangpinEntity>();

		PageUtils page = jifenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenshangpin), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JifenshangpinEntity jifenshangpin){
       	EntityWrapper<JifenshangpinEntity> ew = new EntityWrapper<JifenshangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jifenshangpin, "jifenshangpin")); 
        return R.ok().put("data", jifenshangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JifenshangpinEntity jifenshangpin){
        EntityWrapper< JifenshangpinEntity> ew = new EntityWrapper< JifenshangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jifenshangpin, "jifenshangpin")); 
		JifenshangpinView jifenshangpinView =  jifenshangpinService.selectView(ew);
		return R.ok("查询积分商品成功").put("data", jifenshangpinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JifenshangpinEntity jifenshangpin = jifenshangpinService.selectById(id);
        return R.ok().put("data", jifenshangpin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JifenshangpinEntity jifenshangpin = jifenshangpinService.selectById(id);
        return R.ok().put("data", jifenshangpin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JifenshangpinEntity jifenshangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jifenshangpin);
        jifenshangpinService.insert(jifenshangpin);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JifenshangpinEntity jifenshangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jifenshangpin);
        jifenshangpinService.insert(jifenshangpin);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JifenshangpinEntity jifenshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenshangpin);
        jifenshangpinService.updateById(jifenshangpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jifenshangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
