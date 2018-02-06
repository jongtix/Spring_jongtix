package sam04;

public class Airplane implements Vehicle {

	@Override
	public void ride(String name) {
		System.out.println(name + "는 비행기를 탑니다.");
	}

}
