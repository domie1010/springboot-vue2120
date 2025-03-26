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


import com.dao.ChoujianghuodongDao;
import com.entity.ChoujianghuodongEntity;
import com.service.ChoujianghuodongService;
import com.entity.vo.ChoujianghuodongVO;
import com.entity.view.ChoujianghuodongView;

@Service("choujianghuodongService")
public class ChoujianghuodongServiceImpl extends ServiceImpl<ChoujianghuodongDao, ChoujianghuodongEntity> implements ChoujianghuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChoujianghuodongEntity> page = this.selectPage(
                new Query<ChoujianghuodongEntity>(params).getPage(),
                new EntityWrapper<ChoujianghuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChoujianghuodongEntity> wrapper) {
		  Page<ChoujianghuodongView> page =new Query<ChoujianghuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChoujianghuodongVO> selectListVO(Wrapper<ChoujianghuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChoujianghuodongVO selectVO(Wrapper<ChoujianghuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChoujianghuodongView> selectListView(Wrapper<ChoujianghuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChoujianghuodongView selectView(Wrapper<ChoujianghuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
