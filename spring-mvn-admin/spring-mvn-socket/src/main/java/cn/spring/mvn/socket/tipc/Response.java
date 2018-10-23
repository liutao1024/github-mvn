package cn.spring.mvn.socket.tipc;

import java.io.Serializable;

import cn.spring.mvn.socket.Comm;
import cn.spring.mvn.socket.Output;
import cn.spring.mvn.socket.Sys;

public class Response implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 7659023655411535203L;
	
	private Sys sys;
	private Comm comm;
	private Output output;
	
	public Response(){
		
	}
	public Response(Sys sys, Comm comm, Output output){
		this.sys = sys;
		this.comm = comm;
		this.output = output;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public Comm getComm() {
		return comm;
	}
	public void setComm(Comm comm) {
		this.comm = comm;
	}
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output output) {
		this.output = output;
	}
}