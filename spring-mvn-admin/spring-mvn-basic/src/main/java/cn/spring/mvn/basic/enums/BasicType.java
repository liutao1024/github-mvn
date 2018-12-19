package cn.spring.mvn.basic.enums;

public class BasicType {
	public enum SERIALTYPE{
		CUSTOMER(1, "CUSTOMER", "客户信息"), ELECTRON(2, "ELECTRON", "电子帐号信息"), ACCOUNT(3, "ACCOUNT", "账户信息");
		int rank;
		String value;
		String describe;
		private SERIALTYPE(int rank, String value, String describe){
			this.rank = rank;
			this.value = value;
			this.describe = describe;
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
		public String getDescribe() {
			return describe;
		}
		public void setDescribe(String describe) {
			this.describe = describe;
		}
	};
}
