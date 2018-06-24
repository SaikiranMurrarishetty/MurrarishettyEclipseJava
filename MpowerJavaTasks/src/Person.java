import java.util.*;
public class Person
{

int age; //Instance variable age

Person(int initialAge) //Constructor accepting single argument initial age
{
	if(initialAge > 0)
	{	
		age = initialAge;
	}
	else
	{
		age = 0;
		System.out.println("Age is not not valid, seting age to 0.");
	}

}

void yearPasses()
{
	age++;
}

void amIOld()
{
	if(age < 13)
	System.out.println("You are young.");
	else if(age >= 13 && age < 18)
	System.out.println("You are teenager.");
	else
	System.out.println("You are old.");	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfTestCases,ageOfPerson;
		int[] ageArray;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			noOfTestCases = sc.nextInt();
			if(noOfTestCases < 1 || noOfTestCases > 4)
			{
				System.out.println("Invalid Input..Please Enter a Value in Between(1 and 4)");
				
			}
			else
			{
				break;
			}
			
		}
		ageArray = new int[noOfTestCases];
		
		for(int i = 0;i<noOfTestCases;i++)
		{
			ageOfPerson = sc.nextInt();
			ageArray[i] = ageOfPerson;
			
		}
		

		for(int i = 0;i<ageArray.length;i++)
		{
          Person obj = new Person(ageArray[i]);
          obj.amIOld();
          
          obj.yearPasses();
          obj.yearPasses();
          obj.yearPasses();
          
          obj.amIOld();
			
		}
		
		sc.close();

	}

}
