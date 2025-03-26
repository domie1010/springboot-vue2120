package com.entity.model;

import com.entity.ChoujianghuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 抽奖活动
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
public class ChoujianghuodongModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 活动名称
	 */
	
	private String huodongmingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 活动状态
	 */
	
	private String huodongzhuangtai;
		
	/**
	 * 活动开始时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date huodongkaishishijian;
		
	/**
	 * 活动结束时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date huodongjieshushijian;
		
	/**
	 * 奖项设置
	 */
	
	private String jiangxiangshezhi;
		
	/**
	 * 活动介绍
	 */
	
	private String huodongjieshao;
				
	
	/**
	 * 设置：活动名称
	 */
	 
	public void setHuodongmingcheng(String huodongmingcheng) {
		this.huodongmingcheng = huodongmingcheng;
	}
	
	/**
	 * 获取：活动名称
	 */
	public String getHuodongmingcheng() {
		return huodongmingcheng;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：活动状态
	 */
	 
	public void setHuodongzhuangtai(String huodongzhuangtai) {
		this.huodongzhuangtai = huodongzhuangtai;
	}
	
	/**
	 * 获取：活动状态
	 */
	public String getHuodongzhuangtai() {
		return huodongzhuangtai;
	}
				
	
	/**
	 * 设置：活动开始时间
	 */
	 
	public void setHuodongkaishishijian(Date huodongkaishishijian) {
		this.huodongkaishishijian = huodongkaishishijian;
	}
	
	/**
	 * 获取：活动开始时间
	 */
	public Date getHuodongkaishishijian() {
		return huodongkaishishijian;
	}
				
	
	/**
	 * 设置：活动结束时间
	 */
	 
	public void setHuodongjieshushijian(Date huodongjieshushijian) {
		this.huodongjieshushijian = huodongjieshushijian;
	}
	
	/**
	 * 获取：活动结束时间
	 */
	public Date getHuodongjieshushijian() {
		return huodongjieshushijian;
	}
				
	
	/**
	 * 设置：奖项设置
	 */
	 
	public void setJiangxiangshezhi(String jiangxiangshezhi) {
		this.jiangxiangshezhi = jiangxiangshezhi;
	}
	
	/**
	 * 获取：奖项设置
	 */
	public String getJiangxiangshezhi() {
		return jiangxiangshezhi;
	}
				
	
	/**
	 * 设置：活动介绍
	 */
	 
	public void setHuodongjieshao(String huodongjieshao) {
		this.huodongjieshao = huodongjieshao;
	}
	
	/**
	 * 获取：活动介绍
	 */
	public String getHuodongjieshao() {
		return huodongjieshao;
	}
			
}
