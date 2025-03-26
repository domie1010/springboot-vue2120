package com.dao;

import com.entity.DiscussjifenshangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjifenshangpinVO;
import com.entity.view.DiscussjifenshangpinView;


/**
 * 积分商品评论表
 * 
 * @author 
 * @email 
 * @date 2024-05-16 17:39:08
 */
public interface DiscussjifenshangpinDao extends BaseMapper<DiscussjifenshangpinEntity> {
	
	List<DiscussjifenshangpinVO> selectListVO(@Param("ew") Wrapper<DiscussjifenshangpinEntity> wrapper);
	
	DiscussjifenshangpinVO selectVO(@Param("ew") Wrapper<DiscussjifenshangpinEntity> wrapper);
	
	List<DiscussjifenshangpinView> selectListView(@Param("ew") Wrapper<DiscussjifenshangpinEntity> wrapper);

	List<DiscussjifenshangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjifenshangpinEntity> wrapper);

	
	DiscussjifenshangpinView selectView(@Param("ew") Wrapper<DiscussjifenshangpinEntity> wrapper);
	

}
