class parent
{
	public void su()
	{
		System.out.println("Parent class method");
	}
}
public class Java_Default_Annotations extends parent
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Java_Default_Annotations obj = new Java_Default_Annotations();
		obj.display();
		obj.su();
		
	}
	
	@Deprecated
	public void display()
	{
		System.out.println("This is a deprecated method");
	}
	
	public void newdisplay()
	{
		System.out.println("This is a new method");
	}
	
	@Override
	public void su()
	{

		System.out.println("overriden child class method");
	}
	
}
