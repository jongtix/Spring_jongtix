package ioc.injection;

import java.util.Map;

public class MapBean {
	//Map타입
	private Map<String, String> address;
	
	public Map<String, String> getAddress() {return address;}
	public void setAddress(Map<String, String> address) {
		this.address = address;
	}

}
