import java.util.Scanner;

public class RecursionExample {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("Please Enter The Number");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		
		RecursionExample obj1 = new RecursionExample();
		int factvalue = obj1.Factorial(no);
		System.out.println("Factorial Value:\n"+factvalue);
	}
	
	int Factorial(int number)
	{
		if(number == 1)
		return 1;
		else
		return number * Factorial(number-1);	
	}

}
