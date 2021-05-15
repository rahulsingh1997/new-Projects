package in.co.srdt.unifsupport.controller;

public class SingleResponseModel {

	private String message;
	
	private String status;

	public SingleResponseModel() {
		
	}

	public SingleResponseModel(String message, String status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SingleResponseModel{" +
				"message='" + message + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}