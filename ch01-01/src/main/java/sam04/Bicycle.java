package sam04;

public class Bicycle implements Vehicle {

	@Override
	public void ride(String name) {
		System.out.println(name + "은 자전거를 탑니다.");
	}

}
