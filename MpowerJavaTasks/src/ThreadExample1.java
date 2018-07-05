
public class ThreadExample1
{

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		dummy d = new dummy();
		Thread1 t1 = new Thread1(d);
		t1.start();
		
		Thread1 t2 = new Thread1(d);
		t2.start();
		Thread.sleep(3000);
		for(int i=1;i<=10;i++)
		{
			System.out.println("Thread Name "+Thread.currentThread().getName());
		}
	}

}
class Thread1 extends Thread
{
	dummy d = null;
	Thread1(dummy obj)
	{
		d = obj;
	}
	public void run()
	{
		d.doCalculations();
	}
}

class dummy 
{
	public  synchronized  void doCalculations()
	{


			for(int i=1;i<=10;i++)
			{
				System.out.println("Thread Name "+Thread.currentThread().getName());
			}
	
		
	}
}
