package bean;

import java.util.Calendar;
import javax.persistence.*;

@Entity
@Table (name="pool_reservations")
public class pool_reservations {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pool_reservations_id")
	private int pool_reservations_id;
	
	@Column(name="event_name",nullable=true,length=255)
	private String event_name;
	
	@Column(name="start_time",nullable=false)
	private Calendar start_time;
	
	@Column(name="end_time",nullable=false)
	private Calendar end_time;
	
	@Column(name="detail",nullable=true,length=255)
	private String detail;
	
	@Column(name="price",nullable=true)
	private int price;
	
	@Column(name="document",nullable=true,length=45)
	private String document;
	
	@Column(name="status",nullable=false)
	private int status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="members_id",nullable=false,referencedColumnName="members_id")
	private members members;

	public pool_reservations(int pool_reservations_id, String event_name, Calendar start_time, Calendar end_time,
			String detail, int price, String document, int status, bean.members members) {
		super();
		this.pool_reservations_id = pool_reservations_id;
		this.event_name = event_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.detail = detail;
		this.price = price;
		this.document = document;
		this.status = status;
		this.members = members;
	}

	public pool_reservations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPool_reservations_id() {
		return pool_reservations_id;
	}

	public void setPool_reservations_id(int pool_reservations_id) {
		this.pool_reservations_id = pool_reservations_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public Calendar getStart_time() {
		return start_time;
	}

	public void setStart_time(Calendar start_time) {
		this.start_time = start_time;
	}

	public Calendar getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Calendar end_time) {
		this.end_time = end_time;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public members getMembers() {
		return members;
	}

	public void setMembers(members members) {
		this.members = members;
	}


	
	
}
