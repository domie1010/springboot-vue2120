package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChoujiangjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChoujiangjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChoujiangjiluView;


/**
 * 抽奖记录
 *
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
public interface ChoujiangjiluService extends IService<ChoujiangjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChoujiangjiluVO> selectListVO(Wrapper<ChoujiangjiluEntity> wrapper);
   	
   	ChoujiangjiluVO selectVO(@Param("ew") Wrapper<ChoujiangjiluEntity> wrapper);
   	
   	List<ChoujiangjiluView> selectListView(Wrapper<ChoujiangjiluEntity> wrapper);
   	
   	ChoujiangjiluView selectView(@Param("ew") Wrapper<ChoujiangjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChoujiangjiluEntity> wrapper);

   	

}

