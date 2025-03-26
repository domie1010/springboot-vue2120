package com.entity.model;

import com.entity.MycouponEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 我的优惠券
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-05-16 17:39:07
 */
public class MycouponModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
