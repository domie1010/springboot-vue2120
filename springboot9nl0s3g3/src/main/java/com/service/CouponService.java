package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CouponEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CouponVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CouponView;


/**
 * 优惠券
 *
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CouponVO> selectListVO(Wrapper<CouponEntity> wrapper);
   	
   	CouponVO selectVO(@Param("ew") Wrapper<CouponEntity> wrapper);
   	
   	List<CouponView> selectListView(Wrapper<CouponEntity> wrapper);
   	
   	CouponView selectView(@Param("ew") Wrapper<CouponEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CouponEntity> wrapper);

   	

}

