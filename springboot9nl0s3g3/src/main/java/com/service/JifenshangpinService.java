package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JifenshangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JifenshangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JifenshangpinView;


/**
 * 积分商品
 *
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
public interface JifenshangpinService extends IService<JifenshangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JifenshangpinVO> selectListVO(Wrapper<JifenshangpinEntity> wrapper);
   	
   	JifenshangpinVO selectVO(@Param("ew") Wrapper<JifenshangpinEntity> wrapper);
   	
   	List<JifenshangpinView> selectListView(Wrapper<JifenshangpinEntity> wrapper);
   	
   	JifenshangpinView selectView(@Param("ew") Wrapper<JifenshangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JifenshangpinEntity> wrapper);

   	

}

