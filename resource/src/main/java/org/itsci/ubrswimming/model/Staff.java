package org.itsci.ubrswimming.model;

public class Staff extends Member{

	private Login email;
	private Login password;
	
	String[] facname={"บริหารธุรกิจ",
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
			"มหาวิทยาลัยแม่โจ้-ชุมพร",
			"กองกลาง",
			"กองบริหารทรัพยากรบุคคล",
			"กองคลัง",
			"กองตรวจสอบภายใน",
			"กองเทคโนโลยีดิจิทัล",
			"กองบริหารงานทรัพย์สินและกิจการพิเศษ",
			"กองแผนงาน",
			"ฝ่ายพัฒนาทรัพยากรมนุษย์",
			"กองพัฒนาคุณภาพ",
			"กองพัฒนานักศึกษา",
			"กองวิเทศสัมพันธ์",
			"กองส่งเสริมศิลปวัฒนธรรม",
			"กองกายภาพและสิ่งแวดล้อม",
			"สภาพนักงาน",
			"ฝ่ายสื่อสารองค์กร",
			"ฝ่ายกฏหมาย",
			"ฝ่ายขับเคลื่อนยุทธศาสตร์และโครงการพิเศษ"	
};

	public Login getEmail() {
		return email;
	}

	public void setEmail(Login email) {
		this.email = email;
	}

	public Login getPassword() {
		return password;
	}

	public void setPassword(Login password) {
		this.password = password;
	}

	public String[] getFacname() {
		return facname;
	}

	public void setFacname(String[] facname) {
		this.facname = facname;
	} 
	
}
