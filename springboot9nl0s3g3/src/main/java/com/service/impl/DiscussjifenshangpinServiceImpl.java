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


import com.dao.DiscussjifenshangpinDao;
import com.entity.DiscussjifenshangpinEntity;
import com.service.DiscussjifenshangpinService;
import com.entity.vo.DiscussjifenshangpinVO;
import com.entity.view.DiscussjifenshangpinView;

@Service("discussjifenshangpinService")
public class DiscussjifenshangpinServiceImpl extends ServiceImpl<DiscussjifenshangpinDao, DiscussjifenshangpinEntity> implements DiscussjifenshangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjifenshangpinEntity> page = this.selectPage(
                new Query<DiscussjifenshangpinEntity>(params).getPage(),
                new EntityWrapper<DiscussjifenshangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjifenshangpinEntity> wrapper) {
		  Page<DiscussjifenshangpinView> page =new Query<DiscussjifenshangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussjifenshangpinVO> selectListVO(Wrapper<DiscussjifenshangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjifenshangpinVO selectVO(Wrapper<DiscussjifenshangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjifenshangpinView> selectListView(Wrapper<DiscussjifenshangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjifenshangpinView selectView(Wrapper<DiscussjifenshangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
