package polymorphism;

public class B extends A{
	public void print(B b){
		System.out.println("B and B");
	}
	
	public void print(A a){
		System.out.println("B and A");
	}
	
	/*
	//method inherited from A
	public void print(D d){
		System.out.println("A and D");
	}*/

}
