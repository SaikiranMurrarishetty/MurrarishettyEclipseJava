import java.util.*;
public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		double mealCost   = sc.nextDouble();
		int    tipPercent = sc.nextInt();
		int    taxPercent = sc.nextInt();
		
		double tipAmount = mealCost * ((double)tipPercent/100);
		System.out.println("TipAmount-->"+tipAmount);
		double taxAmount = mealCost * ((double)taxPercent/100);
		System.out.println("TaxAmount-->"+taxAmount);
		
		System.out.println("The Total meal Cost is "+Math.round((mealCost+tipAmount+taxAmount))+" dollars.");
	}

}
