package com.dao;

import com.entity.CouponEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CouponVO;
import com.entity.view.CouponView;


/**
 * 优惠券
 * 
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
public interface CouponDao extends BaseMapper<CouponEntity> {
	
	List<CouponVO> selectListVO(@Param("ew") Wrapper<CouponEntity> wrapper);
	
	CouponVO selectVO(@Param("ew") Wrapper<CouponEntity> wrapper);
	
	List<CouponView> selectListView(@Param("ew") Wrapper<CouponEntity> wrapper);

	List<CouponView> selectListView(Pagination page,@Param("ew") Wrapper<CouponEntity> wrapper);

	
	CouponView selectView(@Param("ew") Wrapper<CouponEntity> wrapper);
	

}
