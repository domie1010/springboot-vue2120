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


import com.dao.MycouponDao;
import com.entity.MycouponEntity;
import com.service.MycouponService;
import com.entity.vo.MycouponVO;
import com.entity.view.MycouponView;

@Service("mycouponService")
public class MycouponServiceImpl extends ServiceImpl<MycouponDao, MycouponEntity> implements MycouponService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MycouponEntity> page = this.selectPage(
                new Query<MycouponEntity>(params).getPage(),
                new EntityWrapper<MycouponEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MycouponEntity> wrapper) {
		  Page<MycouponView> page =new Query<MycouponView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MycouponVO> selectListVO(Wrapper<MycouponEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MycouponVO selectVO(Wrapper<MycouponEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MycouponView> selectListView(Wrapper<MycouponEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MycouponView selectView(Wrapper<MycouponEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
