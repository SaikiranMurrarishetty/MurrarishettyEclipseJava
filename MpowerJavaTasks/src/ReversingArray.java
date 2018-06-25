import java.util.*;
public class ReversingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] IntegerArray;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Enter the Size of the Array:");
		int size = sc.nextInt();
		IntegerArray = new int[size];
		
		System.out.println("Please Enter the Array Elements:");
		for(int i = 0;i<size;i++)
		IntegerArray[i] = sc.nextInt();
		
		System.out.println("The Reverse Array is:");
		for(int j = IntegerArray.length-1;j>=0;j--)
		System.out.print(IntegerArray[j]+" ");
			
			
	}

}
