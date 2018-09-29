package cn.spring.mvn.socket.entity;

public class SystemTransactionInformation {
	private String serialNumber;
	private String serialDate;
	private String ipAddress;
	private String input;
	private String output;
	private String errorMesage;
	private String timestamp;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialDate() {
		return serialDate;
	}

	public void setSerialDate(String serialDate) {
		this.serialDate = serialDate;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getErrorMesage() {
		return errorMesage;
	}

	public void setErrorMesage(String errorMesage) {
		this.errorMesage = errorMesage;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorMesage == null) ? 0 : errorMesage.hashCode());
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		result = prime * result
				+ ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((output == null) ? 0 : output.hashCode());
		result = prime * result
				+ ((serialDate == null) ? 0 : serialDate.hashCode());
		result = prime * result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemTransactionInformation other = (SystemTransactionInformation) obj;
		if (errorMesage == null) {
			if (other.errorMesage != null)
				return false;
		} else if (!errorMesage.equals(other.errorMesage))
			return false;
		if (input == null) {
			if (other.input != null)
				return false;
		} else if (!input.equals(other.input))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (output == null) {
			if (other.output != null)
				return false;
		} else if (!output.equals(other.output))
			return false;
		if (serialDate == null) {
			if (other.serialDate != null)
				return false;
		} else if (!serialDate.equals(other.serialDate))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SystemTransactionInformation [serialNumber=" + serialNumber
				+ ", serialDate=" + serialDate + ", ipAddress=" + ipAddress
				+ ", input=" + input + ", output=" + output + ", errorMesage="
				+ errorMesage + ", timestamp=" + timestamp + "]";
	}
}