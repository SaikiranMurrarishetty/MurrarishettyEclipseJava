import java.util.*;
public class HourGlass {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[][] hourglass ;
		hourglass = new int[6][6];
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<6;i++)
		{
			for(int j = 0;j<6;j++)
			{
				hourglass[i][j] = sc.nextInt();
			}
		}
		HourGlass obj1 = new HourGlass();
		System.out.println("The Maximum Hour Glass Sum is: "+obj1.HGSum(hourglass));
	}

	int HGSum(int[][] HG)
	{
		int temp_sum = 0,sum = 0;
		for(int i = 0;i<4;i++)
		{
			for(int j =0;j<4;j++)
			{
				temp_sum = HG[i][j] + HG[i][j+1] + HG[i][j+2] + HG[i+1][j+1] + HG[i+2][j] + HG[i+2][j+1] + HG[i+2][j+2];
				if(temp_sum > sum)
				sum = temp_sum;
			}
		}
		return sum;
	}
}
