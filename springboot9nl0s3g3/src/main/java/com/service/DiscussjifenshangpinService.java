package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjifenshangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjifenshangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjifenshangpinView;


/**
 * 积分商品评论表
 *
 * @author 
 * @email 
 * @date 2024-05-16 17:39:08
 */
public interface DiscussjifenshangpinService extends IService<DiscussjifenshangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjifenshangpinVO> selectListVO(Wrapper<DiscussjifenshangpinEntity> wrapper);
   	
   	DiscussjifenshangpinVO selectVO(@Param("ew") Wrapper<DiscussjifenshangpinEntity> wrapper);
   	
   	List<DiscussjifenshangpinView> selectListView(Wrapper<DiscussjifenshangpinEntity> wrapper);
   	
   	DiscussjifenshangpinView selectView(@Param("ew") Wrapper<DiscussjifenshangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjifenshangpinEntity> wrapper);

   	

}

