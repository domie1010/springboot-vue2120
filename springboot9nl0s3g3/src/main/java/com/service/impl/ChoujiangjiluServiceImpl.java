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


import com.dao.ChoujiangjiluDao;
import com.entity.ChoujiangjiluEntity;
import com.service.ChoujiangjiluService;
import com.entity.vo.ChoujiangjiluVO;
import com.entity.view.ChoujiangjiluView;

@Service("choujiangjiluService")
public class ChoujiangjiluServiceImpl extends ServiceImpl<ChoujiangjiluDao, ChoujiangjiluEntity> implements ChoujiangjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChoujiangjiluEntity> page = this.selectPage(
                new Query<ChoujiangjiluEntity>(params).getPage(),
                new EntityWrapper<ChoujiangjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChoujiangjiluEntity> wrapper) {
		  Page<ChoujiangjiluView> page =new Query<ChoujiangjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChoujiangjiluVO> selectListVO(Wrapper<ChoujiangjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChoujiangjiluVO selectVO(Wrapper<ChoujiangjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChoujiangjiluView> selectListView(Wrapper<ChoujiangjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChoujiangjiluView selectView(Wrapper<ChoujiangjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
