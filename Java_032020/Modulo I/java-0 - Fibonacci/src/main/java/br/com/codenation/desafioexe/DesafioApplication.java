package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	private static final int NUM_LIMIT_LIST   = 350;

	public static List<Integer> fibonacci() {
		return createListFibonacci();
	}

	public static Boolean isFibonacci(Integer a) {
		return createListFibonacci().contains(a);
	}

	private static List<Integer> createListFibonacci(){
		List<Integer> listFibonacci = new ArrayList<>();
		int lastNum = 0;
		int auxNum = 0;
		int nextNum = 1;

		while (true) {
			listFibonacci.add(lastNum);
			if (lastNum > NUM_LIMIT_LIST) {break;};
			auxNum = lastNum;
			lastNum = nextNum;
			nextNum += auxNum;
		};
		return listFibonacci;
	}
}