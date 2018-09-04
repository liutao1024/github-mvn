package cn.spring.mvn.server.tools;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ResponseMap implements Map<String, Object>{
	private Map<String, Object> sysMap;
	private Map<String, Object> commMap;
	private Map<String, Object> srcMap;
	
	public ResponseMap(){
		
	}
	public ResponseMap(Map<String, Object> sysMap, Map<String, Object> commMap, Map<String, Object> srcMap){
		this.sysMap = sysMap;
		this.commMap = commMap;
		this.srcMap = srcMap;
		
	}
	
	public Map<String, Object> getSysMap() {
		return sysMap;
	}
	public void setSysMap(Map<String, Object> sysMap) {
		this.sysMap = sysMap;
	}
	public Map<String, Object> getCommMap() {
		return commMap;
	}
	public void setCommMap(Map<String, Object> commMap) {
		this.commMap = commMap;
	}
	public Map<String, Object> getSrcMap() {
		return srcMap;
	}
	public void setSrcMap(Map<String, Object> srcMap) {
		this.srcMap = srcMap;
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
		return this.entrySet();
	}
	
	
}
