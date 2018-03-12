package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	//기본 생성자
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	//매개변수 1개짜리 생성자
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker=speaker;
	}
	//매개변수 2개짜리 생성자(객체,기본타입)
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	//set메소드
	public void setSpeaker(Speaker speaker) {this.speaker = speaker;}
	public void setPrice(int price) {this.price = price;}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	public void powerOn() {
		System.out.println("SamsungTV--전원켠다.(가격:"+price+")");
	}
	public void powerOff() {
		System.out.println("SamsungTV--전원끈다.");
	}
	public void volumeUp() {
/*		speaker = new SonySpeaker();*/
		speaker.volumeUp();
		/*System.out.println("SamsungTV--소리 올린다.");*/
	}
	public void volumeDown() {
/*		speaker = new SonySpeaker();*/
		speaker.volumeDown();
		/*System.out.println("SamsungTV--소리 내린다.");*/
	}

}
