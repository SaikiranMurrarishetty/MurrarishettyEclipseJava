
import java.util.*;
public class UserDefinedException {

	public static void main(String[] args) throws InvalidAmountException
	{
		// TODO Auto-generated method stub

	System.out.println("Please Enter a Valid Amount(Positive Value from 1 to 100)\n");
	int no = (new Scanner(System.in)).nextInt();
	
	if(no < 0 || no > 100)
		throw new InvalidAmountException("Amount Value not in range of 1-100");
	
	}

}
