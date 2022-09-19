package Arrays;

import java.util.ArrayList;

import java.util.Scanner;

public class ArraysListExp {

	public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	//syntax
	ArrayList<Integer> list= new ArrayList<>(5);
	
	//input
	for (int i = 0; i < 5; i++) {
		list.add(in.nextInt());
		
		
	}
	//get item in any index
	for (int i = 0; i < 5; i++) {
		System.out.println(list.get(i));
		
		
	}
	System.out.println(list);

	}

}
