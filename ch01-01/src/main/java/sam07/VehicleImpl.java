package sam07;

public class VehicleImpl implements Vehicle {
	private String name;
	private String rider;
	private String speed;

	public VehicleImpl(String name) {
		this.name = name;
	}

	public void setRider(String rider) {
		this.rider = rider;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	@Override
	public void ride() {
		System.out.println(name + "은 " + rider + "을 " + speed + "속도로 운행한다.");
	}

}
