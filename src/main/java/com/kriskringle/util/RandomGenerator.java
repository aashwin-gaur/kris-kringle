package com.kriskringle.util;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.text.RandomStringGenerator;
import org.junit.Ignore;
import org.junit.Test;

public class RandomGenerator {

	private static SecureRandom random = new SecureRandom();

	public static String generatePartyCode(int length) {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z').build();
		return generator.generate(length);
	}

	//TODO: This is O(n2) make it O(n) ////////////////////
	public static <T> T popRandomElementfromList(List<T> fromThisList) {
		T found = returnRandomElementfromList(fromThisList);
		int index = fromThisList.indexOf(found);
		return fromThisList.remove(index);
	}

	public static <T> T returnRandomElementfromList(List<T> fromThisList) {
		return fromThisList.get(random.nextInt(fromThisList.size()));
	}

	////////////////////////////////////////////////////////
	
	@Test @Ignore
	public void test() {
		Integer[] arr = { 4, 5, 6, 7, 8, 9, 10, 11 };
		List<Integer> arrList = new LinkedList<Integer>(Arrays.asList(arr));
		while(arrList.size()>0)
			System.out.println(popRandomElementfromList(arrList));
	}

}
