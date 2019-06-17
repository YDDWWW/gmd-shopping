package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ORDER_DETAIL表对应的实体类，用于封装一行的订单明细信息
 * 
 * @author 17384
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = 5414779535617435087L;

	/**
	 * 订单明细编号
	 */
	private Integer orderDetailId;
	/**
	 * 订单编号
	 */
	private Integer orderId;
	/**
	 * 商品编号
	 */
	private Integer goodsId;
	/**
	 * 商品名字
	 */
	private String goodsName;
	/**
	 * 成交价
	 */
	private Double transactionPrice;
	/**
	 * 成交数量
	 */
	private Integer transactionCount;

}