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


import com.dao.JifenshangpinDao;
import com.entity.JifenshangpinEntity;
import com.service.JifenshangpinService;
import com.entity.vo.JifenshangpinVO;
import com.entity.view.JifenshangpinView;

@Service("jifenshangpinService")
public class JifenshangpinServiceImpl extends ServiceImpl<JifenshangpinDao, JifenshangpinEntity> implements JifenshangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JifenshangpinEntity> page = this.selectPage(
                new Query<JifenshangpinEntity>(params).getPage(),
                new EntityWrapper<JifenshangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JifenshangpinEntity> wrapper) {
		  Page<JifenshangpinView> page =new Query<JifenshangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JifenshangpinVO> selectListVO(Wrapper<JifenshangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JifenshangpinVO selectVO(Wrapper<JifenshangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JifenshangpinView> selectListView(Wrapper<JifenshangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JifenshangpinView selectView(Wrapper<JifenshangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
