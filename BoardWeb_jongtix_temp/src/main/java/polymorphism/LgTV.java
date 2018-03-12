package polymorphism;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {

	/*
	 * @Autowired
	 * 
	 * @Qualifier("apple") // 동일 타입의 component가 여러개일 때 이름으로 DI해주는 annotation
	 */
	// @Resource(name = "apple") // @Autowired와 @Qualifier를 하나로
	@Inject
	@Qualifier("apple")
	private Speaker speaker;

	public void powerOn() {
		System.out.println("LGTV 전원 켠다");
	}

	public void powerOff() {
		System.out.println("LGTV 전원 끈다");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

}
