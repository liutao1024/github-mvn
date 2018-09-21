package cn.spring.mvn.socket.tools;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class RequestMap implements Map<String, Object>, Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = -5291175845786955585L;
	
	private Map<String, Object> sys;
	private Map<String, Object> comm;
	private Map<String, Object> request;
	
	public RequestMap(){
		
	}
	public RequestMap(Map<String, Object> sys, Map<String, Object> comm, Map<String, Object> request){
		this.sys = sys;
		this.comm = comm;
		this.request = request;
	}
	
	
	
	public Map<String, Object> getSys() {
		return sys;
	}



	public void setSys(Map<String, Object> sys) {
		this.sys = sys;
	}



	public Map<String, Object> getComm() {
		return comm;
	}



	public void setComm(Map<String, Object> comm) {
		this.comm = comm;
	}



	public Map<String, Object> getRequest() {
		return request;
	}



	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}



	@Override
	public int size() {
		return this.size();
	}
	@Override
	public boolean isEmpty() {
		return this.isEmpty();
	}
	@Override
	public boolean containsKey(Object key) {
		return this.containsKey(key);
	}
	@Override
	public boolean containsValue(Object value) {
		return this.containsValue(value);
	}
	@Override
	public Object get(Object key) {
		return this.get(key);
	}
	@Override
	public Object put(String key, Object value) {
		return this.put(key, value);
	}
	@Override
	public Object remove(Object key) {
		return this.remove(key);
	}
	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		this.putAll(m);
	}
	@Override
	public void clear() {
		this.clear();
	}
	@Override
	public Set<String> keySet() {
		return this.keySet();
	}
	@Override
	public Collection<Object> values() {
		return this.values();
	}
	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return null;
	}
	
	
}
