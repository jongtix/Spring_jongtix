package sam09;

public class VehicleImpl implements Vehicle {
	private String rider;
	private int speed;
	private Outputter outputter;

	public VehicleImpl(String rider, int speed) {
		this.rider = rider;
		this.speed = speed;
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}

	@Override
	public void ride() {
		String msg = rider + "를 " + speed + "속도로 운행한다.";
		System.out.println(msg);
		if (outputter != null) {
			outputter.output(msg);
		}
	}

}
