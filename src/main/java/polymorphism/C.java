package polymorphism;

public class C extends B{
	public void print(C c){
		System.out.println("C and C");
	}
	
	public void print(A a){
		System.out.println("C and A");
	}
	
	
	/*
	//method inherited from A
	public void print(D d){
		System.out.println("A and D");
	}
	
	//method inherited from B
	public void print(B b){
		System.out.println("B and B");
	}
	*/

}
