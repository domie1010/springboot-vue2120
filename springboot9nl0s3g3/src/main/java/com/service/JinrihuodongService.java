package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinrihuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JinrihuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JinrihuodongView;


/**
 * 今日活动
 *
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
public interface JinrihuodongService extends IService<JinrihuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinrihuodongVO> selectListVO(Wrapper<JinrihuodongEntity> wrapper);
   	
   	JinrihuodongVO selectVO(@Param("ew") Wrapper<JinrihuodongEntity> wrapper);
   	
   	List<JinrihuodongView> selectListView(Wrapper<JinrihuodongEntity> wrapper);
   	
   	JinrihuodongView selectView(@Param("ew") Wrapper<JinrihuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinrihuodongEntity> wrapper);

   	

}

