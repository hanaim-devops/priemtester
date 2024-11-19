package nl.han.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;


// Make this a console AND a web application

@SpringBootApplication
public class PriemTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriemTesterApplication.class, args);
		var customPriemTester = new CustomPriemService();
		System.out.println("Custom priemtester");
		for(int i = 0; i<10; i++) {
			System.out.println("Is " + i + " een priemgetal? " + customPriemTester.isPriemgetal(i));
		}

		var mavenPriemTester = new MavenPriemService();

		System.out.println("");
		System.out.println("Maven based priemtester");

		// BigInteger start = BigInteger.ZERO; // Start at 0
		final BigInteger start = new BigInteger("32452842");
		BigInteger increment = BigInteger.ONE; // Increment by 1

		// End is 10 further.
		BigInteger diff = BigInteger.TEN;
		BigInteger end = start.add(diff);

		for (BigInteger i = start; i.compareTo(end) <= 0; i = i.add(increment)) {
			System.out.println("Is " + i + " een priemgetal? " + mavenPriemTester.isPriemgetal(i));
		}
	}

}
