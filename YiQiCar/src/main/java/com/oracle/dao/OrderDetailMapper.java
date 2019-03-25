package com.oracle.dao;

import org.springframework.stereotype.Repository;

import com.oracle.vo.OrderDetail;
@Repository
public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer orderdetailid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer orderdetailid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}