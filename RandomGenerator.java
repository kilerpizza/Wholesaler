package wholesaler.database;
import java.util.Random;

public class RandomGenerator {

	public static int getRandomNumber(int i) {

		Random randomGenerator = new Random();

		return randomGenerator.nextInt(i);
	}
}