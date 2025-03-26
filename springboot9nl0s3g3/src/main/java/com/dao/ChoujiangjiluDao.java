package com.dao;

import com.entity.ChoujiangjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChoujiangjiluVO;
import com.entity.view.ChoujiangjiluView;


/**
 * 抽奖记录
 * 
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
public interface ChoujiangjiluDao extends BaseMapper<ChoujiangjiluEntity> {
	
	List<ChoujiangjiluVO> selectListVO(@Param("ew") Wrapper<ChoujiangjiluEntity> wrapper);
	
	ChoujiangjiluVO selectVO(@Param("ew") Wrapper<ChoujiangjiluEntity> wrapper);
	
	List<ChoujiangjiluView> selectListView(@Param("ew") Wrapper<ChoujiangjiluEntity> wrapper);

	List<ChoujiangjiluView> selectListView(Pagination page,@Param("ew") Wrapper<ChoujiangjiluEntity> wrapper);

	
	ChoujiangjiluView selectView(@Param("ew") Wrapper<ChoujiangjiluEntity> wrapper);
	

}
