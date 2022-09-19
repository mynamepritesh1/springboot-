package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDim {

	public static void main(String[] args) {
		  
		Scanner in = new Scanner(System.in);
		
          int [][] arr=new int[4][4];
          System.out.println(arr.length);
          
          //input
          for (int row = 0; row < arr.length; row++) {
        	  //for each col in every row 
        	  for (int col = 0; col < arr[row].length; col++) {
        		  arr[row][col] = in.nextInt();
        		  
				
			}
			
		}
          for (int[] a:arr) {
        	  System.out.println(Arrays.toString(a));
			
		}
	}

}
