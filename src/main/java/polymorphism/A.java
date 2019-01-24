package polymorphism;

public class A {
	public void print(A a){
		System.out.println("A and A");
	}
	
	public void print(D d){
		System.out.println("A and D");
	}
}
