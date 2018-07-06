
public class ThreadExample2 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		thread2 t1 = new thread2();
		t1.start();
		try 
		{
			t1.join();	
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		for(int i = 0;i<10;i++)
		{
			System.out.println("Iam in Main Thread");
		}
		
	}

}
class thread2 extends Thread
{
	public void run()
	{
		for(int i = 0;i<10;i++)
		{
			System.out.println("Iam in child Thread");
		}
	}
}
