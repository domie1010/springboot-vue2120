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

import com.entity.DiscussjifenshangpinEntity;
import com.entity.view.DiscussjifenshangpinView;

import com.service.DiscussjifenshangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 积分商品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-16 17:39:08
 */
@RestController
@RequestMapping("/discussjifenshangpin")
public class DiscussjifenshangpinController {
    @Autowired
    private DiscussjifenshangpinService discussjifenshangpinService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjifenshangpinEntity discussjifenshangpin,
		HttpServletRequest request){
        EntityWrapper<DiscussjifenshangpinEntity> ew = new EntityWrapper<DiscussjifenshangpinEntity>();

		PageUtils page = discussjifenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjifenshangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjifenshangpinEntity discussjifenshangpin, 
		HttpServletRequest request){
        EntityWrapper<DiscussjifenshangpinEntity> ew = new EntityWrapper<DiscussjifenshangpinEntity>();

		PageUtils page = discussjifenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjifenshangpin), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjifenshangpinEntity discussjifenshangpin){
       	EntityWrapper<DiscussjifenshangpinEntity> ew = new EntityWrapper<DiscussjifenshangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjifenshangpin, "discussjifenshangpin")); 
        return R.ok().put("data", discussjifenshangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjifenshangpinEntity discussjifenshangpin){
        EntityWrapper< DiscussjifenshangpinEntity> ew = new EntityWrapper< DiscussjifenshangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjifenshangpin, "discussjifenshangpin")); 
		DiscussjifenshangpinView discussjifenshangpinView =  discussjifenshangpinService.selectView(ew);
		return R.ok("查询积分商品评论表成功").put("data", discussjifenshangpinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjifenshangpinEntity discussjifenshangpin = discussjifenshangpinService.selectById(id);
        return R.ok().put("data", discussjifenshangpin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjifenshangpinEntity discussjifenshangpin = discussjifenshangpinService.selectById(id);
        return R.ok().put("data", discussjifenshangpin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjifenshangpinEntity discussjifenshangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjifenshangpin);
        discussjifenshangpinService.insert(discussjifenshangpin);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjifenshangpinEntity discussjifenshangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjifenshangpin);
        discussjifenshangpinService.insert(discussjifenshangpin);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussjifenshangpinEntity discussjifenshangpin = discussjifenshangpinService.selectOne(new EntityWrapper<DiscussjifenshangpinEntity>().eq("", username));
        return R.ok().put("data", discussjifenshangpin);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjifenshangpinEntity discussjifenshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjifenshangpin);
        discussjifenshangpinService.updateById(discussjifenshangpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjifenshangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjifenshangpinEntity discussjifenshangpin, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjifenshangpinEntity> ew = new EntityWrapper<DiscussjifenshangpinEntity>();
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
		PageUtils page = discussjifenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjifenshangpin), params), params));
        return R.ok().put("data", page);
    }










}
