package com.dao;

import com.entity.MycouponEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MycouponVO;
import com.entity.view.MycouponView;


/**
 * 我的优惠券
 * 
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
public interface MycouponDao extends BaseMapper<MycouponEntity> {
	
	List<MycouponVO> selectListVO(@Param("ew") Wrapper<MycouponEntity> wrapper);
	
	MycouponVO selectVO(@Param("ew") Wrapper<MycouponEntity> wrapper);
	
	List<MycouponView> selectListView(@Param("ew") Wrapper<MycouponEntity> wrapper);

	List<MycouponView> selectListView(Pagination page,@Param("ew") Wrapper<MycouponEntity> wrapper);

	
	MycouponView selectView(@Param("ew") Wrapper<MycouponEntity> wrapper);
	

}
