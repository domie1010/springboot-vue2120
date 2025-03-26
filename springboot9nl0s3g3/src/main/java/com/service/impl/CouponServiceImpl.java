package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CouponDao;
import com.entity.CouponEntity;
import com.service.CouponService;
import com.entity.vo.CouponVO;
import com.entity.view.CouponView;

@Service("couponService")
public class CouponServiceImpl extends ServiceImpl<CouponDao, CouponEntity> implements CouponService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CouponEntity> page = this.selectPage(
                new Query<CouponEntity>(params).getPage(),
                new EntityWrapper<CouponEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CouponEntity> wrapper) {
		  Page<CouponView> page =new Query<CouponView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CouponVO> selectListVO(Wrapper<CouponEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CouponVO selectVO(Wrapper<CouponEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CouponView> selectListView(Wrapper<CouponEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CouponView selectView(Wrapper<CouponEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
