import java.util.*;
public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Input");
		
		int no = sc.nextInt();
		System.out.print("<---------------------------------->\n"); 
        for(int i = 0;i<no;i++)
       {
           for(int j = 0;j<=i;j++)
           {
                System.out.print("*");
           }
             System.out.print("\n");
       }
         
        System.out.print("<---------------------------------->\n"); 
         
         
      
      for(int i = 1;i<=no;i++)
       {
           for(int m = i;m<no;m++)
           {
               
               System.out.print(" ");
           }
           for(int j = 1;j<=(2*i-1);j++)
           {
                System.out.print("*");
           }
             System.out.print("\n");
       }
       
      System.out.print("<---------------------------------->\n"); 
       for(int d = 1;d<11;d++)
       {
           System.out.println(no+"*"+d+"="+(no*d));
       }
       
		
	}

}
