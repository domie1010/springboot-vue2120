package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChoujianghuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChoujianghuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChoujianghuodongView;


/**
 * 抽奖活动
 *
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
public interface ChoujianghuodongService extends IService<ChoujianghuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChoujianghuodongVO> selectListVO(Wrapper<ChoujianghuodongEntity> wrapper);
   	
   	ChoujianghuodongVO selectVO(@Param("ew") Wrapper<ChoujianghuodongEntity> wrapper);
   	
   	List<ChoujianghuodongView> selectListView(Wrapper<ChoujianghuodongEntity> wrapper);
   	
   	ChoujianghuodongView selectView(@Param("ew") Wrapper<ChoujianghuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChoujianghuodongEntity> wrapper);

   	

}

