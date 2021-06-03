package Model;

public class Practice {
 static int a;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		a=6;
		this.name = name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
Practice p=new Practice();
System.out.println(p.a);
p.setName(null);
System.out.println(p.a);
System.out.println(p.getName());

Practice p2=new Practice();
System.out.println(p2.a);
Practice p3=new Practice();
System.out.println(p3.a);
	}

}
