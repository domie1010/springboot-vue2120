package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MycouponEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MycouponVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MycouponView;


/**
 * 我的优惠券
 *
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
public interface MycouponService extends IService<MycouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MycouponVO> selectListVO(Wrapper<MycouponEntity> wrapper);
   	
   	MycouponVO selectVO(@Param("ew") Wrapper<MycouponEntity> wrapper);
   	
   	List<MycouponView> selectListView(Wrapper<MycouponEntity> wrapper);
   	
   	MycouponView selectView(@Param("ew") Wrapper<MycouponEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MycouponEntity> wrapper);

   	

}

