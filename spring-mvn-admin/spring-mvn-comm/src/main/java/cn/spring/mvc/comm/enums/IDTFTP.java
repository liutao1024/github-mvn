package cn.spring.mvc.comm.enums;

public enum IDTFTP {
	SHENFENZHENG("身份证", 1, "1001"),FUKOUBO("户口簿", 2, "1002"),FUZHAO("护照", 3, "1003"),JINGUANZHENG("警官证",4,"1004");
	String des;
	int rank;
	String value;
	private IDTFTP(String des, int rank, String value){
		this.des = des;
		this.rank = rank;
		this.value = value;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
