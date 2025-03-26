package com.dao;

import com.entity.JinrihuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JinrihuodongVO;
import com.entity.view.JinrihuodongView;


/**
 * 今日活动
 * 
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
public interface JinrihuodongDao extends BaseMapper<JinrihuodongEntity> {
	
	List<JinrihuodongVO> selectListVO(@Param("ew") Wrapper<JinrihuodongEntity> wrapper);
	
	JinrihuodongVO selectVO(@Param("ew") Wrapper<JinrihuodongEntity> wrapper);
	
	List<JinrihuodongView> selectListView(@Param("ew") Wrapper<JinrihuodongEntity> wrapper);

	List<JinrihuodongView> selectListView(Pagination page,@Param("ew") Wrapper<JinrihuodongEntity> wrapper);

	
	JinrihuodongView selectView(@Param("ew") Wrapper<JinrihuodongEntity> wrapper);
	

}
