package com.oracle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.dao.OrderMapper;

@Service
public class OrderService {

	@Autowired
	OrderMapper dao;
	
	@Transactional
	public List<Map<String,Object>> getAll(){
		
		return dao.getAllOrder();	
	}
	
	@Transactional
	public List<Map<String,Object>> getOrders(Map<String,Object> map){
		
		return dao.getOrders(map);
		
	}
	
	@Transactional
	public Map<String,Object> getOrderById(Integer id){
	
		
		return dao.getOrderById(id);
	}
	
	
}
