package com.dao;

import com.entity.ChoujianghuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChoujianghuodongVO;
import com.entity.view.ChoujianghuodongView;


/**
 * 抽奖活动
 * 
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
public interface ChoujianghuodongDao extends BaseMapper<ChoujianghuodongEntity> {
	
	List<ChoujianghuodongVO> selectListVO(@Param("ew") Wrapper<ChoujianghuodongEntity> wrapper);
	
	ChoujianghuodongVO selectVO(@Param("ew") Wrapper<ChoujianghuodongEntity> wrapper);
	
	List<ChoujianghuodongView> selectListView(@Param("ew") Wrapper<ChoujianghuodongEntity> wrapper);

	List<ChoujianghuodongView> selectListView(Pagination page,@Param("ew") Wrapper<ChoujianghuodongEntity> wrapper);

	
	ChoujianghuodongView selectView(@Param("ew") Wrapper<ChoujianghuodongEntity> wrapper);
	

}
