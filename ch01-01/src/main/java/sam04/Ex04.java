package sam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Ex04 {

	public static void main(String[] args) {
		ApplicationContext bf = new FileSystemXmlApplicationContext("src/main/java/sam04/bean02.xml");

		Vehicle vh = bf.getBean(Vehicle.class); // Car가 Vehicle을 상속받아서 가능
		/* Vehicle vh = bf.getBean(Car.class); */
		vh.ride("임꺽정");
	}

}