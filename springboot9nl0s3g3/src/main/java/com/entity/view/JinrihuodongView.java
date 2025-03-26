package com.entity.view;

import com.entity.JinrihuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 今日活动
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
@TableName("jinrihuodong")
public class JinrihuodongView  extends JinrihuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JinrihuodongView(){
	}
 
 	public JinrihuodongView(JinrihuodongEntity jinrihuodongEntity){
 	try {
			BeanUtils.copyProperties(this, jinrihuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
