package com.oracle.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.service.OrderService;

@Controller
@RequestMapping("pages/ordersys/order/")
public class OrderHandler {

	@Autowired
	OrderService service;
	
	@RequestMapping("/orderlist/{start}")
	public String orderlist(Map<String, Object> map, @PathVariable("start") Integer start) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		PageHelper.startPage(start, 5);

		list = service.getAll();

		PageInfo<Map<String, Object>> info = new PageInfo<Map<String, Object>>(list);

		map.put("pageInfo", info);

		return "/pages/ordersys/order/orderlist";
	}
	
	
	@RequestMapping("/jump")
	public String jump(@RequestParam("num") int num) {

		return "redirect:/pages/ordersys/order/orderlist/" + num;
	}
	
	
	@RequestMapping("/getOrders")
	public String getOrder(HttpSession session,Map<String,Object> map,String ordercode,String orderdate,Integer orderflag) {
		
		map.put("ordercode",ordercode);
		map.put("orderdate",orderdate);
		map.put("orderflag",orderflag);
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		list = service.getOrders(map);
	
		session.setAttribute("info", list);
		
		return "/pages/ordersys/order/orderlist2";
		
	}
	
	@RequestMapping("/search")
	public String getById(Integer orderid,HttpSession session) {
		
		Map<String,Object> imap = service.getOrderById(orderid);
		
		System.out.println(imap);
		
		session.setAttribute("imap", imap);
		
		return "/pages/ordersys/order/orderedit";
	}
	
	
	@RequestMapping(value = "/{path}")
	public String frame(@PathVariable("path") String path) {
		
		return "pages/ordersys/order/" + path;
	}
	
	@RequestMapping("/jump1")
	public String jump1() {
		
		return "redirect:/pages/partssys/partsrep/partsreplist/1";
	}
	
	
}
