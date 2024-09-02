package nl.han.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PriemTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriemTesterApplication.class, args);
		var priemTester = new PriemTester();
		for(int i = 0; i<10; i++) {
			System.out.println("Getal " + i + " is een priemgetal?" + priemTester.isPriemgetal(i));
		}
	}

}
