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
 * 我的优惠券
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
@TableName("mycoupon")
public class MycouponEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MycouponEntity() {
		
	}
	
	public MycouponEntity(T t) {
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
	 * 用户id
	 */
					
	private Long userid;
	
	/**
	 * 优惠券id
	 */
					
	private Long couponid;
	
	/**
	 * 名称
	 */
					
	private String name;
	
	/**
	 * 券编号
	 */
					
	private String couponnumber;
	
	/**
	 * 满额
	 */
					
	private Double fullamount;
	
	/**
	 * 优惠额
	 */
					
	private Double discountamount;
	
	/**
	 * 生效时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date startime;
	
	/**
	 * 过期时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date endtime;
	
	/**
	 * 优惠券类型
	 */
					
	private String type;
	
	/**
	 * 备注
	 */
					
	private String remark;
	
	/**
	 * 状态
	 */
					
	private String status;
	
	
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
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * 设置：优惠券id
	 */
	public void setCouponid(Long couponid) {
		this.couponid = couponid;
	}
	/**
	 * 获取：优惠券id
	 */
	public Long getCouponid() {
		return couponid;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：券编号
	 */
	public void setCouponnumber(String couponnumber) {
		this.couponnumber = couponnumber;
	}
	/**
	 * 获取：券编号
	 */
	public String getCouponnumber() {
		return couponnumber;
	}
	/**
	 * 设置：满额
	 */
	public void setFullamount(Double fullamount) {
		this.fullamount = fullamount;
	}
	/**
	 * 获取：满额
	 */
	public Double getFullamount() {
		return fullamount;
	}
	/**
	 * 设置：优惠额
	 */
	public void setDiscountamount(Double discountamount) {
		this.discountamount = discountamount;
	}
	/**
	 * 获取：优惠额
	 */
	public Double getDiscountamount() {
		return discountamount;
	}
	/**
	 * 设置：生效时间
	 */
	public void setStartime(Date startime) {
		this.startime = startime;
	}
	/**
	 * 获取：生效时间
	 */
	public Date getStartime() {
		return startime;
	}
	/**
	 * 设置：过期时间
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	/**
	 * 获取：过期时间
	 */
	public Date getEndtime() {
		return endtime;
	}
	/**
	 * 设置：优惠券类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：优惠券类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}

}
