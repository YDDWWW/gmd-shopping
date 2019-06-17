package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * 订单模块的控制层
 * 
 * @author 17384
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@RequestMapping(value ="/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			// 查找满足条件的订单信息
			PageInfo<Orders> pageInfo = this.ordersService.selectOrders(orders, pageNumber);
			// 从分页信息总获得订单信息
			List<Orders> list = pageInfo.getList();
			// 如果查询到了，满足条件的订单信息
			if (list != null && list.size() > 0) {
				// 设置结果的状态为0
				rv.setCode(0);
				// 创建Map集合
				Map<String, Object> map = new HashMap<>();
				// 将查询结果存入Map集合中
				map.put("ordersList", list);
		
				PageUtils pageUtils = new PageUtils(PageUtils.PAGE_ROW_COUNT,pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				// 将分页信息以指定的名字存入Map集合中
				map.put("pageUtils", pageUtils);

				rv.setDateMap(map);
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("没有找到满足条件的订单信息！！！");
		return rv;
	}
	
	@RequestMapping(value = "/updateOrderStatus")
	public ResultValue updateOrderStatus(Orders orders) {
		ResultValue rv = new ResultValue();
		 try {
			Integer status = this.ordersService.updateOrderStatus(orders);
			if(status > 0) {
				rv.setCode(0);
				rv.setMessage("修改订单状态成功！！！");
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 rv.setCode(1);
		 rv.setMessage("修改订单状态失败！！！");
		 return rv;
	}
	
	@RequestMapping(value = "selectGroup")
	public ResultValue selectGrouP(Orders orders) {
		ResultValue rv = new ResultValue();			
		try {
			List<Orders> list = this.ordersService.selectGroup(orders);
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				//创建两个集合，用于报讯柱状图x轴与y轴的数据
				List<String> x = new ArrayList<>();
				List<Double> y = new ArrayList<>();
				//将查询结果中商品名称存入x集合，销量存入y集合
				for(Orders o : list) {
					x.add(o.getOrderMonth());
					y.add(o.getOrderPrice());
				}
				//创建map集合
				Map<String,Object> map = new HashMap<>();
				//将x轴和y轴数据存到map集合中
				map.put("x", x);
				map.put("y", y);
					rv.setDateMap(map);
					
					return rv;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			rv.setCode(1);
			return rv;
		}
}

