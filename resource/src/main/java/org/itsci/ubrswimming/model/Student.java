package org.itsci.ubrswimming.model;

public class Student extends Member{
	
	private String[] facname={"บริหารธุรกิจ",
			"วิทยาศาสตร์",
			"เทคโนโลยีการประมงและทรัพยากรทางน้ำ",
			"ศิลปศาสตร์",
			"สถาปัตยกรรมศาสตร์และการออกแบบสิ่งแวดล้อม",
			"สารสนเทศและการสื่อสาร",
			"ผลิตกรรมการเกษตร",
			"วิศวกรรมและอุตสาหกรรมเกษตร",
			"พัฒนาการท่องเที่ยว",
			"เศรษฐศาสตร์",
			"สัตวศาสตร์และเทคโนโลยี",
			"พยาบาลศาสตร์",
			"สัตวแพทยศาสตร์",
			"วิทยาลัยนานาชาติ",
			"วิทยาลัยพลังงานทดแทน",
			"วิทยาลัยบริหารศาสตร์",
			"มหาวิทยาลัยแม่โจ้-แพร่ เฉลิมพระเกียรติ",
			"มหาวิทยาลัยแม่โจ้-ชุมพร"}; 

	
	
	public String[] getFacname() {
		return facname;
	}


	public void setFacname(String[] facname) {
		this.facname = facname;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}

}
