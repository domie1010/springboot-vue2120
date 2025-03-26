package com.entity.vo;

import com.entity.JifenshangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 积分商品
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
public class JifenshangpinVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品图片
	 */
	
	private String shangpintupian;
		
	/**
	 * 品牌
	 */
	
	private String pinpai;
		
	/**
	 * 所需积分
	 */
	
	private Double suoxujifen;
		
	/**
	 * 兑换规则
	 */
	
	private String duihuanguize;
		
	/**
	 * 商品介绍
	 */
	
	private String shangpinjieshao;
		
	/**
	 * 库存
	 */
	
	private Integer alllimittimes;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 积分
	 */
	
	private Integer jf;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：商品图片
	 */
	 
	public void setShangpintupian(String shangpintupian) {
		this.shangpintupian = shangpintupian;
	}
	
	/**
	 * 获取：商品图片
	 */
	public String getShangpintupian() {
		return shangpintupian;
	}
				
	
	/**
	 * 设置：品牌
	 */
	 
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
				
	
	/**
	 * 设置：所需积分
	 */
	 
	public void setSuoxujifen(Double suoxujifen) {
		this.suoxujifen = suoxujifen;
	}
	
	/**
	 * 获取：所需积分
	 */
	public Double getSuoxujifen() {
		return suoxujifen;
	}
				
	
	/**
	 * 设置：兑换规则
	 */
	 
	public void setDuihuanguize(String duihuanguize) {
		this.duihuanguize = duihuanguize;
	}
	
	/**
	 * 获取：兑换规则
	 */
	public String getDuihuanguize() {
		return duihuanguize;
	}
				
	
	/**
	 * 设置：商品介绍
	 */
	 
	public void setShangpinjieshao(String shangpinjieshao) {
		this.shangpinjieshao = shangpinjieshao;
	}
	
	/**
	 * 获取：商品介绍
	 */
	public String getShangpinjieshao() {
		return shangpinjieshao;
	}
				
	
	/**
	 * 设置：库存
	 */
	 
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	
	/**
	 * 获取：库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：积分
	 */
	 
	public void setJf(Integer jf) {
		this.jf = jf;
	}
	
	/**
	 * 获取：积分
	 */
	public Integer getJf() {
		return jf;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
