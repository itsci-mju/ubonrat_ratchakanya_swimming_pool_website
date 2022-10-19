package org.itsci.ubrswimming.model;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table (name="pool_usage")
public class PoolUsage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pool_usage_id")
	private int pool_usage_id;
	
	@Column(name="coupon_no", nullable=false, length=10)
	private String coupon_no;
	
	@Column(name="time",nullable=false)
	private Calendar time;
	
	@Column(name="usage_type",nullable=false)
	private int usage_type;
	
	@Column(name="adult",nullable=true)
	private int adult;
	
	@Column(name="child",nullable=true)
	private int child;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="price", nullable=false)
	private int price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="members_id",nullable=true,referencedColumnName="members_id")
	private Members members;
	
	

	public PoolUsage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PoolUsage(int pool_usage_id, String coupon_no, Calendar time, int usage_type, int adult, int child,
					 int amount, int price, Members members) {
		super();
		this.pool_usage_id = pool_usage_id;
		this.coupon_no = coupon_no;
		this.time = time;
		this.usage_type = usage_type;
		this.adult = adult;
		this.child = child;
		this.amount = amount;
		this.price = price;
		this.members = members;
	}

	public int getPool_usage_id() {
		return pool_usage_id;
	}

	public void setPool_usage_id(int pool_usage_id) {
		this.pool_usage_id = pool_usage_id;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public int getUsage_type() {
		return usage_type;
	}

	public void setUsage_type(int usage_type) {
		this.usage_type = usage_type;
	}

	public String getCoupon_no() {
		return coupon_no;
	}

	public void setCoupon_no(String coupon_no) {
		this.coupon_no = coupon_no;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	
}
