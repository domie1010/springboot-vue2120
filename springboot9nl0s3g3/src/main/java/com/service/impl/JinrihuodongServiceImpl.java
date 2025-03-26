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


import com.dao.JinrihuodongDao;
import com.entity.JinrihuodongEntity;
import com.service.JinrihuodongService;
import com.entity.vo.JinrihuodongVO;
import com.entity.view.JinrihuodongView;

@Service("jinrihuodongService")
public class JinrihuodongServiceImpl extends ServiceImpl<JinrihuodongDao, JinrihuodongEntity> implements JinrihuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinrihuodongEntity> page = this.selectPage(
                new Query<JinrihuodongEntity>(params).getPage(),
                new EntityWrapper<JinrihuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinrihuodongEntity> wrapper) {
		  Page<JinrihuodongView> page =new Query<JinrihuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JinrihuodongVO> selectListVO(Wrapper<JinrihuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JinrihuodongVO selectVO(Wrapper<JinrihuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JinrihuodongView> selectListView(Wrapper<JinrihuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinrihuodongView selectView(Wrapper<JinrihuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
