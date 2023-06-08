package pl.edu.pw.ee;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HashListChainingPerformanceTest {

	@Test
	public void performanceTest() throws FileNotFoundException {
		String fileName = "list_of_words";
		File file = new File(fileName);
		Scanner input;
		ArrayList<String> listOfWords = new ArrayList<>();
		int sizeOfHash = 262147;
		long[] timeElapsed = new long[30];
		input = new Scanner(file);

		while (input.hasNextLine()) {
			listOfWords.add(input.nextLine());
		}
		for (int i = 0; i < 30; i++) {
			HashListChaining<String> hashList = new HashListChaining<>(sizeOfHash);

			for (String word : listOfWords) {
				hashList.add(word);
			}

			long start = System.nanoTime();

			for (String word : listOfWords) {
				hashList.get(word);
			}

			long finish = System.nanoTime();
			timeElapsed[i] = finish - start;

		}
		Arrays.sort(timeElapsed);
		long avgTime = 0;
		for (int i = 10; i < 20; i++) {
			avgTime += timeElapsed[i];
		}
		avgTime /= 10;
		System.out.println(sizeOfHash + " " + avgTime);
	}
}
