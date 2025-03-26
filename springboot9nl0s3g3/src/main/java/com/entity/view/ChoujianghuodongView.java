package com.entity.view;

import com.entity.ChoujianghuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 抽奖活动
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
@TableName("choujianghuodong")
public class ChoujianghuodongView  extends ChoujianghuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChoujianghuodongView(){
	}
 
 	public ChoujianghuodongView(ChoujianghuodongEntity choujianghuodongEntity){
 	try {
			BeanUtils.copyProperties(this, choujianghuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
