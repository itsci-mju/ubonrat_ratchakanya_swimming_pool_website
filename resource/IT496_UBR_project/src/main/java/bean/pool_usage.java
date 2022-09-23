package bean;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table (name="pool_usage")
public class pool_usage {
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
	
	@Column(name="adult",nullable=false)
	private int adult;
	
	@Column(name="child",nullable=false)
	private int child;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="price", nullable=false)
	private int price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="members_id",nullable=true,referencedColumnName="members_id")
	private members members;

	
	
	public pool_usage(int pool_usage_id, Calendar time, int usage_type, String coupon_no, int amount, int price,
			bean.members members) {
		super();
		this.pool_usage_id = pool_usage_id;
		this.time = time;
		this.usage_type = usage_type;
		this.coupon_no = coupon_no;
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

	public members getMembers() {
		return members;
	}

	public void setMembers(members members) {
		this.members = members;
	}

	
}
