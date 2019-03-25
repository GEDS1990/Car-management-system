package com.oracle.vo;

import java.util.Date;

public class Order {
    private Integer orderid;

    private String ordercode;

    private Date orderdate;

    private String orderflag;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderflag() {
        return orderflag;
    }

    public void setOrderflag(String orderflag) {
        this.orderflag = orderflag == null ? null : orderflag.trim();
    }

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", ordercode=" + ordercode + ", orderdate=" + orderdate + ", orderflag="
				+ orderflag + "]";
	}
    
}