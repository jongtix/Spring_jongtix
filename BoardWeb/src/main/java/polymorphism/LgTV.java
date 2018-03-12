package polymorphism;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	/*@Autowired//type으로 DI해주는 annotation
	  @Qualifier("sony")//동일타입의 component가 여러개일때 이름으로 DI해주는 annotation
    */	
  /*@Resource(name="sony")*/
	@Inject
	@Qualifier("apple")
	private Speaker speaker;
	/*speaker = new AppleSpeaker();*/
	public void powerOn() {
		System.out.println("LgTV--전원켠다.");
	}
	public void powerOff() {
		System.out.println("LgTV--전원끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
