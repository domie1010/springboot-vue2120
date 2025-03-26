package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 抽奖活动
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-16 17:39:06
 */
@TableName("choujianghuodong")
public class ChoujianghuodongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChoujianghuodongEntity() {
		
	}
	
	public ChoujianghuodongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 活动编号
	 */
					
	private String huodongbianhao;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：活动编号
	 */
	public void setHuodongbianhao(String huodongbianhao) {
		this.huodongbianhao = huodongbianhao;
	}
	/**
	 * 获取：活动编号
	 */
	public String getHuodongbianhao() {
		return huodongbianhao;
	}
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
