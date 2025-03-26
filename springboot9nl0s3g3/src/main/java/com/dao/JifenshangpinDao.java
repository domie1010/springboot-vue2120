package com.dao;

import com.entity.JifenshangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JifenshangpinVO;
import com.entity.view.JifenshangpinView;


/**
 * 积分商品
 * 
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
public interface JifenshangpinDao extends BaseMapper<JifenshangpinEntity> {
	
	List<JifenshangpinVO> selectListVO(@Param("ew") Wrapper<JifenshangpinEntity> wrapper);
	
	JifenshangpinVO selectVO(@Param("ew") Wrapper<JifenshangpinEntity> wrapper);
	
	List<JifenshangpinView> selectListView(@Param("ew") Wrapper<JifenshangpinEntity> wrapper);

	List<JifenshangpinView> selectListView(Pagination page,@Param("ew") Wrapper<JifenshangpinEntity> wrapper);

	
	JifenshangpinView selectView(@Param("ew") Wrapper<JifenshangpinEntity> wrapper);
	

}
