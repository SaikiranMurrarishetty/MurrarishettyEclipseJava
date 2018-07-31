

public class Java_Default_Methods implements Cloneable
{
public static void main(String args[]) throws Exception
{
	Java_Default_Methods obj = new Java_Default_Methods();
	
System.out.println("1.toString()----Prints the hascode value of object reference\n");
System.out.println(obj.toString()+"\n");

System.out.println("2.getClass()----Gets the class name at run time andn Prints the class name\n");
System.out.println(obj.getClass()+"\n");


System.out.println("3.hashCode()----Gets the hashcode value of the object\n");
System.out.println(obj.hashCode()+"\n");

System.out.println("4.equals()----Checks the value of content in the object and returns true/false\n");
String s1  = new String("sai");
String s2  = new String("saikiran");
System.out.println(s1.equals(s2)+"\n");

System.out.println("5.Clone()----Create a copy of the object and returns that obhect\n");
Java_Default_Methods o2 = (Java_Default_Methods)obj.clone();
System.out.println(o2+"\n");

obj = null;
System.gc();

}

public void finalize()
{
	System.out.println("6.finalize()----Garbage collector calls this method just before destroying the object\n");
    System.out.println("finalize method overriden");

    System.out.println("Destroyed all objects");
}
}