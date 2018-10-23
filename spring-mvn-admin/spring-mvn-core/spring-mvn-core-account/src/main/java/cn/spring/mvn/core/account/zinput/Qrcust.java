package cn.spring.mvn.core.account.zinput;

import java.util.List;


public class Qrcust {
	static class Input{
		String custno;
		String custna;
		public String getCustno() {
			return custno;
		}
		public void setCustno(String custno) {
			this.custno = custno;
		}
		public String getCustna() {
			return custna;
		}
		public void setCustna(String custna) {
			this.custna = custna;
		}
	}
	
	class Output{
		int count;
		List<Info> infos;
	}
	
	class Info{
		String custno;
		String custna;
		String custsx;
		String idtftp;
		String idtfno;
		public String getCustno() {
			return custno;
		}
		public void setCustno(String custno) {
			this.custno = custno;
		}
		public String getCustna() {
			return custna;
		}
		public void setCustna(String custna) {
			this.custna = custna;
		}
		public String getCustsx() {
			return custsx;
		}
		public void setCustsx(String custsx) {
			this.custsx = custsx;
		}
		public String getIdtftp() {
			return idtftp;
		}
		public void setIdtftp(String idtftp) {
			this.idtftp = idtftp;
		}
		public String getIdtfno() {
			return idtfno;
		}
		public void setIdtfno(String idtfno) {
			this.idtfno = idtfno;
		}
	}
}
