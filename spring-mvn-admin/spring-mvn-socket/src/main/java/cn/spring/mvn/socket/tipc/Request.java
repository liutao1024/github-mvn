package cn.spring.mvn.socket.tipc;

import java.io.Serializable;

import cn.spring.mvn.socket.Comm;
import cn.spring.mvn.socket.Input;
import cn.spring.mvn.socket.Sys;

public class Request implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = -5291175845786955585L;
	
	private Sys sys;
	private Comm comm;
	private Input input;
	
	public Request(){
		
	}
	public Request(Sys sys, Comm comm, Input input){
		this.sys = sys;
		this.comm = comm;
		this.input = input;
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
	public Input getInput() {
		return input;
	}
	public void setInput(Input input) {
		this.input = input;
	}
}