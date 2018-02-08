package sam03;

public class VehicleImpl implements Vehicle {
	private String name;
	private String rider;

	public VehicleImpl(String rider) {
		this.rider = rider;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRider(String rider) {
		this.rider = rider;
	}

	@Override
	public void ride() {
		try {
			Thread.sleep(3000);
			System.out.println(name + "(이)가 " + rider + "을(를) 운행한다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
